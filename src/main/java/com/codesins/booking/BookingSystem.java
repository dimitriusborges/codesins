package main.java.com.codesins.booking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSystem {

/*
Memory structure functions as a db with three tables:
Hotels registration
listing registration that points to hotels
Booking registration that points to listings
 */

    private final Map<Integer, Hotel> listedHotels = new HashMap<>();
    private final List<Reservation> reservationList = new ArrayList<>();


    public boolean createListing(int listingId, int totalRooms) {

        if (listedHotels.containsKey(listingId)) {
            return false;
        }

        if (totalRooms <= 0) {
            return false;
        }

        listedHotels.put(listingId, new Hotel(totalRooms));

        return true;
    }

    public boolean bookRoom(String bookingId, int listingId, int count) {

        if(!listedHotels.containsKey(listingId)
                || this.reservationAlreadyExists(bookingId)) {

            return false;
        }

        if (!listedHotels.get(listingId).bookRooms(count)) {
            return false;
        }
        this.reservationList.add(new Reservation(bookingId, listingId, count));
        return true;

    }

    public boolean cancelBooking(String bookingId) {

        var reservationToCancel = this.reservationList
                .stream()
                .filter(reservation -> bookingId.equals(reservation.bookingId())).findFirst().orElse(null);

        if(reservationToCancel == null){
            System.out.printf("Cannot cancel the Booking Reservation because the Booking Id %s does not exist%n", bookingId);
            return false;
        }

        this.listedHotels.get(reservationToCancel.listingId()).freeRooms(reservationToCancel.reservedRooms());

        this.reservationList.remove(reservationToCancel);

        return true;
    }


    public int getAvailableRooms(int listingId) {
        if(!listedHotels.containsKey(listingId)){
            System.out.printf("Failed to get the Available Rooms for the listing Identification %d: this listing does not exist%n", listingId);
            return -1;        }

        return listedHotels.get(listingId).getAvailableRooms();
    }


    private boolean reservationAlreadyExists(String bookingId){
        return reservationList.stream().anyMatch(reservation -> reservation.bookingId().equals(bookingId));
    }
}

