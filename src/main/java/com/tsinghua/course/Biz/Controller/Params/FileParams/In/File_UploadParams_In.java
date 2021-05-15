package com.tsinghua.course.Biz.Controller.Params.FileParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;
import io.netty.handler.codec.http.multipart.FileUpload;

/**
 * @描述 上传文件的入参
 **/
@BizType(BizTypeEnum.FILE_UPLOAD)
public class File_UploadParams_In extends CommonInParams {
    // 文件
    @Required
    private FileUpload file;

    public FileUpload getFile() { return file; }

    public void setFile(FileUpload file) { this.file = file; }
}
