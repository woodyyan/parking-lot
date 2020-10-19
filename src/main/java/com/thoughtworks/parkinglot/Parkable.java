package com.thoughtworks.parkinglot;

public interface Parkable {
    ParkingTicket park(Car car);

    Car fetch(ParkingTicket ticket);

    boolean isFull();

    boolean hasCar(ParkingTicket ticket);
}
