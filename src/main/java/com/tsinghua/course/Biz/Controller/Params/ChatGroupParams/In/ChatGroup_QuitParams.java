package com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 退出聊天群的入参
 **/
@BizType(BizTypeEnum.CHATGROUP_QUIT)
public class ChatGroup_QuitParams extends CommonInParams {
    // id
    @Required
    private String id;

    private String target_username;

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }

    public String getTarget_username() { return target_username; }

    public void setTarget_username(String target_username) { this.target_username = target_username; }
}
