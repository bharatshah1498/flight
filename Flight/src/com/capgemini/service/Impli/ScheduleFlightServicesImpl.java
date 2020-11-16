package com.capgemini.service.Impli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.dao.Interface.ScheduleDao;
import com.capgemini.entities.Airport;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.entities.ScheduledFlight;
import com.capgemini.exception.NoArguementException;
import com.capgemini.exception.ScheduleNotFound;
import com.capgemini.service.Interface.ScheduleFlightServices;

public class ScheduleFlightServicesImpl implements ScheduleFlightServices{
	
	private ScheduleDao dao;
	
	public ScheduleFlightServicesImpl(ScheduleDao dao) {
        this.dao = dao;
    }
	
	@Override
	public ScheduledFlight scheduleFlight(ScheduledFlight scheduleFlight) {
		// TODO Auto-generated method stub
		if (scheduleFlight == null) {
            throw new ScheduleNotFound("Schedule is null");
        }
        ScheduledFlight schedule = dao.scheduleFlight(scheduleFlight);
        return schedule;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlights(Airport source, Airport dest, LocalDate date) {
		// TODO Auto-generated method stub
		if (source == null || dest == null || date == null) {
            throw new NoArguementException("Argument is null");
        }
        List<ScheduledFlight> schedule = new ArrayList<>();
        schedule = dao.viewScheduledFlights(source, dest, date);
        return schedule;
	}

	@Override
	public Flight viewScheduledFlight(int flightNumber) {
		// TODO Auto-generated method stub
		if (flightNumber == 0) {
            throw new NoArguementException("Argument is null");
        }
        Flight flight = new Flight();
        flight = dao.viewScheduledFlight(flightNumber);
        return flight;
	}

	@Override
	public List<ScheduledFlight> viewScheduledFlight() {
		// TODO Auto-generated method stub
		List<ScheduledFlight> schedule = dao.viewScheduledFlight();
        return schedule;
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(Flight f, Schedule s, int flightNumber) {
		// TODO Auto-generated method stub
		if (f == null || s == null || flightNumber == 0) {
            throw new NoArguementException("Argument is null");
        }
        ScheduledFlight schedule1 = new ScheduledFlight();
        schedule1 = dao.modifyScheduledFlight(f, s, flightNumber);
        return schedule1;
	}

	@Override
	public void deleteScheduledFlight(int flightNumber) {
		// TODO Auto-generated method stub
		if (flightNumber == 0) {
            throw new NoArguementException("Argument is null");
        }
        dao.deleteScheduledFlight(flightNumber);
	}

	@Override
	public void validateScheduledFlights(ScheduledFlight scheduleFlight) {
		// TODO Auto-generated method stub
		ScheduledFlight s = scheduleFlight;
		if(s.getAvailableSeats() < 0 && s.getFlight() == null && s.getSchedule() == null )
		{
			throw new ScheduleNotFound("Schedule is not created");
		}
		else
		{
			System.out.println("created schedule");
		}	
	}
	
}
