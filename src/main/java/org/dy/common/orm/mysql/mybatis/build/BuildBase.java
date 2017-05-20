package org.dy.common.orm.mysql.mybatis.build;

import org.dy.common.orm.mysql.mybatis.Mybatisorm;
import org.dy.common.orm.mysql.mybatis.base.AbstractBuildFactory;
import org.dy.common.orm.mysql.mybatis.bean.TableWapper;
import org.dy.common.orm.mysql.mybatis.enums.OutPathKey;
import org.dy.common.orm.mysql.mybatis.util.Util;

import java.util.*;

import static org.dy.common.orm.mysql.mybatis.util.Util.parseDate;

/**
 * @author dy
 * JDK-version:  JDK1.8
 * comments:  构建模型
 * @since 2017/01/16 15:22
 */
public class BuildBase extends AbstractBuildFactory {
    @Override
    public OutPathKey getOutPath() {
        return OutPathKey.BASE;
    }

    @Override
    public void buildTable(TableWapper wapper) {

    }

    @Override
    public void buildTable() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("packageName", TablesBuilder.BASEPACKAGE);
        map.put("head", "");
        map.put("headName", "");
        map.put("date", parseDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        Util.writeCode("base",map, Mybatisorm.PROJECT_PATH+"\\base\\Base.java/");
    }
}
