package com.tsinghua.course.Biz.Controller.Params.ChatParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Model.Chat;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取一条聊天的出参
 **/
@BizType(BizTypeEnum.CHAT_GET)
public class Chat_GetParams_Out extends CommonOutParams {
    // mongodb唯一id
    private String id;

    // 时间
    private String time;

    // 文字部分内容
    private String text;

    // 发送人
    private String username;

    // 对应的聊天
    private String chatgourp_id;

    // 图像
    private ArrayList<String> images;

    // 视频
    private ArrayList<String> vedios;

    // 音频
    private ArrayList<String> audios;

    public Chat_GetParams_Out(Chat chat) {
        setId(chat.getId());
        setTime(chat.getTime());
        setText(chat.getText());
        setImages(chat.getImages());
        setVedios(chat.getVedios());
        setAudios(chat.getAudios());
        setUsername(chat.getUsername());
        setChatgourp_id(chat.getChatgroup_id());
    }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }

    public void setUsername(String username) { this.username = username; }

    public String getUsername() { return username; }

    public String getChatgourp_id() { return chatgourp_id; }

    public void setChatgourp_id(String chatgourp_id) { this.chatgourp_id = chatgourp_id; }

    public ArrayList<String> getImages() { return images; }

    public void setImages(ArrayList<String> images) { this.images = images; }

    public ArrayList<String> getVedios() { return vedios; }

    public void setVedios(ArrayList<String> vedios) { this.vedios = vedios; }

    public ArrayList<String> getAudios() { return audios; }

    public void setAudios(ArrayList<String> audios) { this.audios = audios; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }
}
