package com.tsinghua.course.Biz.Controller.Params.ChatParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 删除一条聊天的入参
 **/
@BizType(BizTypeEnum.CHAT_DELETE)
public class Chat_DeleteParams extends CommonInParams {
    // id
    @Required
    private String id;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
