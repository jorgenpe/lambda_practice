package org.example.data;

import org.example.Sequencers.AppUserSequencer;
import org.example.Sequencers.PersonSequencer;
import org.example.models.AppUser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppUserRepositoryTest {

    // Declaration of objects during test
    private AppUserRepository testAppUseRepository;


    // Test input methods that creates the input used in the tests.
    public List<AppUser> getAppUsers(){

        AppUserSequencer.reset();
        final int id = AppUserSequencer.nextAppUserId();
        final int id2 = AppUserSequencer.nextAppUserId();
        final int id3 = AppUserSequencer.nextAppUserId();

        return Arrays.asList(


                new AppUser(id, "Name", "password"),
                new AppUser(id2, "Olof", "67Noll"),
                new AppUser(id3, "Nisse", "llo97")

        );
    }

    //Before each test
    @BeforeEach
    void setUp() {
        AppUserSequencer.reset();
        testAppUseRepository = AppUserRepository.getInstance();
        testAppUseRepository.clear();

        for(int i = 0; i < getAppUsers().size(); i++){

            testAppUseRepository.persist(getAppUsers().get(i));
        }

    }

    // The different tests
    @Test
    void persist() {

        int id4 = AppUserSequencer.nextAppUserId();
        AppUser testObject = new AppUser(id4, "Jan", "l9lo7");

        int expected = 4;

        AppUser result = testAppUseRepository.persist(testObject);

        assertEquals(expected,testAppUseRepository.findAll().size());


    }

    @Test
    void findAll() {

        int expected = 3;

        assertEquals(expected,testAppUseRepository.findAll().size());

    }

    @Test
    void findById() {

        AppUser expected = testAppUseRepository.findAll().get(1);
        AppUser result = testAppUseRepository.findById(10002);


        assertSame(expected, result);

    }

    @Test
    void findByUsername() {

        AppUser result = testAppUseRepository.findByUsername("Olof");
        AppUser expected = testAppUseRepository.findAll().get(1);

        assertEquals(expected, result);


    }

    @Test
    void getAppUserCount() {

        int result = testAppUseRepository.getAppUserCount();
        int expected = 3;

        assertEquals(expected, result);
    }

    @Test
    void remove() {
        testAppUseRepository.remove(10001);
        AppUser result = testAppUseRepository.findById(10001);


        assertEquals(null, result);
    }
}