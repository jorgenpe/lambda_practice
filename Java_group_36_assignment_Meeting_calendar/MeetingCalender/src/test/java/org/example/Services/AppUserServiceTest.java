package org.example.Services;

import org.example.Sequencers.AppUserSequencer;
import org.example.Sequencers.MeetingSequencer;
import org.example.Sequencers.PersonSequencer;
import org.example.data.AppUserRepository;
import org.example.data.MeetingRepository;
import org.example.models.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppUserServiceTest {

    // Declaration of objects during test
    private AppUserRepository testAppUserRepository;
    private AppUserService testAppUserService;

    // Test input methods that creates the input used in the tests.
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


        AppUserSequencer.reset();
        testAppUserService = AppUserService.getInstance();
        testAppUserRepository = AppUserRepository.getInstance();
        testAppUserRepository.clear();
        testAppUserService.clear();

        for(int i = 0; i < getAppUsers().size(); i++){

            testAppUserRepository.persist(getAppUsers().get(i));
        }


    }

    // The different tests
    @Test
    void testCreate() {

        AppUser testAppUser = testAppUserService.create("Nisse", "12de");

        assertEquals(null, testAppUser);

    }

    @Test
    void testUpdate() {

        AppUser testAppUser = testAppUserService.update(10001, "Adam", "98gf");
        AppUser expected = testAppUserService.findById(10001);
        assertEquals(testAppUser, expected);
    }
}