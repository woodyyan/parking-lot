package com.thoughtworks.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class SmartParkingBoyTest {


    @Test
    public void should_parking_car_when_this_parking_lot_has_most_available_parking_rooms() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();

        //when
        ParkingTicket ticket1 = smartParkingBoy.park(car1);


        //then
        assertEquals(1, parkingLot1.getAvailableNumber());
        assertEquals(1, parkingLot2.getAvailableNumber());

    }
}
