import java.util.Scanner;

public class TwoCalculator {

    public static void main(String[] args){
        /*Variables*/
        Scanner in = new Scanner(System.in);
        int a, b;

        /*Printout, input and calculation*/
        System.out.println("State first number");
        a = Integer.parseInt(in.nextLine());

        System.out.println("State second number");
        b = Integer.parseInt(in.nextLine());

        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (a / b));

    }
}
