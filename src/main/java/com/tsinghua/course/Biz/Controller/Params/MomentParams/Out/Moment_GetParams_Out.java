package com.tsinghua.course.Biz.Controller.Params.MomentParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Model.*;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取动态的出参
 **/
@BizType(BizTypeEnum.MOMENT_GET)
public class Moment_GetParams_Out extends CommonOutParams {
    //ID
    private String id;

    // 文字部分内容
    private String text;

    // 发送人
    private String username;

    // 点赞的人
    private ArrayList<String> like;

    // 时间
    private String time;

    // 图像
    private ArrayList<String> images;

    // 视频
    private ArrayList<String> vedios;

    // 音频
    private ArrayList<String> audios;

    public Moment_GetParams_Out(Moment moment) {
        this.success = true;
        setId(moment.getId());
        setText(moment.getText());
        setUsername(moment.getUsername());
        setLike(moment.getLike());
        setTime(moment.getTime());
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public ArrayList<String> getLike() { return like; }

    public void setLike(ArrayList<String> like) { this.like = like; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public void setImages(ArrayList<String> images) { this.images = images; }

    public ArrayList<String> getImages() { return images; }

    public void setVedios(ArrayList<String> vedios) { this.vedios = vedios; }

    public ArrayList<String> getVedios() { return vedios; }

    public ArrayList<String> getAudios() { return audios; }

    public void setAudios(ArrayList<String> audios) { this.audios = audios; }
}
