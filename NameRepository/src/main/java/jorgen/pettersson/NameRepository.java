package jorgen.pettersson;
import java.util.Arrays;
public class NameRepository {
    private static String[] nameRepository = new String[0];


        //Programmed by Jörgen Pettersson //


    /**Get size of the array*/
    public static int getSize(){

        return nameRepository.length;
    }

    /** Clear the array of all data*/
    public static void clear(){

     nameRepository = new String[0];

    }

    /** Add a name to Array*/
    public static boolean add(String fullName){
        String[] temp;
        boolean boolTemp = find_Full_Name(fullName);

         if(!boolTemp){

            temp = Arrays.copyOf(nameRepository,getSize() + 1);
            nameRepository = temp;
            nameRepository[getSize() - 1] = fullName;

            return true;

        }

        return false;
    }

    /** Find a full name and return a string*/
    public static String find(final String fullName){
        int index = 0;
        if(getSize() == 0){
            return null;
        }
        while(index < getSize()){

            if(fullName.equalsIgnoreCase(nameRepository[index])){
                return nameRepository[index];
            }
            index++;
        }

        return null;

    }

    /** A private method that find a full name and return a boolean*/
    private static boolean find_Full_Name(String fullName){
        int index = 0;

        if(nameRepository.length == 0){
            return false;
        }

        while(index < nameRepository.length){

            if(fullName.equalsIgnoreCase(nameRepository[index])){
                return true;
            }
            index++;
        }

        return false;
    }

    /** A private method that find a full name and return a int*/
    private static int findFullName(String fullName){
        int index = 0;

        if(nameRepository.length == 0){

            return -1;
        }

        while(index < nameRepository.length){

            if(fullName.equalsIgnoreCase(nameRepository[index])){

                return index;
            }
            index++;
        }

        return -1;
    }


    /** findAll returns a copy of nameRepository array*/
    public static String[] findAll(){

        String [] temp = Arrays.copyOf(nameRepository,getSize() );

        return temp;

    }

    /** Update takes name and updateName and return a boolean*/
    public static boolean update( final String name, final String updateName){

        int index = 0;
        int count =0;

        if(nameRepository.length == 0){

            return false;

        } else if(find_Full_Name(updateName))
        {
            return false;
        }

        while(count < nameRepository.length){

            if(nameRepository[count].equalsIgnoreCase(name) ){

                nameRepository[count] = updateName;

                return true;

            }
            count++;

        }

        index = name.indexOf(name);

        return false;
    }

    /** findByFirstName search for a first name and return a array with the full name*/
    public static String[] findByFirstName(final String firstName){

        int index = 0;

        String [] result = new String[0];
        String [] temp;


        if(nameRepository.length == 0 ){

            return result;

        }


        for(int i = 0; i < nameRepository.length;i++){

            boolean btemp = checkFirstName(firstName, i);

            if(btemp){

                temp = Arrays.copyOf(result,result.length + 1);
                result = temp;
                result[result.length - 1] = nameRepository[i];

            }

        }


        return result;

    }

    /** checkFirstName is a private method that test if first name is in the index place in array. Returns a boolean*/
    private static boolean checkFirstName(String name, int i){

        if(name.equalsIgnoreCase(nameRepository[i].substring(0 , name.length()))){

            return true;

        }

        return false;

    }

    /** findBylastName search for a last name and return a array with the full name*/
    public static String[] findByLastName(final String lastName){

        String [] result = new String[0];
        String [] temp;

        if(nameRepository.length == 0 ){

            return result;

        }

        for(int i = 0; i < nameRepository.length;i++){
            boolean btemp = checkLastName(lastName, i);
            if(btemp){

                temp = Arrays.copyOf(result,result.length + 1);
                result = temp;
                result[result.length - 1] = nameRepository[i];

            }
        }


        return result;

    }

    /** checkFirstName is a privat method that test if last name is in the index place in array. Returns a boolean*/
    private static boolean checkLastName(String lastName, int i) {

        int index = 0;
        index = nameRepository[i].indexOf(" ");

        if(index == -1){
            return false;
        }

        if(lastName.equalsIgnoreCase(nameRepository[i].substring(index+1))){

            return true;

        }
        return false;

    }

    /** remove is a method that removes a name from array. Returns a boolean*/
    public static boolean remove(final String fullName){
        int index = findFullName(fullName);
        String[] temp;

        if(index == -1){

            return false;

        }else if (index == nameRepository.length -1){


            nameRepository = Arrays.copyOf(nameRepository,nameRepository.length -1);

            return true;
        }

        nameRepository[index] = nameRepository[nameRepository.length-1];

         temp = Arrays.copyOf(nameRepository,nameRepository.length -1);
        nameRepository = temp;

        return true;
    }

    /** addArrayString is a method that takes a array and set it to nameRespository*/
    public static void addArrayString(String[] nameArray){
        if(nameRepository.length == 0){

            nameRepository = nameArray;

        }

    }

}
