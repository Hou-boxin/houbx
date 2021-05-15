package com.tsinghua.course.Base.Model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @描述 对应mongodb中的Comment集合
 **/
@Document("Comment")
public class Comment {
    // mongodb唯一id
    String id;
    // 评论者
    String username;
    // 评论的动态
    String moment_id;
    // 内容
    String content;
    // 时间
    String time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() { return content;}

    public void setContent(String content)  { this.content = content; }

    public String getMoment_id() { return moment_id; }

    public void setMoment_id(String moment_id) { this.moment_id = moment_id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }
}
