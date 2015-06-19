package com.averis;

import java.util.Scanner;

public class PrintShapesUsingChars {

	public static void main(String[] args) {
		int input = 0;
		boolean isNotNumber;
		boolean isEvenNumber = true;
		do {
			System.out.println("Please enter an odd number between 3 and 9:");
			Scanner scc = new Scanner(System.in);
			try {
				input = Integer.parseInt(scc.nextLine().trim());
				isNotNumber = false;
				isEvenNumber = input % 2 == 0;
			} catch (NumberFormatException e) {
				isNotNumber = true;
			}

		} while (isNotNumber || input < 3 || isEvenNumber || input >= 9);

		int stars = 0;
		int indents = 0;
		System.out.println();
		for (int i = 1; i < input * 2; i++) {
			if (i % 2 == 1) {
				// this is the top triangle of the diamond
				if (i < input) {
					stars = i;
					indents = (input - i) / 2;
					// System.out.println("stars="+stars +
					// "indents="+indents+" i="+i);
				}
				// this is the middle line
				if (i == input) {
					stars = i;
					indents = 0;
					// System.out.println("stars="+stars + "indents="+indents
					// +"i="+i);
				}
				// this is the upside-down bottom triangle
				if (i > input) {
					stars = input * 2 - i;
					indents = (i - input) / 2;
					// System.out.println("stars="+stars +
					// "indents="+indents+" i="+i);
				}
				// printing left indents
				for (int j = 1; j <= indents; j++) {
					System.out.print(" ");
				}
				// printing stars
				for (int j = 1; j <= stars; j++) {
					// if left stars
					if (input == stars) {

						// print stars left of centre char
						if (j < input / 2 + 1) {
							System.out.print("*");
						}
						// print centre character
						if (j == input / 2 + 1) {
							System.out.print(input);
						}
						// print chars right of centre char
						if (j > input / 2 + 1) {
							System.out.print("*");
						}
					} else {
						System.out.print("*");
					}
				}
				// printing right indents
				for (int j = 1; j <= indents; j++) {
					System.out.print(" ");
				}
				System.out.println();
			}

		}

	}

}
