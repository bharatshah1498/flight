package com.capgemini.service.Interface;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.entities.Airport;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.entities.ScheduledFlight;

public interface ScheduleFlightServices {
	
	ScheduledFlight scheduleFlight(ScheduledFlight scheduleFlight);
	List<ScheduledFlight> viewScheduledFlights(Airport source, Airport dest, LocalDate date);
	Flight viewScheduledFlight(int flightNumber);
	List<ScheduledFlight> viewScheduledFlight();
	ScheduledFlight modifyScheduledFlight(Flight f, Schedule s, int flightNumber);
	void deleteScheduledFlight(int flightNumber);
	
	void validateScheduledFlights(ScheduledFlight scheduleFlight); 	
}
