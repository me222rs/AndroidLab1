package com.example.mycountries;

import java.util.ArrayList;

public class DataHandler {
	private static ArrayList<String> arrayList;
	
	//Gets the array list
	public static ArrayList<String> GetArrayList(){
		return arrayList;
	}
	//Sets the array list
	public static void SetArrayList(ArrayList<String> array){

			arrayList = array;
		
	}
	
	
}
