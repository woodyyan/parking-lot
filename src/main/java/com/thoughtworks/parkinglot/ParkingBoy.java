package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exception.NoAvailableSpaceException;
import com.thoughtworks.parkinglot.exception.WrongTicketException;

import java.util.Arrays;
import java.util.List;

public class ParkingBoy implements Parkable {

    protected final List<ParkingLot> parkingLots;

    public ParkingBoy(ParkingLot... initParkingLots) {
        this.parkingLots = Arrays.asList(initParkingLots);
    }

    @Override
    public ParkingTicket park(Car car) {
        return this.parkingLots
            .stream()
            .filter(parkingLot -> !parkingLot.isFull())
            .findFirst()
            .orElseThrow(() -> new NoAvailableSpaceException("Parking lot is full!"))
            .park(car);
    }

    @Override
    public Car fetch(ParkingTicket ticket) {
        return parkingLots.stream()
            .filter(parkingLot -> parkingLot.hasCar(ticket))
            .findFirst()
            .orElseThrow(() -> new WrongTicketException("Ticket cannot find a car."))
            .fetch(ticket);
    }

    @Override
    public boolean isFull() {
        return this.parkingLots.stream().allMatch(ParkingLot::isFull);
    }

    @Override
    public boolean hasCar(ParkingTicket ticket) {
        return this.parkingLots.stream().anyMatch(parkingLot -> parkingLot.hasCar(ticket));
    }
}
