package main.java.com.codesins;

import java.util.Arrays;
import java.util.List;

public class BookingWindow {

    private final List<Integer> bookingOptions;


    BookingWindow(int[] bookingOptions){

        this.bookingOptions = Arrays.stream(bookingOptions).boxed().toList();

    }


    // int[] prices = {100, 200, 300, 150, 120, 400};
    public int findMaxWindowFromBudget(int budget){

        if(this.bookingOptions.isEmpty()){
            return 0;
        }

        var windowStart = 0;

        //this is the max index not the max size
        var windowUpperLimit = bookingOptions.size();
        var windowBudget = this.bookingOptions.getFirst();
        var currentWindowSize = 0;


        for(int windowEnd = 1; windowEnd < windowUpperLimit; windowEnd++){

            windowBudget += this.bookingOptions.get(windowEnd);


            while(windowBudget > budget && windowStart <= windowEnd){
                windowBudget -= this.bookingOptions.get(windowStart);
                windowStart++;
            }
            currentWindowSize = Math.max(currentWindowSize, (windowEnd - windowStart + 1));

        }

        return currentWindowSize;
    }



}
