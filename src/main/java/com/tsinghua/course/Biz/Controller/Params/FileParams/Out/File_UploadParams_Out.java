package com.tsinghua.course.Biz.Controller.Params.FileParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 上传文件的出参
 **/
@BizType(BizTypeEnum.FILE_UPLOAD)
public class File_UploadParams_Out extends CommonOutParams {
    // 对应id
    private String url;

    public File_UploadParams_Out(String url) {
        setUrl(url);
    }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }
}
