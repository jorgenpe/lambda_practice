import java.util.Random;
import java.util.Scanner;

public class RandomNumber {

    public static void main(String[] args)
    {
        // programed by Jörgen Pettersson//



        int Val ;
        int choice = 0;

        Scanner in = new Scanner(System.in);
        Random slump = new Random();

        /* call to method  menu */
        choice = menu();
        /* While loop that handles menu with switch and case.  */
        while (choice !=2)
        {
            switch (choice)
            {

                case 1: {
                    /* Generate a number between 1 and 500.*/
                    System.out.println("\n Geuss a number (1 - 500): ");
                    Val = (int) (slump.nextFloat()*500+1);
                    /*Call method HogLag.*/
                    HogLag(Val,in);
                }
                break;


            }

            choice = menu();
        }
    }

    static int menu()
    {
        Scanner in = new Scanner(System.in);

        System.out.println ("\n 1. guess numbers ");

        System.out.println ("\n 2. Quit\n");

        return in.nextInt();

    }

    /* Method of typ void, where the guesses are made in a  for-loop. The if statement try the conditions and
     a printout is made. In each loop a new guess is made.

     */
    static void HogLag(int SlumpTal, Scanner in)
    {
        int Heltal;

        for (int i = 0; i < 500; i++)
        {
            System.out.print("Guess " + (i+1) +":");
            Heltal = in.nextInt();
            if (SlumpTal == Heltal)
            {
                System.out.println("\n  Right answer in only "+ (i+1) + " guesses - great!");
                break;
            }
            else if (Heltal < SlumpTal)
            {
                System.out.println("Clue: higher");
            }
            else
            {
                System.out.println("Clue: Lower");
            }
            if ( SlumpTal != Heltal && i == 9)
            {
                System.out.println("\nYou have not guessed right after 10 guesses.");
            }
        }

    }
}
