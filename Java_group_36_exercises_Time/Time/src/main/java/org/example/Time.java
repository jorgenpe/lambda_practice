package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Time
{
    public static void main( String[] args )
    {

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
        exercise9();
        exercise10();
        exercise11();
        exercise12();
        exercise13();
        exercise14();
        exercise15();
        exercise16();

    }

    public static void exercise1(){

        LocalDate date = LocalDate.now();
        System.out.println("\n" + date);

    }


    public static void exercise2(){

        LocalDate date = LocalDate.now().plusDays(1).minusMonths(1);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("E dd MMM ");
        String text = date.format(formatDate);
        System.out.println("\n" + text);
    }

    public static void exercise3(){

        System.out.println("\n");
        for( int i = 0; i < 7; i++){
            LocalDate date = LocalDate.of(2021,04,26).plusDays(i);
            DateTimeFormatter formatDate = DateTimeFormatter.ISO_DATE;
            String text = date.format(formatDate);

            System.out.println(text);
        }

        System.out.println("\n");
    }

    public static void exercise4(){

        LocalDate date = LocalDate.parse("2021-04-28");

        System.out.println("\n" + date);
    }

    public static void exercise5(){

        LocalDate date = LocalDate.parse("1945-04-08");
        DayOfWeek day = DayOfWeek.from(date);

        System.out.println("\n" + day);
    }

    public static void exercise6(){
        LocalDate date = LocalDate.now().plusYears(10).minusMonths(10);

        Month month = Month.from(date);

        System.out.println("\n" + month);

    }

    public static void exercise7(){

        LocalDate date = LocalDate.parse("1945-04-08");
        LocalDate myBirth = LocalDate.of(1969, 8, 30);

        Period datBetweenBirth = Period.between(date , myBirth);

        System.out.println("\n Number of years: " + datBetweenBirth.getYears() + " Number of months: " + datBetweenBirth.getMonths() +
                " Number of days: " + datBetweenBirth.getDays());

    }

    public static void exercise8(){

        LocalDate firstDate = LocalDate.parse("2016-01-01");
        LocalDate secondDate = LocalDate.parse("2020-07-30");
        Period  periodDate = Period.between(firstDate, secondDate );
        LocalDate date = LocalDate.now().plusDays(periodDate.getDays()).plusMonths(periodDate.getMonths()).plusYears(periodDate.getYears());

        System.out.println("\n" + date + "\n");
    }

    public static void exercise9(){

        LocalTime time = LocalTime.now();

        System.out.println(time + "\n");
    }

    public static void exercise10(){

        LocalTime time = LocalTime.now();

        System.out.println("the nanoseconds is: " + time.getNano() + "\n");
    }

    public static void exercise11(){

        LocalTime time = LocalTime.parse("10:00");

        System.out.println(time + "\n");
    }

    public static void exercise12(){

        LocalTime time = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println( time.format(timeFormat) + "\n");
    }

    public static void exercise13(){

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("'date: 'yyyy-MM-dd 'time: 'hh:mm:ss");


        System.out.println( dateTime.format(dateTimeFormat)  + "\n");
    }

    public static void exercise14(){

        LocalDateTime dateTime = LocalDateTime.now().plusDays(1);
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("E,dd MMM HH:mm");

        System.out.println(dateTime.format(dateTimeFormat) +"\n");
    }

    public static void exercise15(){


        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        String temp = date.toString();
        temp = temp + "T" + time.toString();
        LocalDateTime dateTime = LocalDateTime.parse(temp);


        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println(dateTime.format(dateTimeFormat) +"\n");

    }

    public static void exercise16(){

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date = LocalDate.parse(dateTime.format(dateFormat));

        String temp = dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond();
        LocalTime time = LocalTime.parse(temp);

        System.out.println(date + "T" + time + "\n");

    }



}
