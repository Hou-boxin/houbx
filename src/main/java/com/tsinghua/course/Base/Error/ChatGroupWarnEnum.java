package com.tsinghua.course.Base.Error;

/**
 * @描述 动态操作警告枚举
 **/
public enum ChatGroupWarnEnum implements ExceptionInterface{
    POST_FAILED_1("ChatGroupWarn001", "群聊人数至少为2"),
    POST_FAILED_2("ChatGroupWarn002", "发起群聊失败"),
    GET_FAILED_1("ChatGroupWarn003","群聊不存在"),
    GET_ALL_FAILED("ChatGroupWarn004","目标用户未参与任何群聊"),
    DELETE_FAILED_1("ChatGroupWarn005","删除群聊时，未找到对应群聊"),
    DELETE_FAILED_2("ChatGroupWarn006", "错误，只有本群群主才能解散群聊"),
    DELETE_FAILED_3("ChatGroupWarn007","解散群聊失败"),
    JOIN_FAILED_1("ChatGroupWarn008","在加入群聊时，未找到对应群聊"),
    JOIN_FAILED_2("ChatGroupWarn009","在加入群聊时，未找到对应用户"),
    JOIN_FAILED_3("ChatGroupWarn010","错误，没有权限邀请目标用户加入群聊"),
    JOIN_FAILED_4("ChatGroupWarn011","错误，目标用户已在群聊中，不可重复添加"),
    JOIN_FAILED_5("ChatGroupWarn012","加入群聊失败"),
    QUIT_FAILED_1("ChatGroupWarn013","在退出群聊时，未找到对应群聊"),
    QUIT_FAILED_2("ChatGroupWarn014","在退出群聊时，未找到对应用户"),
    QUIT_FAILED_3("ChatGroupWarn015","错误，没有权限让目标用户退出群聊"),
    QUIT_FAILED_4("ChatGroupWarn016","错误，目标用户不在群聊中，不可让其退出群聊"),
    QUIT_FAILED_5("ChatGroupWarn017","退出群聊失败"),
    GET_FAILED_2("ChatGroupWarn018","错误，尝试获取未加入的群聊信息")
    ;

    ChatGroupWarnEnum(String code, String msg) {
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