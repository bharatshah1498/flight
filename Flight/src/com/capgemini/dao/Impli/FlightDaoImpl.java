package com.capgemini.dao.Impli;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.dao.Interface.IFlightDao;
import com.capgemini.entities.Flight;
import com.capgemini.exception.IncorrectArgumentException;

public class FlightDaoImpl implements IFlightDao {
	
	private static Map<Integer, Flight> map=new HashMap<Integer,Flight>();
	
	static {
		map.put(166001,new Flight(166001,"Airbus A380",150,"Gerald R. Ford"));
		map.put(166002,new Flight(166002,"Boeing 737",120,"Nimitz"));
		map.put(166003,new Flight(166003,"Boeing 747",170,"Dwight D. Eisenhower"));
		map.put(166004,new Flight(166004,"Boeing 767",95,"Carl Vinson"));
	}
	
	@Override
	public Flight addFlight(Flight f) {
		map.put(f.getFlightNumber(), f);
		return f;	
	}

	@Override
	public Flight modifyFlight(Flight f) {
		try {
			@SuppressWarnings("unused")
			Flight f1 = map.get(f.getFlightNumber());
			map.put(f.getFlightNumber(), f);
			return f;
		} catch (NullPointerException e) {
			return null;
		}	
	}

	@Override
	public Flight viewFlight(int flightNumber) {
		
		Flight f = new Flight();
		try {
			f=map.get(flightNumber);
			return f;
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public List<Flight> viewAllFlight() {
		Collection<Flight> coll=map.values();
		List<Flight> lists = new ArrayList<>(coll);
		return lists;
	}

	@Override
	public void deleteFlight(int flightNumber) {
		try {
			map.remove(flightNumber);
		} catch (NullPointerException e) {
			throw new IncorrectArgumentException("Invalid Flight number");
		}
	}
		
}


