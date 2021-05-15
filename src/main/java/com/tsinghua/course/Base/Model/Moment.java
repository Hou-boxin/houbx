package com.tsinghua.course.Base.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * @描述 对应mongodb中的Moment集合
 **/
@Document("Moment")
public class Moment {
    // mongodb唯一id
    String id;
    // 文字部分内容
    String text;
    // 时间
    String time;
    // 图像
    ArrayList<String> images;
    // 视频
    ArrayList<String> vedios;
    // 音频
    ArrayList<String> audios;
    // 发送人
    String username;
    // 点赞的人
    ArrayList<String> like;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public ArrayList<String> getAudios() { return audios; }

    public void setAudios(ArrayList<String> audios) { this.audios = audios; }

    public ArrayList<String> getImages() { return images; }

    public void setImages(ArrayList<String> images) { this.images = images; }

    public ArrayList<String> getVedios() { return vedios; }

    public void setVedios(ArrayList<String> vedios) { this.vedios = vedios; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public ArrayList<String> getLike() { return like; }

    public void setLike(ArrayList<String> like) { this.like = like; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
