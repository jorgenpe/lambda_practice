package org.example.models;

import org.example.Sequencers.MeetingSequencer;
import org.example.Sequencers.PersonSequencer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MeetingTest {

    // Declaration of variables during test
    Meeting meeting;
    Person person;
    AppUser appuser;

    //Before each test
    @BeforeEach
    void setUp() {
        appuser= new AppUser(10001, "name", "password");
        person = new Person(PersonSequencer.nextPersonId(), "Olof", "Nilson", "o@hotmail.com", appuser);
        meeting = new Meeting(MeetingSequencer.nextMeetingId(), "Java Singleton",
                LocalDate.of(2021, 5, 5), LocalTime.of(9, 00), LocalTime.of(10, 00), person);

    }

    // The different tests

    @Test
    void addAttendant() {
        meeting.addAttendant(person);

        assertTrue(meeting.getAttendants().contains(person));

    }

    @Test
    void getTopic() {
        String result = meeting.getTopic();
        String expected ="Java Singleton";

        assertEquals(expected, result);

    }

    @Test
    void setTopic() {

        meeting.setTopic("Java");
        String expected ="Java";
        String result = meeting.getTopic();

        assertEquals(expected, result);
    }

    @Test
    void getMeetingDate() {

        LocalDate result = meeting.getMeetingDate();
        LocalDate expected = LocalDate.of(2021, 5, 5) ;

        assertEquals(expected, result);
    }

    @Test
    void setMeetingDate() {

        meeting.setMeetingDate(LocalDate.of(2021, 6, 5));
        LocalDate result = meeting.getMeetingDate();
        LocalDate expected = LocalDate.of(2021, 6, 5) ;

        assertEquals(expected, result);

    }

    @Test
    void getStart() {

        LocalTime result = meeting.getStart();
        LocalTime expected = LocalTime.of(9, 00) ;

        assertEquals(expected, result);
    }

    @Test
    void setStart() {

        meeting.setStart(LocalTime.of(10, 6));
        LocalTime result = meeting.getStart();
        LocalTime expected = LocalTime.of(10, 6) ;

        assertEquals(expected, result);

    }

    @Test
    void getEnd() {

        LocalTime result = meeting.getEnd();
        LocalTime expected = LocalTime.of(10, 00) ;

        assertEquals(expected, result);
    }

    @Test
    void setEnd() {

        meeting.setEnd(LocalTime.of(10, 6));
        LocalTime result = meeting.getEnd();
        LocalTime expected = LocalTime.of(10, 6) ;

        assertEquals(expected, result);
    }

    @Test
    void getOrganizer() {

        Person result = meeting.getOrganizer();
        Person expected = person;

        assertEquals(expected, result);

    }

    @Test
    void setOrganizer() {


        meeting.setOrganizer(person);
        Person result = meeting.getOrganizer();
        Person expected = person;

        assertEquals(expected, result);
    }

    @Test
    void getAttendants() {

        List<Person> testList = new ArrayList<>();
        testList.add(person);
        meeting.setAttendants(testList);
        List<Person> result =meeting.getAttendants();

        assertEquals(testList, result);

    }

    @Test
    void setAttendants() {

        List<Person> testList = new ArrayList<>();
        testList.add(person);
        meeting.setAttendants(testList);
        List<Person> result =meeting.getAttendants();

        assertEquals(testList, result);
    }
}