package com.tsinghua.course.Biz.Controller.Params.SocketParams;

import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 产生新的聊天时，Socket返回给客户端的出参
 **/
public class Socket_NewChatParams extends CommonOutParams {
    // 新聊天对应的群聊id
    private String chatgroup_id;
    // 新聊天的id
    private String chat_id;
    // 提示内容
    private String text;

    public Socket_NewChatParams(String chatgroup_id, String chat_id) {
        setText("New chat");
        setChatgroup_id(chatgroup_id);
        setChat_id(chat_id);
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getChat_id() { return chat_id; }

    public void setChat_id(String chat_id) { this.chat_id = chat_id; }

    public String getChatgroup_id() { return chatgroup_id; }

    public void setChatgroup_id(String chatgroup_id) { this.chatgroup_id = chatgroup_id; }
}
