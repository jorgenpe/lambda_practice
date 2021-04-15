import java.util.Scanner;

public class TimeConvert {

    public static void main(String[] args){
        /*Variables*/
        Scanner in = new Scanner(System.in);
        int hour;
        int minute;
        int seconds;
        int time;

        /*Printout and input*/
        System.out.println(" State seconds to be converted: ");
        time = Integer.parseInt(in.nextLine());

        /*Calculations*/
        hour = time/3600;
        time = time%3600;
        minute = time/60;
        seconds = time%60;

        /*Final printout*/
        System.out.println(" Seconds converted to : " + hour +":" + minute + ":" + seconds);


    }
}
