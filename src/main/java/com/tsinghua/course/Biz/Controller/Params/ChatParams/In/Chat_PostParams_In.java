package com.tsinghua.course.Biz.Controller.Params.ChatParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

import java.util.ArrayList;

/**
 * @描述 发送聊天的入参
 **/
@BizType(BizTypeEnum.CHAT_POST)
public class Chat_PostParams_In extends CommonInParams {
    // 对应聊天群的id
    @Required
    private String chatgroup_id;

    // 聊天正文
    private String text;

    // 图像
    private ArrayList<String> images;

    // 视频
    private ArrayList<String> vedios;

    // 音频
    private ArrayList<String> audios;

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getChatgroup_id() { return chatgroup_id; }

    public void setChatgroup_id(String chatgroup_id) { this.chatgroup_id = chatgroup_id; }

    public ArrayList<String> getImages() { return images; }

    public void setImages(ArrayList<String> images) { this.images = images; }

    public ArrayList<String> getVedios() { return vedios; }

    public void setVedios(ArrayList<String> vedios) { this.vedios = vedios; }

    public ArrayList<String> getAudios() { return audios; }

    public void setAudios(ArrayList<String> audios) { this.audios = audios; }
}
