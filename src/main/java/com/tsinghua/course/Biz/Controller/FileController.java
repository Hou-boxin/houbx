package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Error.FileWarnEnum;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.FileParams.In.File_UploadParams_In;
import com.tsinghua.course.Biz.Controller.Params.FileParams.Out.File_UploadParams_Out;
import com.tsinghua.course.Biz.Processor.FileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @描述 文件控制器，用于执行文件相关的业务
 **/
@Component
public class FileController {
    @Autowired
    FileProcessor fileProcessor;

    /**
     * 发送聊天业务
     */
    @BizType(BizTypeEnum.FILE_UPLOAD)
    @NeedLogin
    public File_UploadParams_Out uploadFile(File_UploadParams_In inParams) throws Exception {
        String url = fileProcessor.uploadFile(inParams);
        if (url == null)
            throw new CourseWarn(FileWarnEnum.UPLOAD_FAILED);

        return new File_UploadParams_Out(url);
    }
}
