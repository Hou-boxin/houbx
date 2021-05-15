package com.tsinghua.course.Biz.Controller.Params.CommentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取一条评论的入参
 **/
@BizType(BizTypeEnum.COMMENT_GET)
public class Comment_GetParams_In extends CommonInParams {
    //ID
    @Required
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
