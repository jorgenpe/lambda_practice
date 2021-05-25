package org.example.Services;

import org.example.Sequencers.AppUserSequencer;
import org.example.data.AppUserRepository;
import org.example.models.AppUser;

import java.util.ArrayList;
import java.util.List;

public class AppUserService {

    private static final AppUserService INSTANCE;

    static{
        INSTANCE = new AppUserService();
    }

    private final AppUserRepository appUserRepository;

    // Method that you need to initiate a object of singelton
    public static AppUserService getInstance(){
        return INSTANCE;
    }

    // Private constructor.
    private AppUserService(){
        this.appUserRepository = AppUserRepository.getInstance();
    }


    //Public  service methods that do operation with input, if they have any , and return different return types specific to the method.
    public AppUser create(String useName, String password){

         int id = AppUserSequencer.nextAppUserId();
         if(appUserRepository.findByUsername(useName).getUsername().equals(useName)){

             return null;

         }


         AppUser appUserTemp = new AppUser(id, useName, password);
         appUserRepository.persist(appUserTemp);
        return appUserTemp;
    }

    public List<AppUser>  findAll(){

        return appUserRepository.findAll();
    }

    public AppUser persist(AppUser appUser) {
        return appUserRepository.persist(appUser);
    }

    public AppUser findById(int id) {
        return appUserRepository.findById(id);
    }

    public AppUser findByUsername(String userName) {
        return appUserRepository.findByUsername(userName);
    }

    public int getAppUserCount() {
        return appUserRepository.getAppUserCount();
    }

    public boolean remove(int id) {
        return appUserRepository.remove(id);
    }




    public AppUser update(int id, String userName, String password){

        AppUser appUserTemp = findById(id);

        if(appUserTemp != null){

            if(appUserTemp.getUsername().equals(userName)){
                return null;
            }

            appUserTemp = new AppUser(id, userName, password);

            boolean boolTemp = remove(id);
            appUserRepository.persist(appUserTemp);

            return appUserTemp;
        }
       return null;
    }

    // Clear method that clears the AppUserRepository
    public void clear() {
        appUserRepository.clear();
    }
}
