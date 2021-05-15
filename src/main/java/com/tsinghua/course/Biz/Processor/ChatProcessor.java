package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Base.Model.Chat;
import com.tsinghua.course.Base.Model.ChatGroup;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.In.Chat_GetAllParams_In;
import com.tsinghua.course.Biz.Controller.Params.ChatParams.In.Chat_PostParams_In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @描述 聊天内容原子处理器，所有与聊天内容相关的原子操作都在此处理器中执行
 **/
@Component
public class ChatProcessor {
    @Autowired
    MongoTemplate mongoTemplate;

    /** 获取一条聊天 **/
    public Chat getChatById(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.CHAT_ID).is(id));

        try {
            Chat chat = mongoTemplate.findOne(query, Chat.class);
            return chat;
        } catch (Exception e) {
            return null;
        }
    }

    /** 获取一个群的聊天 **/
    public ArrayList<Chat> getChatAll(Chat_GetAllParams_In inParams) {
        Query query = new Query();
        Criteria criteria = Criteria.where(KeyConstant.CHAT_ON).is(inParams.getChatgroup_id());
        if (inParams.getTarget_username() != null)
            criteria.andOperator(Criteria.where(KeyConstant.USERNAME).is(inParams.getTarget_username()));
        query.addCriteria(criteria);

        ArrayList<Chat> chats = new ArrayList<Chat>();
        try {
            chats.addAll(mongoTemplate.find(query, Chat.class));
            return chats;
        } catch (Exception e) {
            return null;
        }
    }

    /** 发起聊天 **/
    public Chat postChat(Chat_PostParams_In inParams) {
        Chat chat = new Chat();
        chat.setId(null);
        chat.setTime(String.valueOf(System.currentTimeMillis()));
        chat.setChatgroup_id(inParams.getChatgroup_id());
        chat.setUsername(inParams.getUsername());
        if (inParams.getText() != null)
            chat.setText(inParams.getText());
        else
            chat.setText("");
        if (inParams.getImages() != null)
            chat.setImages(inParams.getImages());
        else
            chat.setImages(new ArrayList<String>());
        if (inParams.getVedios() != null)
            chat.setVedios(inParams.getVedios());
        else
            chat.setVedios(new ArrayList<String>());
        if (inParams.getAudios() != null)
            chat.setAudios(inParams.getAudios());
        else
            chat.setAudios(new ArrayList<String>());

        Query query_chatgroup = new Query().
                addCriteria(Criteria.where(KeyConstant.CHATGROUP_ID).is(inParams.getChatgroup_id()));
        Update update = new Update().set(KeyConstant.LATEST_POSTTIME, System.currentTimeMillis());
        try {
            mongoTemplate.insert(chat, KeyConstant.CHAT);
            mongoTemplate.updateFirst(query_chatgroup, update, ChatGroup.class);
            return chat;
        } catch (Exception e) {
            return null;
        }
    }

    /** 删除群天 **/
    public boolean deleteChat(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.CHAT_ID).is(id));

        try {
            mongoTemplate.remove(query, Chat.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
