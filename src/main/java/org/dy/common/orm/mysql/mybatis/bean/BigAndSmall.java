package org.dy.common.orm.mysql.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  大小写
 * since Date： 2016-03-16 15:18
 */
public class BigAndSmall {

    @Setter
    @Getter
    private String bigName;

    @Setter
    @Getter
    private String smallName;

    @Setter
    @Getter
    private String type;
}
