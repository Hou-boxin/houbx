package com.tsinghua.course.Biz.Controller.Params.CommentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取全部评论的入参
 **/
@BizType(BizTypeEnum.COMMENT_GETALL)
public class Comment_GetAllParams_In extends CommonInParams {
    // 对象用户名
    @Required
    private String moment_id;

    public void setMoment_id(String moment_id) { this.moment_id = moment_id; }

    public String getMoment_id() { return moment_id; }
}
