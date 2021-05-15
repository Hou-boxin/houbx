package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Base.Error.ChatWarnEnum;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Model.Chat;
import com.tsinghua.course.Base.Model.ChatGroup;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.In.Chat_DeleteParams;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.In.Chat_GetAllParams_In;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.In.Chat_GetParams_In;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.In.Chat_PostParams_In;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.Out.Chat_GetAllParams_Out;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.Out.Chat_GetParams_Out;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.Out.Chat_PostParams_Out;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;
import com.tsinghua.course.Biz.Processor.ChatGroupProcessor;
import com.tsinghua.course.Biz.Processor.ChatProcessor;
import com.tsinghua.course.Biz.Processor.UserProcessor;
import com.tsinghua.course.Frame.Util.SocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 聊天控制器，用于执行聊天内容相关的业务
 **/
@Component
public class ChatController {
    @Autowired
    ChatProcessor chatProcessor;
    @Autowired
    ChatGroupProcessor chatgroupProcessor;
    @Autowired
    UserProcessor userProcessor;

    /** 获取某一聊天群业务 **/
    @BizType(BizTypeEnum.CHAT_GET)
    @NeedLogin
    public Chat_GetParams_Out getChat(Chat_GetParams_In inParams) throws Exception {
        Chat chat = chatProcessor.getChatById(inParams.getId());
        if (chat== null)
            throw new CourseWarn(ChatWarnEnum.GET_FAILED_1);

        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(chat.getChatgroup_id());
        if (!chatgroup.getInvolvers().contains(inParams.getUsername()))
            throw new CourseWarn(ChatWarnEnum.GET_FAILED_2);

        return new Chat_GetParams_Out(chat);
    }

    /** 获取用户聊天业务 */
    @BizType(BizTypeEnum.CHAT_GETALL)
    @NeedLogin
    public Chat_GetAllParams_Out getAllChat(Chat_GetAllParams_In inParams) throws Exception {
        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(inParams.getChatgroup_id());
        if (chatgroup == null)
            throw new CourseWarn(ChatWarnEnum.GET_FAILED_ALL_1);

        User user = userProcessor.getUserByUsername(inParams.getUsername());
        if (user == null || !chatgroup.getInvolvers().contains(user.getUsername()))
            throw new CourseWarn(ChatWarnEnum.GET_FAILED_ALL_2);

        if (inParams.getTarget_username() != null)
        {
            User target_user = userProcessor.getUserByUsername(inParams.getTarget_username());
            if (target_user == null || !chatgroup.getInvolvers().contains(target_user.getUsername()))
                throw new CourseWarn(ChatWarnEnum.GET_FAILED_ALL_2);
        }

        ArrayList<Chat> chats = chatProcessor.getChatAll(inParams);
        if (chats == null || chats.isEmpty())
            throw new CourseWarn(ChatWarnEnum.GET_FAILED_ALL_3);

        ArrayList<Chat_GetParams_Out> chats_params = new ArrayList<Chat_GetParams_Out>();
        int size = chats.size();
        for(int i = 0; i < size; i++)
            chats_params.add(new Chat_GetParams_Out(chats.get(i)));

        return new Chat_GetAllParams_Out(chats_params);
    }

    /** 发送聊天业务 */
    @BizType(BizTypeEnum.CHAT_POST)
    @NeedLogin
    public Chat_PostParams_Out postChat(Chat_PostParams_In inParams) throws Exception {
        ChatGroup chatgroup = chatgroupProcessor.getChatGroupById(inParams.getChatgroup_id());
        if (chatgroup == null)
            throw new CourseWarn(ChatWarnEnum.POST_FAILED_1);

        User user = userProcessor.getUserByUsername(inParams.getUsername());
        if (user == null || !chatgroup.getInvolvers().contains(user.getUsername()))
            throw new CourseWarn(ChatWarnEnum.POST_FAILED_2);

        Chat chat = chatProcessor.postChat(inParams);
        if (chat == null)
            throw new CourseWarn(ChatWarnEnum.POST_FAILED_3);

        /** 向前台通知有新的聊天产生 **/
        SocketUtil.newChat(chatgroup.getInvolvers(), inParams.getChatgroup_id(), chat.getId());
        return new Chat_PostParams_Out(chat.getId());
    }

    /** 删除聊天业务 */
    @BizType(BizTypeEnum.CHAT_DELETE)
    @NeedLogin
    public CommonOutParams deleteChat(Chat_DeleteParams inParams) throws Exception {
        Chat chat = chatProcessor.getChatById(inParams.getId());
        if (chat == null)
            throw new CourseWarn(ChatWarnEnum.DELETE_FAILED_1);

        if (!chat.getUsername().equals(inParams.getUsername()))
            throw new CourseWarn(ChatWarnEnum.DELETE_FAILED_2);

        if (!chatProcessor.deleteChat(inParams.getId()))
            throw new CourseWarn(ChatWarnEnum.DELETE_FAILED_3);

        return new CommonOutParams(true);
    }
}
