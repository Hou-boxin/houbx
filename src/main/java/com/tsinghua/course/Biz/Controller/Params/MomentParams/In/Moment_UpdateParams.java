package com.tsinghua.course.Biz.Controller.Params.MomentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 编辑动态的入参
 **/
@BizType(BizTypeEnum.MOMENT_UPDATE)
public class Moment_UpdateParams extends CommonInParams {
    // 文字部分内容
    private String text;

    // 图像
    private ArrayList<String> images;

    // 视频
    private ArrayList<String> vedios;

    // 音频
    private ArrayList<String> audios;

    @Required
    private String id;

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public void setImages(ArrayList<String> images) { this.images = images; }

    public ArrayList<String> getImages() { return images; }

    public void setVedios(ArrayList<String> vedios) { this.vedios = vedios; }

    public ArrayList<String> getVedios() { return vedios; }

    public ArrayList<String> getAudios() { return audios; }

    public void setAudios(ArrayList<String> audios) { this.audios = audios; }
}
