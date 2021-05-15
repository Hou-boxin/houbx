package com.tsinghua.course.Biz.Controller.Params.ChatParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取某一用户全部聊天的出参
 **/
@BizType(BizTypeEnum.CHAT_GETALL)
public class Chat_GetAllParams_Out extends CommonOutParams {
    // 聊天出参列表
    private ArrayList<Chat_GetParams_Out> chats;

    public Chat_GetAllParams_Out(ArrayList<Chat_GetParams_Out> chats) {
        setChats(chats);
    }

    public ArrayList<Chat_GetParams_Out> getChats() { return chats; }

    public void setChats(ArrayList<Chat_GetParams_Out> chats) { this.chats = chats; }
}
