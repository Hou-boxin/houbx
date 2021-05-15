package com.tsinghua.course.Biz.Controller.Params.UserParams.Out;

import com.tsinghua.course.Base.Annotation.BizType;
import com.tsinghua.course.Biz.BizTypeEnum;
import com.tsinghua.course.Biz.Controller.Params.CommonOutParams;

import java.util.ArrayList;

/**
 * @描述 所有联系人的出参
 **/
@BizType(BizTypeEnum.USER_GET_CONTACTS)
public class User_GetAllContactsParams extends CommonOutParams {
    public User_GetAllContactsParams(ArrayList<User_GetParams_Out> contacts) {
        setContacts(contacts);
    }

    // 用户信息列表
    private ArrayList<User_GetParams_Out> contacts;

    public void setContacts(ArrayList<User_GetParams_Out> contacts) { this.contacts = contacts; }

    public ArrayList<User_GetParams_Out> getContacts() { return contacts; }
}
