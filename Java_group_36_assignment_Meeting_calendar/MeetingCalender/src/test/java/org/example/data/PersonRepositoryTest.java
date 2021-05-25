package org.example.data;

import org.example.Sequencers.AppUserSequencer;
import org.example.Sequencers.PersonSequencer;
import org.example.models.AppUser;
import org.example.models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonRepositoryTest {

    // Declaration of variables during test
    private PersonRepository testPersonRepository;

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

        testPersonRepository =  PersonRepository.getInstance();
        testPersonRepository.clear();

        for(int i = 0; i < getPerson().size(); i++){

            testPersonRepository.persist(getPerson().get(i));
        }

    }

    // The different tests
    @Test
    void persist() {

        int id4 = AppUserSequencer.nextAppUserId();
        int id5 = PersonSequencer.nextPersonId();

        AppUser testAppUser = new AppUser(id4, "Adam", "llo98");
        Person testPerson = new Person(id5, "Name", "lastname", "e@hotmail.com", testAppUser );

        Person result = testPersonRepository.persist(testPerson);
        int expected = 4;

        assertEquals(expected, testPersonRepository.findAll().size());

    }

    @Test
    void findAll() {

        int expected = 3;

        assertEquals(expected,testPersonRepository.findAll().size());


    }

    @Test
    void findByEmail() {


        Person result = testPersonRepository.findByEmail("e@hotmail.com");
        Person expected = testPersonRepository.findAll().get(0);

        assertEquals(expected, result);
    }

    @Test
    void findByFirstName() {

        List<Person> result = testPersonRepository.findByFirstName("Olof");
        int expected = 1;

        assertEquals(expected, result.size());
    }

    @Test
    void findByLastName() {

        List<Person> result = testPersonRepository.findByFirstName("Olof");
        int expected = 1;

        assertEquals(expected, result.size());
    }
    @Test
    void findByUsername() {

        List<Person> result = testPersonRepository.findByLastName("Svensson");
        int expected = 2;

        assertEquals(expected, result.size());
    }
    @Test
    void findById() {

        Person expected = testPersonRepository.findAll().get(1);


        Person result = testPersonRepository.findById(20002);
        assertSame(expected, result);
    }



    @Test
    void getPeopleCount() {

        int result = testPersonRepository.getPeopleCount();
        int expected = testPersonRepository.findAll().size();

        assertEquals(expected, result);

    }

    @Test
    void remove() {


        testPersonRepository.remove(20002);
        Person result = testPersonRepository.findById(20002);


        assertEquals(null, result);
    }
}