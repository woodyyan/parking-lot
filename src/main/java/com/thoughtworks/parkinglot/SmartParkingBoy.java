package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exception.NoAvailableSpaceException;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        return this.parkingLots
            .stream()
            .filter(parkingLot -> !parkingLot.isFull())
            .min((first, second) -> second.getAvailableNumber() - first.getAvailableNumber())
            .orElseThrow(() -> new NoAvailableSpaceException("Parking lot is full!"))
            .park(car);
    }
}
