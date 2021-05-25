package org.example.Services;

import org.example.Sequencers.AppUserSequencer;
import org.example.Sequencers.PersonSequencer;
import org.example.data.AppUserRepository;
import org.example.data.PersonRepository;
import org.example.models.AppUser;
import org.example.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    // Declaration of objects during test
    private AppUserService testAppUserService;
    private PersonRepository testPersonRepository;
    private PersonService testPersonService;
    private AppUserRepository testAppUserRepository;

    // Test input methods that creates the input used in the tests.
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

        testAppUserRepository.clear();
        testAppUserService.clear();
        testPersonService.clear();
        testPersonRepository.clear();

        for(int i = 0; i < getPerson().size(); i++){

            testPersonRepository.persist(getPerson().get(i));
        }

        for(int i = 0; i < getAppUsers().size(); i++){

            testAppUserRepository.persist(getAppUsers().get(i));
        }

    }

    // The different tests
    @Test
    void create() {

        Person testPerson = testPersonService.create("Nisse", "12kl", " Nisse", "Svensson", "w@hotmail.com");

        assertEquals(null,testPerson );

    }

    @Test
    void update() {

        Person testPerson = testPersonService.update(20001, "Gunnar", "Karlson", "d@hotmail.com");
        Person expected = testPersonService.findById(20001);

        assertEquals(expected,testPerson);
    }
}