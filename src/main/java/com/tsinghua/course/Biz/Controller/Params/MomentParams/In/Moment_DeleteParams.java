package com.tsinghua.course.Biz.Controller.Params.MomentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取删除动态的入参
 **/
@BizType(BizTypeEnum.MOMENT_DELETE)
public class Moment_DeleteParams extends CommonInParams {
    //ID
    @Required
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
