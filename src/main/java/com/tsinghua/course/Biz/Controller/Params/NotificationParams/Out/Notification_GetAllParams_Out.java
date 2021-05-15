package com.tsinghua.course.Biz.Controller.Params.NotificationParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取全部通知的出参
 **/
@BizType(BizTypeEnum.NOTIFICATION_GETALL)
public class Notification_GetAllParams_Out extends CommonOutParams {
    // 通知信息的列表
    private ArrayList<Notification_GetPrams_Out> notifications;

    public Notification_GetAllParams_Out(ArrayList<Notification_GetPrams_Out> notification) {
        setNotifications(notifications);
    }

    public ArrayList<Notification_GetPrams_Out> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<Notification_GetPrams_Out> notifications) {
        this.notifications = notifications;
    }
}
