package org.dy.common.orm.mysql.mybatis.build;

import org.dy.common.orm.mysql.mybatis.base.AbstractBuildFactory;
import org.dy.common.orm.mysql.mybatis.bean.Column;
import org.dy.common.orm.mysql.mybatis.bean.Table;
import org.dy.common.orm.mysql.mybatis.bean.TableWapper;
import org.dy.common.orm.mysql.mybatis.enums.OutPathKey;
import org.dy.common.orm.mysql.mybatis.util.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.dy.common.orm.mysql.mybatis.util.Util.parseDate;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  构建服务实现
 * since Date： 2016-03-16 15:21
 */
public class BuildServiceImpl extends AbstractBuildFactory {

    @Override
    public OutPathKey getOutPath() {
        return OutPathKey.SERVICE_IMPL;
    }

    @Override
    public void buildTable(TableWapper tableWapper) {
        String daoPackage = tableWapper.getDaoPackage();
        String pojoPackage = tableWapper.getPojoPackage();
        String servicePackage = tableWapper.getServicePackage();
        String serviceImplPackage = tableWapper.getServiceImplPackage();

        String outPath = tableWapper.getOutPathMap().get(OutPathKey.DEFULT);
        if(tableWapper.getOutPathMap().get(getOutPath()) != null){
            outPath = tableWapper.getOutPathMap().get(getOutPath());
        }
        Table table = tableWapper.getTable();
        String tableName = table.getName();
        String headName = Util.getUpperHumpName(tableName);
//        String bigDoName = Util.getUpperHumpName(tableName)+"DO";
        String bigDoName = Util.getUpperHumpName(tableName);
//        String minDoName = Util.getHumpName(tableName)+"DO";
        String minDoName = Util.getHumpName(tableName);
        String bigDaoName = Util.getUpperHumpName(tableName)+"Mapper";
        String minDaoName = Util.getHumpName(tableName)+"Mapper";
        String bigServiceName = "I"+Util.getUpperHumpName(tableName)+"Service";
        String minServiceName = Util.getHumpName(tableName)+"Service";
        String bigServiceImplName = Util.getUpperHumpName(tableName)+"Service";
        String minServiceImplName = Util.getHumpName(tableName)+"Service";

        String idType = "String";
        List<Column> columnList = table.getColumns();
        for (Column column : columnList) {
            if(column.getName().equals("id")){
                if (column.getType().equalsIgnoreCase("BIGINT")){
                    idType = "Long";
                } else if (column.getType().equalsIgnoreCase("INT") || column.getType().equalsIgnoreCase("TINYINT")) {
                    idType = "int";
                }else{
                    idType = "String";
                }
            }
        }


        Map<String,Object> map = new HashMap<String,Object>();
        map.put("pojoPackage", pojoPackage);
        map.put("daoPackage", daoPackage);
        map.put("servicePackage", servicePackage);
        map.put("serviceImplPackage", serviceImplPackage);
        map.put("bigDoName", bigDoName);
        map.put("minDoName", minDoName);
        map.put("bigDaoName", bigDaoName);
        map.put("minDaoName", minDaoName);
        map.put("bigServiceName", bigServiceName);
        map.put("minServiceName", minServiceName);
        map.put("bigServiceImplName", bigServiceImplName);
        map.put("minServiceImplName", minServiceImplName);
        map.put("headName", headName);
        map.put("idType", idType);
        map.put("date", parseDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        Util.writeCode("service", map,outPath+bigServiceImplName+".java/");
    }
    @Override
    public void buildTable() {

    }
}
