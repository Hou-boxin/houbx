package com.tsinghua.course.Base.Error;

/**
 * @描述 动态操作警告枚举
 **/
public enum ChatWarnEnum implements ExceptionInterface{
    POST_FAILED_1("ChatWarn001", "在发送聊天时，未找到对应群聊"),
    POST_FAILED_2("ChatWarn002", "错误，尝试向未加入的聊天群发送聊天"),
    POST_FAILED_3("ChatWarn003","发送聊天失败"),
    GET_FAILED_ALL_1("ChatWarn004","获取聊天时，未找到对应群聊"),
    GET_FAILED_ALL_2("ChatWarn005","错误，尝试获得未加入的聊天群内容"),
    GET_FAILED_ALL_3("ChatWarn006","获取聊天失败"),
    DELETE_FAILED_1("ChatWarn007","在删除聊天时，未找到对应聊天"),
    DELETE_FAILED_2("ChatWarn008","错误，尝试删除非用户自己发送的聊天"),
    DELETE_FAILED_3("ChatWarn009","删除聊天失败"),
    GET_FAILED_1("ChatWarn010","获取聊天失败"),
    GET_FAILED_2("ChatWarn011","错误，尝试获得未加入的聊天群内容"),
    ;

    ChatWarnEnum(String code, String msg) {
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