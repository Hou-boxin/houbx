package com.tsinghua.course.Biz.Controller.Params.CommentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 评论动态的入参
 **/
@BizType(BizTypeEnum.COMMENT_POST)
public class Comment_PostParams_In extends CommonInParams {
    // 评论的动态
    @Required
    private String moment_id;
    // 内容
    @Required
    private String text;

    public String getMoment_id() { return moment_id; }

    public void setMoment_id(String moment_id) { this.moment_id = moment_id; }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }
}
