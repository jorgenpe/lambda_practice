package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class CarTest
{
    /**
     * Doing a print out with testCar.drive() and testing getModel
     */
    @Test
    public void carTest(){
        Car testCar = new Car(123, 2020, "V 60", "white", "2.3 l");
        String expected = "V 60";
        testCar.drive();

        assertEquals(expected, testCar.getModel());
    }
}
