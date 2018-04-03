package com.trc.mall;

import java.util.List;

/**
 * @author dy
 * @since 2016-12-01  & JDK 1.8.0_91
 */
public class ResultModel<T> {

    /**
     * 接口调用是否成功
     */
    private boolean result = true;

    /**
     * 接口返回内容
     */
    private T model;

    /**
     * 接口失败code
     */
    private String errorCode;
    /**
     * 接口返回信息
     */
    private String message;


    public ResultModel() {
    }

    public ResultModel(String message) {
        this.message = message;
    }

    public ResultModel(boolean result, String message, String errorCode) {
        this.result = result;
        this.message = message;
        this.errorCode = errorCode;
    }

}
