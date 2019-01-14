package com.kosmonaut.netprog.querytest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Car {
	private String carReg;
	private String zone;
	private Calendar lastAction;
	
	
	public Car(String carReg, String zone, Calendar lastAction) {
		this.carReg = carReg;
		this.zone = zone;
		this.lastAction = lastAction;
		
	}
	
	
	
	public String getReg() {
		return carReg;
	}
	
	public String getLast() {
//		return lastAction.format(Calendar.getInstance().getTime());
		return lastAction.getTime().toString();
	}
	
	public void setLast(Calendar lastAction) {
		this.lastAction = lastAction;
	}
	
	public String getDue() {
		
//		Calendar c = lastAction.getCalendar();
		lastAction.add(Calendar.HOUR, 1);
		String dueString = lastAction.getTime().toString();
		
		return dueString;
	}
	
	
	public String getZone() {
		return zone;
	}
	
	public void setZone(String zone) {
		this.zone = zone;
	}
	
	
	public boolean checkEqual(String plate) {
		if(this.getReg().equals(plate)) {
			return true;
		} else
			return false;
	}

}
