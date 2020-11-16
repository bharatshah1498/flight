package com.capgemini.dao.Impli;

import com.capgemini.dao.Interface.ScheduleDao;
import com.capgemini.entities.Airport;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.entities.ScheduledFlight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDaoImpl implements ScheduleDao {

	static
	{
		
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
