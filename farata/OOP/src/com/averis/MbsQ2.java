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
		Scanner scc = new Scanner(System.in);

		input = (scc.nextLine().trim());

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
		
		for(Integer o: rold){
			System.out.println(" \"" + valueMap.get(o) + "\"" + "->" + o);
		}	
		


	}

}
