package org.example.Services;

import org.example.Sequencers.PersonSequencer;
import org.example.data.AppUserRepository;
import org.example.data.PersonRepository;
import org.example.models.AppUser;
import org.example.models.Person;

import java.util.List;

public class PersonService {



        //Singelton starts.
        private static final PersonService INSTANCE;

        static{
            INSTANCE = new PersonService();
        }

        private final AppUserService appUserService;;
        private final PersonRepository personRepository;

        // Method that you need to initiate a object of singelton
        public static PersonService getInstance(){
        return INSTANCE;
    }

        // Private constructor
        private PersonService(){

            this.appUserService = AppUserService.getInstance();
            this.personRepository = PersonRepository.getInstance();
        }
        // Singelton ends.


        //Public  service methods that do operation with input, if they have any , and return different return types specific to the method.
        public Person create(String userName, String password, String firstName, String lastName, String email){

            int id = PersonSequencer.nextPersonId();

            if(personRepository.findByEmail(email) != null){
                return null;
            }

            AppUser appUserTemp = appUserService.create(userName, password);


            if( appUserTemp != null){

                Person tempPerson =new Person(id, firstName, lastName, email, appUserTemp );

                personRepository.persist(tempPerson);
                return tempPerson;

            }
            return  null;

        }

        public List<Person> findAll(){

           return personRepository.findAll();
        }

        public Person findByEmail(String email){

            return personRepository.findByEmail(email);
        }

        public List<Person> findByFirstName(String  firstname){

            return personRepository.findByFirstName(firstname);
        }

        public Person findById(int id){

            return personRepository.findById(id);
        }

        public List<Person> findByLastName(String lastName){

            return personRepository.findByLastName(lastName);
        }

        public boolean remove(int id){

            return personRepository.remove(id);
        }

        public Person update(int id, String firstName, String lastName, String email){

            if(personRepository.findByEmail(email) != null){
                return null;
            }
            Person personTemp = personRepository.findById(id);
            if(personTemp == null){
                return null;
            }

            personTemp.setFirstName(firstName);
            personTemp.setLastName(lastName);
            personTemp.setEmail(email);

            boolean boolTemp = remove(id);
            if(boolTemp){

                personRepository.persist(personTemp);
                return personTemp;
            }
            return null;

        }

        // Clear method that clears the PersonRepository
        public void clear() {
        personRepository.clear();
    }
}
