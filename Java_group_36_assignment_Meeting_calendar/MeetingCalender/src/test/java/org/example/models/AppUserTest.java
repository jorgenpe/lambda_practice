package org.example.models;

import org.example.Sequencers.AppUserSequencer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    // Declaration of variables during test
    AppUser appuser;

    //Before each test
    @BeforeEach
    void setUp() {
        AppUserSequencer.reset();
        appuser = new AppUser(AppUserSequencer.nextAppUserId(), "name", "password");
    }

    // The different tests
    @Test
    void getUsername() {

        String uName = appuser.getUsername();
        String expected = "name";

        assertEquals(expected, uName);
    }

    @Test
    void setUsername() {


        appuser.setUsername("John");
        String uName = appuser.getUsername();
        String expected = "name";

        assertNotEquals(expected, uName);
    }

    @Test
    void getPassword() {
        String password = appuser.getPassword();
        String expected = "password";

        assertEquals(expected, password);
    }

    @Test
    void setPassword() {

        appuser.setPassword("0000");
        String password = appuser.getPassword();
        String expected = "password";

        assertNotEquals(expected, password);
    }
}