package org.example.data;


import org.example.models.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserRepository {

    //Singelton starts.
    private static final AppUserRepository INSTANCE;

    static{
        INSTANCE = new AppUserRepository();
    }

    private final List<AppUser> appUserStorage;

    // Method that you need to initiate a object of singelton
    public static AppUserRepository getInstance(){
        return INSTANCE;
    }

    // Private constructor
    private AppUserRepository(){
        this.appUserStorage = new ArrayList<>();
    }
    // Singelton ends

    // Method where you add person objects to AppUserRepository
    public AppUser persist(AppUser appUser){

        if(!appUserStorage.contains(appUser))
        {

            appUserStorage.add(appUser);
        }

        return appUser;
    }

    //Public methods that do operation with input, if they have any , and return different return types specific to the method.
    public List<AppUser>  findAll(){

        return new ArrayList<>(appUserStorage);
    }

    public AppUser findById(int id){

        for(int i = 0; i < appUserStorage.size(); i++){

            int tempId = appUserStorage.get(i).getId();

            if(tempId == id){

                return appUserStorage.get(i);
            }
        }
        return null;
    }

    public AppUser findByUsername(String userName){

        for(int i = 0; i < appUserStorage.size(); i++){

            if(appUserStorage.get(i).getUsername().equals(userName)){

                return appUserStorage.get(i);
            }
        }
        return null;
    }

    public int getAppUserCount(){

        return appUserStorage.size();
    }

    public boolean remove(int id){

        for(int i = 0; i < appUserStorage.size(); i++){

            if(appUserStorage.get(i).getId() == (id)){

                appUserStorage.remove(appUserStorage.get(i));
                return true;
            }
        }
        return false;

    }

    // Method that clears the AppUserRepository
    public void clear(){

        appUserStorage.clear();

    }



}
