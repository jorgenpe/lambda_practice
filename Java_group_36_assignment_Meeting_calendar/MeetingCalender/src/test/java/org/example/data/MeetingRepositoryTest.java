package org.example.data;

import org.example.Sequencers.AppUserSequencer;
import org.example.Sequencers.MeetingSequencer;
import org.example.Sequencers.PersonSequencer;
import org.example.models.AppUser;
import org.example.models.Meeting;
import org.example.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRepositoryTest {

    // Declaration of objects during test
    private MeetingRepository testMeetingRepository;


    // Test input methods that creates the input used in the tests.
    public List<Meeting> getMeeting(){

        MeetingSequencer.reset();
        int id = MeetingSequencer.nextMeetingId();
        int id2 = MeetingSequencer.nextMeetingId();
        int id3 = MeetingSequencer.nextMeetingId();


        return Arrays.asList(


                new Meeting(id, "Java", LocalDate.of(2021,5 , 5), LocalTime.of(9,00),
                        LocalTime.of(10,00),getPerson().get(2) ),

                new Meeting(id2, "Testing Java", LocalDate.of(2021,5 , 5), LocalTime.of(10,00)
                        ,LocalTime.of(11,00), getPerson().get(1)),

                new Meeting(id3, "Java", LocalDate.of(2021,5 , 10), LocalTime.of(9,30),
                        LocalTime.of(14,00), getPerson().get(2))

        );


    }


    public List<Person> getPerson(){

        PersonSequencer.reset();
        int id = PersonSequencer.nextPersonId();
        int id2 = PersonSequencer.nextPersonId();
        int id3 = PersonSequencer.nextPersonId();

        return Arrays.asList(


                new Person(id, "Name", "lastname", "e@hotmail.com", getAppUsers().get(0) ),
                new Person(id2, "Olof", "Svensson", "a@hotmail.com", getAppUsers().get(1)),
                new Person(id3, "Nisse", "Svensson", "n@hotmail.com", getAppUsers().get(2))

        );


    }


    public List<AppUser> getAppUsers(){

        AppUserSequencer.reset();
        int id = AppUserSequencer.nextAppUserId();
        int id2 = AppUserSequencer.nextAppUserId();
        int id3 = AppUserSequencer.nextAppUserId();

        return Arrays.asList(


                new AppUser(id, "Name", "password"),
                new AppUser(id2, "Olof", "67Noll"),
                new AppUser(id3, "Nisse", "llo97")

        );
    }

    //Before each test
    @BeforeEach
    void setUp() {

        MeetingSequencer.reset();
        PersonSequencer.reset();
        AppUserSequencer.reset();
        testMeetingRepository =  MeetingRepository.getInstance();
        testMeetingRepository.clear();

        for(int i = 0; i < getPerson().size(); i++){

            testMeetingRepository.persist(getMeeting().get(i));
        }

    }

    @Test
    void persist() {

        int id4 = AppUserSequencer.nextAppUserId();
        int id5 = PersonSequencer.nextPersonId();
        int id6 = MeetingSequencer.nextMeetingId();

        AppUser testAppUser = new AppUser(id4, "Adam", "llo98");
        Person testPerson = new Person(id5, "Name", "lastname", "e@hotmail.com", testAppUser );
        Meeting testMeeting = new Meeting(id6, "Archaeological dig", LocalDate.of(2021, 5, 5),LocalTime.of(13, 00),
                LocalTime.of(13, 00), testPerson);

        Meeting result = testMeetingRepository.persist(testMeeting);
        int expected = 4;

        assertEquals(expected, testMeetingRepository.findAll().size());

    }

    @Test
    void findAll() {

        int expected = 3;
        assertEquals(expected, testMeetingRepository.findAll().size());
    }

    @Test
    void findByAttendeePersonId() {

        testMeetingRepository.findAll().get(0).setAttendants(getPerson());

        int  expected = 1;
        List<Meeting> result = testMeetingRepository.findByAttendeePersonId(20001);

        assertEquals(expected,result.size());
    }

    @Test
    void findById() {

        Meeting expected = testMeetingRepository.findAll().get(1);

        Meeting result = testMeetingRepository.findById(30002);
        assertSame(expected, result);
    }

    @Test
    void findMeetingByDate() {

        List<Meeting> result = testMeetingRepository.findMeetingByDate(LocalDate.of(2021,5,5));
        int expected = 2;

        assertEquals(expected, result.size());
    }

    @Test
    void finByMeetingsBetween() {

        LocalDateTime start = LocalDateTime.of(2021,5,5,9, 00);
        LocalDateTime end = LocalDateTime.of(2021,5,5, 11, 00);

        List<Meeting> result = testMeetingRepository.finByMeetingsBetween(start, end);
        int expected = 2;

        assertEquals(expected, result.size());
    }

    @Test
    void findByOrganizerPersonId() {


        int  expected = 2;
        List<Meeting> result = testMeetingRepository.findByOrganizerPersonId(20003);

        assertEquals(expected,result.size());


    }

    @Test
    void findByTopic() {

        List<Meeting> result = testMeetingRepository.findByTopic("Java");
        int expected = 2;

        assertEquals(expected, result.size());

    }

    @Test
    void getMeetingCount() {

        int result = testMeetingRepository.getMeetingCount();
        int expected = testMeetingRepository.findAll().size();

        assertEquals(expected, result);

    }

    @Test
    void remove() {


        testMeetingRepository.remove(30001);
        Meeting result = testMeetingRepository.findById(30001);


        assertEquals(null, result);
    }
}