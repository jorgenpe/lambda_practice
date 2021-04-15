package org.example;





import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Rot13ConverterTest {

    @Test
    public static void a_becomes_n{

        char letter = 'a';
        char expected = 'n';

        char actual =Rot13Convertion.convertChar(letter);
        assertEquals(expected,letter);
    }
}
