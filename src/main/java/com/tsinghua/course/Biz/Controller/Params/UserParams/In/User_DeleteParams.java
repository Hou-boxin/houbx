package com.tsinghua.course.Biz.Controller.Params.UserParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 添加好友的入参
 **/
@BizType(BizTypeEnum.USER_DELETE)
public class User_DeleteParams extends CommonInParams {
    // 添加对象
    @Required
    private String target_username;

    public void setTarget_username(String target_username) { this.target_username = target_username; }

    public String getTarget_username() { return target_username; }
}
