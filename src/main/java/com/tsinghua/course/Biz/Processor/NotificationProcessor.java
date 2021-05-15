package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Base.Model.Notification;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.In.Notification_GetAllParams_In;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.In.Notification_GetParams_In;
import com.tsinghua.course.Biz.Controller.Params.NotificationParams.In.Notification_PostParams_In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 通知的原子处理器
 **/
@Component
public class NotificationProcessor {
    @Autowired
    MongoTemplate mongoTemplate;

    /** 根据id从数据库中获取通知 */
    public Notification getNotification(Notification_GetParams_In inParams) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.NOTIFICATION_ID).is(inParams.getId()));

        try {
            Notification notification = mongoTemplate.findOne(query, Notification.class);
            return notification;
        } catch (Exception e) {
            return null;
        }
    }

    /** 根据用户名获取通知 **/
    public ArrayList<Notification> getNotificationAll(Notification_GetAllParams_In inParams) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.USERNAME).is(inParams.getUsername()));
        if (inParams.getIs_read() != null)
            query.addCriteria(Criteria.where(KeyConstant.IS_READ).is(inParams.getIs_read()));
        ArrayList<Notification> notifications = new ArrayList<Notification>();

        try {
            notifications.addAll(mongoTemplate.find(query, Notification.class));
            return notifications;
        } catch (Exception e) {
            return null;
        }
    }

    /** 发送通知 **/
    public Notification postNotification(Notification_PostParams_In inParams) {
        Notification notification = new Notification();
        notification.setId(null);
        notification.setText(inParams.getText());
        notification.setTitle(inParams.getTitle());
        notification.setReceivers(inParams.getReceivers());
        notification.setIsRead(KeyConstant.FALSE);
        notification.setTitle(String.valueOf(System.currentTimeMillis()));

        try {
            mongoTemplate.insert(notification, KeyConstant.NOTIFICATION);
            return notification;
        } catch (Exception e) {
            return null;
        }
    }
}
