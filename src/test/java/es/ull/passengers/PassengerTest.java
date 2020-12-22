package es.ull.passengers;


import es.ull.flights.Flight;
import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    void setUp(){
        passenger = new Passenger("ABC", "Samuel", "ES");
    }

    @Test
    void testGetIdentifier(){
        assertEquals("ABC",passenger.getIdentifier());
    }

    @Test
    void testGetName(){
        assertEquals("Samuel", passenger.getName());
    }

    @Test
    void testGetCountryCode(){
        assertEquals("ES",passenger.getCountryCode());
    }

    @Test
    void testGetFlight(){
        Flight flight = new Flight("AB123", 77);
        passenger.setFlight(flight);
        assertEquals(flight,passenger.getFlight());
    }

    @Test
    void testToString(){
        String expectedString = "Passenger " + passenger.getName() + " with identifier: " +
                passenger.getIdentifier() + " from " + passenger.getCountryCode();
        assertEquals(expectedString,passenger.toString());
    }


}
