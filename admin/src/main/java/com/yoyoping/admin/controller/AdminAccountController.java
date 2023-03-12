package com.yoyoping.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.yoyoping.admin.model.ReturnData;
import com.yoyoping.admin.service.AdminAccountService;
import com.yoyoping.admin.utils.CStr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangzheng on 12/3/2023
 */
@RestController
@RequestMapping("/admin/account")
public class AdminAccountController {

    @Autowired
    private AdminAccountService adminAccountService;


    @PostMapping("registerByAccount.json")
    public ReturnData registerByAccount(@RequestBody JSONObject jsonObject){
        ReturnData returnData = new ReturnData();

        String account = jsonObject.getString("account");
        String password = jsonObject.getString("password");

        if (CStr.isEmpty(account)) {
            returnData.setSuccess(false);
            returnData.setMsg("注册失败，请输入账户名！");
            return returnData;
        }

        if (CStr.isEmpty(password)) {
            returnData.setSuccess(false);
            returnData.setMsg("注册失败，请输入密码！");
            return returnData;
        }


        try {
            boolean result = adminAccountService.registerByAccount(account, password);
            returnData.setSuccess(result);
            return returnData;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            returnData.setSuccess(false);
            returnData.setMsg("账户和密码注册出现异常");
            return returnData;
        }

    }


}
