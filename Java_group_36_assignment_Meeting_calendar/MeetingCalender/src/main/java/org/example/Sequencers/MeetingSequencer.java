package org.example.Sequencers;

public class MeetingSequencer {

    private static int meetingId = 30000;

    public static int nextMeetingId(){
        ;
        return ++meetingId;
    }

    public static void reset(){

        meetingId= 30000;
    }
}
