package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Error.MomentWarnEnum;
import com.tsinghua.course.Base.Model.Moment;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;
import com.tsinghua.course.Biz.Controller.Params.MomentParams.In.*;
import com.tsinghua.course.Biz.Controller.Params.MomentParams.Out.Moment_GetAllParams_Out;
import com.tsinghua.course.Biz.Controller.Params.MomentParams.Out.Moment_GetParams_Out;
import com.tsinghua.course.Biz.Controller.Params.MomentParams.Out.Moment_PostParams_Out;
import com.tsinghua.course.Biz.Processor.MomentProcessor;
import com.tsinghua.course.Biz.Processor.UserProcessor;
import com.tsinghua.course.Frame.Util.SocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 动态控制器，用于执行动态相关的业务
 **/
@Component
public class MomentController {
    @Autowired
    MomentProcessor momentProcessor;
    @Autowired
    UserProcessor userProcessor;

    /** 获取动态业务 */
    @BizType(BizTypeEnum.MOMENT_GET)
    @NeedLogin
    public Moment_GetParams_Out momentGet(Moment_GetParams_In inParams) throws Exception {
        Moment moment = momentProcessor.getMomentById(inParams.getId());
        if (moment == null)
            throw new CourseWarn(MomentWarnEnum.GET_FAILED_1);

        User user = userProcessor.getUserByUsername(moment.getUsername());
        if (!user.getContacts().contains(inParams.getUsername()))
            throw new CourseWarn(MomentWarnEnum.GET_FAILED_2);

        return new Moment_GetParams_Out(moment);
    }

    /** 获得全部动态业务 **/
    /** 默认获得登录人的动态 **/
    @BizType(BizTypeEnum.MOMENT_GETALL)
    @NeedLogin
    public Moment_GetAllParams_Out momentGetAll(Moment_GetAllParams_In inParams) throws Exception{
        ArrayList<Moment> moments;
        if (inParams.getTarget_username() != null)
        {
            User user = userProcessor.getUserByUsername(inParams.getUsername());
            if (!user.getContacts().contains(inParams.getTarget_username()))
                throw new CourseWarn(MomentWarnEnum.GET_ALL_FAILED_2);

            moments = momentProcessor.getMomentByUsername(inParams.getTarget_username());
        }
        else
            moments = momentProcessor.getMomentByUsername(inParams.getUsername());

        if (moments == null || moments.isEmpty())
            throw new CourseWarn(MomentWarnEnum.GET_ALL_FAILED_1);

        ArrayList<Moment_GetParams_Out> moments_params = new ArrayList<Moment_GetParams_Out>();
        int size = moments.size();
        for(int i = 0; i < size; i++)
            moments_params.add(new Moment_GetParams_Out(moments.get(i)));

        return new Moment_GetAllParams_Out(moments_params);
    }


    /** 发送动态业务 */
    /** 提醒所有好友有新的动态 **/
    @BizType(BizTypeEnum.MOMENT_POST)
    @NeedLogin
    public Moment_PostParams_Out momentPost(Moment_PostParams_In inParams) throws Exception {
        Moment moment = momentProcessor.postMoment(inParams);
        if (moment == null)
            throw new CourseWarn(MomentWarnEnum.POST_FAILED);

        User user = userProcessor.getUserByUsername(inParams.getUsername());
        SocketUtil.newMoment(user.getContacts(), moment.getId());
        return new Moment_PostParams_Out(moment.getId());
    }

    /** 编辑动态业务 **/
    @BizType(BizTypeEnum.MOMENT_UPDATE)
    @NeedLogin
    public CommonOutParams momentUpdate(Moment_UpdateParams inParams) throws Exception{
        /** 目标动态不存在 **/
        Moment moment = momentProcessor.getMomentById(inParams.getId());
        if(moment == null)
            throw new CourseWarn(MomentWarnEnum.UPDATE_FAILED_1);

        if(!moment.getUsername().equals(inParams.getUsername()))
            throw new CourseWarn(MomentWarnEnum.UPDATE_FAILED_2);

        if (!momentProcessor.updateMoment(inParams))
            throw new CourseWarn(MomentWarnEnum.UPDATE_FAILED_3);

        return new CommonOutParams(true);
    }

    /** 删除动态业务 */
    /** 默认只能删除自己的 **/
    @BizType(BizTypeEnum.MOMENT_DELETE)
    public CommonOutParams momentDelete(Moment_DeleteParams inParams) throws Exception {
        Moment moment = momentProcessor.getMomentById(inParams.getId());
        if (moment == null)
            throw new CourseWarn(MomentWarnEnum.DELETE_FAILED_1);

        if (!moment.getUsername().equals(inParams.getUsername()))
            throw new CourseWarn(MomentWarnEnum.DELETE_FAILED_2);

        if (!momentProcessor.deleteMoment(inParams.getId()))
            throw new CourseWarn(MomentWarnEnum.DELETE_FAILED_3);

        return new CommonOutParams();
    }

    /** 点赞动态业务 */
    /** 不可重复点赞同一动态 **/
    /** 提醒所有人有新的点赞 **/
    @BizType(BizTypeEnum.MOMENT_LIKE)
    public CommonOutParams momentLike(Moment_LikeParams inParams) throws Exception {
        Moment moment = momentProcessor.getMomentById(inParams.getId());
        if (moment == null)
            throw new CourseWarn(MomentWarnEnum.LIKE_FAILED_1);

        if (moment.getLike() != null && moment.getLike().contains(inParams.getUsername()))
            throw new CourseWarn(MomentWarnEnum.LIKE_FAILED_2);

        if (!momentProcessor.likeMoment(inParams.getUsername(), inParams.getId()))
            throw new CourseWarn(MomentWarnEnum.LIKE_FAILED_3);

        SocketUtil.newLike(moment.getUsername(), moment.getId());
        return new CommonOutParams();
    }

    /** 删除点赞动态业务 */
    @BizType(BizTypeEnum.MOMENT_DELETE_LIKE)
    public CommonOutParams momentDeleteLike(Moment_DeleteLikeParams inParams) throws Exception{
        Moment moment = momentProcessor.getMomentById(inParams.getId());
        if (moment == null)
            throw new CourseWarn(MomentWarnEnum.DELETE_LIKE_FAILED_1);

        if (moment.getLike() != null && !moment.getLike().contains(inParams.getUsername()))
            throw new CourseWarn(MomentWarnEnum.DELETE_LIKE_FAILED_2);

        if (momentProcessor.deleteLike(inParams.getUsername(), inParams.getId()))
            throw new CourseWarn(MomentWarnEnum.DELETE_LIKE_FAILED_3);

        return new CommonOutParams();
    }
}
