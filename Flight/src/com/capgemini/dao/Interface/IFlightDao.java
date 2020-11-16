package com.capgemini.dao.Interface;


import java.util.List;

import com.capgemini.entities.Flight;

public interface IFlightDao {
	public Flight addFlight(Flight f);
	public Flight modifyFlight(Flight f);
	public Flight viewFlight(int flightNumber);
	public List<Flight> viewAllFlight();
	public void deleteFlight(int flightNumber);
	
	

}
