package com.kosmonaut.netprog.querytest;

import java.util.List;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.regex.*;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/")
public class MyResource {

	
	public static List<Car> parking = new ArrayList<Car>();
	

    @GET
    @Path("/{sampleReg}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt(@PathParam("sampleReg") String sample) {
        for(Car temp : parking) {
        	if(temp.checkEqual(sample)) {
        		return JSONifyCar(temp);
        	}
        }
        
        return "Not found";
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String showAll() {
    	
    	return JSONifyCar(parking.get(0));
    	
    }
    
    


	@PUT
    @Path("/{color}/{CAR_REG}")
    @Produces(MediaType.TEXT_PLAIN)
    public String recordNewCar(@PathParam("color") String color, @PathParam("CAR_REG") String carReg) throws Exception {
    	
    	if(color.equals("green") || color.equals("blue")) {
    		
    		if(plateValidator(carReg)) {
    			
    			Calendar currentDate = Calendar.getInstance();
    			
    			Car currentCar = new Car(carReg, color, currentDate);
    			
    			parking.add(currentCar);
    			
//    			return "Car Successfully added!";
    			return JSONifyCar(currentCar);

    			
    		} else {
    			return "ERROR WITH CAR REG";
    		}
    		
    	} else {
    		return "ERROR WITH ZONE";
    	}
    	
    }
	
   
    private boolean plateValidator(String plate) {
    	
    	String line = plate;
    	String pattern = "[ETYOPAHKXCBM]{1,2}[0-9]{4}[ETYOPAHKXCBM]{2}";
    	
    	Pattern r = Pattern.compile(pattern);
    	
    	Matcher m = r.matcher(line);
    	
    	if(m.find()) {
    		return true;
    	}
    	
    	return false;
    	
    }
    
    private String JSONifyCar(Car car) {
    	
    	String carReg = car.getReg();
    	String activity = activityCheck(car);
    	String due = car.getDue();
    	String lastAction = car.getLast();
    	
    	
    	return " car reg    : " + carReg + "\n"
    		 + " activity   : " + activity + "\n"
    		 + " due date   : " + due + "\n"
    		 + "lastAcition : " + lastAction + "\n\n" ;
    	
    }
    
    private String activityCheck(Car car) {
    	for(Car temp : parking) {
    		if(car.equals(temp)) {
    			return "true";
    		}
    	}
    	return "false";
    }
}


