package org.dy.common.orm.mysql.mybatis.base;

import org.dy.common.orm.mysql.mybatis.bean.TableWapper;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  对此类的描述，可以引用系统设计中的描述
 * since Date： 2016-03-16 15:59
 */
public interface BuildFactory {

    public void buildTable(TableWapper tableWapper);
    public void buildTable();
}
