package es.ull.passengers;


import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;
public class PassengerTest {

    private Passenger passenger;

    @BeforeEach
    void setUp(){
        passenger = new Passenger("ABC", "Samuel", "ES");
    }

    @Test
    void testGetIdentifier(){
        assertEquals("ABC",passenger.getIdentifier());
    }
}
