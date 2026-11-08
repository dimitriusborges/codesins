package main.java.com.codesins.booking;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final Integer totalRooms;
    private Integer availableRooms;

    public Hotel(Integer totalRooms){
        this.totalRooms = totalRooms;
        this.availableRooms = totalRooms;
    }

    public boolean bookRooms(int roomsToBook){

        if(availableRooms <= roomsToBook){
            return false;
        }

        if(roomsToBook <= 0){
            return false;
        }

        availableRooms -= roomsToBook;
        return  true;
    }

    public boolean freeRooms(int roomsToFree){
        if(availableRooms.equals(totalRooms)) {
            return true;
        }
        availableRooms +=roomsToFree;
        return true;
    }

    public Integer getAvailableRooms(){
        return this.availableRooms;
    }
}
