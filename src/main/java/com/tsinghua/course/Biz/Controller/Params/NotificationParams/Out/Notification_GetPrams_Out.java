package com.tsinghua.course.Biz.Controller.Params.NotificationParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Model.Notification;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 获取通知的出参
 **/
@BizType(BizTypeEnum.NOTIFICATION_GET)
public class Notification_GetPrams_Out extends CommonOutParams {
    // mongodb唯一id
    private String id;
    // 标题
    private String title;
    // 内容
    private String text;
    // 是否已读
    private String is_read;
    // 时间
    private String time;

    public Notification_GetPrams_Out(Notification notification) {
        setId(notification.getId());
        setText(notification.getText());
        setIs_read(notification.getIsRead());
        setTitle(notification.getTitle());
        setTitle(notification.getTime());
    }

    public void setIs_read(String is_read) { this.is_read = is_read; }

    public String getIs_read() { return is_read; }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }
}
