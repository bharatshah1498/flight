package com.capgemini.service.Interface;
/**
 * @author
 */

import java.util.List;

import com.capgemini.entities.Booking;
import com.capgemini.entities.Passenger;

public interface IBookingService {
    public Booking addBooking(Booking b);
    public Booking modifyBooking(Booking b);
    public Booking viewBooking(int i);
    public void deleteBooking(int i);
    public void validateBooking(Booking b);
    public void validatePassenger(Passenger p);
	List<Booking> viewAllBooking();

}
