package com.averis;

import java.util.Scanner;

public class Reverse {
	
public static void main (String[] args){
	String input = "";
	
	System.out.println("Please enter a sentence of your choice");
	Scanner scc = new Scanner(System.in);
	input = scc.nextLine().trim();
	input.replace("[^0-9]", " ");
	
	String [] k = input.split(" ");
	String [] reverseSentence = new String [k.length];
	 
	int counter = 0;
	
		for(int i=k.length-1; i>=0; i--){
			
			reverseSentence[counter]=k[i];
			System.out.println(reverseSentence[counter]);
			counter++;
		}
	
}
}
