package com.tsinghua.course.Biz.Controller.Params.MomentParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取全部动态的入参
 **/
@BizType(BizTypeEnum.MOMENT_GETALL)
public class Moment_GetAllParams_In extends CommonInParams {
    // 获取动态的对象名
    private String target_username;

    public void setTarget_username(String target_username) { this.target_username = target_username; }

    public String getTarget_username() { return target_username; }
}
