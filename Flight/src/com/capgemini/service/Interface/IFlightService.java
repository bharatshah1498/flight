package com.capgemini.service.Interface;

import java.util.List;

import com.capgemini.entities.Flight;
public interface IFlightService {
	public Flight addFlight(Flight f);
	public Flight modifyFlight(Flight f);
	public Flight viewFlight(int flightNumber);
	public List<Flight> viewAllFlight();
	public void deleteFlight(int flightNumber);
	public void validateFlight(Flight f);
}
