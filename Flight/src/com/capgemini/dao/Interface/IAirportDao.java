package com.capgemini.dao.Interface;

import java.util.List;

import com.capgemini.entities.Airport;

public interface IAirportDao {
	public List<Airport> viewAllAirport();
	public Airport viewAirport(String airportCode);
	
}
