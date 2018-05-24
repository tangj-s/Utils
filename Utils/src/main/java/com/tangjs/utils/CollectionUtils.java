package com.tangjs.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 集合，List ,Map 
 * @author tangjunshan
 * @date 2018年5月24日  
 *
 *
 */
public class CollectionUtils {
	
	/**
	 * 前提条件： 对象为List<Map>类型
	 * sortKey，为 Map 的 某个 Key
	 * descend ：排序方式 true:降序 ，false ：升序
	 * 把 value对象的toString() 结果比较
	 */
	private static class ListMapComparetor implements Comparator{
		Object sortKey;
		boolean descend;
		public ListMapComparetor(Object sortKey,boolean descend) {
			this.sortKey=sortKey;
			this.descend=descend;
		}
		@Override
		public int compare(Object o1, Object o2) {
			int compareResult;
			if(o1==null && o2==null)compareResult=0;
			else if(o1==null)compareResult=-1;
			else if(o2==null)compareResult=1;
			else {
				Object obj1=((Map)o1).get(sortKey);
				Object obj2=((Map)o2).get(sortKey);
				if(obj1==null && obj2==null)
					compareResult=0;
				else if(obj1==null)compareResult=-1;
				else if(obj2==null)compareResult=1;
				else {
					compareResult=obj1.toString().compareTo(obj2.toString());
				}
			}
			return descend?compareResult*-1:compareResult;
		}
		
	}
	
	/**
	 * List<Map> 排序，支持多个字段排序，传入的参数  Map类型 ，key-value: sort-true(降序)/false(升序)
	 * @author tangjunshan
	 * @date 2018年5月24日  
	 *
	 *
	 */
	private static class ListMapMutiComparator implements Comparator{
		private List comparators;
		public ListMapMutiComparator(Map sortKeys) {
			this.comparators=new ArrayList(sortKeys.size());
			for(Iterator it=sortKeys.entrySet().iterator();it.hasNext();) {
				Map.Entry sortKeyEntry =(Map.Entry)it.next();
				try {
					Object sortKey=sortKeyEntry.getKey();
					Object sortOrder=sortKeyEntry.getValue();
					comparators.add(new ListMapComparetor(sortKey, (sortOrder instanceof Boolean)?((Boolean)sortOrder).booleanValue():Boolean.valueOf((String)sortOrder).booleanValue()));                         
				}catch(Exception e) {
					System.out.println("error");
					return;
				}
			}
		}
		@Override
		public int compare(Object o1, Object o2) {
			for (Iterator iter = this.comparators.iterator();iter.hasNext();) {
				Comparator comparator=(Comparator)iter.next();
				int result=comparator.compare(o1, o2);
				if(result!=0)return result;
			}
			return 0;
		}
		
	}
	
	/**
	 * List<Map> 排序  按string 排序
	 * @param list List
	 * @param sortKey 排序字段
	 * @param desc  true 降序 ，false升序
	 */
	public static void sortListBySingleMapKey(List list,Object sortKey,boolean desc) {
		if(sortKey==null) {
			System.out.println("sort keys should not be null. ");
			return;
		}
		Collections.sort(list, new ListMapComparetor(sortKey, desc));
		return;
	}
	
	
	/**
	 * List<Map> 排序  按string 排序
	 * @param list List
	 * @param sortKeys 排序字段   true 降序 ，false升序 多个字段   key-value : sort- true/false
	 */
	public static void sortListByMultiMapKey(List list,Map sortKeys) {
		if(sortKeys==null||sortKeys.isEmpty()) {
			System.out.println("error");
			return;
		}
		Collections.sort(list, new ListMapMutiComparator(sortKeys));
	}
	

}
