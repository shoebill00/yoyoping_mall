package com.yoyoping.admin.service;

/**
 * @author zhangzheng on 12/3/2023
 */
public interface AdminAccountService {

    /**
     * 用户名密码注册
     * @param account 账户名
     * @param password  密码
     * @return  是否成功
     */
    boolean registerByAccount(String account,String password);



}
