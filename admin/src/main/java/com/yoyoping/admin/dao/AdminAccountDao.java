package com.yoyoping.admin.dao;

import com.yoyoping.admin.dao.provider.AdminAccountDaoProvider;
import com.yoyoping.admin.model.AdminAccountDO;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangzheng on 12/3/2023
 */
@Mapper
public interface AdminAccountDao {


    @InsertProvider(type = AdminAccountDaoProvider.class, method = "insertAdminAccount")
    int insertAdminAccount(AdminAccountDO adminAccountDO);



}
