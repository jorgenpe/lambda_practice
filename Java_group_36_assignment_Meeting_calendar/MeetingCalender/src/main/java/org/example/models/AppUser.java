package org.example.models;

import java.util.Objects;

public class AppUser {

    // Object list declaration
    private  final int id ;
    private String username;
    private String password;

    //Constructor
    public AppUser(int appId, String useName, String passWord){

        this.id = appId;
        this.username = useName;
        this.password = passWord;
    }

    // get set methods
    public  int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // Override method that override equals
    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if( o == null || getClass() != o.getClass()){

            return false;
        }
        AppUser appUser = (AppUser) o;

        return Objects.equals(id, appUser.id) && Objects.equals(username, appUser.username) && Objects.equals(password, appUser.password );

    }

    // Creates a hashcode integer that are used in comparing in equals
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
