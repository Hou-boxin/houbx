package com.tsinghua.course.Base.Model;

import com.tsinghua.course.Base.Enum.NotificationType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

/**
 * @描述 对应mongodb中的Notification集合
 **/
@Document("Notification")
public class Notification {
    String time;
    // mongodb唯一id
    String id;
    // 通知类型
    NotificationType type;
    // 接受者
    ArrayList<String> receivers;
    // 标题
    String title;
    // 内容
    String text;
    // 是否已读
    String is_read;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(NotificationType type) { this.type = type; }

    public NotificationType getType() { return type; }

    public ArrayList<String> getReceivers() { return receivers; }

    public void setReceivers(ArrayList<String> receivers) { this.receivers = receivers; }

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title;}

    public void setText(String text) { this.text = text; }

    public String getText() { return text; }

    public String getIsRead() { return is_read;}

    public void setIsRead(String is_read) { this.is_read = is_read; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
