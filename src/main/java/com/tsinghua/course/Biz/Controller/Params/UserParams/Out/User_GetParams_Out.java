package com.tsinghua.course.Biz.Controller.Params.UserParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Base.Model.User;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

/**
 * @描述 用户信息的出参
 **/
@BizType(BizTypeEnum.USER_GET)
public class User_GetParams_Out extends CommonOutParams {
    //ID
    private String id;

    // 用户名
    private String username;

    // 绑定手机号
    private String phone_number;

    // 绑定邮箱
    private String email;

    // 头像
    private String avatar;

    // 性别
    private String gender;

    // 地址
    private String address;

    // 个性签名
    private String introduction;

    public User_GetParams_Out(User user) {
        this.success = true;
        setId(user.getId());
        setUsername(user.getUsername());
        setPhone_number(user.getPhone_number());
        setEmail(user.getEmail());
        setAvatar(user.getAvatar());
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone_number(String phone_number) {this.phone_number = phone_number;}

    public String getPhone_number() {return this.phone_number;}

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getAvatar() { return avatar; }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return gender; }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return address; }

    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getIntroduction() { return introduction; }
}

