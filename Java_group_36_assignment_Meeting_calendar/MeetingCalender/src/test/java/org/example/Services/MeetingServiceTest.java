package org.example.Services;

import org.example.Sequencers.AppUserSequencer;
import org.example.Sequencers.MeetingSequencer;
import org.example.Sequencers.PersonSequencer;
import org.example.data.AppUserRepository;
import org.example.data.MeetingRepository;
import org.example.data.PersonRepository;
import org.example.models.AppUser;
import org.example.models.Meeting;
import org.example.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingServiceTest {

    // Declaration of objects during test
    private AppUserService testAppUserService;
    private PersonRepository testPersonRepository;
    private PersonService testPersonService;
    private AppUserRepository testAppUserRepository;
    private MeetingService testMeetingService;
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

        PersonSequencer.reset();
        AppUserSequencer.reset();

        testPersonService = PersonService.getInstance();
        testPersonRepository =  PersonRepository.getInstance();
        testAppUserService = AppUserService.getInstance();
        testAppUserRepository = AppUserRepository.getInstance();
        testMeetingService = MeetingService.getInstance();
        testMeetingRepository =  MeetingRepository.getInstance();

        testAppUserRepository.clear();
        testAppUserService.clear();
        testPersonService.clear();
        testPersonRepository.clear();
        testMeetingService.clear();
        testMeetingRepository.clear();

        for(int i = 0; i < getPerson().size(); i++){

            testMeetingRepository.persist(getMeeting().get(i));
        }

        for(int i = 0; i < getPerson().size(); i++){

            testPersonRepository.persist(getPerson().get(i));
        }




        for(int i = 0; i < getAppUsers().size(); i++){

            testAppUserRepository.persist(getAppUsers().get(i));
        }

    }

    // The different tests
    @Test
    void addAttendant() {

        Meeting testMeeting = testMeetingService.addAttendant(30001, 20002);
        Meeting expected = testMeetingService.findById(30001);

        assertEquals(testMeeting,expected);
    }

    @Test
    void create() {

    Meeting testMeeting = testMeetingService.create("Archaeological dig", LocalDateTime.of(2021, 5, 5,13, 00)
            ,LocalDateTime.of(2120,5,5,13, 00),"Olof");

    int expected =  30004;

    assertEquals(expected,testMeeting.getId());

    }

    @Test
    void testCreate() {

        List<Integer> testPersonId = new ArrayList<>();
        testPersonId.add(20001);
        testPersonId.add(20003);

        Meeting testMeeting = testMeetingService.create("Archaeological dig", LocalDateTime.of(2021, 5, 5,13, 00)
                ,LocalDateTime.of(2120,5,5,13, 00),"Olof", testPersonId);

        String expected = "Nisse";

        assertEquals(expected,testMeeting.getAttendants().get(1).getFirstName());



    }

    @Test
    void removeAttendant() {
        List<Integer> testPersonId = new ArrayList<>();
        testPersonId.add(20001);
        testPersonId.add(20003);
        testPersonId.add(20002);

        Meeting tempMeeting = testMeetingService.create("Archaeological dig", LocalDateTime.of(2021, 5, 5,13, 00)
                ,LocalDateTime.of(2120,5,5,13, 00),"Olof");

        testMeetingRepository.persist(tempMeeting);
        Meeting temp = testMeetingService.create("Archaeological dig", LocalDateTime.of(2021, 5, 5,13, 00)
                ,LocalDateTime.of(2120,5,5,13, 00),"Olof", testPersonId);
        testMeetingRepository.findAll().get(3).setAttendants(temp.getAttendants());

        Meeting meeting = testMeetingService.removeAttendant(30004,20003);
        int result = testMeetingRepository.findById(30004).getAttendants().size();
        int expected = 2;

        assertEquals(expected, result);

    }

    @Test
    void update() {

    String notExpected = testMeetingService.findById(30002).getTopic();

    Meeting testMeeting = testMeetingService.update(30002, "Fish" ,LocalDate.of(2021,5,6),LocalTime.of(14,00),
            LocalTime.of(15,30));

    assertNotEquals(notExpected,testMeeting.getTopic());


    }
}