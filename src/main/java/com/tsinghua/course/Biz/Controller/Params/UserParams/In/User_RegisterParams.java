package com.tsinghua.course.Biz.Controller.Params.UserParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Annotation.Required;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 用户注册的入参
 **/
@BizType(BizTypeEnum.USER_REGISTER)
public class User_RegisterParams extends CommonInParams {
    // 注册名
    @Required
    private String target_username;

    // 注册用的密码
    @Required
    private String password;

    // 注册用的邮箱
    @Required
    private String email;

    // 注册用的电话
    @Required
    private String phone_number;

    // 头像
    private String avatar;

    // 性别
    private String gender;

    // 地址
    private String address;

    // 个性签名
    private String introduction;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public void setTarget_username(String target_username) { this.target_username = target_username; }

    public String getTarget_username() { return target_username; }

    public String getPhone_number() { return phone_number; }

    public void setPhone_number(String phone_number) { this.phone_number = phone_number; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return gender; }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return address; }

    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getIntroduction() { return introduction; }
}
