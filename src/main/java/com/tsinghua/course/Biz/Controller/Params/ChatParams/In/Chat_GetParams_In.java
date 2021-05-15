package com.tsinghua.course.Biz.Controller.Params.ChatParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 获取一条聊天的入参
 **/
@BizType(BizTypeEnum.CHAT_GET)
public class Chat_GetParams_In extends CommonInParams {
    // id
    @Required
    private String id;

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }
}
