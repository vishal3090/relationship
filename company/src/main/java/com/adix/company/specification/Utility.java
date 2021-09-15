package com.adix.company.specification;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

	public static Object converter(Class<?> clazz, Object value) throws Exception {
		Object obj = null;

		if (clazz == Long.class) {
			obj = Long.parseLong(value.toString());
		} else if (clazz == String.class) {
			obj = value.toString();
		} else if (clazz == Date.class) {
			obj = new SimpleDateFormat("yyyy-MM-dd").parse(value.toString());

		} else {
			obj = value;
		}

		//System.out.println("class:" + obj.getClass());
		return obj;

	}

}