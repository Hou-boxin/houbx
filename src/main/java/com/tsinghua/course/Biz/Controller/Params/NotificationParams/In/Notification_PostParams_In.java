package com.tsinghua.course.Biz.Controller.Params.NotificationParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

import java.util.ArrayList;

/**
 * @描述 发送通知的入参
 **/
@BizType(BizTypeEnum.NOTIFICATION_POST)
public class Notification_PostParams_In extends CommonInParams {
    // 接受者
    @Required
    private ArrayList<String> receivers;
    // 标题
    @Required
    private String title;
    // 内容
    @Required
    private String text;

    public ArrayList<String> getReceivers() { return receivers; }

    public void setReceivers(ArrayList<String> receivers) { this.receivers = receivers; }

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }
}
