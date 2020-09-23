package org.example.utils;

/**
 *
 * @author dreamguy
 * @date 2020/9/17
 */

public enum AppCodeMessageUtil {
    SUCCESS(0, "success"),
    EXCEPTION_NULL(-1, "value cannot be null"),
    EXCEPTION_OUT_FOR9(-2, "the parameter value must be between 0 and 9"),
    EXCEPTION_OUT_FOR99(-3, "the parameter value must be between 0 and 99");

    private Integer code;
    private String message;

    AppCodeMessageUtil(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getValue() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public static String getByCode(Integer code){
        for(AppCodeMessageUtil appCodeMessageUtil : AppCodeMessageUtil.values()){
            if(code.equals(appCodeMessageUtil.getCode())){
                return appCodeMessageUtil.getValue();
            }
        }
        return null;
    }
}
