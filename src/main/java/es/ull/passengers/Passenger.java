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
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;

public class Passenger {

    /**
     * @brief atributo que indica el identificador del pasajero
     */
    private String identifier;
    /**
     * @brief atributo que indica el nombre del pasajero
     */
    private String name;
    /**
     * @brief atributo que indica el código del país
     */
    private String countryCode;
    /**
     * @brief atributo que indica el vuelo del pasajero
     */
    private Flight flight;

    /**
     *
     * @param identifier
     * @param name
     * @param countryCode
     *
     * @brief constructor de la clase Pasajero
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     *
     * @return identifier
     * @brief get de identificador del pasajero
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @return name
     * @brief get del nombre del pasajero
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return countryCode
     * @brief get del código del país
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     *
     * @return flight
     * @brief get del vuelo del pasajero
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     *
     * @param flight
     * @brief método para enlazar un vuelo con otro
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     *
     * @param flight
     * @brief set de vuelo
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     *
     * @return
     * @brief método para imprimir pasajero por pantalla
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
