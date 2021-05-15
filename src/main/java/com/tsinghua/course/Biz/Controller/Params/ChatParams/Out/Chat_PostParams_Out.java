package com.tsinghua.course.Biz.Controller.Params.ChatParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 发送聊天的出参
 **/
@BizType(BizTypeEnum.CHAT_POST)
public class Chat_PostParams_Out extends CommonOutParams {
    // id
    private String id;

    public Chat_PostParams_Out(String id) { setId(id); }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }
}
