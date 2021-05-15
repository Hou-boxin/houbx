package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Base.Model.Comment;
import com.tsinghua.course.Biz.Controller.Params.CommentParams.In.Comment_PostParams_In;
import com.tsinghua.course.Biz.Controller.Params.CommentParams.In.Comment_UpdateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 评论原子处理器，所有与评论相关的原子操作都在此处理器中执行
 **/
@Component
public class CommentProcessor {
    @Autowired
    MongoTemplate mongoTemplate;

    /** 根据用户名从数据库中获取评论 */
    public ArrayList<Comment> getCommentByMoment(String moment_id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.COMMENT_ON).is(moment_id));
        ArrayList<Comment> comments = new ArrayList<Comment>();

        try {
            comments.addAll(mongoTemplate.find(query, Comment.class));
            return comments;
        } catch (Exception e) {
            return null;
        }
    }

    /** 根据ID从数据库中获取评论 */
    public Comment getCommentById(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.COMMENT_ID).is(id));

        try {
            Comment comment = mongoTemplate.findOne(query, Comment.class);
            return comment;
        } catch (Exception e) {
            return null;
        }
    }

    /** 发布评论 */
    public Comment postComment(Comment_PostParams_In inParams) {
        Comment comment = new Comment();
        comment.setId(null);
        comment.setUsername(inParams.getUsername());
        comment.setContent(inParams.getText());
        comment.setMoment_id(inParams.getMoment_id());
        comment.setTime(String.valueOf(System.currentTimeMillis()));

        try {
            mongoTemplate.insert(comment, KeyConstant.COMMENT);
            return comment;
        } catch (Exception e) {
            return null;
        }
    }

    /** 编辑评论 **/
    public boolean updateComment(Comment_UpdateParams inParams){
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.COMMENT_ID).is(inParams.getId()));
        Update update = new Update();
        update.set(KeyConstant.COMMENT_TEXT, inParams.getContent());
        update.set(KeyConstant.TIME, String.valueOf(System.currentTimeMillis()));

        try {
            mongoTemplate.updateFirst(query, update, Comment.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 删除评论 **/
    public boolean deleteComment(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.COMMENT_ID).is(id));

        try {
            mongoTemplate.remove(query, Comment.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
