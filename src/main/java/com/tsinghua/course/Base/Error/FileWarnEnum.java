package com.tsinghua.course.Base.Error;

/**
 * @描述 评论操作警告枚举
 **/
public enum FileWarnEnum implements ExceptionInterface{
    UPLOAD_FAILED("FileWarn001","上传文件失败"),
    ;

    FileWarnEnum(String code, String msg) {
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