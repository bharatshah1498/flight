package com.capgemini.dao.Impli;


import com.capgemini.dao.Interface.IBookingDao;
import com.capgemini.entities.Booking;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDaoImpl implements IBookingDao {
	
    private static Map<Integer, Booking> bookingData = new HashMap<>();
    
    static
    {
    	
    }
    
    @Override
    public Booking addBooking(Booking b) {
    	
    	if (b != null) {
    		bookingData.put(b.getBookingId(),b);
    		return b;
    	}
    	else {
    		return null;
    	}
    }

    @Override
    public Booking viewBooking(int i) {
        Booking b = null;
		try {
			b=bookingData.get(i);
			return b;
		} catch (NullPointerException e) {
			return null;
		}
    }

	@Override
	public List<Booking> viewAllBooking() {
		Collection<Booking> coll=bookingData.values();
		List<Booking> lists = new ArrayList<>(coll);
		return lists;
	}
	
    @Override
    public void deleteBooking(int i) {
        
    	try {
			bookingData.remove(i);
		} catch (NullPointerException e) {
			
		}
    	
    }

	@Override
	public Booking modifyBooking(Booking b) {
		if (b != null) {
    		bookingData.put(b.getBookingId(),b);
    		return b;
    	}
    	else {
    		return null;
    	}
	}

}
