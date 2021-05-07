package org.example.models;

import java.util.Objects;

public class Person {

    // Object list declaration
    private final  int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser userCredentials;

    // Constructor
    public Person(int Id, String firstname, String lastname, String Email, AppUser usercredentials){

        this.id = Id;
        this.firstName = firstname;
        this.lastName = lastname;
        this.email = Email;
        this.userCredentials = usercredentials;
    }

    // get set methods
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AppUser getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(AppUser userCredentials) {
        this.userCredentials = userCredentials;
    }

    // Override method that override equals
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if( o == null || getClass() != o.getClass()){

            return false;
        }
        Person person = (Person) o;

        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName )&&
                Objects.equals(email, person.email);

    }

    // Creates a hashcode integer that are used in comparing in equals
    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
