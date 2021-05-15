package com.tsinghua.course.Base.Error;

/**
 * @描述 用户操作警告枚举
 **/
public enum UserWarnEnum implements ExceptionInterface {
    LOGIN_FAILED("UserWarn001", "用户或密码不正确"),
    NEED_LOGIN("UserWarn002", "用户未登录或登录已过期"),
    PERMISSION_DENIED("UserWarn003", "无权限访问对应内容"),
    REGISTER_FAILED_1("UserWarn004", "该用户名已被注册"),
    REGISTER_FAILED_2("UserWarn005","用户注册失败"),
    UPDATE_FAILED_1("UserWarn006", "更新失败"),
    UPDATE_FAILED_2("UserWarn007","更新用户是，未找到对应用户"),
    GET_FAILED("UserWarn008", "用户名不存在"),
    ADD_FAILED_1("UserWarn009","添加好友时，未找到对应用户"),
    ADD_FAILED_2("UserWarn010","添加好友失败"),
    ADD_FAILED_3("UserWarn011","已添加该用户为好友，不可重复添加"),
    DELETE_FAILED_1("UserWarn012","删除好友时，未找到对应用户"),
    DELETE_FAILED_2("UserWarn013","目标用户不是好友，不可删除"),
    DELETE_FAILED_3("UserWarn014","删除好友失败"),
    GET_CONTACTS_FAILED_1("UserWarn015", "获取好友时，未找到对应用户"),
    GET_CONTACTS_FAILED_2("UserWarn016","该用户没有好友")
    ;

    UserWarnEnum(String code, String msg) {
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
