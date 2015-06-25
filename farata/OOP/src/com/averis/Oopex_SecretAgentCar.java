package com.averis;

public class Oopex_SecretAgentCar extends Oopex_Car{

	int currentSubmergeDepth;
	boolean isGunOnBoard=true;
	final String MANUFACTURER="Nissan"; //constant
	
	
	void submerge(){
		currentSubmergeDepth = 50;
	}
	
	void surface(){
		
	}
}
