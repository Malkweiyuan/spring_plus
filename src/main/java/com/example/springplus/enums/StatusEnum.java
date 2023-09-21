package com.example.springplus.enums;

public enum StatusEnum {

    OK("1000", "成功"),
    ERROR("9000", "业务异常"),
    UN_LOGIN("9001", "未登录"),
    EXCEED_TOKEN("9002", "token过期"),
    FORBIDDEN("9003", "没有访问权限"),
    EXCEED_REFRESH_TOKEN("9004", "refreshToken过期"),
    NO_BIND("9005", "未绑定用户"),
    UN_GRANT_TYPE("9006", "不支持GRANT_TYPE"),
    UN_ALLOWED_AUTHORIZATION("9007", "用户未允许授权"),
    SYSTEM_ERROR("9999", "系统异常");

    private final String code;
    private final String message;

    private StatusEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
