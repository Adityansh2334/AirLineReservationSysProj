package com.air.app.util;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
//		LinkedList<Integer> listEconomy = PlaneServlet.getListEconomy();
//		System.out.println(listEconomy.contains(11));
//		if(l1.contains(sn))System.out.println(l1.remove(sn));
//		if(l2.contains(sn))System.out.println(l2.remove(sn));
//		int i=0;
//		int l=-1;
//		do {
//		i=(int)(Math.random()* (10000-500+1)+500); //formula>> (Math.random()*(max-min+1)+min)
//		System.out.println(i);
//		}while(i==i);
//		int [] arr= new int[500];
//		Random r= new Random();
//		for(int i=0;i<500;i++) {
////			arr[i]=Math.floor.(Math.random()* (10000-500+1)+500);
//			arr[i]=(r.nextInt((10000-500+1)+500));
//		}
//		for(int i=0;i<arr.length;i++) {
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[i]==arr[j]) {
//					System.out.println(arr[i]);
//				}
//			}
//		}
//		System.out.println("No");
		
		Timestamp ts= new Timestamp(new Date().getTime());
		System.out.println(ts);
	}

}
