package test.main.java.com.codesins.booking;

import main.java.com.codesins.booking.Hotel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {


    @Test
    public void shouldRentNRooms(){

        var totalRooms = 5;
        var roomsToBook = 4;
        Hotel sut = new Hotel(totalRooms);

        assertEquals(totalRooms, sut.getAvailableRooms());
        assertTrue(sut.bookRooms(roomsToBook));
        assertEquals(totalRooms - roomsToBook, sut.getAvailableRooms());
    }

    @Test
    public void shouldDenyRoomRentingIfNotAvailable(){

        var totalRooms = 5;
        var roomsToBook = 6;
        Hotel sut = new Hotel(totalRooms);

        assertFalse(sut.bookRooms(roomsToBook));

    }

    @Test
    public void shouldDenyRoomRentingIfNRoomsIsInvalid(){

        var totalRooms = 5;
        var roomsToBook = -1;
        Hotel sut = new Hotel(totalRooms);

        assertFalse(sut.bookRooms(roomsToBook));

    }

    @Test
    public void shouldFreeTheCorrectNumberOfRooms(){
        var totalRooms = 5;
        var roomsToBook = 2;
        var roomsToFree = 1;
        var roomsAfterFree = 4;
        Hotel sut = new Hotel(totalRooms);

        assertEquals(totalRooms, sut.getAvailableRooms());
        assertTrue(sut.bookRooms(roomsToBook));
        assertEquals(totalRooms - roomsToBook, sut.getAvailableRooms());

        assertTrue(sut.freeRooms(roomsToFree));
        assertEquals(roomsAfterFree, sut.getAvailableRooms());
    }
}
