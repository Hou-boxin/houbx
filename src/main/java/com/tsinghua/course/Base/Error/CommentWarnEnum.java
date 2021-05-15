package com.tsinghua.course.Base.Error;

/**
 * @描述 评论操作警告枚举
 **/
public enum CommentWarnEnum implements ExceptionInterface{
    POST_FAILED_1("CommentWarn001","评论动态时，未找到对应动态"),
    POST_FAILED_2("CommentWarn002","评论动态失败"),
    GET_FAILED_1("CommentWarn003","不存在对应评论"),
    GET_ALL_FAILED_1("CommentWarn004","目标动态不存在评论"),
    UPDATE_FAILED_1("CommentWarn005","编辑评论时，未找到对应动态"),
    UPDATE_FAILED_2("CommentWarn006","错误，尝试编辑非用户自己的评论"),
    UPDATE_FAILED_3("CommentWarn007","编辑评论失败"),
    DELETE_FAILED_1("CommentWarn008", "删除评论时，未找到对应动态"),
    DELETE_FAILED_2("CommentWarn009", "错误，尝试删除非用户自己的评论"),
    DELETE_FAILED_3("CommentWarn010", "删除评论失败"),
    GET_FAILED_2("CommentWarn011","错误，尝试获得非自己好友动态的评论"),
    GET_ALL_FAILED_2("CommentWarn012","错误，尝试获得非自己好友动态的评论"),
    POST_FAILED_3("CommenWarn013","错误，尝试评论非自己好友的动态")
    ;

    CommentWarnEnum(String code, String msg) {
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
