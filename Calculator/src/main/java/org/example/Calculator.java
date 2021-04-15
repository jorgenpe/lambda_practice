package org.example;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        //Programmed by Jörgen Pettersson //

        Scanner in = new Scanner(System.in);
        int choice;

        String a = "0";
        String b = "0";
        double result = 0;




        do
        {

            choice = menu(in, result);
            switch (choice) {

                case 1:{

                    result = add(in,a,b);
                }
                break;

                case 2:{

                    result = sub(in, a ,b);
                }
                break;


                case 3:{

                    result = multi(in, a, b);
                }
                break;


                case 4:{

                    result = div(in, a, b);
                }
                break;

                case 5:{

                    result = squ(in, a);
                }
                break;


            }




        }
        while (choice != 6);


    }

    private static int menu(Scanner in, double result) {

        String tempText = "0";
        boolean boolTemp = true;
        int temp = 0;

        System.out.println("\n 1. Addition ");
        System.out.println("\n 2. Subtraction ");
        System.out.println("\n 3. Multiplication");
        System.out.println("\n 4. Division ");
        System.out.println("\n 5. Square");
        System.out.println("\n 6 Quit.");
        System.out.println("\n The result is: " + result);

        do {
            tempText = in.next();
            boolTemp = true;
            if(!isInteger(tempText)){
                System.out.println(" Ilegal token. Must be a number 1-6");

                boolTemp = false;
            } else if (Integer.parseInt(tempText) < 1 || Integer.parseInt(tempText) > 6 ){
                System.out.println(" The number is not a menu choice. Please select number from menu.");

                boolTemp = false;
            } else {
                boolTemp = true;
            }


        }
        while(!boolTemp);



        temp = Integer.parseInt(tempText);



        return temp;

    }

    public static boolean isInteger(String text){

        int temp;
        try{
            temp = Integer.parseInt(text);
            return true;
        }catch (Exception e){

            return false;
        }
    }

    public static boolean isDouble(String text){
        double temp ;
        try{
            temp = Double.parseDouble(text);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static double add(Scanner in,String a, String b) {

        double c = 0.0;
        double d = 0.0;
        double temp ;
        char charAddAdd = '+';
        System.out.println("State first number: ");
        c = inputControl(in, a) ;

        System.out.println("State second number: ");
        d = inputControl(in, b);
        temp = addCalc(c, d);
        do{
            System.out.println("Do you want to add another number. Press +. Press any other key to not add more.");
            charAddAdd = in.next().charAt(0);
            if (charAddAdd == '+'){

                System.out.println("State the number you wnt to add: ");
                d = inputControl(in, b);
                temp = addCalc(temp, d);

            }
        }while(charAddAdd == '+');


        return temp;
    }
    public static double inputControl(Scanner in , String a){
        boolean boolTemp= true;
        do{
            a = in.next();

            if(!isDouble(a)){
            System.out.println(" Is not a number! Please enter a number.");
            boolTemp = false;
            }else{
                boolTemp = true;
            }

        }
        while(!boolTemp);
        return Double.parseDouble(a);
    }
    public static double addCalc(double a, double b) {

        return a + b;
    }


    public static double sub(Scanner in,String a, String b) {
        double c = 0.0;
        double d = 0.0;
        double temp ;
        char charSubSub = '-';
        System.out.println("State first number: ");
        c = inputControl(in, a) ;

        System.out.println("State second number: ");
        d = inputControl(in, b);
        temp = subCalc(c, d);
        do{
            System.out.println("Do you want to subtract another number. Press -. Press any other key to not add more.");
            charSubSub = in.next().charAt(0);
            if (charSubSub == '-'){

                System.out.println("State the number you want to add: ");
                d = inputControl(in, b);
                temp = subCalc(temp, d);

            }
        }while(charSubSub == '-');
        return temp;
    }

    public static double subCalc(double a, double b) {

        return a - b;
    }

    public static double multi(Scanner in,String a, String b) {
        double c = 0.0;
        double d = 0.0;
        System.out.println("State first number: ");
        c = inputControl(in, a) ;

        System.out.println("State second number: ");
        d = inputControl(in, b);
        return multiCalc(c, d);
    }

    public static double multiCalc(double a, double b) {

        return a * b;
    }


    public static double div(Scanner in,String a, String b) {
        double c = 0.0;
        double d = 0.0;
        System.out.println("State the number to be divided: ");
        c = inputControl(in, a) ;

        System.out.println("State the divider: ");
        d = inputControl(in, b);
        do {
            if (d == 0)
            {
                System.out.println("You can not divide with zero. Please choice a number other than zero" );
                d = inputControl(in, b);
            }
        }while(d == 0);

        return divCalc(c, d);
    }

    public static double divCalc(double a, double b) {

        return a / b;
    }

    public static double squ(Scanner in,String a) {
        double c = 0.0;

        System.out.println("State first number: ");
        c = inputControl(in, a) ;

        return squCalc(c);
    }

    public static double squCalc(double a) {

        return a * a;
    }



}
