package com.capgemini.service.Impli;
/**
 * @author
 */

import java.util.List;

import com.capgemini.dao.Impli.AirportDaoImpl;
import com.capgemini.dao.Interface.IAirportDao;
import com.capgemini.entities.Airport;
import com.capgemini.exception.IncorrectArgumentException;
import com.capgemini.service.Interface.IAirportService;

public class AirportServiceImpl implements IAirportService {
	IAirportDao dao=new AirportDaoImpl();
	
	public AirportServiceImpl(AirportDaoImpl dao)
	{
		this.dao=dao;
	}
    public AirportServiceImpl() {

    }

	@Override
	public List<Airport> viewAllAirport()

	{
		List<Airport> list=dao.viewAllAirport();
		return list;
	}


	@Override
	public Airport viewAirport(String a) {
		if(a==null){
			throw new IncorrectArgumentException("Airport code is null");
		}
		return dao.viewAirport(a);
	}
	
}
