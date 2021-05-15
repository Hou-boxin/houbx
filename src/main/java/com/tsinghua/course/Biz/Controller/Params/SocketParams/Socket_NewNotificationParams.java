package com.tsinghua.course.Biz.Controller.Params.SocketParams;

import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 产生新的通知时，Socket返回给客户端的出参
 **/
public class Socket_NewNotificationParams extends CommonOutParams {
    // 新动态的id
    private String notification_id;
    // 提示内容
    private String text;

    public Socket_NewNotificationParams(String notification_id) {
        setText("New notification");
        setNotification_id(notification_id);
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public String getNotification_id() { return notification_id; }

    public void setNotification_id(String notification_id) { this.notification_id = notification_id; }
}
