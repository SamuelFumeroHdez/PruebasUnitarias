/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.flights;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

public class Flight {

    /**
     * @brief atributo que indica el número de vuelo
     */
    private String flightNumber;
    /**
     * @brief atributo que indica el numero de asientos
     */
    private int seats;
    /**
     * @brief atributo que contiene el conjunto de pasajeros del vuelo
     */
    private Set<Passenger> passengers = new HashSet<>();
    /**
     * @brief atributo que contiene la expresion regular para el numero de vuelo
     */
    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    /**
     * Atributo que contiene el patrón del numero de vuelo
     */
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     *
     * @param flightNumber
     * @param seats
     * @brief constructor de la clase Flight
     */
    public Flight(String flightNumber, int seats) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     *
     * @return flightNumber
     * @brief get de numero de vuelo
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     *
     * @return passengers.size()
     * @brief get del numero de pasajeros que hay en un vuelo
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     *
     * @param passenger
     * @return
     * @brief método para añadir un pasajero al vuelo
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     *
     * @param passenger
     * @return
     * @brief método para eliminar un pasajero del vuelo
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }
}
