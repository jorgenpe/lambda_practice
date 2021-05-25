package org.example.Sequencers;

public class AppUserSequencer {

    private static int appUserId = 10000;

    public static int nextAppUserId(){

        return ++appUserId;
    }

    public static void reset(){

        appUserId = 10000;
    }


}
