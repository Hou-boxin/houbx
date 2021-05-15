package com.tsinghua.course.Biz.Controller.Params.SocketParams;

import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 产生新的动态时，Socket返回给客户端的出参
 **/
public class Socket_NewMomentParams extends CommonOutParams {
    // 新动态的id
    private String moment_id;
    // 提示内容
    private String text;

    public Socket_NewMomentParams(String moment_id) {
        setText("New moment");
        setMoment_id(moment_id);
    }

    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    public void setMoment_id(String moment_id) { this.moment_id = moment_id; }

    public String getMoment_id() { return moment_id; }
}
