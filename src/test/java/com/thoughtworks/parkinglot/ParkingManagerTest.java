package com.thoughtworks.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;


public class ParkingManagerTest {

    @Test
    public void should_parking_the_vehicles_when_manager_manage_a_parking_lot_and_2_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy, parkingLot, smartParkingBoy);
        Car car = new Car();

        //when
        ParkingTicket ticket1 = parkingManager.park(car);
        ParkingTicket ticket2 = parkingManager.park(car);
        ParkingTicket ticket3 = parkingManager.park(car);

        //then
        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotNull(ticket3);
    }

    @Test
    public void should_pick_up_the_indicated_vehicles_in_a_parking_of_parking_boy_when_manager_manage_a_parking_lot_and_2_parking_boy() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot(1));
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(new ParkingLot(1));
        ParkingManager parkingManager = new ParkingManager(parkingBoy, parkingLot, smartParkingBoy);
        Car car = new Car();
        parkingManager.park(new Car());
        ParkingTicket ticket2 = parkingManager.park(car);
        parkingManager.park(new Car());

        //when
        Car pickedCar = parkingManager.fetch(ticket2);

        //then
        assertEquals(car, pickedCar);
    }
}
