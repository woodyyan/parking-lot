package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exception.NoAvailableSpaceException;

import java.util.Comparator;


public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        return this.parkingLots
            .stream()
            .filter(parkingLot -> !parkingLot.isFull())
            .max(Comparator.comparing(ParkingLot::getAvailableRate))
            .orElseThrow(() -> new NoAvailableSpaceException("Parking lot is full!"))
            .park(car);
    }
}
