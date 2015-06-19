//Developer: Theresa JvR Mostert
//Date: 10 June 2015
//Company Request: Black Swan (Test)
//This program allows the user to enter a String and then prints out how many times each character appears in the string
//Sorted by least to most duplicates

package com.averis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections;

public class MbsQ2 {

	public static void main(String[] args) {

		String input ="";//= "Hello World";
		System.out.println("This program prints characters used and sorts them from least used to most duplicates. ");
		System.out.println("Enter any string:");
		//Declare the scanner
		Scanner scc = new Scanner(System.in);
//Allow input and ensure no extra space or gibberish
		input = (scc.nextLine().trim());
//Declare a hashmap that holds (extracts) each character as a key and counts them (e.g. there are 3 of the character "l" in the string)
		Map<Character, Integer> charCollection = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {

			char aChar = input.charAt(i);

			if (!charCollection.containsKey(aChar)) {
				charCollection.put(aChar, 1);
			} else {
				charCollection.put(aChar, charCollection.get(aChar) + 1);
			}
		}

		
		System.out.println("-----------");
		//format as requested using a second Hashmap and a List of type array
		List<Character> cha = new ArrayList<Character>();
		cha.addAll(charCollection.keySet());
		Collections.sort(cha);
		Map<Integer, List<Character>> valueMap = new HashMap<Integer, List<Character>>();
		for (Character x : cha) {
			
			if (valueMap.get(charCollection.get(x)) == null){
				valueMap.put(charCollection.get(x), new ArrayList<Character>());
			} 
			valueMap.get(charCollection.get(x)).add(x);
			
		}
		
		List<Integer> rold = new ArrayList<Integer>();
		rold.addAll(valueMap.keySet());
		Collections.sort(rold);
		//print : character -> number of that character
		for(Integer o: rold){
			System.out.println(" \"" + valueMap.get(o) + "\"" + "->" + o);
		}	

	}

}
