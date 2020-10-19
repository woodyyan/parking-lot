package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exception.NoAvailableSpaceException;

import java.util.HashMap;
import java.util.Map;


public class ParkingLot implements Parkable {
    private final int capacity;
    private final Map<ParkingTicket, Car> parkingRooms;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.parkingRooms = new HashMap<>(capacity);
    }

    public int getAvailableNumber() {
        return this.capacity - parkingRooms.size();
    }

    @Override
    public ParkingTicket park(Car car) {
        if (this.parkingRooms.size() >= this.capacity) {
            throw new NoAvailableSpaceException("Parking lot is full!");
        }
        ParkingTicket newTicket = new ParkingTicket();
        this.parkingRooms.put(newTicket, car);
        return newTicket;
    }

    @Override
    public Car fetch(ParkingTicket ticket) {
        Car car = this.parkingRooms.get(ticket);
        parkingRooms.remove(ticket);
        return car;
    }

    @Override
    public boolean isFull() {
        return this.capacity == parkingRooms.size();
    }

    @Override
    public boolean hasCar(ParkingTicket ticket) {
        return parkingRooms.containsKey(ticket);
    }

    public double getAvailableRate() {
        return (double) this.getAvailableNumber() / this.capacity;
    }
}
