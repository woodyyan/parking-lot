package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exception.NoAvailableSpaceException;
import com.thoughtworks.parkinglot.exception.WrongTicketException;

import java.util.Arrays;
import java.util.List;


public class ParkingManager {
    private final List<Parkable> parkableList;

    public ParkingManager(Parkable... parkables) {
        this.parkableList = Arrays.asList(parkables);
    }

    public ParkingTicket park(Car car) {
        return parkableList.stream()
            .filter(parkable -> !parkable.isFull())
            .findFirst()
            .orElseThrow(() -> new NoAvailableSpaceException("Parking lot is full!"))
            .park(car);
    }

    public Car fetch(ParkingTicket ticket) {
        return parkableList.stream()
            .filter(parkable -> parkable.hasCar(ticket))
            .findFirst()
            .orElseThrow(() -> new WrongTicketException("Ticket cannot find a car."))
            .fetch(ticket);
    }
}
