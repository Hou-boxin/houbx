package com.tsinghua.course.Base.Model;
import com.tsinghua.course.Base.Enum.ChatRoleType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Map;

/**
 * @描述 对应mongodb中的Chat集合
 **/
@Document("ChatGroup")
public class ChatGroup {
    // mongodb唯一id
    String id;
    // 聊天标题
    String title;
    // 最新发言时间
    long latest_posttime;
    // 群友
    ArrayList<String> involvers;
    // 群友的身份
    Map<String, ChatRoleType> roles;

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return title; }

    public long getLatest_posttime() { return latest_posttime; }

    public void setLatest_posttime(long latest_posttime) { this.latest_posttime = latest_posttime; }

    public ArrayList<String> getInvolvers() { return involvers; }

    public void setInvolvers(ArrayList<String> involvers) { this.involvers = involvers; }

    public Map<String, ChatRoleType> getRoles() { return roles; }

    public void setRoles(Map<String, ChatRoleType> roles) { this.roles = roles; }
}
