package com.capgemini.service.Interface;

import com.capgemini.entities.Airport;

import java.util.List;

public interface IAirportService {

    public List<Airport> viewAllAirport();

    public Airport viewAirport(String a);
}
