package com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 发起聊天群的出参
 **/
@BizType(BizTypeEnum.CHATGROUP_POST)
public class ChatGroup_PostParams_Out extends CommonOutParams {
    // id
    private String id;

    public ChatGroup_PostParams_Out(String id) { setId(id); }

    public void setId(String id) { this.id = id; }

    public String getId() { return id; }
}
