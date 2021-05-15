package com.tsinghua.course.Biz.Controller.Params.NotificationParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取一个用户全部通知的入参
 **/
@BizType(BizTypeEnum.NOTIFICATION_GETALL)
public class Notification_GetAllParams_In extends CommonInParams {
    // 是否已读
    private String is_read;

    public void setIs_read(String is_read) { this.is_read = is_read; }

    public String getIs_read() { return is_read; }
}
