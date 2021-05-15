package com.tsinghua.course.Base.Constant;

/**
 * @描述 用于key的常量列表，一般对应于类中的属性名称，如User类中的username属性
 **/
public class KeyConstant {
    /** 以下为全局通用key */
    // 参数
    public static final String PARAMS = "params";
    // 路径
    public static final String PATH = "path";
    // 操作类型
    public static final String BIZ_TYPE = "bizType";

    public static final String TIME = "time";
    /** 以下为User关键key */
    public static final String USER = "User";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PHONE_NUMBER = "phone_number";
    public static final String EMAIL = "email";
    public static final String CONTACTS = "contacts";
    public static final String AVATAT = "avatar";
    public static final String GENDER = "gender";
    public static final String ADDRESS = "address";
    public static final String INTRODUCTION = "introduction";

    /** 以下为Moment关键key */
    public static final String MOMENT = "Moment";
    public static final String MOMENT_ID = "id";
    public static final String SENDER = "username";
    public static final String MOMENT_TEXT = "text";
    public static final String MOMENT_IMAGES = "images";
    public static final String MOMENT_VEDIOS = "vedios";
    public static final String MOMENT_AUDIOS = "audios";
    public static final String LIKE = "like";

    /** 以下为Comment关键key **/
    public static final String COMMENT = "Comment";
    public static final String COMMENT_ID = "id";
    public static final String COMMENTATOR = "username";
    public static final String COMMENT_ON = "moment_id";
    public static final String COMMENT_TEXT = "content";

    /** 以下为ChatGroup关键key **/
    public static final String CHATGROUP = "ChatGroup";
    public static final String CHATGROUP_ID = "id";
    public static final String TITLE = "title";
    public static final String LATEST_POSTTIME = "latest_posttime";
    public static final String INVOLVERS = "involvers";
    public static final String ROLES = "roles";

    /** 以下为Chat关键key **/
    public static final String CHAT = "Chat";
    public static final String CHAT_ID = "id";
    public static final String CHAT_ON = "chatgroup_id";
    public static final String CHAT_TEXT = "text";

    /** 以下为Notification关键key **/
    public static final String NOTIFICATION = "Notification";
    public static final String NOTIFICATION_ID = "id";
    public static final String RECEIVERS = "receivers";
    public static final String NOTIFICATION_TITLE = "title";
    public static final String NOTIFICATION_TEXT = "text";
    public static final String IS_READ = "is_read";
    public static final String TRUE = "true";
    public static final String FALSE = "false";

    /** 以下为File关键key **/
    public static final String FILE_STORE_PATH = "/html/file";
}
