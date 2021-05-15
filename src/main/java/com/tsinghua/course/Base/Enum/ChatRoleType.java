package com.tsinghua.course.Base.Enum;

/**
 * @描述 群聊身份类型枚举
 **/
public enum ChatRoleType {
    NORMAL("普通群友"),
    ADMIN("群主")
            ;

    ChatRoleType(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }
}
