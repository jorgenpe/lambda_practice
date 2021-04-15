import java.util.Scanner;

public class Username {

    public static void main(String[] args){
        /*input output*/
        Scanner in = new Scanner(System.in);
        String user;

        System.out.println("State your name:");

        user = in.nextLine();

        System.out.println("\n Hello! \n " + user );


    }
}
