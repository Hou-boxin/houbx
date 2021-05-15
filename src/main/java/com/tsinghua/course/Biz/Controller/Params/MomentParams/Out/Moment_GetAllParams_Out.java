package com.tsinghua.course.Biz.Controller.Params.MomentParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 获取全部动态的出参
 **/
@BizType(BizTypeEnum.MOMENT_GETALL)
public class Moment_GetAllParams_Out extends CommonOutParams {
    // moment列表
    private ArrayList<Moment_GetParams_Out> moments;

    public Moment_GetAllParams_Out(ArrayList<Moment_GetParams_Out> moments) {
        setMoments(moments);
    }

    public void setMoments(ArrayList<Moment_GetParams_Out> moments) { this.moments = moments; }

    public ArrayList<Moment_GetParams_Out> getMoments() { return moments; }
}
