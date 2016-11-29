package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomeAndItem {
	private static Map<String, List<String>> cusMap=new HashMap<String,List<String>>();
	private static Map<String,Integer> itemMap=new HashMap<String,Integer>();
	/**
	 * 还没有做边界条件判断
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String targetItem=sc.nextLine();
		String cusItem=sc.nextLine();
		String[] si=cusItem.split(" ");
		
		/*
		 * store the customer-item information
		 */
		for(int i=0;i<si.length;i+=2){
			String customer=si[i];
			String items=si[i+1];
			if(cusMap.containsKey(customer)){
				cusMap.get(customer).add(items);
			}else{
				List<String> tempList=new ArrayList<String>();
				tempList.add(items);
				cusMap.put(customer, tempList);
			}
			
			if(!itemMap.containsKey(items)){
				itemMap.put(items, 0);
			}
		}
		System.out.println(cusMap);
		/*
		 * find out who buy the target item
		 * and count what else item does the customer buy
		 */
		for(String cus:cusMap.keySet()){
			if(cusMap.get(cus).contains(targetItem)){
				for(String ite:cusMap.get(cus)){
					if(!ite.equals(targetItem)){
						int times=itemMap.get(ite)+1;
						itemMap.put(ite, times);
					}
				}
			}
		}
		String result="";
		int tempTimes=0;
		for(String str:itemMap.keySet()){
			if(itemMap.get(str)>tempTimes){
				tempTimes=itemMap.get(str);
				result=str;
			}
		}
		
		System.out.println(result);
	}
}
