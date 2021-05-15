package com.tsinghua.course.Biz;

import com.tsinghua.course.Biz.Controller.*;
import com.tsinghua.course.Biz.Controller.NotificationController;

/**
 * @描述 业务类型枚举，所有的业务类型都需要枚举在此类中
 **/
public enum BizTypeEnum {
    /** 以下为用户业务类型 */
    USER_LOGIN(UserController.class, "/user/login", "用户登录"),
    USER_REGISTER(UserController.class, "/user/register", "用户注册"),
    USER_GET(UserController.class, "/user/get", "获取用户信息"),
    USER_UPDATE(UserController.class, "/user/update","更新用户信息" ),
    USER_ADD(UserController.class, "/user/add", "添加好友"),
    USER_DELETE(UserController.class, "/user/delete", "删除好友"),
    USER_GET_CONTACTS(UserController.class, "/user/get_contacts", "获取联系人"),

    /** 以下为动态业务类型 **/
    MOMENT_GET(MomentController.class, "/moment/get", "获取一条动态"),
    MOMENT_GETALL(MomentController.class,"/moment/get_all", "获取用户的全部动态"),
    MOMENT_POST(MomentController.class, "/moment/post", "发送动态"),
    MOMENT_DELETE(MomentController.class, "/moment/delete", "删除动态"),
    MOMENT_UPDATE(MomentController.class,"/moment/update","更新动态"),
    MOMENT_LIKE(MomentController.class, "/moment/like", "点赞动态"),
    MOMENT_DELETE_LIKE(MomentController.class, "/moment/delete_like","删除点赞"),

    /** 以下为评论业务类型 **/
    COMMENT_POST(CommentController.class, "/comment/post", "评论动态"),
    COMMENT_DELETE(CommentController.class, "/comment/delete", "删除评论"),
    COMMENT_GET(CommentController.class,"/comment/get","获得评论"),
    COMMENT_GETALL(CommentController.class,"/comment/get_all","获得一个动态的全部评论"),
    COMMENT_UPDATE(CommentController.class,"/comment/update","编辑评论"),

    /** 以下为聊天群业务类型 **/
    CHATGROUP_GET(ChatGroupController.class,"/chatgroup/get", "获取聊天群"),
    CHATGROUP_GETALL(ChatGroupController.class,"/chatgroup/get_all","获取用户的全部聊天群"),
    CHATGROUP_POST(ChatGroupController.class, "/chatgroup/post", "发起聊天群"),
    CHATGROUP_DELETE(ChatGroupController.class,"/chatgroup/delete","删除聊天群"),
    CHATGROUP_UPDATE(ChatGroupController.class,"/chatgroup/update","编辑聊天群"),
    CHATGROUP_JOIN(ChatGroupController.class,"/chatgroup/join","加入群聊"),
    CHATGROUP_QUIT(ChatGroupController.class,"/chatgroup/quit","退出群聊"),

    /** 以下为聊天业务类型 **/
    CHAT_GET(ChatController.class,"/chat/get","获取一条消息"),
    CHAT_GETALL(ChatController.class,"/chat/get_all","获取群聊中的全部消息"),
    CHAT_POST(ChatController.class, "/chat/post", "发送消息"),
    CHAT_DELETE(ChatController.class,"/chat/delete", "删除消息"),

    /** 通知业务类型 **/
    NOTIFICATION_POST(NotificationController.class,"/notification/post","发送消息"),
    NOTIFICATION_GET(NotificationController.class,"/notification/get","获取消息"),
    NOTIFICATION_GETALL(NotificationController.class,"/notification/get_all","获取用户的全部消息"),

    /** 文件业务类型 **/
    FILE_UPLOAD(FileController.class,"/file/upload","上传文件"),

    /** 定时任务业务测试 */
    LOG_TEST(TimerController.class, null, "定时日志测试"),


    /** 测试业务，在书写正式代码时可以删除，在书写正式代码前先运行测试业务，如果测试业务无问题说明各模块正常 */
    LOGIN_TEST(TestController.class, "/test/loginPermission", "登录控制测试"),
    ADMIN_TEST(TestController.class, "/test/adminPermission", "管理员权限控制测试"),
    REDIS_TEST(TestController.class, "/test/redis", "redis缓存测试"),
    TIMER_TEST(TestController.class, "/test/timer", "定时器测试"),
    ERROR_TEST(TestController.class, "/test/error", "内部报错测试"),
    FILE_UPLOAD_TEST(TestController.class, "/test/upload", "文件上传测试"),
    FILE_DOWNLOAD_TEST(TestController.class, "/test/url", "获取文件下载的路径"),
    MULTI_RETURN_TEST(TestController.class, "/test/multiParams", "返回多个参数的测试"),
    MONGODB_TEST(TestController.class, "/test/mongodb", "mongodb数据库功能测试")
    ;

    BizTypeEnum(Class<?> controller, String httpPath, String description) {
        this.controller = controller;
        this.description = description;
        this.httpPath = httpPath;
    }

    /** 执行业务具体的类 */
    Class<?> controller;
    /** 业务对应的http请求路径 */
    String httpPath;
    /** 业务描述 */
    String description;

    public Class<?> getControllerClass() {
        return controller;
    }

    public String getDescription() {
        return description;
    }

    public String getHttpPath() {
        return httpPath;
    }
}
