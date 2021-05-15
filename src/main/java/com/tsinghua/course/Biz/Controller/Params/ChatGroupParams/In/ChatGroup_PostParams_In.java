package com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

import java.util.ArrayList;

/**
 * @描述 发起聊天群的入参
 **/
@BizType(BizTypeEnum.CHATGROUP_POST)
public class ChatGroup_PostParams_In extends CommonInParams {
    // title
    @Required
    private String title;

    @Required
    private ArrayList<String> involvers;

    public void setTitle(String title) { this.title = title; }

    public String getTitle() { return title; }

    public void setInvolvers(ArrayList<String> involvers) { this.involvers = involvers; }

    public ArrayList<String> getInvolvers() { return involvers; }
}
