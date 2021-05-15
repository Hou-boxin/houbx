package com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 删除某一聊天群的入参
 **/
@BizType(BizTypeEnum.CHATGROUP_DELETE)
public class ChatGroup_DeleteParmas extends CommonInParams {
    // id
    @Required
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
