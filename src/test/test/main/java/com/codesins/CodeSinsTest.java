package test.main.java.com.codesins;

import main.java.com.codesins.CodeSins;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeSinsTest {

    private final CodeSins sut = new CodeSins();



    @Test
    void testQuestionOne(){

        String[] titles = {"  cASa  DE   prAiA ", "APARTAMENTO   CENTRO  ", "LOFT"};
        String[] expectedResult = {"Casa De Praia", "Apartamento Centro", "Loft"};

        var result = sut.formatPropertyTitles(titles);

        assertArrayEquals(result, expectedResult);


    }

    @Test
    void testQuestionTwo(){

        int[][] calendar ={
                {0, 1, 0, 0, 2}, //property 1
                {0, 0, 0, 0, 0}, //2
                {1, 0, 0, 0, 0}  //3
        };

        int[] expectedResult = {2, 3};

        var result = sut.findAvailableDates(calendar);

        assertArrayEquals(result, expectedResult);
    }


    @Test
    void testQuestionThree(){
        int[] prices = {100, 200, 300, 150, 120, 400};
        int maxBudged = 600;

        var expectedResult = 3;

        var result = sut.maxBookingWindow(prices, maxBudged);

        assertEquals(expectedResult, result);
    }

}