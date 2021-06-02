package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        IO ioTest = new IO();
        String in = "If this works, then I'm bloody happy with my self!";

        ioTest.createTextFile(in);
        File source = new File("source/testText.txt");

        String test = ioTest.fileReaderFile(source);

        System.out.println(test);

        List<String> name = new ArrayList<>();

        name.add("Olle");
        name.add("Lisa");
        name.add("Anna");
        name.add("Anders");
        name.add("Ann");
        name.add("Nils");
        name.add("Johan");
        name.add("Susan");
        name.add("Mia");
        name.add("Erik");
        name.add("Nova");

        ioTest.createTextLineFile(name);

    }
}
