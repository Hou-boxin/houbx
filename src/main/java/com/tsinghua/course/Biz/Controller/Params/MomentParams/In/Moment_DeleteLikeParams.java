package com.tsinghua.course.Biz.Controller.Params.MomentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 取消点赞的入参
 **/
@BizType(BizTypeEnum.MOMENT_DELETE_LIKE)
public class Moment_DeleteLikeParams extends CommonInParams {
    //ID
    @Required
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}