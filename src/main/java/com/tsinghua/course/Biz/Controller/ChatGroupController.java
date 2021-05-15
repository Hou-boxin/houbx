package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Base.Enum.ChatRoleType;
import com.tsinghua.course.Base.Error.ChatGroupWarnEnum;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Model.ChatGroup;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.In.*;
import com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.Out.ChatGroup_GetAllParams_Out;
import com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.Out.ChatGroup_GetParams_Out;
import com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.Out.ChatGroup_PostParams_Out;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;
import com.tsinghua.course.Biz.Processor.ChatGroupProcessor;
import com.tsinghua.course.Biz.Processor.UserProcessor;
import com.tsinghua.course.Frame.Util.SocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;

/**
 * @描述 聊天群控制器，用于执行聊天相关的业务
 **/
@Component
public class ChatGroupController {
    @Autowired
    ChatGroupProcessor chatgroupProcessor;
    @Autowired
    UserProcessor userProcessor;

    /** 获取某一聊天群业务 **/
    @BizType(BizTypeEnum.CHATGROUP_GET)
    @NeedLogin
    public ChatGroup_GetParams_Out getChatGroup(ChatGroup_GetParams_In inParams) throws Exception {
        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(inParams.getId());
        if (chatgroup == null)
            throw new CourseWarn(ChatGroupWarnEnum.GET_FAILED_1);

        if (!chatgroup.getInvolvers().contains(inParams.getUsername()))
            throw new CourseWarn(ChatGroupWarnEnum.GET_FAILED_2);

        return new ChatGroup_GetParams_Out(chatgroup);
    }

    /** 获取用户参与的全部聊天群业务 **/
    @BizType(BizTypeEnum.CHATGROUP_GETALL)
    @NeedLogin
    public ChatGroup_GetAllParams_Out getChatGroupAll(CommonInParams inParams) throws Exception {
        ArrayList<ChatGroup> chatgroups = chatgroupProcessor.getChatGroupByUsername(inParams.getUsername());
        if (chatgroups == null || chatgroups.isEmpty())
            throw new CourseWarn(ChatGroupWarnEnum.GET_ALL_FAILED);

        ArrayList<ChatGroup_GetParams_Out> chatgroups_params = new ArrayList<ChatGroup_GetParams_Out>();
        int size = chatgroups.size();
        for(int i = 0; i < size; i++)
            chatgroups_params.add(new ChatGroup_GetParams_Out(chatgroups.get(i)));

        return new ChatGroup_GetAllParams_Out(chatgroups_params);
    }

    /** 发起聊天群业务 **/
    /** 默认发起者是群主 **/
    @BizType(BizTypeEnum.CHATGROUP_POST)
    @NeedLogin
    public ChatGroup_PostParams_Out postChatGroup(ChatGroup_PostParams_In inParams) throws Exception {
        if (inParams.getInvolvers().isEmpty())
            throw new CourseWarn(ChatGroupWarnEnum.POST_FAILED_1);

        ChatGroup chatgroup = chatgroupProcessor.postChatGroup(inParams);
        if (chatgroup == null)
            throw new CourseWarn(ChatGroupWarnEnum.POST_FAILED_2);

        SocketUtil.newChatgroup(chatgroup.getInvolvers(), chatgroup.getId());
        return new ChatGroup_PostParams_Out(chatgroup.getId());
    }

    /** 删除聊天群业务 **/
    /** 只有群主才能解散群聊 **/
    @BizType(BizTypeEnum.CHATGROUP_DELETE)
    @NeedLogin
    public CommonOutParams deleteChatGroup(ChatGroup_DeleteParmas inParams) throws Exception {
        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(inParams.getId());
        if (chatgroup == null)
            throw new CourseWarn(ChatGroupWarnEnum.DELETE_FAILED_1);

        if (!chatgroup.getInvolvers().contains(inParams.getUsername()) ||
            !chatgroup.getRoles().get(inParams.getUsername()).equals(ChatRoleType.ADMIN))
            throw new CourseWarn(ChatGroupWarnEnum.DELETE_FAILED_2);

        if (!chatgroupProcessor.deleteChatGroup(inParams.getId()))
            throw new CourseWarn(ChatGroupWarnEnum.DELETE_FAILED_3);

        return new CommonOutParams();
    }

    /** 编辑聊天群业务 **/
    @BizType(BizTypeEnum.CHATGROUP_UPDATE)
    @NeedLogin
    public CommonOutParams updateChatGroup(CommonInParams inParams) throws Exception {
        return new CommonOutParams();
    }

    /** 邀请加入群聊 **/
    /** 只有群聊成员才能邀请其他人加入群聊 **/
    @BizType(BizTypeEnum.CHATGROUP_JOIN)
    @NeedLogin
    public CommonOutParams joinChatGroup(ChatGroup_JoinParams inParams) throws Exception {
        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(inParams.getId());
        if (chatgroup == null)
            throw new CourseWarn(ChatGroupWarnEnum.JOIN_FAILED_1);

        User user = userProcessor.getUserByUsername(inParams.getUsername());
        User target_usr = userProcessor.getUserByUsername(inParams.getTarget_username());
        if (user == null || target_usr == null)
            throw new CourseWarn(ChatGroupWarnEnum.JOIN_FAILED_2);

        ArrayList<String> involvers = chatgroup.getInvolvers();
        if (!involvers.contains(inParams.getUsername()))
            throw new CourseWarn(ChatGroupWarnEnum.JOIN_FAILED_3);
        if (involvers.contains(inParams.getTarget_username()))
            throw new CourseWarn(ChatGroupWarnEnum.JOIN_FAILED_4);

        if (!chatgroupProcessor.joinChatGroup(inParams.getTarget_username(), inParams.getId()))
            throw new CourseWarn(ChatGroupWarnEnum.JOIN_FAILED_5);

        return new CommonOutParams();
    }

    /** 退出群聊 **/
    /** 普通群友只能让自己退群，群主可让其他人退群 **/
    /** 默认群主不能退群 **/
    @BizType(BizTypeEnum.CHATGROUP_QUIT)
    @NeedLogin
    public CommonOutParams quitChatGroup(ChatGroup_QuitParams inParams) throws Exception {
        String id = inParams.getId();
        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(id);
        if (chatgroup == null)
            throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_1);

        String username = inParams.getUsername();
        User user = userProcessor.getUserByUsername(username);
        ArrayList<String> involvers = chatgroup.getInvolvers();

        /** 群主踢别人出去 **/
        if (inParams.getTarget_username() != null)
        {
            String target_username = inParams.getTarget_username();
            User target_usr = userProcessor.getUserByUsername(target_username);
            if (user == null || target_usr == null)
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_2);

            if (!involvers.contains(username)|| !involvers.contains(target_username))
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_4);

            Map<String, ChatRoleType> roles = chatgroup.getRoles();
            if (!roles.get(username).equals(ChatRoleType.ADMIN))
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_3);

            if (!chatgroupProcessor.quitChatGroup(target_username, id))
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_5);
        }
        /** 自行退群 **/
        else
        {
            if (user == null)
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_2);

            if (!involvers.contains(username))
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_4);

            if (!chatgroupProcessor.quitChatGroup(username, id))
                throw new CourseWarn(ChatGroupWarnEnum.QUIT_FAILED_5);
        }

        return new CommonOutParams();
    }
}
