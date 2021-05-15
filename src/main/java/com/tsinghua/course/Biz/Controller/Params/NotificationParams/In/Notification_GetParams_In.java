package com.tsinghua.course.Biz.Controller.Params.NotificationParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取通知的入参
 **/
@BizType(BizTypeEnum.NOTIFICATION_GET)
public class Notification_GetParams_In extends CommonInParams {
    // mongodb唯一id
    @Required
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
