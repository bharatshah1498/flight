package com.capgemini.entities;

public class Flight {
	private  int flightNumber;
	private String flightModel;
	private int seatCapacity;
	private String carrierName;

	public Flight() {
		super();
	}
	public Flight(int flightNumber,String flightModel,int seatCapacity,String carrierName) {
		super();
		this.flightNumber=flightNumber;
		this.flightModel=flightModel;
		this.seatCapacity=seatCapacity;
		this.carrierName=carrierName;		
	}

	@Override
	public String toString() {
		return "Flight{" +
				"flightNumber=" + flightNumber +
				", flightModel='" + flightModel + '\'' +
				", seatCapacity=" + seatCapacity +
				", carrierName='" + carrierName + '\'' +
				'}';
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightModel() {
		return flightModel;
	}
	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	
}