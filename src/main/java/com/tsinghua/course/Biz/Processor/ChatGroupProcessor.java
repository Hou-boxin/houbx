package com.tsinghua.course.Biz.Processor;

import com.tsinghua.course.Base.Constant.KeyConstant;
import com.tsinghua.course.Base.Enum.ChatRoleType;
import com.tsinghua.course.Base.Model.Chat;
import com.tsinghua.course.Base.Model.ChatGroup;
import com.tsinghua.course.Biz.Controller.Params.ChatGroupParams.In.ChatGroup_PostParams_In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @描述 聊天群原子处理器，所有与聊天群相关的原子操作都在此处理器中执行
 **/
@Component
public class ChatGroupProcessor {
    @Autowired
    MongoTemplate mongoTemplate;

    /** 根据id查找一个群聊 **/
    public ChatGroup getChatGroupById(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.CHATGROUP_ID).is(id));

        try {
            ChatGroup chatgroup = mongoTemplate.findOne(query, ChatGroup.class);
            return chatgroup;
        } catch (Exception e) {
            return null;
        }
    }

    /** 根据用户名查找一个群聊 **/
    /** 将该用户所在的所有群聊都返回 **/
    public ArrayList<ChatGroup> getChatGroupByUsername(String username) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.INVOLVERS).is(username));
        ArrayList<ChatGroup> chatgroups = new ArrayList<ChatGroup>();

        try {
            chatgroups.addAll(mongoTemplate.find(query, ChatGroup.class));
            return chatgroups;
        } catch (Exception e) {
            return null;
        }
    }

    /** 发起一个群聊 **/
    public ChatGroup postChatGroup(ChatGroup_PostParams_In inParams) {
        ChatGroup chatgroup = new ChatGroup();
        chatgroup.setId(null);
        chatgroup.setTitle(inParams.getTitle());
        chatgroup.setLatest_posttime(System.currentTimeMillis());

        ArrayList<String> involvers = inParams.getInvolvers();
        Map<String, ChatRoleType> roles = new HashMap<String, ChatRoleType>();
        int size = involvers.size();
        for (int i = 0; i < size; i++)
        {
            roles.put(involvers.get(i), ChatRoleType.NORMAL);
        }
        involvers.add(inParams.getUsername());
        chatgroup.setInvolvers(involvers);
        roles.put(inParams.getUsername(), ChatRoleType.ADMIN);
        chatgroup.setRoles(roles);

        try {
            mongoTemplate.insert(chatgroup, KeyConstant.CHATGROUP);
            return chatgroup;
        } catch (Exception e) {
            return null;
        }
    }

    /** 删除一个群聊 **/
    /** 级联删除该群聊的所有聊天 **/
    public boolean deleteChatGroup(String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.CHATGROUP_ID).is(id));
        Query query_chat = new Query().addCriteria(Criteria.where(KeyConstant.CHAT_ON).is(id));

        try {
            mongoTemplate.remove(query, ChatGroup.class);
            mongoTemplate.findAllAndRemove(query_chat, Chat.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 加入一个群聊 **/
    public boolean joinChatGroup(String target_username, String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.CHATGROUP_ID).is(id));
        Update update = new Update().push(KeyConstant.INVOLVERS, target_username);
        Update update1 = new Update().set(KeyConstant.ROLES + "." + target_username, ChatRoleType.NORMAL);

        try {
            mongoTemplate.updateFirst(query, update, ChatGroup.class);
            mongoTemplate.updateFirst(query, update1, ChatGroup.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /** 退出一个群聊 **/
    public boolean quitChatGroup(String target_username, String id) {
        Query query = new Query().addCriteria(Criteria.where(KeyConstant.CHATGROUP_ID).is(id));
        Update update = new Update().pull(KeyConstant.INVOLVERS, target_username);
        Update update1 = new Update().unset(KeyConstant.ROLES + "." + target_username);

        try {
            mongoTemplate.updateFirst(query, update, ChatGroup.class);
            mongoTemplate.updateFirst(query, update1, ChatGroup.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
