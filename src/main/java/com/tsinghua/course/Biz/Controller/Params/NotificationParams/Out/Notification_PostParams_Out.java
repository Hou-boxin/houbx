package com.tsinghua.course.Biz.Controller.Params.NotificationParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 发送通知的出参
 **/
@BizType(BizTypeEnum.NOTIFICATION_POST)
public class Notification_PostParams_Out extends CommonOutParams {
    // id
    private String id;

    public Notification_PostParams_Out(String id) { setId(id); }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }
}
