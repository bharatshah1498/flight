package com.capgemini.dao.Impli;

import com.capgemini.dao.Interface.ScheduleDao;
import com.capgemini.entities.Airport;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.entities.ScheduledFlight;
import com.capgemini.service.Impli.AirportServiceImpl;
import com.capgemini.service.Impli.IFlightServiceImpl;
import com.capgemini.service.Interface.IAirportService;
import com.capgemini.service.Interface.IFlightService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {

	static
	{
		IFlightService flightService = new IFlightServiceImpl(new FlightDaoImpl());
        IAirportService airportService = new AirportServiceImpl(new AirportDaoImpl());
        Flight f1 = flightService.viewFlight(166001);
        Airport sourceAirport = airportService.viewAirport("IGIA");
        Airport destinationAirport = airportService.viewAirport("CSIA");
        LocalDateTime at = LocalDateTime .parse("2018-12-30T19:34:50.63");
        LocalDateTime dt = LocalDateTime .parse("2018-12-30T21:45:23.35");
        Schedule sch = new Schedule(sourceAirport, destinationAirport, at, dt);
        scheduledFlightList.add(new ScheduledFlight(f1,125,sch));
        
        f1 = flightService.viewFlight(166002);
        sourceAirport = airportService.viewAirport("IGIA");
        destinationAirport = airportService.viewAirport("CSIA");
        at = LocalDateTime .parse("2019-01-10T09:34:50.63");
        dt = LocalDateTime .parse("2019-01-10T11:45:23.35");
        sch = new Schedule(sourceAirport, destinationAirport, at, dt);
        scheduledFlightList.add(new ScheduledFlight(f1,110,sch));
	}
	
	@Override
	public ScheduledFlight scheduleFlight(ScheduledFlight scheduleFlight) {
		scheduledFlightList.add(scheduleFlight);
		return null;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlights(Airport source, Airport dest, LocalDate date) {
		
		List<ScheduledFlight> search = new ArrayList<>();
		for(ScheduledFlight s: scheduledFlightList) {
			Schedule f = s.getSchedule();
			if(f.getSourceAirport() == source && f.getDestinationAirport() == dest && f.getDepartureTime().toLocalDate() == date) {
				search.add(s);
			}
		}
		return search;
	}

	@Override
	public Flight viewScheduledFlight(int flightNumber) {
		for(ScheduledFlight s: scheduledFlightList) {
			Flight f = s.getFlight();
			if(f.getFlightNumber() == flightNumber) {
				return f;
			}
		}
		return null;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		return scheduledFlightList;
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(Flight f, Schedule s, int flightNumber) {
		for(ScheduledFlight sf: scheduledFlightList) {
			Flight fs = sf.getFlight();
			if(fs.getFlightNumber() == flightNumber) {
				sf.setFlight(f);
				sf.setSchedule(s);
				return sf;
			}
		}
		return null;
	}

	@Override
	public void deleteScheduledFlight(int flightNumber) {
		
		for (int i = 0; i < scheduledFlightList.size(); i++) {
			ScheduledFlight s = scheduledFlightList.get(i);
			Flight f = s.getFlight();
			if(f.getFlightNumber() == flightNumber) {
				scheduledFlightList.remove(i);
				break;
			}
		}
		
	}
    
}
