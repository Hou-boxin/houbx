package com.tsinghua.course.Biz.Controller.Params.MomentParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 发送动态的出参
 **/
@BizType(BizTypeEnum.MOMENT_POST)
public class Moment_PostParams_Out extends CommonOutParams {
    // id
    private String id;

    public Moment_PostParams_Out(String id) { setId(id); }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
