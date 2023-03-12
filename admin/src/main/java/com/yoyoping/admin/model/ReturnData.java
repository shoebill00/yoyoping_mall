package com.yoyoping.admin.model;


/**
 * 封装响应数据
 * @author zhangzheng on 12/3/2023
 */
public class ReturnData {

    private int code = 200;

    private String msg;

    private Object data;

    private boolean success;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ReturnData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }

}