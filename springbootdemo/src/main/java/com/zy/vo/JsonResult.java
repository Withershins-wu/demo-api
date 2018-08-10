package com.zy.vo;

import lombok.Data;

/**
 * @author zhangyan
 * @date 2018-08-09 15:05
 * @desc 输出Vo
 **/
@Data
public class JsonResult<T> {

    public static final int SUCCESS = 200;// 成功
    public static final int FAIL = 201;// 失败
    private Integer code;
    private String msg = "";
    private T data;

    public static JsonResult fail(String msg) {
        JsonResult result = new JsonResult();
        result.setCode(JsonResult.FAIL);
        result.setMsg(msg);
        return result;
    }
    public static JsonResult success(String msg) {
        JsonResult result = new JsonResult();
        result.setCode(JsonResult.SUCCESS);
        result.setMsg(msg);
        return result;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}