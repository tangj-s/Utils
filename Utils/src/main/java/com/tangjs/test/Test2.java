package com.tangjs.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tangjs.utils.CollectionUtils;
import com.tangjs.utils.DateUtils;

public class Test2 {

	public static void main(String[] args) {
		System.out.println(DateUtils.rollDateByDateUnit(new Date(System.currentTimeMillis()), 2, true, Calendar.WEEK_OF_YEAR));
		
		Date date=DateUtils.rollDateByDateUnit(new Date(System.currentTimeMillis()), 2, true, Calendar.WEEK_OF_YEAR);
		java.util.Date d=(java.util.Date)date;
		System.out.println(d);
		System.out.println(DateUtils.getDate2String(new Date(System.currentTimeMillis()), "yyyy-MM-dd HH:mm:ss"));
		System.out.println(DateUtils.getDate2String3(new Date(System.currentTimeMillis())));

		
		List<Map> list=new ArrayList<Map>();
		
		for(int i=5;i>1;i--) {
			Map map=new HashMap();
			map.put("a", "a"+i);
			map.put("b", "b"+(i+5));
			map.put("c", "c"+i);
			list.add(map);
		}
		
		for(int i=10;i>6;i--) {
			Map map=new HashMap();
			map.put("a", 2);
			map.put("b", (i));
			map.put("c", "c"+i);
			list.add(map);
		}
		
		
		
		System.out.println(list);
		CollectionUtils.sortListBySingleMapKey(list, "a", true);
		System.out.println(list);
		CollectionUtils.sortListBySingleMapKey(list, "a", false);
		System.out.println(list);	
		
		Map sortKeys=new HashMap();
		sortKeys.put("a", false);
		sortKeys.put("b", false);
		
		CollectionUtils.sortListByMultiMapKey(list, sortKeys);
		System.out.println(list);	
		CollectionUtils.sortListByMultiMapKey(list, sortKeys);
		System.out.println(list);	
	}

}
