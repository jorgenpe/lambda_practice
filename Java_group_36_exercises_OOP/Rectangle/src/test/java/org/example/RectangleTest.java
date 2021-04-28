package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RectangleTest
{
    /**
     * Test of calculation of area
     */
    @Test
    public void testRectangle(){
        double expected = 12.0;
        Rectangle rectangleTest = new Rectangle();
        rectangleTest.setHight(4.0);
        rectangleTest.setWeight(3.0);

        System.out.println(rectangleTest.toString());
        assertEquals(expected,rectangleTest.getArea());
    }
}
