package test.main.java.com.codesins.booking;
import main.java.com.codesins.booking.BookingSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookingSystemTest {


    private BookingSystem sut = new BookingSystem();


    @Test
    public void shouldAddNewListingIfAbsent(){
        assertTrue(sut.createListing(1, 5));
    }


    @Test
    public void shouldDenyNewListingIfListingIdIsUsed(){
        var listingId = 1;
        var totalRooms = 5;

        assertTrue(sut.createListing(listingId, totalRooms));
        assertFalse(sut.createListing(listingId, totalRooms));

    }

    @Test
    public void shouldDenyNewListingIfTotalRoomsIsInvalid(){

        assertFalse(sut.createListing(1, 0));
        assertFalse(sut.createListing(1, -1));
    }

    @Test
    public void shouldBookNRoomsIfAvailable(){
        var listingId = 1;
        var totalRooms = 5;
        var bookingId = "1";
        var roomsToBook = 3;

        sut.createListing(listingId, totalRooms);

        assertTrue(sut.bookRoom(bookingId, listingId, roomsToBook));
    }

    @Test
    public void shouldDenyBookingIfListingDoesNotExist(){
        var listingId = 1;
        var totalRooms = 5;
        var bookingId = "1";
        var roomsToBook = 3;

        sut.createListing(listingId, totalRooms);

        assertFalse(sut.bookRoom(bookingId, 99, roomsToBook));
    }

    @Test
    public void shouldDenyBookingIfBookingIdNotAvailable(){
        var listingId = 1;
        var totalRooms = 5;
        var bookingId = "1";
        var roomsToBook = 3;

        sut.createListing(listingId, totalRooms);

        assertTrue(sut.bookRoom(bookingId, 1, roomsToBook));
        assertFalse(sut.bookRoom(bookingId, 1, roomsToBook));
    }

    @Test
    public void shouldDenyBookingIfNRoomsNotAvailable(){
        var listingId = 1;
        var totalRooms = 5;
        var bookingId = "1";
        var roomsToBook = 6;

        sut.createListing(listingId, totalRooms);

        assertFalse(sut.bookRoom(bookingId, 1, roomsToBook));
    }

    @Test
    public void shouldReturnAvailableRoomsIfListingExists(){
        var totalRooms = 5;
        var listingId = 1;
        var bookingId = "1";
        var roomsToBook = 2;
        var expectedAvailableRooms = 3;

        sut.createListing(listingId, totalRooms);
        assertEquals(totalRooms, sut.getAvailableRooms(listingId));
        sut.bookRoom(bookingId, listingId, roomsToBook);
        assertEquals(expectedAvailableRooms, sut.getAvailableRooms(listingId));
    }

    @Test
    public void getAvailableRoomsShouldReturnFlagIfListingDoesNotExist(){
        var totalRooms = 5;
        var listingId = 1;

        sut.createListing(listingId, totalRooms);
        assertEquals(-1, sut.getAvailableRooms(2));
    }

    @Test
    public void shouldCancelBookingIfBookingIdExists(){
        var listingId = 1;
        var totalRooms = 5;
        var bookingId = "1";
        var roomsToBook = 3;

        sut.createListing(listingId, totalRooms);
        assertTrue(sut.bookRoom(bookingId, listingId, roomsToBook));
        assertTrue(sut.cancelBooking(bookingId));
        assertEquals(totalRooms, sut.getAvailableRooms(listingId));
        assertTrue(sut.bookRoom(bookingId, listingId, roomsToBook)); //booking Id available again
    }

    @Test
    public void shouldDenyBookingIfBookingIdDoesNotExists(){
        var listingId = 1;
        var totalRooms = 5;
        var bookingId = "1";
        var roomsToBook = 3;

        sut.createListing(listingId, totalRooms);
        assertTrue(sut.bookRoom(bookingId, listingId, roomsToBook));
        assertFalse(sut.cancelBooking("random"));
    }
}
