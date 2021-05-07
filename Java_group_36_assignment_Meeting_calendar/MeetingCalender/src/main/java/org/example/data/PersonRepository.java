package org.example.data;

import org.example.Sequencers.PersonSequencer;
import org.example.models.AppUser;
import org.example.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonRepository {

    // Singelton start
    private static final PersonRepository INSTANCE;

    static{
        INSTANCE = new PersonRepository();
    }

    private final List<Person> personStorage;

    // Method that you need to initiate a object of singelton.
    public static PersonRepository getInstance(){
        return INSTANCE;
    }

    // privat constructor
    private PersonRepository(){
        this.personStorage = new ArrayList<>();
    }
    //Singelton ends

    // Method where you add person objects to PersonRepository
    public Person persist(Person person){

        if(!personStorage.contains(person)){

            personStorage.add(person);
        }
        return person;
    }

    public List<Person> findAll(){

        return new ArrayList<>(personStorage);
    }

    public Person findByEmail(String email){

        for (Person person : personStorage) {

            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    //Public methods that do operation with input, if they have any , and return different return types specific to the method.
    public List<Person> findByFirstName(String firstName){

        List<Person> tempPerson= new ArrayList<>();

        for (Person person : personStorage) {

            if (person.getFirstName().equals(firstName)) {

                tempPerson.add(person);
            }
        }

        return tempPerson;

    }

    public List<Person> findByLastName(String lastName){

        List<Person> tempPerson= new ArrayList<>();

        for (Person person : personStorage) {

            if (person.getLastName().equals(lastName)) {

                tempPerson.add(person);
            }
        }

        return tempPerson;

    }

    public Person findById(int id){

        for (Person person : personStorage) {

            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public Person findByUsername(String userName){

        for (Person person : personStorage) {

            if (person.getUserCredentials().getUsername().equals(userName)) {

                return person;
            }
        }
        return null;
    }

    public int getPeopleCount(){

        return personStorage.size();
    }

    public boolean remove(int id){


        for(int i = 0; i < personStorage.size(); i++){

            if(personStorage.get(i).getId() == (id)){

                personStorage.remove(personStorage.get(i));
                return true;
            }
        }
        return false;
    }

    // Method that clears the PersonRepository
    public void clear(){

        personStorage.clear();

    }

}
