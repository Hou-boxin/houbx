package com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Enum.ChatRoleType;
import com.tsinghua.course.Base.Model.ChatGroup;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;
import java.util.Map;

/**
 * @描述 获取某一聊天群的出参
 **/
@BizType(BizTypeEnum.CHATGROUP_GET)
public class ChatGroup_GetParams_Out extends CommonOutParams {
    // mongodb唯一id
    private String id;
    // 聊天标题
    private String title;
    // 最新发言时间
    private long latest_posttime;
    // 群友
    private ArrayList<String> users;
    // 身份
    private ArrayList<String> roles;

    public ChatGroup_GetParams_Out(ChatGroup chatgroup) {
        this.success = true;
        setId(chatgroup.getId());
        setTitle(chatgroup.getTitle());
        setLatest_posttime(chatgroup.getLatest_posttime());

        ArrayList<String> involvers = chatgroup.getInvolvers();
        Map<String, ChatRoleType> roles = chatgroup.getRoles();
        setUsers(involvers);

        ArrayList<String> tmp = new ArrayList<String>();
        int size = involvers.size();
        for (int i = 0; i < size; i++)
            tmp.add(roles.get(involvers.get(i)).getName());
        setRoles(tmp);
    }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return title; }

    public long getLatest_posttime() { return latest_posttime; }

    public void setLatest_posttime(long latest_posttime) { this.latest_posttime = latest_posttime; }

    public ArrayList<String> getUsers() { return users; }

    public void setUsers(ArrayList<String> users) { this.users = users; }

    public ArrayList<String> getRoles() { return roles; }

    public void setRoles(ArrayList<String> roles) { this.roles = roles; }
}
