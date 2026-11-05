package main.java.com.codesins;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CodeSins {

    // ==========================================
    // Questão 1: formatPropertyTitles
    // ==========================================
    public static String[] formatPropertyTitles(String[] titles) {
        var propTitles = new PropertyTitles(titles);
        return propTitles.formatPropertyTitles();
    }

    // ==========================================
    // Questão 2: findAvailableDates
    // ==========================================
    public static int[] findAvailableDates(int[][] calendar) {
        // Implemente aqui
        return new int[0];
    }

    // ==========================================
    // Questão 3: maxBookingWindow
    // ==========================================
    public static int maxBookingWindow(int[] prices, int maxBudget) {
        // Implemente aqui
        return 0;
    }

    // ==========================================
    // Questão 4: BookingSystem (Design)
    // ==========================================
    public static class BookingSystem {

        public BookingSystem() {
            // Inicialize suas estruturas de dados aqui
        }

        public boolean createListing(int listingId, int totalRooms) {
            return false;
        }

        public boolean bookRoom(String bookingId, int listingId, int count) {
            return false;
        }

        public boolean cancelBooking(String bookingId) {
            return false;
        }

        public int getAvailableRooms(int listingId) {
            return -1;
        }
    }


    public static void main(String[] args){
    }
}