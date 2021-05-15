package com.tsinghua.course.Biz.Controller;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.NeedLogin;
import com.tsinghua.course.Base.Error.CommentWarnEnum;
import com.tsinghua.course.Base.Error.CourseWarn;
import com.tsinghua.course.Base.Model.Comment;
import com.tsinghua.course.Base.Model.Moment;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommentParams.In.*;
import com.tsinghua.course.Biz.Controller.Params.CommentParams.Out.Comment_GetAllParams_Out;
import com.tsinghua.course.Biz.Controller.Params.CommentParams.Out.Comment_GetParams_Out;
import com.tsinghua.course.Biz.Controller.Params.CommentParams.Out.Comment_PostParams_Out;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;
import com.tsinghua.course.Biz.Processor.CommentProcessor;
import com.tsinghua.course.Biz.Processor.MomentProcessor;
import com.tsinghua.course.Biz.Processor.UserProcessor;
import com.tsinghua.course.Frame.Util.SocketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 评论控制器，用于执行评论相关的业务
 **/
@Component
public class CommentController {
    @Autowired
    CommentProcessor commentProcessor;
    @Autowired
    MomentProcessor momentProcessor;
    @Autowired
    UserProcessor userProcessor;

    /** 评论动态业务 */
    @BizType(BizTypeEnum.COMMENT_POST)
    @NeedLogin
    public Comment_PostParams_Out postComment(Comment_PostParams_In inParams) throws Exception {
        Moment moment = momentProcessor.getMomentById(inParams.getMoment_id());
        if (moment == null)
            throw new CourseWarn(CommentWarnEnum.POST_FAILED_1);

        User user = userProcessor.getUserByUsername(moment.getUsername());
        if (!user.getContacts().contains(inParams.getUsername()))
            throw new CourseWarn(CommentWarnEnum.POST_FAILED_3);

        Comment comment = commentProcessor.postComment(inParams);
        if (comment == null)
            throw new CourseWarn(CommentWarnEnum.POST_FAILED_2);

        SocketUtil.newComment(moment.getUsername(), moment.getId(), comment.getId());
        return new Comment_PostParams_Out(comment.getId());
    }

    /** 获取一条评论业务 */
    @BizType(BizTypeEnum.COMMENT_GET)
    @NeedLogin
    public Comment_GetParams_Out getComment(Comment_GetParams_In inParams) throws Exception {
        Comment comment = commentProcessor.getCommentById(inParams.getId());
        if (comment == null)
            throw new CourseWarn(CommentWarnEnum.GET_FAILED_1);

        Moment moment = momentProcessor.getMomentById(comment.getMoment_id());
        User user = userProcessor.getUserByUsername(moment.getUsername());
        if (!user.getContacts().contains(inParams.getUsername()))
            throw new CourseWarn(CommentWarnEnum.GET_FAILED_2);

        return new Comment_GetParams_Out(comment);
    }

    /** 获取某个动态的全部评论业务 **/
    @BizType(BizTypeEnum.COMMENT_GETALL)
    @NeedLogin
    public Comment_GetAllParams_Out getAllComment(Comment_GetAllParams_In inParams) throws Exception{
        ArrayList<Comment> comments = commentProcessor.getCommentByMoment(inParams.getMoment_id());
        if (comments == null || comments.isEmpty())
            throw new CourseWarn(CommentWarnEnum.GET_ALL_FAILED_1);

        Moment moment = momentProcessor.getMomentById(inParams.getMoment_id());
        User user = userProcessor.getUserByUsername(moment.getUsername());
        if (!user.getContacts().contains(inParams.getUsername()))
            throw new CourseWarn(CommentWarnEnum.GET_ALL_FAILED_2);

        ArrayList<Comment_GetParams_Out> comments_params = new ArrayList<Comment_GetParams_Out>();
        int size = comments.size();
        for(int i = 0; i < size; i++)
            comments_params.add(new Comment_GetParams_Out(comments.get(i)));

        return new Comment_GetAllParams_Out(comments_params);
    }

    /** 编辑评论业务 */
    /** 默认只能编辑自己的 **/
    @BizType(BizTypeEnum.COMMENT_UPDATE)
    @NeedLogin
    public CommonOutParams updateComment(Comment_UpdateParams inParams) throws Exception {
        Comment comment = commentProcessor.getCommentById(inParams.getId());
        if (comment == null)
            throw new CourseWarn(CommentWarnEnum.UPDATE_FAILED_1);

        if (!comment.getUsername().equals(inParams.getUsername()))
            throw new CourseWarn(CommentWarnEnum.UPDATE_FAILED_2);

        if (!commentProcessor.updateComment(inParams))
            throw new CourseWarn(CommentWarnEnum.UPDATE_FAILED_3);

        return new CommonOutParams();
    }

    /** 删除评论业务 */
    /** 默认只能删除自己的 **/
    @BizType(BizTypeEnum.COMMENT_DELETE)
    @NeedLogin
    public CommonOutParams deleteComment(Comment_DeleteParams inParams) throws Exception {
        Comment comment = commentProcessor.getCommentById(inParams.getId());
        if (comment == null)
            throw new CourseWarn(CommentWarnEnum.DELETE_FAILED_1);

        if (!comment.getUsername().equals(inParams.getUsername()))
            throw new CourseWarn(CommentWarnEnum.DELETE_FAILED_2);

        if (!commentProcessor.deleteComment(inParams.getId()))
            throw new CourseWarn(CommentWarnEnum.DELETE_FAILED_3);

        return new CommonOutParams();
    }
}
