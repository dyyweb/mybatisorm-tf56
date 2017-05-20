package org.dy.common.orm.mysql.mybatis.build;

import org.dy.common.orm.mysql.mybatis.base.AbstractBuildFactory;
import org.dy.common.orm.mysql.mybatis.bean.BigAndSmall;
import org.dy.common.orm.mysql.mybatis.bean.Column;
import org.dy.common.orm.mysql.mybatis.bean.Table;
import org.dy.common.orm.mysql.mybatis.bean.TableWapper;
import org.dy.common.orm.mysql.mybatis.enums.OutPathKey;
import org.dy.common.orm.mysql.mybatis.util.Util;

import java.util.*;

import static org.dy.common.orm.mysql.mybatis.util.Util.parseDate;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  构建模型
 * since Date： 2016/11/16 15:22
 */
public class BuildDto extends AbstractBuildFactory {

	@Override
	public OutPathKey getOutPath() {
		return OutPathKey.DTO;
	}

	@Override
	public void buildTable(TableWapper tableWapper) {
		List<Column> column = new ArrayList<Column>();
		List<BigAndSmall> column2 = new ArrayList<BigAndSmall>();
		Map<String, Object> map = new HashMap<String, Object>();

		Table table = tableWapper.getTable();
		List<Column> columnList = table.getColumns();
		String doName = Util.getUpperHumpName(table.getName());
		String outPath = tableWapper.getOutPathMap().get(OutPathKey.DEFULT);
		if(tableWapper.getOutPathMap().get(getOutPath()) != null){
			outPath = tableWapper.getOutPathMap().get(getOutPath());
		}
		String packageName = tableWapper.getPojoPackage();


		String head = "";
		doName = doName.replace("Tab", "");
		String headName = Util.getUpperHumpName(doName);
		head = doName;
		map.put("columList", column);
		map.put("columList2", column2);
		map.put("packageName", packageName);
		map.put("head", head);
		map.put("headName", headName);
		map.put("date", parseDate(new Date(),"yyyy-MM-dd HH:mm:ss"));

		Util.writeCode("dto", map, outPath + doName + "DTO.java/");
	}

	@Override
	public void buildTable() {

	}
}
