package com.capgemini.service.Impli;

import java.util.List;

import com.capgemini.dao.Impli.BookingDaoImpl;
import com.capgemini.dao.Interface.IBookingDao;
import com.capgemini.entities.Booking;
import com.capgemini.entities.Passenger;
import com.capgemini.exception.BookingNotFound;
import com.capgemini.exception.IncorrectArgumentException;
import com.capgemini.exception.NoArguementException;
import com.capgemini.exception.PassengerNotFoundException;
import com.capgemini.service.Interface.IBookingService;

//import static java.time.LocalDateTime.now;

public class BookingServiceImpl implements IBookingService {
    IBookingDao store = new BookingDaoImpl();

    public BookingServiceImpl(BookingDaoImpl store) {
        this.store = store;
    }

    public BookingServiceImpl() {

    }

    @Override
    public Booking addBooking(Booking b) {
        if(b!=null)
        return store.addBooking(b);
        else {
            throw new BookingNotFound("Booking Details does not exits!!");
        }
    }

    @Override
    public Booking modifyBooking(Booking b) {
        if(b!=null)
        return store.modifyBooking(b);
        else
        {
            throw new BookingNotFound("Booking Details does not exits!!");
        }
    }

    @Override
    public Booking viewBooking(int i) {
        if(i<0) {
            Booking b = store.viewBooking(i);
            return b;
        }
        else
        {
            throw new NoArguementException(" Invalid id");
        }
    }
    @Override
    public List<Booking> viewAllBooking() {
        List<Booking> lists = store.viewAllBooking();
        return lists;
    }

    @Override
    public void deleteBooking(int i) {
        if(i<0)
        {
            store.deleteBooking(i);
        }
        else
        {
            throw new NoArguementException("Invalid id");
        }

    }

    @Override
    public void validateBooking(Booking b) {
        if(b!=null) {
            if (b.getNoOfPassengers() < 0 && b.getTicketCost() < 0) {

                throw new IncorrectArgumentException("Booking is not created");
            } else {
                System.out.println("created Booking");
            }
        }else
        {
            throw new BookingNotFound("Booking is null");
        }

    }

    @Override
    public void validatePassenger(Passenger p) {
        if(p.getPnrNumber()<0 && p.getPassengerName().isEmpty()&& p.getPassengerAge()<0 && p.getPassengerUIN()<0 && p.getLuggage() <100)
        {
            throw new PassengerNotFoundException("Passenger is not created");
        }
        else
        {
            System.out.println("Passenger is created");
        }

    }
}
