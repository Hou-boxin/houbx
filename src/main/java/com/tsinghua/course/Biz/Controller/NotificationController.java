package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Error.NotificationWarnEnum;
import com.tsinghua.course.Base.Model.Notification;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.In.Notification_GetAllParams_In;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.In.Notification_GetParams_In;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.In.Notification_PostParams_In;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.Out.Notification_GetAllParams_Out;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.Out.Notification_GetPrams_Out;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.Out.Notification_PostParams_Out;
import com.tsinghua.course.Biz.Processor.NotificationProcessor;
import com.tsinghua.course.Biz.Processor.UserProcessor;
import com.tsinghua.course.Frame.Util.SocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 通知控制器，用于执行用户相关的业务
 **/
@Component
public class NotificationController {
    @Autowired
    NotificationProcessor notificationProcessor;
    @Autowired
    UserProcessor userProcessor;

    /** 发送通知业务 */
    @BizType(BizTypeEnum.NOTIFICATION_POST)
    @NeedLogin
    public Notification_PostParams_Out postNotification(Notification_PostParams_In inParams) throws Exception {
        ArrayList<String> receivers = inParams.getReceivers();
        int size = receivers.size();
        for (int i = 0; i < size; i++) {
            if (userProcessor.getUserByUsername(receivers.get(i)) == null)
                throw new CourseWarn(NotificationWarnEnum.POST_FAILED_1);
        }

        Notification notification = notificationProcessor.postNotification(inParams);
        if (notification == null)
            throw new CourseWarn(NotificationWarnEnum.POST_FAILED_2);

        /** 向前台通知有新的通知产生 **/
        SocketUtil.newNotification(receivers, notification.getId());
        return new Notification_PostParams_Out(notification.getId());
    }

    /** 获取通知业务 */
    @BizType(BizTypeEnum.NOTIFICATION_GET)
    @NeedLogin
    public Notification_GetPrams_Out getNotification(Notification_GetParams_In inParams) throws Exception {
        Notification notification = notificationProcessor.getNotification(inParams);
        if (notification == null)
            throw new CourseWarn(NotificationWarnEnum.GET_FAILED_2);

        if (!notification.getReceivers().contains(inParams.getUsername()))
            throw new CourseWarn(NotificationWarnEnum.GET_FAILED_1);

        return new Notification_GetPrams_Out(notification);
    }

    /** 获取全部通知业务 */
    @BizType(BizTypeEnum.NOTIFICATION_GETALL)
    @NeedLogin
    public Notification_GetAllParams_Out getAllNotification(Notification_GetAllParams_In inParams) throws Exception {
        ArrayList<Notification> notifications = notificationProcessor.getNotificationAll(inParams);
        if (notifications == null || notifications.isEmpty())
            throw new CourseWarn(NotificationWarnEnum.GET_ALL_FAILED);

        ArrayList<Notification_GetPrams_Out> notification_params =
                new ArrayList<Notification_GetPrams_Out>();
        int size = notifications.size();
        for(int i = 0; i < size; i++)
            notification_params.add(new Notification_GetPrams_Out(notifications.get(i)));

        return new Notification_GetAllParams_Out(notification_params);
    }
}
