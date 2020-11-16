package com.capgemini.UI;

import com.capgemini.dao.Impli.AirportDaoImpl;
import com.capgemini.dao.Impli.BookingDaoImpl;
import com.capgemini.dao.Impli.FlightDaoImpl;
import com.capgemini.dao.Impli.ScheduleDaoImpl;
import com.capgemini.dao.Impli.UserDaoImpl;
import com.capgemini.entities.Airport;
import com.capgemini.entities.Booking;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Passenger;
import com.capgemini.entities.Schedule;
import com.capgemini.entities.ScheduledFlight;
import com.capgemini.entities.Users;
import com.capgemini.service.Impli.AirportServiceImpl;
import com.capgemini.service.Impli.BookingServiceImpl;
import com.capgemini.service.Impli.IFlightServiceImpl;
import com.capgemini.service.Impli.ScheduleFlightServicesImpl;
import com.capgemini.service.Impli.UserServiceImpl;
import com.capgemini.service.Interface.IAirportService;
import com.capgemini.service.Interface.IBookingService;
import com.capgemini.service.Interface.IFlightService;
import com.capgemini.service.Interface.IUserService;
import com.capgemini.service.Interface.ScheduleFlightServices;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
//import com.capgemini.util.MyDBConnection;
/**
 *
 */
//import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class LoginUI {
    /**
     *
     * @param args
     */

    public static void main(String[] args)
    {
        //Connection con = MyDBConnection.getConnection();
        //LoginUI ui = new LoginUI();
        LoginUI.runUi();

    }

    static void runUi() {
        /**
         * Login Details and SignUp Details
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN PRESS 1");
        System.out.println("SIGNUP PRESS 2");
        System.out.println("EXIT PRESS 3");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter UserID");
                int uid = sc.nextInt();
                System.out.println("Enter Password");
                String pass = sc.next();
                UserServiceImpl us = new UserServiceImpl(new UserDaoImpl());
                Users u = us.validateUser(uid, pass);
                if (u != null) {
                    if (u.getUserType().equals("A")) {
                        displayAdminPanel(u);
                    } else {
                        displayCustomerPanel(u);
                    }
                } else {
                    System.out.println("Invalid User Data!!");
                    runUi();

                }
                break;

            case 2:
                IUserService us1 = new UserServiceImpl(new UserDaoImpl());
                System.out.println("Do you want to signUp");
                System.out.println("Enter the userId");
                int i = sc.nextInt();
                System.out.println("Enter the UserName :");
                String name = sc.next();
                System.out.println("Enter the password");
                String pass1 = sc.next();
                System.out.println("Enter the UserPhone :");
                long phone = sc.nextLong();
                System.out.println("Enter the Email :");
                String email = sc.next();
                System.out.println("Enter the userType either C or A");
                String userType = sc.next();
                Users u1 = new Users(i, name, pass1, phone, email, userType);
                us1.addUser(u1);
                System.out.println("New user created");
                runUi();
                break;
            case 3:
                System.out.println("Terminate");
                sc.close();
                return;
            default:
                System.out.println("Invalid Choice");
                break;
        }

        sc.close();
    }

    private static void displayAdminPanel(Users user)
    /**
     * Display all the Admin control methods
     */
    {
        System.out.println("Welcome " + user.getUserName() + "! You are Admin.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to add Flight Details");
        System.out.println("Press 2 to modify Flight details");
        System.out.println("Press 3 to remove Flight details");
        System.out.println("press 4 to search a flight by id");
        System.out.println("press 5 to View all flights");
        System.out.println("press 6 to View all aiports");
        System.out.println("Press 7 to add ScheduleFlight Details");
        System.out.println("Press 8 to remove ScheduleFlight details");
   
        System.out.println("press 9 to search a Schedule Flight");
        System.out.println("press 10 to List all Users");
        System.out.println("press 11 to Logout");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                IFlightService serviceFlight1 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the flight number");
                int fn = sc.nextInt();
                System.out.println("Enter the flight model");
                String fm = sc.next();
                System.out.println("Enter the flight seat capacity");
                int fsc = sc.nextInt();
                System.out.println("Enter the flight carrier name");
                String fcn = sc.next();
                Flight f = new Flight(fn, fm, fsc, fcn);
                serviceFlight1.addFlight(f);
                displayAdminPanel(user);
                break;

            case 2:
                IFlightService serviceFlight2 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the  Flight number which is to be modify");
                int fn1 = sc.nextInt();
                System.out.println("Enter the new flight model");
                String fm1 = sc.next();
                System.out.println("Enter the new seat Capacity");
                int sc1 = sc.nextInt();
                System.out.println("Enter the new Flight carrier name");
                String fcn1 = sc.next();
                Flight f1 = new Flight(fn1, fm1, sc1, fcn1);
                serviceFlight2.modifyFlight(f1);
                displayAdminPanel(user);
                break;

            case 3:
                IFlightService serviceFlight3 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the  Flight number which is to be Delete");
                int fn2 = sc.nextInt();
                serviceFlight3.deleteFlight(fn2);
                displayAdminPanel(user);
                break;

            case 4:
                IFlightService serviceFlight4 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the  Flight number");
                int fn3 = sc.nextInt();
                Flight f2 = serviceFlight4.viewFlight(fn3);
                System.out.println(f2);
                displayAdminPanel(user);
                break;
            
            case 5:
            	IFlightService flightService1 = new IFlightServiceImpl(new FlightDaoImpl());
            	List<Flight> list2 = flightService1.viewAllFlight();
            	for (Flight f12 : list2) {
            		System.out.println(f12);
            	}
            	System.out.println();
            	displayAdminPanel(user);
            	break;
            	
            case 6:
            	IAirportService airportService1 = new AirportServiceImpl(new AirportDaoImpl());
            	List<Airport> list1 = airportService1.viewAllAirport();
            	for (Airport a : list1) {
            		System.out.println(a);
            	}
            	System.out.println();
            	displayAdminPanel(user);
            	break;

            case 7:
                IFlightService flightService = new IFlightServiceImpl(new FlightDaoImpl());
                IAirportService airportService = new AirportServiceImpl(new AirportDaoImpl());
            	ScheduleFlightServices serviceScheduleFlight1 = new ScheduleFlightServicesImpl(new ScheduleDaoImpl());
                
            	System.out.println("Enter flight number");
                int flightNumber = sc.nextInt();
                sc.nextLine();
                Flight f3 = flightService.viewFlight(flightNumber);
                
                System.out.println("Enter source airport code");
                String sourceAirportCode = sc.nextLine();
                Airport sourceAirport = airportService.viewAirport(sourceAirportCode);
                
                System.out.println("Enter destination airport code");
                String destinationAirportCode = sc.nextLine();
                Airport destinationAirport = airportService.viewAirport(destinationAirportCode);
                
                System.out.println("Enter arrival date time");
                String arrivalDateTime=sc.nextLine();
                LocalDateTime at = LocalDateTime .parse(arrivalDateTime);
                
                System.out.println("Enter departure date time");
                String departureDateTime=sc.nextLine();
                LocalDateTime dt = LocalDateTime .parse(departureDateTime);
                
                Schedule sch = new Schedule(sourceAirport, destinationAirport, at, dt);
                
                System.out.println("Enter available number of seats");
                int availSeats=sc.nextInt();
                sc.nextLine();
                
                ScheduledFlight scf=new ScheduledFlight(f3,availSeats,sch);
                serviceScheduleFlight1.scheduleFlight(scf);
                
                displayAdminPanel(user);
                break;
                
            case 8:
                ScheduleFlightServices serviceScheduleFlight3 = new ScheduleFlightServicesImpl(new ScheduleDaoImpl());
                System.out.println("Enter the  ScheduleFlight Id which is to be Delete");
                int scf3 = sc.nextInt();
                sc.nextLine();
                serviceScheduleFlight3.deleteScheduledFlight(scf3);
                displayAdminPanel(user);
                break;

            case 9:
                ScheduleFlightServices serviceScheduleFlight4 = new ScheduleFlightServicesImpl(new ScheduleDaoImpl());
                System.out.println("Enter the Schedule Flight id");
                int fid1 = sc.nextInt();
                sc.nextLine();
                System.out.println(serviceScheduleFlight4.viewScheduledFlight(fid1));
                displayAdminPanel(user);
                break;
                
            case 10:
            	UserServiceImpl us = new UserServiceImpl(new UserDaoImpl());
            	List<Users> list = us.viewAllUser();
            	for (Users u : list) {
            		System.out.println(u);
            	}
            	System.out.println();
            	displayAdminPanel(user);
            	break;
            case 11:
                System.out.println("LogoutSuccessfully");
                runUi();
                sc.close();
                return;
            default: {
                System.out.println("Incorrect choice");
                displayAdminPanel(user);
                break;
            }
        }
        
        sc.close();
    }

    private static void displayCustomerPanel(Users user)
    /**
     * Display all the Customer methods
     */
    {
        System.out.println("Welcome " + user.getUserName() + "! You are Customer.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to do Booking");
        System.out.println("press 2 to view all your Booking");
        System.out.println("Press 3 to cancel Booking details");
        System.out.println("Press 4 to view Booking Details of specific id");
        System.out.println("Press 5 to view all flight details");
        System.out.println("Press 6 to view all schedules");
        System.out.println("Press 7 to Logout");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
            	IFlightService flightService = new IFlightServiceImpl(new FlightDaoImpl());
            	IBookingService serviceBooking1 = new BookingServiceImpl(new BookingDaoImpl());
            	
            	String genNum = Double.toString(Math.random()).substring(3,11);
                int bookingId = Integer.parseInt(genNum);
                
            	System.out.println("Enter flight number");
                int flightNumber = sc.nextInt();
                sc.nextLine();
                Flight f = flightService.viewFlight(flightNumber);
            	
                LocalDate bookingDate = LocalDate.now();
                
                System.out.println("Enter no of Passengers");
                int noOfpassengers = sc.nextInt();
                sc.nextLine();
                
                List<Passenger> list = new ArrayList<>();
                for (int i=0; i<noOfpassengers; i++) {
                	
                	String genNum1 = Double.toString(Math.random()).substring(3,11);
                    int pPNR = Integer.parseInt(genNum1);
                	System.out.println("Enter Passenger Name");
                	String pName = sc.nextLine();
                	System.out.println("Enter Passenger Age");
                	int pAge = sc.nextInt();
                	sc.nextLine();
                	System.out.println("Enter Passenger UIN");
                	int pUIN = sc.nextInt();
                	sc.nextLine();
                	System.out.println("Enter Luggage");
                	double pLuggage = sc.nextDouble();
                	sc.nextLine();
                	
                	Passenger p = new Passenger(pPNR, pName, pAge, pUIN, pLuggage);
                	list.add(p);
                }
                
                System.out.println("Enter the ticketCost");
                double tc = sc.nextDouble();
                
                Booking b = new Booking(bookingId, user, bookingDate, list, tc, f, noOfpassengers);
                
                serviceBooking1.addBooking(b);
                displayCustomerPanel(user);
                break;
                
            case 2:
            	IBookingService serviceBooking5 = new BookingServiceImpl(new BookingDaoImpl());
            	List<Booking> list4 = serviceBooking5.viewAllBooking();
            	for (Booking b1 : list4) {
            		System.out.println(b1);
            	}
            	System.out.println();
                displayCustomerPanel(user);
            	break;

            case 3:
                IBookingService serviceBooking3 = new BookingServiceImpl(new BookingDaoImpl());
                System.out.println("Enter the Booking id which is to be deleted");
                int id2 = sc.nextInt();
                serviceBooking3.deleteBooking(id2);
                displayCustomerPanel(user);
                break;

            case 4:
                IBookingService serviceBooking4 = new BookingServiceImpl(new BookingDaoImpl());
                System.out.println("Enter the Booking id to view the details");
                int id3 = sc.nextInt();
                Booking b2 = serviceBooking4.viewBooking(id3);
                System.out.println(b2);
                displayCustomerPanel(user);
                break;

            case 5:
            	IFlightService flightService1 = new IFlightServiceImpl(new FlightDaoImpl());
            	List<Flight> list2 = flightService1.viewAllFlight();
            	for (Flight f12 : list2) {
            		System.out.println(f12);
            	}
            	System.out.println();
                displayCustomerPanel(user);
                break;
                
            case 6:
            	ScheduleFlightServices scheduleflightService1 = new ScheduleFlightServicesImpl(new ScheduleDaoImpl());
            	List<ScheduledFlight> list3 = scheduleflightService1.viewScheduledFlight();
            	for (ScheduledFlight sf : list3) {
            		System.out.println(sf);
            	}
            	System.out.println();
                displayCustomerPanel(user);
            	break;
            	
            case 7:
                System.out.println("LogoutSuccessfully");
                runUi();
                sc.close();
                return;

            default: {
                System.out.println("Incorrect choice");
                displayCustomerPanel(user);
            }
        }
        sc.close();
    }
}
