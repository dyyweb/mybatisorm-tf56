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
 * comments:  构件服务
 * since Date： 2016-03-16 15:21
 */
public class BuildService extends AbstractBuildFactory{

    @Override
    public OutPathKey getOutPath() {
        return OutPathKey.SERVICE;
    }

    @Override
    public void buildTable(TableWapper tableWapper) {

        String daoPackage = tableWapper.getDaoPackage();
        String pojoPackage = tableWapper.getPojoPackage();
        String servicePackage = tableWapper.getServicePackage();

        String outPath = tableWapper.getOutPathMap().get(OutPathKey.DEFULT);
        if(tableWapper.getOutPathMap().get(getOutPath()) != null){
            outPath = tableWapper.getOutPathMap().get(getOutPath());
        }
        Table table = tableWapper.getTable();
        String tableName = table.getName();
        String headName = Util.getUpperHumpName(tableName);
        String minDoName = Util.getHumpName(tableName)+"DO";
//        String minDoName = Util.getHumpName(tableName);
        String bigDoName = Util.getUpperHumpName(tableName)+"DO";
//        String bigDoName = Util.getUpperHumpName(tableName);
        String bigDaoName = Util.getUpperHumpName(tableName)+"Dao";
        String minDaoName = Util.getHumpName(tableName)+"Dao";

        String bigServiceName = "I"+Util.getUpperHumpName(tableName)+"Service";

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
        map.put("bigDoName", bigDoName);
        map.put("minDoName", minDoName);
        map.put("bigDaoName", bigDaoName);
        map.put("minDaoName", minDaoName);
        map.put("bigServiceName", bigServiceName);
        map.put("headName", headName);
        map.put("idType", idType);
        map.put("date", parseDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
        Util.writeCode("api", map,outPath+bigServiceName+".java/");
    }
    @Override
    public void buildTable() {

    }
}
