package com.tsinghua.course.Biz.Controller.Params.SocketParams;

import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 产生新的评论时，Socket返回给客户端的出参
 **/
public class Socket_NewCommentParams extends CommonOutParams {
    // 新聊天对应的群聊id
    private String moment_id;
    // 新聊天的id
    private String comment_id;
    // 提示内容
    private String text;

    public Socket_NewCommentParams(String moment_id, String comment_id) {
        setText("New comment");
        setMoment_id(moment_id);
        setComment_id(comment_id);
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public void setMoment_id(String moment_id) { this.moment_id = moment_id; }

    public String getMoment_id() { return moment_id; }

    public String getComment_id() { return comment_id; }

    public void setComment_id(String comment_id) { this.comment_id = comment_id; }
}
