package com.tsinghua.course.Base.Model;

import com.tsinghua.course.Base.Enum.UserType;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @描述 对应mongodb中的User集合，mongodb是非关系型数据库，可以存储的对象类型很丰富，使用起来方便很多
 **/
@Document("User")
public class User {
    /** 子对象文档 */
    public static class SubObj {
        /** 存储的时间 */
        String time;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
    // mongodb唯一id
    String id;
    // 用户名
    String username;
    // 密码
    String password;
    // 绑定手机号
    String phone_number;
    // 绑定邮箱
    String email;
    // 性别
    String gender;
    // 地址
    String address;
    // 个性签名
    String introduction;

    // 联系人
    // 存储用户名
    ArrayList<String> contacts;
    // 头像
    String avatar;

    // 测试数组
    String[] testArr;
    // 测试对象
    Map<String, String> testObj;
    // 另一个测试对象，和 Map<String, String> 方式存储的格式是一样的，但是直观很多
    SubObj subObj;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {this.phone_number = phone_number;}

    public String getPhone_number() {return this.phone_number;}

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    public  void setContacts(ArrayList<String> contacts)  {this.contacts = contacts;}

    public ArrayList<String> getContacts() {return this.contacts;}

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getAvatar() { return avatar; }

    public void setGender(String gender) { this.gender = gender; }

    public String getGender() { return gender; }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return address; }

    public void setIntroduction(String introduction) { this.introduction = introduction; }

    public String getIntroduction() { return introduction; }

    public String[] getTestArr() {
        return testArr;
    }

    public void setTestArr(String[] testArr) {
        this.testArr = testArr;
    }

    public Map<String, String> getTestObj() {
        return testObj;
    }

    public void setTestObj(Map<String, String> testObj) {
        this.testObj = testObj;
    }

    public SubObj getSubObj() {
        return subObj;
    }

    public void setSubObj(SubObj subObj) {
        this.subObj = subObj;
    }

}
