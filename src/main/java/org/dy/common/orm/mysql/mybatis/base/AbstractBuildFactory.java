package org.dy.common.orm.mysql.mybatis.base;

import org.dy.common.orm.mysql.mybatis.enums.OutPathKey;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  对此类的描述，可以引用系统设计中的描述
 * since Date： 2016-03-16 16:03
 */
public abstract class AbstractBuildFactory implements BuildFactory{

    /**
     * 获取输出路径
     * @return
     */
    public abstract OutPathKey getOutPath();
}
