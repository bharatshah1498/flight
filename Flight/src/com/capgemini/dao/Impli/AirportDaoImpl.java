package com.capgemini.dao.Impli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.dao.Interface.IAirportDao;
import com.capgemini.entities.*;


public class AirportDaoImpl implements IAirportDao {

	private static Map<String, Airport> airportData = new HashMap<>();
	
	static
	{
		Airport airport1 = new Airport("Indira Gandhi International Airport", "Delhi", "IGIA");
		Airport airport2 = new Airport("Chhatrapati Shivaji International Airport", "Mumbai", "CSIA");
		Airport airport3 = new Airport("Bangalore International Airport", "Bengaluru", "BIA");
		Airport airport4 = new Airport("Anna International Airport", "Chennai", "ANIA");
		Airport airport5 = new Airport("Kolkata International Airport", "Kolkata", "KIA");
		Airport airport6 = new Airport("Hyderabad International Airport", "Hyderabad", "HIA");
		Airport airport7 = new Airport("Ahmedabad International Airport", "Ahmedabad", "AMIA");
		Airport airport8 = new Airport("Cochin International Airport", "Cochin", "CHIA");
		Airport airport9 = new Airport("Goa International Airport", "Goa", "GIA");
		
		airportData.put(airport1.getAirportCode(),airport1);
		airportData.put(airport2.getAirportCode(),airport2);
		airportData.put(airport3.getAirportCode(),airport3);
		airportData.put(airport4.getAirportCode(),airport4);
		airportData.put(airport5.getAirportCode(),airport5);
		airportData.put(airport6.getAirportCode(),airport6);
		airportData.put(airport7.getAirportCode(),airport7);
		airportData.put(airport8.getAirportCode(),airport8);
		airportData.put(airport9.getAirportCode(),airport9);
	}
	
	
	@Override
	public List<Airport> viewAllAirport() {		
		Airport a=null;
		List<Airport> lists = new ArrayList<>();
	    
		for(String airportCode : airportData.keySet()) {
       		a = airportData.get(airportCode);
       		lists.add(a);
       	}	
       	return lists;
       	
	}

	@Override
	public Airport viewAirport(String airportCode) {		
		Airport a = null;
		try {
			a = airportData.get(airportCode);
			return a;
		} catch (Exception e) {
			return null;
		}
	}
	
	
}
