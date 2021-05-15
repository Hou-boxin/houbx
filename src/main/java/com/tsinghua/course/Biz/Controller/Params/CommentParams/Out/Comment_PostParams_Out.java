package com.tsinghua.course.Biz.Controller.Params.CommentParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 发布一条动态的出参
 **/
@BizType(BizTypeEnum.COMMENT_POST)
public class Comment_PostParams_Out extends CommonOutParams {
    // id
    private String id;

    public Comment_PostParams_Out(String id) { setId(id); }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
