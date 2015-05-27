package com.averis;

public class SecretAgentCar extends Car{

	int currentSubmergeDepth;
	boolean isGunOnBoard=true;
	final String MANUFACTURER="Nissan"; //constant
	
	
	void submerge(){
		currentSubmergeDepth = 50;
	}
	
	void surface(){
		
	}
}
