package dao.impl;

import entity.Enter;

public interface EnterDaoImpl {

//    用户登入
    public Enter selectLogin(String enter_telephone, String enter_password);

//    用户注册
    public int addEnter(Enter enter);

//    判断注册手机号码是否重复
    public int pattPhone(String phone);


    //判断手机号是否重复
    public int codeId(String id);

//    查询
    public Enter showBy(int id);

//    更新
    public int update(Enter enter);
}
