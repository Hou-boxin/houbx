package com.tsinghua.course.Biz.Controller.Params.CommentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 编辑评论的入参
 **/
@BizType(BizTypeEnum.COMMENT_UPDATE)
public class Comment_UpdateParams extends CommonInParams {
    // id
    @Required
    private String id;

    // 正文内容
    @Required
    private String content;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }
}
