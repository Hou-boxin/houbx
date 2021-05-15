package com.tsinghua.course.Biz.Controller.Params.CommentParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Model.Comment;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 获取一条动态的出参
 **/
@BizType(BizTypeEnum.COMMENT_GET)
public class Comment_GetParams_Out extends CommonOutParams {
    // mongodb唯一id
    private String id;
    // 评论者
    private String username;
    // 评论的动态
    private String moment_id;
    // 内容
    private String text;
    // 时间
    private String time;

    public Comment_GetParams_Out(Comment comment) {
        setId(comment.getId());
        setUsername(comment.getUsername());
        setMoment_id(comment.getMoment_id());
        setText(comment.getContent());
        setTime(comment.getTime());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() { return text;}

    public void setText(String text)  { this.text = text; }

    public String getMoment_id() { return moment_id; }

    public void setMoment_id(String moment_id) { this.moment_id = moment_id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }
}
