package com.averis;

import com.averis.Car;

public class RaceCar {
	
	public static void main (String[] args){
	Car car1 = new Car();
	Car car2 = new Car();
	
	car1.colour = "red";
	car2.colour = "green";
	
	car1.SwitchOnLights();
	
	System.out.println("Car1 is " +car1.colour+ " and Car2 is " +car2.colour);
	
	}
	
	
}
