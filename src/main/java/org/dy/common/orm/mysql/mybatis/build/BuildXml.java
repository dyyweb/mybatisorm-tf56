package org.dy.common.orm.mysql.mybatis.build;

import org.dy.common.orm.mysql.mybatis.base.AbstractBuildFactory;
import org.dy.common.orm.mysql.mybatis.bean.Column;
import org.dy.common.orm.mysql.mybatis.bean.TableWapper;
import org.dy.common.orm.mysql.mybatis.bean.XmlBean;
import org.dy.common.orm.mysql.mybatis.enums.OutPathKey;
import org.dy.common.orm.mysql.mybatis.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  构件Mappering
 * since Date： 2016/11/16 15:23
 */
public class BuildXml extends AbstractBuildFactory {

	@Override
	public OutPathKey getOutPath() {
		return OutPathKey.XML;
	}

	@Override
	public void buildTable(TableWapper tableWapper) {
		try {
			List<XmlBean> list = new ArrayList<XmlBean>();
			List<XmlBean> dynamicQueryNumList = new ArrayList<XmlBean>();
			List<XmlBean> dynamicQueryVarList = new ArrayList<XmlBean>();
			List<XmlBean> dynamicQueryEnuList = new ArrayList<XmlBean>();
			List<XmlBean> dynamicQueryDateList = new ArrayList<XmlBean>();

			String outPath = tableWapper.getOutPathMap().get(OutPathKey.DEFULT);
			if(tableWapper.getOutPathMap().get(getOutPath()) != null){
				outPath = tableWapper.getOutPathMap().get(getOutPath());
			}
			List<Column> columns = tableWapper.getTable().getColumns();
			String table_name = tableWapper.getTable().getName();
			String pojoPackage=tableWapper.getPojoPackage();
			String daoPackage=tableWapper.getDaoPackage();
			String tableName = Util.getHumpName(tableWapper.getTable().getName());
			String TableName = Util.getUpperHumpName(tableWapper.getTable().getName());
			String idType = "String";
			for (Column column : columns) {
				XmlBean xmlBean = new XmlBean();
				String name = Util.getHumpName(column.getName());
				xmlBean.setColumnName(column.getName());
				xmlBean.setPropertyName(name);
				if(column.getType().equalsIgnoreCase("DATETIME")
						||column.getType().equalsIgnoreCase("DATE")
						||column.getType().equalsIgnoreCase("TIME")
						||column.getType().equalsIgnoreCase("TIMESTAMP"))
				{
					xmlBean.setType("DATE");
					dynamicQueryDateList.add(xmlBean);
				}
				else if (column.getType().equalsIgnoreCase("VARCHAR")
						||column.getType().equalsIgnoreCase("CHAR")
						||column.getType().equalsIgnoreCase("BLOB")
						||column.getType().equalsIgnoreCase("TEXT")
						||column.getType().equalsIgnoreCase("LONGBLOB")
						||column.getType().equalsIgnoreCase("LONGTEXT") ) {
					xmlBean.setType("STRING");
					dynamicQueryVarList.add(xmlBean);
				}
				else if(column.getType().equalsIgnoreCase("ENUM")){
					xmlBean.setType("STRING");
					dynamicQueryEnuList.add(xmlBean);
				}
				else if(column.getType().equalsIgnoreCase("INT")
						||column.getType().equalsIgnoreCase("BIGINT")
						||column.getType().equalsIgnoreCase("DOUBLE")
						||column.getType().equalsIgnoreCase("FLOAT")
						||column.getType().equalsIgnoreCase("INTEGER")){
					xmlBean.setType("INT");
					dynamicQueryNumList.add(xmlBean);
				}

				if(column.getName().equals("id")){
					if (column.getType().equalsIgnoreCase("BIGINT")){
						idType = "Long";
					} else if (column.getType().equalsIgnoreCase("INT") || column.getType().equalsIgnoreCase("TINYINT")) {
						idType = "int";
					}else{
						idType = "String";
					}
				}
				list.add(xmlBean);

			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			map.put("dynamicQueryNumList", dynamicQueryNumList);
			map.put("dynamicQueryVarList", dynamicQueryVarList);
			map.put("dynamicQueryEnuList", dynamicQueryEnuList);
			map.put("dynamicQueryDateList", dynamicQueryDateList);
			tableName = TableName.replace("Tab", "");
			map.put("tableName", tableName);
			map.put("TableName", TableName);
			map.put("table_name", table_name);
			map.put("TABLE_NAME", table_name.toUpperCase());
			map.put("pojoPackage", pojoPackage);
			map.put("daoPackage", daoPackage);
			map.put("idType", idType);
			Util.writeCode("sqlmap", map, outPath+tableName+"Mapper.xml/");

		} catch (Exception e) {
			e.printStackTrace(); // To change body of catch statement use File |
		}
	}
	@Override
	public void buildTable() {

	}
}
