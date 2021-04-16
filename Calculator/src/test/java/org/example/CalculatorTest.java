package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{



    @Test

    public void addCalc(){

        double a = 2.0;
        double b = 2.0;
        double expected = 4.0;
        double result = Calculator.addCalc(a ,b);

        assertEquals(expected, result);

    }



    @Test

    public void subCalc(){

        double a = 2.0;
        double b = 2.0;
        double expected = 0.0;
        double result = Calculator.subCalc(a ,b);

        assertEquals(expected, result);

    }



    @Test

    public void multiCalc(){

        double a = 2.0;
        double b = 2.0;
        double expected = 4.0;
        double result = Calculator.multiCalc(a ,b);

        assertEquals(expected, result);

    }




    @Test

    public void divCalc(){

        double a = 2.0;
        double b = 2.0;
        double expected = 1.0;
        double result = Calculator.divCalc(a ,b);

        assertEquals(expected, result);

    }



    @Test

    public void squCalc(){

        double a = 2.0;
        double expected = 4.0;
        double result = Calculator.squCalc(a );

        assertEquals(expected, result);

    }

    @Test
    public void isInteger(){
        String a ="2";
        boolean expected = true;
        boolean result = Calculator.isInteger(a );
        assertEquals(true, result);
    }

    @Test
    public void isDouble(){
        String a ="2.0 ";
        boolean expected = true;
        boolean result = Calculator.isDouble(a );
        assertEquals(true, result);
    }

}