import java.util.Scanner;

public class PrintCalculation {

    public static void main(String[] args){

        int a ,b , c, d, e ,f , g, h;
        Scanner in = new Scanner(System.in);


        a = firstNumber(in);
        b = secondNumber(in);

        c = firstNumber(in);
        d = secondNumber(in);

        e = firstNumber(in);
        f = secondNumber(in);

        g = firstNumber(in);
        h = secondNumber(in);

        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(c + " + " + d + " = " + (c - d));
        System.out.println(e + " + " + f + " = " + (e * f));
        System.out.println(g + " + " + h + " = " + (g/ h));
    }
    public static int firstNumber(Scanner in){

        System.out.println("State first number: ");
        return Integer.parseInt(in.nextLine());
    }

    public static int secondNumber(Scanner in){

        System.out.println("State second number: ");
        return Integer.parseInt(in.nextLine());
    }
}
