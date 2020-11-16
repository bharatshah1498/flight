package com.capgemini.service.Impli;
/**
 * @author
 */

import java.util.List;


import com.capgemini.dao.Impli.FlightDaoImpl;
import com.capgemini.dao.Interface.IFlightDao;
import com.capgemini.entities.Flight;
import com.capgemini.exception.FlightNotFoundException;
import com.capgemini.exception.IncorrectArgumentException;
import com.capgemini.service.Interface.IFlightService;

public class IFlightServiceImpl implements IFlightService {
	IFlightDao dao=new FlightDaoImpl();
	public IFlightServiceImpl(FlightDaoImpl dao)
	{
		this.dao=dao;
	}

	public IFlightServiceImpl() {

	}

	@Override
	public Flight addFlight(Flight f) {
		if(f!=null) {
			return dao.addFlight(f);
		}
		else
		{
			throw new FlightNotFoundException("flight is null");
		}
	}

	@Override
	public Flight modifyFlight(Flight f) {
		if (f != null) {
			return dao.modifyFlight(f);
		} else {
			throw new FlightNotFoundException("Flight is null");
		}
	}

	@Override
	public Flight viewFlight(int flightNumber) {
		if(flightNumber>0) {
			return dao.viewFlight(flightNumber);
		}
		else {
			throw new IncorrectArgumentException("Invalid Flight number");
		}
	}

	@Override
	public List<Flight> viewAllFlight() {
		List<Flight> list=dao.viewAllFlight();
		return list;
	}

	@Override
	public void deleteFlight(int flightNumber) {
		if(flightNumber>0)
		{
			dao.deleteFlight(flightNumber);
		}
		else
		{
			throw new IncorrectArgumentException("Invalid Flight number");
		}
	}

	@Override
	public void validateFlight(Flight f) {
		if(f.getFlightNumber()<0 && f.getFlightModel().isEmpty() && f.getCarrierName().isEmpty() && f.getSeatCapacity()>240)
		{
			throw new FlightNotFoundException("Flight is not created");
		}
		else
		{
			System.out.println("created flight");
		}
	}

}
