package com.example.mycountries;

import java.util.ArrayList;

public class DataHandler {
	private static ArrayList<String> arrayList;
	
	
	public static ArrayList<String> GetArrayList(){
		//if(arrayList == null){
			//arrayList.add("test");
			//return arrayList;
		//}
		return arrayList;
	}
	
	public static void SetArrayList(ArrayList<String> array){
		//System.out.println(array);

			arrayList = array;
		
	}
}
