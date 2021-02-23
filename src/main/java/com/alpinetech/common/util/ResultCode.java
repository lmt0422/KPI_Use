package com.alpinetech.common.util;

/**
 * @author xmr
 * @date 2021/02/21 17:13
 * @description 响应码枚举
 */
public enum ResultCode {

    SUCCESS(1000, "操作成功"),

    BODY_NOT_MATCH(400, "请求的数据格式不符!"),

    SIGNATURE_NOT_MATCH(401, "请求的数字签名不匹配!"),

    NOT_FOUND(404, "未找到该资源!"),

    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),

    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),

    FAILED(1001, "响应失败"),

    VALIDATE_FAILED(1002, "参数校验失败"),

    ERROR(5000, "未知错误");


    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
