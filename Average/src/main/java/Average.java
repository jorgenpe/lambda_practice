import java.util.Scanner;

public class Average {

    public static void main(String[] args){

        average();
    }

    public static void average(){
        /*Variables*/
        Scanner in = new Scanner(System.in);
        int a ,b ,c;

        /* printout, input and calculation*/
        System.out.println("State first number: ");
        a = Integer.parseInt(in.nextLine());
        System.out.println("State second number: ");
        b = Integer.parseInt(in.nextLine());
        System.out.println("State third number: ");
        c = Integer.parseInt(in.nextLine());

        System.out.println("The average is : " + a + " + " + b + " + " + c + " = " + ((a + b + c)/3));

    }
}
