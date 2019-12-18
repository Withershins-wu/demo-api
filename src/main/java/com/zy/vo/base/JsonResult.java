package com.zy.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhangyan
 * @date 2018-08-09 15:05
 * @desc 输出Vo
 **/
@ApiModel("输出vo")
@Data
public class JsonResult<T> {

    public static final int SUCCESS = 200;// 成功
    public static final int FAIL = 201;// 失败
    @ApiModelProperty("200：成功，201：失败")
    private Integer code;
    @ApiModelProperty("返回信息")
    private String msg = "";
    @ApiModelProperty("返回数据")
    private T data;

    public static JsonResult fail(String msg) {
        JsonResult result = new JsonResult();
        result.setCode(JsonResult.FAIL);
        result.setMsg(msg);
        return result;
    }

    public static JsonResult fail(int status, String msg) {
        if (status == SUCCESS) {
            throw new RuntimeException("ok is not fail");
        }
        JsonResult result = new JsonResult();
        result.setCode(status);
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