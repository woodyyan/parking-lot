package com.thoughtworks.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;


public class ParkingBoyTest {

    @Test
    public void should_call_parking_of_parkinglot_when_parking_a_vehicle() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        //when
        ParkingTicket ticket1 = parkingBoy.park(car1);
        ParkingTicket ticket2 = parkingBoy.park(car2);
        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
    }

    @Test
    public void should_get_parking_car_when_it_parking_in_any_parking_lot_boy_manage() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot1, parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket ticket1 = parkingBoy.park(car1);
        ParkingTicket ticket2 = parkingBoy.park(car2);
        //when
        Car pickedCar2 = parkingBoy.fetch(ticket2);
        Car pickedCar1 = parkingBoy.fetch(ticket1);

        //then
        assertEquals(car1, pickedCar1);
        assertEquals(car2, pickedCar2);
        assertNotSame(ticket1, ticket2);
    }


}
