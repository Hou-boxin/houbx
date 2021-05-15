package com.tsinghua.course.Biz.Controller.Params.CommentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 删除评论的入参
 **/
@BizType(BizTypeEnum.COMMENT_DELETE)
public class Comment_DeleteParams extends CommonInParams {
    // id
    @Required
    private String id;

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }
}
