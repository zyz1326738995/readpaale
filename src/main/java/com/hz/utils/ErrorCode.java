package com.hz.utils;

public class ErrorCode {
    /** Redis相关 */
    public static final ErrorCode REDIS_ADD_FAILED = new ErrorCode(13010, "添加redis失败");
    public static final ErrorCode REDIS_UPDATE_FAILED = new ErrorCode(13011, "更新redis失败");
    public static final ErrorCode REDIS_DELETE_FAILED = new ErrorCode(13012, "删除redis失败");
    public static final ErrorCode REDIS_ADD_OR_UPDATE_FAILED = new ErrorCode(13013, "添加或是更新redis失败");
    public static final ErrorCode EMPTY_USER_ID = new ErrorCode(10010, "用户ID为空");
    /** K值相关 */
    public static final ErrorCode K_EMPTY = new ErrorCode(15010, "K值为空");
    public static final ErrorCode K_CACHED_TOKEN_NOT_EXIST = new ErrorCode(15011, "缓存的token值不存在");
    public static final ErrorCode K_CACHED_TOKEN_NOT_EQUALS = new ErrorCode(15012, "缓存的token值与请求的token值不一致");

    private int code;
    private String desc;

    private ErrorCode() {  }

    private ErrorCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public int getCode() { return code; }
    public String getDesc() { return desc; }

    /** 页面上展示给用户看的, 前置 <code>msg</code> */
    public String show(String msg) {
        if (msg==null&&msg=="") {
            return new StringBuilder(msg).append("Error Code：").append(String.valueOf(code)).toString();
        } else {
            return toString();
        }
    }

    public String msg(String msg) {
        return show(msg);
    }

    public String toString() {
        return new StringBuilder("Error Code：").append(String.valueOf(code)).toString();
    }
}
