package org.dy.common.orm.mysql.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * author: dy
 * JDK-version:  JDK1.8
 * comments:  字段
 * since Date： 2016/11/16 14:53
 */
public class Column {

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String type;

	@Setter
	@Getter
	private String remark;

	public static final String TYLE_SHORT = "TINYINT";

	public static final String TYLE_INT = "INT";

	public static final String TYLE_LONG = "BIGINT";

	public static final String TYLE_STRING = "VARCHAR";

	public static final String TYLE_ENUM = "ENUM";

	public static final String TYLE_DOUBLE = "DOUBLE";

	public static enum ColumnType {

	}

}
