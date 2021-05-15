package com.tsinghua.course.Base.Error;

/**
 * @描述 动态操作警告枚举
 **/
public enum MomentWarnEnum implements ExceptionInterface{
    GET_FAILED_1("MomentWarn001", "获取动态失败"),
    GET_ALL_FAILED_1("MomentWarn002","该用户的不存在动态"),
    POST_FAILED("MomentWarn003", "发送动态失败"),
    DELETE_FAILED_1("MomentWarn004", "删除动态时，未找到对应动态"),
    DELETE_FAILED_2("MomentWarn005", "错误，试图删除非用户自己的动态"),
    DELETE_FAILED_3("MomentWarn006", "删除动态失败"),
    UPDATE_FAILED_1("MomentWarn007","编辑动态时，未找到对应动态"),
    UPDATE_FAILED_2("MomentWarn008","错误，尝试编辑非用户自己的动态"),
    UPDATE_FAILED_3("MomentWarn009","编辑动态失败"),
    LIKE_FAILED_1("MomentWarn010","点赞动态时，未找到对应动态"),
    LIKE_FAILED_2("MomentWarn011","已点赞过该动态，不可重复点赞"),
    LIKE_FAILED_3("MomentWarn012","点赞动态失败"),
    DELETE_LIKE_FAILED_1("MomentWarn013","删除点赞时，未找到对应点赞"),
    DELETE_LIKE_FAILED_2("MomentWarn014","尚未点赞该动态，不可删除"),
    DELETE_LIKE_FAILED_3("MomentWarn015","删除点赞失败"),
    GET_FAILED_2("MomentWarn016","错误，试图获取非自己好友的动态"),
    GET_ALL_FAILED_2("MomentWarn017","错误，试图获取非自己好友的动态"),
    ;

    MomentWarnEnum(String code, String msg) {
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
