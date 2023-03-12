package com.yoyoping.admin.dao.provider;

import com.yoyoping.admin.model.AdminAccountDO;
import com.yoyoping.admin.utils.CNum;
import com.yoyoping.admin.utils.CStr;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author zhangzheng on 12/3/2023
 */
public class AdminAccountDaoProvider {

    public String insertAdminAccount(AdminAccountDO model) {
        String sql = new SQL() {{
            INSERT_INTO("t_admin_account");
            VALUES("account", "#{account}");
            if (!CStr.isEmpty(model.getPassword())) {
                VALUES("password", "#{password}");
            }
            if (!CStr.isEmpty(model.getRealName())) {
                VALUES("realName", "#{realName}");
            }
            if (model.getPhone() > 0 ) {
                VALUES("phone", "#{phone}");
            }
            VALUES("createTime", "NOW()");
        }}.toString();
        System.out.println("sql==>"+sql);
        return sql;
    }


}
