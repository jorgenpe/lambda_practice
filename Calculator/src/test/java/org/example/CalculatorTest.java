package org.example;


import org.junit.jupiter.api.Test;

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

    }



    @Test

    public void multiCalc(){

        double a = 2.0;
        double b = 2.0;

    }




    @Test

    public void divCalc(){

        double a = 2.0;
        double b = 2.0;

    }



    @Test

    public void squCalc(){

        double a = 2.0;

    }




}