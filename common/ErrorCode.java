package com.trc.mall.errorcode;

/**
 * @author dy
 * @since 2016-12-01  & JDK 1.8.0_91
 */
public class ErrorCode {
    /**
     * 对象为空
     */
    public static final String ITEM_IS_NULL = "0000";

    /**
     * 获取对象异常
     */
    public static final String GET_EXCEPTION = "1000";
    /**
     * 获取对象列表异常
     */
    public static final String QUERY_LIST_EXCEPTION = "2000";
    /**
     * 插入数据异常
     */
    public static final String INSERT_EXCEPTION  = "3000";
    /**
     * 修改数据异常
     */
    public static final String UPDATE_EXCEPTION  = "4000";
    /**
     * 删除数据异常
     */
    public static final String DELETE_EXCEPTION  = "5000";
    /**
     * 重复提交异常
     */
    public static final String REPEAT_SUBMIT = "6000";

    /**
     * 校验缺少参数异常
     */
    public static final String NOT_FIND_PARAM = "7000";
}
