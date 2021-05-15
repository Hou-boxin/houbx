package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Base.Enum.GenderType;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.Controller.Params.UserParams.In.User_RegisterParams;
import com.tsinghua.course.Biz.Controller.Params.UserParams.In.User_UpdateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 用户原子处理器，所有与用户相关的原子操作都在此处理器中执行
 **/
@Component
public class UserProcessor {
    @Autowired
    MongoTemplate mongoTemplate;

    /** 根据用户名从数据库中获取用户 */
    public User getUserByUsername(String username) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.USERNAME).is(username));

        try {
            User user = mongoTemplate.findOne(query, User.class);
            return user;
        }catch (Exception e){
            return null;
        }
    }

    /** 向数据库中新增用户 **/
    /** 禁止同名的用户 **/
    public boolean addUser(User_RegisterParams inParams) {
        User user = new User();
        user.setUsername(inParams.getTarget_username());
        user.setPassword(inParams.getPassword());
        user.setEmail(inParams.getEmail());
        user.setPhone_number(inParams.getPhone_number());
        user.setContacts(new ArrayList<String>());
        if (inParams.getAvatar() != null)
            user.setAvatar(inParams.getAvatar());
        else
            user.setAvatar("");
        if (inParams.getGender() != null)
            user.setGender(inParams.getGender());
        else
            user.setGender(GenderType.UNKNOWN.getName());
        if (inParams.getAddress() != null)
            user.setAddress(inParams.getAddress());
        else
            user.setAddress("");
        if (inParams.getIntroduction() != null)
            user.setIntroduction(inParams.getIntroduction());
        else
            user.setIntroduction("");

        try {
            mongoTemplate.insert(user, KeyConstant.USER);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 更新数据库中的用户信息 **/
    /** 可更新头像、邮件、电话、密码**/
    public boolean updateUser(User_UpdateParams inParams) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.USERNAME).is(inParams.getUsername()));
        Update update = new Update();

        if (inParams.getEmail() != null)
            update.set(KeyConstant.EMAIL, inParams.getEmail());
        if (inParams.getAvatar() != null)
            update.set(KeyConstant.AVATAT, inParams.getAvatar());
        if (inParams.getPhone_number() != null)
            update.set(KeyConstant.PHONE_NUMBER, inParams.getPhone_number());
        if (inParams.getGender() != null)
            update.set(KeyConstant.GENDER, inParams.getGender());
        if (inParams.getAddress() != null)
            update.set(KeyConstant.ADDRESS, inParams.getAddress());
        if (inParams.getIntroduction() != null)
            update.set(KeyConstant.INTRODUCTION, inParams.getIntroduction());

        try {
            mongoTemplate.updateFirst(query, update, User.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 添加好友 **/
    public boolean addContact(String username, String target_username) throws Exception{
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.USERNAME).is(username));
        Update update = new Update().push(KeyConstant.CONTACTS, target_username);

        try {
            mongoTemplate.updateFirst(query, update, User.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 删除好友 **/
    public boolean deleteContact(String username, String target_username) throws Exception{
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.USERNAME).is(username));
        Update update = new Update().pull(KeyConstant.CONTACTS, target_username);

        try {
            mongoTemplate.updateFirst(query, update, User.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
