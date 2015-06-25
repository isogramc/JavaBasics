package com.averis;

import com.averis.Oopex_Car;

public class Oopex_RaceCar {
	
	public static void main (String[] args){
	Oopex_Car car1 = new Oopex_Car();
	Oopex_Car car2 = new Oopex_Car();
	
	car1.colour = "red";
	car2.colour = "green";
	
	car1.SwitchOnLights();
	
	System.out.println("Car1 is " +car1.colour+ " and Car2 is " +car2.colour);
	
	}
	
	
}
