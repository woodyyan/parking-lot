package com.thoughtworks.parkinglot;

import com.thoughtworks.parkinglot.exception.NoAvailableSpaceException;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;


public class ParkingLotTest {

    @Test
    public void should_get_1_available_parking_room_when_parking_lot_is_empty_and_1_total_place() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        //when
        int availableNum = parkingLot.getAvailableNumber();

        //then
        assertEquals(1, availableNum);
    }

    @Test
    public void should_parking_vehicle_success_when_call_packing() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car();
        //when
        ParkingTicket ticket1 = parkingLot.park(car);
        ParkingTicket ticket2 = parkingLot.park(car);

        //then

        assertNotNull(ticket1);
        assertNotNull(ticket2);
        assertNotSame(ticket2, ticket1);
        assertEquals(0, parkingLot.getAvailableNumber());
    }

    @Test
    public void should_get_indicated_vehicle_when_get_vehicle_via_park_ticket_and_not_only_one_car_in_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket ticket1 = parkingLot.park(car1);
        ParkingTicket ticket2 = parkingLot.park(car2);
        //when
        Car pickedCar = parkingLot.fetch(ticket1);

        //then
        assertEquals(car1, pickedCar);
        assertEquals(1, parkingLot.getAvailableNumber());

    }

    @Test(expected = NoAvailableSpaceException.class)
    public void should_throw_no_available_space_exception_when_parking_vehicle_more_than_total_room_num() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car = new Car();
        //when
        parkingLot.park(car);
        parkingLot.park(car);
        parkingLot.park(car);

        //then
    }

    //测测是可以删除
    @Test
    public void should_get_2_available_parking_room_when_parking_lot_has_3_rooms_with_two_vehicle_parked() {

        //given
        ParkingLot parkingLot = new ParkingLot(3);
        Car car = new Car();
        ParkingTicket ticket1 = parkingLot.park(car);

        //when
        int availableNum = parkingLot.getAvailableNumber();

        //then
        assertEquals(2, availableNum);
    }

}
