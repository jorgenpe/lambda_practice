package org.example.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Meeting {

    // Object list declaration
    private final int id;
    private String topic;
    private LocalDate meetingDate;
    private LocalTime start;
    private LocalTime end;
    private Person organizer;
    private List<Person> attendants;

    // Constructor
    public Meeting(int Id, String Topic, LocalDate MeetingDate, LocalTime Start, LocalTime End, Person Organizer ){

        this.id = Id;
        this.topic = Topic;
        this.meetingDate = MeetingDate;
        this.start = Start;
        this.end = End;
        this.organizer = Organizer;
    }

    // method that adds a person to the list attendants in the specific meeting
    public void addAttendant(Person aPerson){
        boolean temp = false;
        if(attendants == null){
            attendants = new ArrayList<>();
        }

        if(aPerson != null){

            for(int i = 0; i < attendants.size(); i++){

                if(aPerson.equals(attendants.get(i))){

                    temp = true;
                }

            }

            if(!temp){
                attendants.add(aPerson);
            }

        }
    }

    // get set methods
    public  int getId() {

        return id;
    }

    public String getTopic() {

        return topic;
    }

    public void setTopic(String topic) {

        this.topic = topic;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Person getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Person organizer) {
        this.organizer = organizer;
    }

    public List<Person> getAttendants() {
        return attendants;
    }

    public void setAttendants(List<Person> attendants) {
        this.attendants = attendants;
    }

    // Override method that override equals
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if( o == null || getClass() != o.getClass()){

            return false;
        }
            Meeting meeting = (Meeting) o;

            return Objects.equals(id, meeting.id) && Objects.equals(topic, meeting.topic) && Objects.equals(meetingDate, meeting.meetingDate) &&
                    Objects.equals(start, meeting.start) && Objects.equals(end, meeting.end);


    }

    // Creates a hashcode integer that are used in comparing in equals
    @Override
    public int hashCode() {
        return Objects.hash(id, topic, meetingDate, start, end);
    }
}
