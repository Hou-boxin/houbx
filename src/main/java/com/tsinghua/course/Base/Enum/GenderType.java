package com.tsinghua.course.Base.Enum;

/**
 * @描述 性别类型枚举
 **/
public enum GenderType {
    MALE("男性"),
    FEMALE("女性"),
    UNKNOWN("未知")
            ;

    GenderType(String name) {
        this.name = name;
    }

    String name;

    public String getName() {
        return name;
    }
}
