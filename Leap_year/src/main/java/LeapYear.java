import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args)
    {
        leapYear();

    }
    /*Method for printout and input to leap year*/
    public static void leapYear(){
        int leapyear;
        boolean test;
        Scanner in = new Scanner(System.in);


        System.out.println("Stat the year you want to examen for leap year: ");
        leapyear = Integer.parseInt(in.nextLine());
        test = leapCal(leapyear);
        if( test ){
            System.out.println(" The year is a leap year!");
        }else{
            System.out.println(" The year is not a leap year!");
        }
    }
    /*Calculation of leap year and return a boolean*/
    public static boolean leapCal(int leap){

        if (leap%400 == 0){
            return true;
        }else if(leap%100 == 0){

            return false;

        }else if(leap%4 == 0){
            return true;
        }

        return false;
    }
}
