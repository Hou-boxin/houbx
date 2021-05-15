package com.tsinghua.course.Base.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * @描述 对应mongodb中的Chat_Content集合
 **/
@Document("Chat")
public class Chat {
    String time;
    // mongodb唯一id
    String id;
    // 文字部分内容
    String text;
    // 图像
    ArrayList<String> images;
    // 视频
    ArrayList<String> vedios;
    // 音频
    ArrayList<String> audios;
    // 发送人
    String username;
    // 对应的聊天
    String chatgroup_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public ArrayList<String> getImages() { return images; }

    public void setImages(ArrayList<String> images) { this.images = images; }

    public ArrayList<String> getVedios() { return vedios; }

    public void setVedios(ArrayList<String> vedios) { this.vedios = vedios; }

    public ArrayList<String> getAudios() { return audios; }

    public void setAudios(ArrayList<String> audios) { this.audios = audios; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getChatgroup_id() { return chatgroup_id; }

    public void setChatgroup_id(String chatgroup_id) { this.chatgroup_id = chatgroup_id; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
