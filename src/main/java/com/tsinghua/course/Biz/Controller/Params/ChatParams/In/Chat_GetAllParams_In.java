package com.tsinghua.course.Biz.Controller.Params.ChatParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取某一用户聊天的入参
 **/
@BizType(BizTypeEnum.CHAT_GETALL)
public class Chat_GetAllParams_In extends CommonInParams {
    // 群id
    @Required
    private String chatgroup_id;

    // 目标用户名
    private String target_username;

    public String getChatgroup_id() { return chatgroup_id; }

    public void setChatgroup_id(String chatgroup_id) { this.chatgroup_id = chatgroup_id; }

    public String getTarget_username() { return target_username; }

    public void setTarget_username(String target_username) { this.target_username = target_username; }
}
