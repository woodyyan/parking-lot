package com.thoughtworks.parkinglot;

import org.junit.Test;

import java.util.stream.IntStream;

import static junit.framework.Assert.assertEquals;


public class SuperParkingBoyTest {

    @Test
    public void should_parking_car_when_this_parking_lot_has_most_available_rate_of_parking_rooms() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(6);
        ParkingLot parkingLot2 = new ParkingLot(2);
        ParkingBoy superParkingBoy = new SuperParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();

        //when

        IntStream.rangeClosed(1, 3).forEach(x -> superParkingBoy.park(car1));


        //then
        assertEquals(4, parkingLot1.getAvailableNumber());
        assertEquals(1, parkingLot2.getAvailableNumber());

    }
}
