package com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取用户全部聊天群的出参
 **/
@BizType(BizTypeEnum.CHATGROUP_GETALL)
public class ChatGroup_GetAllParams_Out extends CommonOutParams {
    private ArrayList<ChatGroup_GetParams_Out> chatgroups;

    public ChatGroup_GetAllParams_Out(ArrayList<ChatGroup_GetParams_Out> chatgroups) {
        setChatgroups(chatgroups);
    }

    public ArrayList<ChatGroup_GetParams_Out> getChatgroups() { return chatgroups; }

    public void setChatgroups(ArrayList<ChatGroup_GetParams_Out> chatgroups) { this.chatgroups = chatgroups; }
}
