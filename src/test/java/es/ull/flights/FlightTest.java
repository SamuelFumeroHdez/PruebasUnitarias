package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Flight flight;

    @BeforeEach
    void setUp(){
        flight = new Flight("AB123",77);
    }

    @Test
    public void testGetFlightNumber(){
        assertEquals("AB123",flight.getFlightNumber());
    }


}