//Developer: Theresa JvR Mostert
//Date: 10 June 2015
//Application: My Black Swan
//This application uses recursion to find the sum of each digit in a given number
//259 returns 16 because 2+5+9 = 16 

package com.averis;

public class Alg_RecursionStrings {
	
	public static void main (String[] args){
		System.out.println("This program takes a given number and adds it's consecutive digits in the following manner using recursion:");
		System.out.println("E.g. Enter 1234, translates = [1+2+3+4] = 10");
		String input = "1470";
		System.out.println("This is the Input:");
		System.out.print(getFirstCharacter(input));
		System.out.print(getRestOfCharacters(input));
		System.out.println();
		System.out.println("This is the Output:");
		System.out.println(add(input));
		
	}
	
	public static String getFirstCharacter(String input){
		if (input == null || input.isEmpty()){
			return "";
		}
		return input.substring(0, 1);
	}
	
	public static String getRestOfCharacters(String input){
		if (input == null || input.isEmpty()){
			return "";
		}
		if (input.length() == 1){
			return input;
		}
		return input.substring(1, input.length());
	}
	
	public static int add(String input){
		
		if (input == null || input.isEmpty()){
			return 0;
		}
		
		if (input.length() == 1){
			return Integer.parseInt(input);
		}
		
		return Integer.parseInt(getFirstCharacter(input)) + add(getRestOfCharacters(input));
		
	}
	
	
}
