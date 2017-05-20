package com.trc.mall;

import java.util.List;

/**
 * @author dy
 * @since 2016-12-01  & JDK 1.8.0_91
 */
public class ResultModel<T> {

    public static final String SUCCESS="success";

    public static final String FAILED="failed";
    /**
     * 接口调用是否成功
     * ture 成功、false 失败
     */
    private boolean result = true;

    /**
     * 接口调用返回对象模型
     */
    private T model;

    /**
     * 接口调用返回对象集合模型
     */
    private List<T> modelList;

    /**
     * 接口调用失败code
     */
    private String errorCode;
    /**
     * 接口调用信息
     */
    private String message;

    /**
     * 接口调用异常类
     */
    private Exception exception;

    public ResultModel() {}

    public ResultModel(boolean result, String message,String errorCode) {
        this.result = result;
        this.message = message;
        this.errorCode = errorCode;
    }

    public ResultModel(T model) {
        this.model = model;
    }

    public ResultModel(List<T> modelList) {
        this.modelList = modelList;
    }


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public List<T> getModelList() {
        return modelList;
    }

    public void setModelList(List<T> modelList) {
        this.modelList = modelList;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
}
