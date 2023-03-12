package com.yoyoping.admin.service.impl;

import com.yoyoping.admin.dao.AdminAccountDao;
import com.yoyoping.admin.model.AdminAccountDO;
import com.yoyoping.admin.service.AdminAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhangzheng on 12/3/2023
 */
@Service
public class AdminAccountServiceImpl implements AdminAccountService {

    @Resource
    private AdminAccountDao adminAccountDao;

    @Override
    public boolean registerByAccount(String account, String password) {
        AdminAccountDO adminAccountDO = new AdminAccountDO();
        adminAccountDO.setAccount(account);
        adminAccountDO.setPassword(password);
        int result = adminAccountDao.insertAdminAccount(adminAccountDO);
        if (result > 0) {
            return true;
        }
        return false;
    }


}
