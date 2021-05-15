package com.tsinghua.course.Biz.Controller.Params.UserParams.In;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonInParams;

/**
 * @描述 更新用户信息的入参
 **/
@BizType(BizTypeEnum.USER_UPDATE)
public class User_UpdateParams extends CommonInParams {
    // 手机号
    private String phone_number;

    // 注册用的邮箱
    private String email;

    // 头像
    private String avatar;

    // 密码
    private String password;

    // 性别
    private String gender;

    // 地址
    private String address;

    // 个性签名
    private String introduction;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public void setPhone_number(String phone_number) {this.phone_number = phone_number;}

    public String getPhone_number() {return this.phone_number;}

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return gender; }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return address; }

    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getIntroduction() { return introduction; }
}