package org.example.Sequencers;

public class PersonSequencer {


    private static int personId = 20000;

    public static int nextPersonId(){

        return ++personId;
    }

    public static void reset(){

        personId = 20000;
    }
}
