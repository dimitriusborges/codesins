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

}