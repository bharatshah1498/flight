package com.capgemini.dao.Interface;

import java.util.List;

import com.capgemini.entities.Booking;

public interface IBookingDao {
    public Booking addBooking(Booking b);
    public Booking modifyBooking(Booking b);
    public Booking viewBooking(int i);
    public List<Booking> viewAllBooking();
    public void deleteBooking(int i);
}
