package main.java.com.codesins.booking;

public record Reservation(
    String bookingId,
    Integer listingId,
    Integer reservedRooms
){}
