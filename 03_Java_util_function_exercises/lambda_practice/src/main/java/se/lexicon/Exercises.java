package se.lexicon;


import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       1.	Find everyone that has firstName: “Erik” using findMany().
       */


    public static void exercise1(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getFirstName().equalsIgnoreCase("Erik");

        for(Person m: storage.findMany(filter)){

            System.out.println(m.toString());
        }

        System.out.println("----------------------");
    }

    /*
        2.	Find all females in the collection using findMany().
     */
    public static void exercise2(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getGender().equals(Gender.FEMALE);

        for(Person m: storage.findMany(filter)){

            System.out.println(m.toString());
        }

        System.out.println("----------------------");
    }

    /*
        3.	Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message){
        System.out.println(message);


        Predicate<Person> filter = n -> n.getBirthDate().isAfter(LocalDate.of(2000,1,1));

        for(Person m: storage.findMany(filter)){

            System.out.println(m.toString());
        }

        System.out.println("----------------------");
    }

    /*
        4.	Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getId() == 123;

        System.out.println(storage.findOne(filter).toString());


        System.out.println("----------------------");

    }

    /*
        5.	Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getId() == 456;
        Function<Person, String> personToString = p-> ("Name: " + p.getFirstName()+ " " + p.getLastName() + " born " + p.getBirthDate());


        System.out.println( storage.findOneAndMapToString(filter, personToString));
        System.out.println("----------------------");
    }

    /*
        6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getFirstName().charAt(0) == 'E' && n.getGender().equals(Gender.MALE);
        Function<Person, String> personToString = p-> p.toString();

        for(String m : storage.findManyAndMapEachToString(filter, personToString)){

            System.out.println(m);
        }

        System.out.println("----------------------");
    }

    /*
        7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message){
        System.out.println(message);
        Predicate<Person> filter = n -> n.getBirthDate().isAfter(LocalDate.now().minusYears(9));
        Function<Person, String> personToString = p-> ("Name: " + p.getFirstName()+ " " + p.getLastName() + "  " + (LocalDate.now().getYear() - p.getBirthDate().getYear()  ) + " year");

        for(String m : storage.findManyAndMapEachToString(filter, personToString)){

            System.out.println(m);
        }

        System.out.println("----------------------");
    }

    /*
        8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message){
        System.out.println(message);
        Predicate<Person> filter = n -> n.getFirstName().equalsIgnoreCase("Ulf");
        Consumer<Person> consumer = p -> System.out.println(p.toString());

        storage.findAndDo(filter, consumer);


        System.out.println("----------------------");
    }

    /*
        9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getLastName().contains(n.getFirstName());
        Consumer<Person> consumer = p -> System.out.println(p.toString());

        storage.findAndDo(filter, consumer);

        System.out.println("----------------------");
    }

    /*
        10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getFirstName().equalsIgnoreCase(new StringBuilder().append(n.getFirstName()).reverse().toString().trim());
        Consumer<Person> consumer = p -> System.out.println(p.getFirstName() + " " + p.getLastName());

        storage.findAndDo(filter, consumer);



        System.out.println("----------------------");
    }

    /*
        11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getFirstName().charAt(0) == 'A';

        Comparator<Person> byBirth = Comparator.comparing(p -> p.getBirthDate());

        for(Person m: storage.findAndSort(filter,byBirth)){

            System.out.println(m);
        }

        System.out.println("----------------------");
    }

    /*
        12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message){
        System.out.println(message);

        Predicate<Person> filter = n -> n.getBirthDate().isBefore(LocalDate.of(1950,1,1));

        Comparator<Person> byBirth = Comparator.comparing(p -> p.getBirthDate());

        for(Person m: storage.findAndSort(filter,byBirth.reversed())){

            System.out.println(m);
        }



        System.out.println("----------------------");
    }

    /*
        13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message){
        System.out.println(message);

        Comparator<Person> byLastName = Comparator.comparing(p -> p.getLastName());
        Comparator<Person> byFirstName = Comparator.comparing(p -> p.getFirstName());
        Comparator<Person> byBirth = Comparator.comparing(p -> p.getBirthDate());


        System.out.println("Starts byLastName:");
            for(Person m: storage.findAndSort(byLastName)){

                System.out.println(m);
            }
        System.out.println("Ends byLastName:");

        System.out.println("Starts byFirstName:");
            for(Person m: storage.findAndSort(byFirstName)){

                System.out.println(m);
            }
        System.out.println("Ends byFirstName:");

        System.out.println("Starts byBirth:");
            for(Person m: storage.findAndSort(byBirth)){

                System.out.println(m);
            }
        System.out.println("Ends byBirth:");

        System.out.println("----------------------");
    }
}
