package com.tsinghua.course.Biz.Controller.Params.SocketParams;

import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 产生新的聊天群时，Socket返回给客户端的出参
 **/
public class Socket_NewChatGroupParams extends CommonOutParams {
    // id
    private String chatgroup_id;

    private String text;

    public Socket_NewChatGroupParams(String chatgroup_id) {
        setText("New chatgroup");
        setChatgroup_id(chatgroup_id);
    }

    public String getChatgroup_id() { return chatgroup_id; }

    public void setChatgroup_id(String chatgroup_id) { this.chatgroup_id = chatgroup_id; }

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }
}
