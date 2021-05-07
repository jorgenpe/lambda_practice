package org.example.models;


import org.example.Sequencers.PersonSequencer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    // Declaration of variables during test
    Person person;
    Person personTwo;

    //Before each test
    @BeforeEach
    void setUp() {
        PersonSequencer.reset();

        AppUser appuser= new AppUser(10001, "name", "password");
        person = new Person(PersonSequencer.nextPersonId(), "Olof", "Nilson", "o@hotmail.com", appuser);
        personTwo = new Person(PersonSequencer.nextPersonId(), "Anders", "Svenson", "s@hotmail.com", appuser);

    }

    // The different tests
    @Test
    void getId() {

        int Id = person.getId();

        int expected = 20001;
        assertEquals(expected, Id);
    }

    @Test
    void getIdTwo() {

        int Id = personTwo.getId();

        int expected = 20002;
        assertEquals(expected, Id);
    }


    @Test
    void getFirstName() {

        String firstname = person.getFirstName();
        String expected = "Nilson";

        assertNotEquals(expected, firstname);
    }

    @Test
    void setFirstName() {

        person.setFirstName("Sven");
        String firstname = person.getFirstName();
        String expected = "Nilson";

        assertNotEquals(expected, firstname);
    }

    @Test
    void getLastName() {

        String lastname = person.getLastName();
        String expected = "Nilson";

        assertEquals(expected, lastname);
    }

    @Test
    void setLastName() {

        person.setLastName("Sven");
        String lastname = person.getLastName();
        String expected = "Nilson";

        assertNotEquals(expected, lastname);
    }

    @Test
    void getEmail() {


        String email = person.getEmail();
        String expected = "Nilson@hotmail.com";

        assertNotEquals(expected, email);
    }

    @Test
    void setEmail() {
        person.setEmail("Sven@hotmail.com");
        String email = person.getEmail();
        String expected = "Nilson@hotmail.com";

        assertNotEquals(expected, email);
    }

    @Test
    void getUserCredentials() {

        AppUser expected =  new AppUser(10002, "Sven", "password");
        person.setUserCredentials(expected);
        AppUser appuser = person.getUserCredentials();


        assertEquals(appuser,expected);

    }

    @Test
    void setUserCredentials() {
        AppUser expected =  new AppUser(10002, "Sven", "password");
        person.setUserCredentials(expected);
        AppUser appuser = person.getUserCredentials();

        assertEquals(appuser,expected);
    }
}