package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Error.UserWarnEnum;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;
import com.tsinghua.course.Biz.Controller.Params.UserParams.In.*;
import com.tsinghua.course.Biz.Controller.Params.UserParams.Out.User_GetAllContactsParams;
import com.tsinghua.course.Biz.Controller.Params.UserParams.Out.User_GetParams_Out;
import com.tsinghua.course.Biz.Processor.UserProcessor;
import com.tsinghua.course.Frame.Util.*;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 用户控制器，用于执行用户相关的业务
 **/
@Component
public class UserController {
    @Autowired
    UserProcessor userProcessor;

    /** 用户登录业务 */
    @BizType(BizTypeEnum.USER_LOGIN)
    public CommonOutParams userLogin(User_LoginInParams inParams) throws Exception {
        String username = inParams.getUsername();
        if (username == null)
            throw new CourseWarn(UserWarnEnum.LOGIN_FAILED);
        User user = userProcessor.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(inParams.getPassword()))
            throw new CourseWarn(UserWarnEnum.LOGIN_FAILED);

        /** 登录成功，记录登录状态 */
        ChannelHandlerContext ctx =  ThreadUtil.getCtx();
        /** ctx不为空记录WebSocket状态，否则记录http状态 */
        if (ctx != null)
            SocketUtil.setUserSocket(username, ctx);
        else {
            HttpSession httpSession = ThreadUtil.getHttpSession();
            if (httpSession != null) {
                httpSession.setUsername(username);
            }
        }
        return new CommonOutParams(true);
    }

    /** 用户注册业务 */
    @BizType(BizTypeEnum.USER_REGISTER)
    public CommonOutParams userRegister(User_RegisterParams inParams) throws Exception {
        /** 用户名不可重复 **/
        if (userProcessor.getUserByUsername(inParams.getTarget_username()) != null)
            throw new CourseWarn(UserWarnEnum.REGISTER_FAILED_1);

        if (!userProcessor.addUser(inParams))
            throw new CourseWarn(UserWarnEnum.REGISTER_FAILED_2);

        return new CommonOutParams(true);
    }

    /** 用户更新业务 */
    @BizType(BizTypeEnum.USER_UPDATE)
    @NeedLogin
    public CommonOutParams userUpdate(User_UpdateParams inParams) throws Exception {
        if (userProcessor.getUserByUsername(inParams.getUsername()) == null)
            throw new CourseWarn(UserWarnEnum.UPDATE_FAILED_2);

        if (!userProcessor.updateUser(inParams))
            throw new CourseWarn(UserWarnEnum.UPDATE_FAILED_1);

        return new CommonOutParams(true);
    }

    /** 获取用户信息业务 **/
    /** 默认获取登录者的 **/
    @BizType(BizTypeEnum.USER_GET)
    @NeedLogin
    public User_GetParams_Out userGet(User_GetParams_In inParams) throws Exception {
        User user;
        if (inParams.getTarget_username() == null)
            user = userProcessor.getUserByUsername(inParams.getUsername());
        else
            user = userProcessor.getUserByUsername(inParams.getTarget_username());
        if (user == null)
            throw new CourseWarn(UserWarnEnum.GET_FAILED);

        return new User_GetParams_Out(user);
    }

    /** 添加好友 **/
    @BizType(BizTypeEnum.USER_ADD)
    @NeedLogin
    public CommonOutParams userAdd(User_AddParams inParams) throws Exception{
        String username = inParams.getUsername();
        User user = userProcessor.getUserByUsername(username);
        String target_username = inParams.getTarget_username();
        User target_user = userProcessor.getUserByUsername(target_username);

        /** 目标用户不存在 **/
        if (user == null || target_user == null)
            throw new CourseWarn(UserWarnEnum.ADD_FAILED_1);

        /** 重复添加 **/
        ArrayList<String> contacts = user.getContacts();
        if (!contacts.isEmpty() && contacts.contains(target_username))
            throw new CourseWarn(UserWarnEnum.ADD_FAILED_3);

        if (!userProcessor.addContact(username, target_username)
                || !userProcessor.addContact(target_username, username))
            throw new CourseWarn(UserWarnEnum.ADD_FAILED_2);

        return new CommonOutParams(true);
    }

    /** 删除好友 **/
    @BizType(BizTypeEnum.USER_DELETE)
    @NeedLogin
    public CommonOutParams userDelete(User_DeleteParams inParams) throws Exception{
        String username = inParams.getUsername();
        User user = userProcessor.getUserByUsername(username);
        String target_username = inParams.getTarget_username();
        User target_user = userProcessor.getUserByUsername(target_username);

        /** 目标用户不存在 **/
        if (user == null || target_user == null)
            throw new CourseWarn(UserWarnEnum.DELETE_FAILED_1);

        /** 尚未添加该好友 **/
        ArrayList<String> contacts = user.getContacts();
        if (contacts.isEmpty() || !contacts.contains(target_username))
            throw new CourseWarn(UserWarnEnum.DELETE_FAILED_2);

        if (!userProcessor.deleteContact(username, target_username) ||
                !userProcessor.deleteContact(target_username, username))
            throw new CourseWarn(UserWarnEnum.DELETE_FAILED_3);

        return new CommonOutParams(true);
    }

    /** 获取所有好友 **/
    @BizType(BizTypeEnum.USER_GET_CONTACTS)
    @NeedLogin
    public User_GetAllContactsParams userGetContacts(CommonInParams inParams) throws Exception{
        User user = userProcessor.getUserByUsername(inParams.getUsername());
        if (user == null)
            throw new CourseWarn(UserWarnEnum.GET_CONTACTS_FAILED_1);

        ArrayList<String> contacts = user.getContacts();
        if(contacts == null || contacts.isEmpty())
            throw new CourseWarn(UserWarnEnum.GET_CONTACTS_FAILED_2);

        ArrayList<User_GetParams_Out> contacts_params = new ArrayList<User_GetParams_Out>();
        int size = contacts.size();
        for(int i = 0; i < size; i++)
            contacts_params.add(new User_GetParams_Out(userProcessor.getUserByUsername(contacts.get(i))));

        return new User_GetAllContactsParams(contacts_params);
    }
}
