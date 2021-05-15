package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Base.Model.Comment;
import com.tsinghua.course.Base.Model.Moment;
import com.tsinghua.course.Biz.Controller.Params.MomentParams.In.Moment_PostParams_In;
import com.tsinghua.course.Biz.Controller.Params.MomentParams.In.Moment_UpdateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 动态原子处理器，所有与动态相关的原子操作都在此处理器中执行
 **/
@Component
public class MomentProcessor {
    @Autowired
    MongoTemplate mongoTemplate;

    /** 根据用户名从数据库中获取动态 */
    public ArrayList<Moment> getMomentByUsername(String username) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.SENDER).is(username));
        ArrayList<Moment> moments = new ArrayList<Moment>();

        try {
            moments.addAll(mongoTemplate.find(query, Moment.class));
            return moments;
        } catch (Exception e) {
            return null;
        }
    }

    /** 根据ID从数据库中获取动态 */
    public Moment getMomentById(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.MOMENT_ID).is(id));

        try {
            Moment moment = mongoTemplate.findOne(query, Moment.class);
            return moment;
        } catch (Exception e) {
            return null;
        }
    }

    /** 发布动态 */
    public Moment postMoment(Moment_PostParams_In inParams) {
        Moment moment = new Moment();
        moment.setId(null);
        moment.setUsername(inParams.getUsername());
        if (inParams.getText() != null)
            moment.setText(inParams.getText());
        else
            moment.setText("");
        if (inParams.getImages() != null)
            moment.setImages(inParams.getImages());
        else
            moment.setImages(new ArrayList<String>());
        if (inParams.getVedios() != null)
            moment.setVedios(inParams.getVedios());
        else
            moment.setVedios(new ArrayList<String>());
        if (inParams.getAudios() != null)
            moment.setAudios(inParams.getAudios());
        else
            moment.setAudios(new ArrayList<String>());
        moment.setLike(new ArrayList<String>());
        moment.setTime(String.valueOf(System.currentTimeMillis()));

        try {
            mongoTemplate.insert(moment, KeyConstant.MOMENT);
            return moment;
        } catch (Exception e) {
            return null;
        }
    }

    /** 编辑动态 **/
    public boolean updateMoment(Moment_UpdateParams inParams) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.MOMENT_ID).is(inParams.getId()));
        Update update = new Update();
        if (inParams.getText() != null)
            update.set(KeyConstant.MOMENT_TEXT, inParams.getText());
        if (inParams.getImages() != null)
            update.set(KeyConstant.MOMENT_IMAGES, inParams.getImages());
        if (inParams.getVedios() != null)
            update.set(KeyConstant.MOMENT_VEDIOS, inParams.getVedios());
        if (inParams.getAudios() != null)
            update.set(KeyConstant.MOMENT_AUDIOS, inParams.getAudios());
        update.set(KeyConstant.TIME, String.valueOf(System.currentTimeMillis()));

        try {
            mongoTemplate.updateFirst(query, update, Moment.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 删除动态 **/
    /** 级联删除该动态的所有评论 **/
    public boolean deleteMoment(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.MOMENT_ID).is(id));
        Query query_comment = new Query().addCriteria(Criteria.where(KeyConstant.COMMENT_ON).is(id));

        try {
            mongoTemplate.findAllAndRemove(query_comment, Comment.class);
            mongoTemplate.remove(query, Moment.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 点赞动态 **/
    public boolean likeMoment(String username, String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.MOMENT_ID).is(id));
        Update update = new Update().push(KeyConstant.LIKE, username);

        try {
            mongoTemplate.updateFirst(query, update, Moment.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 删除点赞 **/
    public boolean deleteLike(String username, String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.MOMENT_ID).is(id));
        Update update = new Update().pull(KeyConstant.LIKE, username);

        try {
            mongoTemplate.updateFirst(query, update, Moment.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
