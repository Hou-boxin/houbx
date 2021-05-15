package com.tsinghua.course.Biz.Controller.Params.CommentParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取全部动态的出参
 **/
@BizType(BizTypeEnum.COMMENT_GETALL)
public class Comment_GetAllParams_Out extends CommonOutParams {
    // comment列表
    private ArrayList<Comment_GetParams_Out> comments;

    public Comment_GetAllParams_Out(ArrayList<Comment_GetParams_Out> comments){
        setComments(comments);
    }

    public ArrayList<Comment_GetParams_Out> getComments() { return comments; }

    public void setComments(ArrayList<Comment_GetParams_Out> comments) { this.comments = comments; }
}
