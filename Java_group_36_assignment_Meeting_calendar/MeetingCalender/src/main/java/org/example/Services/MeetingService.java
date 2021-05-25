package org.example.Services;

import org.example.Sequencers.MeetingSequencer;
import org.example.data.AppUserRepository;
import org.example.data.MeetingRepository;
import org.example.data.PersonRepository;
import org.example.models.Meeting;
import org.example.models.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MeetingService {

    //Singelton begin
    private static final MeetingService INSTANCE;

    static{
        INSTANCE = new MeetingService();
    }

    private final PersonService personService;
    private final MeetingRepository meetingRepository;

    // Method that you need to initiate a object of singelton
    public static MeetingService getInstance(){
        return INSTANCE;
    }

    private MeetingService(){

        this.personService =  PersonService.getInstance();
        this.meetingRepository = MeetingRepository.getInstance();
    }
    // Singelton ends.

    //Public  service methods that do operation with input, if they have any , and return different return types specific to the method.
    public Meeting addAttendant(int meetingId, int personId){

        Meeting meetingTemp = meetingRepository.findById(meetingId);
        Person personTemp = personService.findById(personId);
        meetingTemp.addAttendant(personTemp);

        return meetingTemp;

    }

    public Meeting create(String topic, LocalDateTime start, LocalDateTime end, String userName ){

        int id = MeetingSequencer.nextMeetingId();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");


       for(int i = 0; i < personService.findAll().size(); i++){

           if (personService.findAll().get(i).getUserCredentials().getUsername().equals(userName)){

                LocalDate date = LocalDate.parse(start.format(dateFormat));
                LocalTime startTime = LocalTime.parse(start.format(timeFormat));
                LocalTime endTime = LocalTime.parse(end.format(timeFormat));
                Person organizerTemp = personService.findAll().get(i);
                Meeting testMeeting =new Meeting(id, topic, date,startTime ,endTime, organizerTemp );
                meetingRepository.persist(testMeeting);
                return  testMeeting;
           }
       }
      return null;

    }

    public Meeting create(String topic, LocalDateTime start, LocalDateTime end, String userName, List<Integer> attendees){

        int id = MeetingSequencer.nextMeetingId();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");
        LocalDate date = LocalDate.parse(start.format(dateFormat));
        LocalTime startTime = LocalTime.parse(start.format(timeFormat));
        LocalTime endTime = LocalTime.parse(end.format(timeFormat));
        Person organizerTemp = null ;
        List<Person> personAttendees = new ArrayList<>();
        Meeting meetingTemp;


        for(int i = 0; i < personService.findAll().size(); i++){

            if (personService.findAll().get(i).getUserCredentials().getUsername().equals(userName)){

                organizerTemp = personService.findAll().get(i);
            }


            for(int j = 0; j < attendees.size(); j++) {

                if (personService.findAll().get(i).getId() == attendees.get(j)) {

                    personAttendees.add(personService.findAll().get(i));
                }
            }




        }
        meetingTemp = new Meeting(id, topic, date,startTime ,endTime, organizerTemp);
        meetingRepository.persist(meetingTemp);
        meetingTemp.setAttendants(personAttendees);
        meetingRepository.findAll().get(meetingRepository.findAll().size()-1).setAttendants(personAttendees);
        return meetingTemp;
    }


    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    public List<Meeting> findByAttendeePersonId(int personId) {
        return meetingRepository.findByAttendeePersonId(personId);
    }

    public Meeting findById(int id) {
        return meetingRepository.findById(id);
    }

    public List<Meeting> findMeetingByDate(LocalDate date) {
        return meetingRepository.findMeetingByDate(date);
    }

    public List<Meeting> finByMeetingsBetween(LocalDateTime start, LocalDateTime end) {
        return meetingRepository.finByMeetingsBetween(start, end);
    }

    public List<Meeting> findByOrganizerPersonId(int id) {
        return meetingRepository.findByOrganizerPersonId(id);
    }

    public List<Meeting> findByTopic(String topic) {
        return meetingRepository.findByTopic(topic);
    }

    public boolean remove(int id) {
        return meetingRepository.remove(id);
    }

    public Meeting removeAttendant(int meetingId, int personId){

        Meeting meetingTemp = meetingRepository.findById(meetingId);
        Person personTemp = personService.findById(personId);

        for (int i = 0; i < meetingTemp.getAttendants().size(); i++) {


            if(meetingTemp.getAttendants().get(i).equals(personTemp)){

                meetingTemp.getAttendants().remove(i);
            }
        }

       return meetingTemp ;

    }

    public Meeting update(int id, String topic, LocalDate date, LocalTime start, LocalTime end){

        Meeting meetingTemp = meetingRepository.findById( id);

        meetingTemp.setTopic(topic);
        meetingTemp.setMeetingDate(date);
        meetingTemp.setStart(start);
        meetingTemp.setEnd(end);

        return meetingTemp;

    }

    // Clear method that clears the MeetingRepository
    public void clear() {
        meetingRepository.clear();
    }
}
