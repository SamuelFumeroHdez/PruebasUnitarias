package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    private Flight flight;
    private Passenger passenger;

    @BeforeEach
    void setUp(){
        flight = new Flight("AB123",77);
        passenger = new Passenger("ABC","Pepe", "ES");
        flight.addPassenger(passenger);
    }



    @Test
    void testGetFlightNumber(){
        assertEquals("AB123",flight.getFlightNumber());
    }

    @Test
    void testGetNumberOfPassengers(){
        assertEquals(1,flight.getNumberOfPassengers());
    }

    @Test
    void testAddPassenger(){
        assertTrue(flight.addPassenger(new Passenger("ABC", "Pedro", "ES")));
    }

    @Test
    void testRemovePassenger(){
        assertTrue(flight.removePassenger(passenger));
    }


}