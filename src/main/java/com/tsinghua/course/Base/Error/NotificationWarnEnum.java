package com.tsinghua.course.Base.Error;

import com.tsinghua.course.Base.Model.Notification;

/**
 * @描述 通知操作警告枚举
 **/
public enum NotificationWarnEnum implements ExceptionInterface{
    POST_FAILED_1("NotificationWarn001", "在发布通知时，未找到对应的通知对象"),
    POST_FAILED_2("NotificationWarn002", "发布通知失败"),
    GET_FAILED_1("NotificationWarn003","错误，尝试获取非对应用户的通知"),
    GET_FAILED_2("NotificationWarn004","获取通知失败"),
    GET_ALL_FAILED("NotificationWarn005","获取全部通知失败")
    ;

    NotificationWarnEnum(String code, String msg) {
        errorCode = code;
        errorMsg = msg;
    }

    private String errorCode;
    private String errorMsg;
    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMsg;
    }
}