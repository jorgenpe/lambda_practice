package org.example.data;


import org.example.models.Meeting;
import org.example.models.Person;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MeetingRepository {

    //Singelton start
    private static final MeetingRepository INSTANCE;

    static{
        INSTANCE = new MeetingRepository();
    }

    private final List<Meeting> meetingStorage;

    // Method that you need to initiate a object of singelton
    public static MeetingRepository getInstance(){
        return INSTANCE;
    }

    // Private constructor
    private MeetingRepository(){

        this.meetingStorage = new ArrayList<>();
    }
    // Singelton ends

    // Method where you add person objects to MeetingRepository
    public Meeting persist(Meeting meeting){

        if(!meetingStorage.contains(meeting)){

            meetingStorage.add(meeting);
        }

        return meeting;
    }


    //Public methods that do operation with input, if they have any , and return different return types specific to the method.
    public List<Meeting> findAll(){

        return new ArrayList<>(meetingStorage);
    }

    public List<Meeting> findByAttendeePersonId(int personId){

        List<Meeting> temp = new ArrayList<>();

        for(int i = 0; i < meetingStorage.size(); i++){

            if((meetingStorage.get(i).getAttendants()) != null){

                for(int j = 0; j < meetingStorage.get(i).getAttendants().size(); j++){

                    int intTemp = meetingStorage.get(i).getAttendants().get(j).getId();
                    if( intTemp == personId){

                        temp.add(meetingStorage.get(i));
                    }
                }

            }

        }
        return temp;

    }


    public Meeting findById(int id){

        int temp;

        for (int i = 0; i< meetingStorage.size(); i++) {

            temp = meetingStorage.get(i).getId();

            if (temp == id) {

                return meetingStorage.get(i);
            }
        }
        return null;
    }

    public List<Meeting> findMeetingByDate(LocalDate date){

        List<Meeting> temp = new ArrayList<>();

        for (int i = 0; i< meetingStorage.size(); i++){

            if(meetingStorage.get(i).getMeetingDate().equals(date)){


                  temp.add(meetingStorage.get(i));
            }
        }
        return temp;
    }

    public List<Meeting> finByMeetingsBetween(LocalDateTime start, LocalDateTime end){

        List<Meeting> meetingTemp = new ArrayList<>();
        DateTimeFormatter dateTemp = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeTemp = DateTimeFormatter.ofPattern("HH:mm");


        for (Meeting meeting : meetingStorage) {

            int tempStart = LocalTime.parse(start.format(timeTemp)).toSecondOfDay();
            int tempEnd = LocalTime.parse(end.format(timeTemp)).toSecondOfDay();
            int tempMeetingStart = LocalTime.parse(meeting.getStart().format(timeTemp)).toSecondOfDay();
            int tempMeetingEnd = LocalTime.parse(meeting.getEnd().format(timeTemp)).toSecondOfDay();

            if (meeting.getMeetingDate().equals(LocalDate.parse(start.format(dateTemp))) && tempStart <= tempMeetingStart && tempEnd >= tempMeetingEnd){

                meetingTemp.add(meeting);
            }

        }
        return meetingTemp;

    }

    public List<Meeting> findByOrganizerPersonId(int id){

        List<Meeting> meetingTemp = new ArrayList<>();

        for(int i = 0; i < meetingStorage.size(); i++){


            int intTemp = meetingStorage.get(i).getOrganizer().getId();

            if(intTemp == id){

                meetingTemp.add(meetingStorage.get(i));
            }
        }
        return meetingTemp;
    }

    public List<Meeting> findByTopic(String topic){

        List<Meeting> meetingTemp = new ArrayList<>();

        for(int i = 0; i < meetingStorage.size(); i++){


            if(meetingStorage.get(i).getTopic().trim().equals(topic.trim())){

                meetingTemp.add(meetingStorage.get(i));
            }
        }
        return meetingTemp;
    }


    public int getMeetingCount(){

        return meetingStorage.size();
    }

    public boolean remove(int id){

        for(int i = 0; i < meetingStorage.size(); i++){

            int intTemp = meetingStorage.get(i).getId();
            if(intTemp == id){

                meetingStorage.remove(meetingStorage.get(i));
                return true;
            }
        }
        return false;
    }

    // Method that clears the MeetingRepository
    public void clear(){
        meetingStorage.clear();
    }

}
