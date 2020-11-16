package com.capgemini.entities;

import java.time.LocalDateTime;

public class Schedule
{
	private Airport sourceAirport;
	private Airport destinationAirport;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;

	public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime,
			LocalDateTime departureTime) {
		super();
		this.sourceAirport = sourceAirport;
		this.destinationAirport = destinationAirport;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}
	public Schedule()
	{
	}
	
	public Airport getSourceAirport() {
		return sourceAirport;
	}
	public void setSourceAirport(Airport sourceAirport) {
		this.sourceAirport = sourceAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	@Override
	public String toString() {

		return "\n Source Airport :" + sourceAirport + "\n Destination Airport :" + destinationAirport
				+ "\n Arrival Time :" + arrivalTime + "\n Departure Time :" + departureTime;
	}


}