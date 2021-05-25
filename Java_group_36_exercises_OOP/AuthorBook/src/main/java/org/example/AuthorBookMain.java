package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class AuthorBookMain {

    /*
    * Main method handles menu
    * */
    public static void main(String[] args) {

        AuthorBook[] authorTest = new AuthorBook[0];


        Scanner in = new Scanner(System.in);
        int choice;


        do {

            choice = menu(in);
            switch (choice) {

                case 1: {

                    authorTest = addAuthor(authorTest, in);

                }
                break;

                case 2: {

                    printAllBooksOfAuthor(authorTest, in);
                }
                break;


                case 3: {

                    printAuthorOfBook(authorTest, in);
                }
                break;

                }

        }
        while (choice != 4) ;



    }
        /*
        Method that handles output and input to menu
         */
        private static int menu (Scanner in){

            String tempText;
            boolean boolTemp ;
            int temp = 0;

            System.out.println("\n 1. Add author and books ");
            System.out.println("\n 2. Print books of author ");
            System.out.println("\n 3. Print author of book");
            System.out.println("\n 4 Quit.");


            do {
                tempText = in.next().trim();
                boolTemp = true;
                if (!isInteger(tempText)) {
                    System.out.println(" Illegal token. Must be a number 1-3");

                    boolTemp = false;
                } else if (Integer.parseInt(tempText) < 1 || Integer.parseInt(tempText) > 4) {
                    System.out.println(" The number is not a menu choice. Please select number from menu.");

                    boolTemp = false;
                } else {
                    boolTemp = true;
                }


            }
            while (!boolTemp);


            temp = Integer.parseInt(tempText);


            return temp;

        }

        /*
        Method that verify if int is a int
         */
        public static boolean isInteger (String text){

            int temp;
            try {
                temp = Integer.parseInt(text);
                return true;
            } catch (Exception e) {

                return false;
            }
        }

        /*
        Method that handles input to author and book.
        It calls different methods to verify that author and book is unique.
        If ok, it sets the new author and book.
         */
        public static AuthorBook[] addAuthor (AuthorBook[] author, Scanner in) {

            int index;
            String stringTemp;
            String tempString;
            boolean boolTemp = true;
            AuthorBook testAuthor = new AuthorBook();
            Books bookTemp = new Books();

            System.out.println("First name of the author: ");
            testAuthor.setAuthorFirstName(in.next());
            System.out.println("Last name of the author: ");
            testAuthor.setAuthorLastName(in.next());

            index = authorSearch( author, testAuthor);

            do {
                System.out.println("State name of the book: ");
                stringTemp = in.next().trim();

                System.out.println("State number of pages in the book: ");

                tempString = in.next();
                bookTemp.setNumberOfPages(tempString);



                bookTemp.setBookName(stringTemp);

                boolTemp = bookSearch(author, stringTemp);


                if(boolTemp){
                    System.out.println("The book already exist.");
                    boolTemp =true;
                }

            } while(boolTemp);

            author  = setAuthorBook(author, testAuthor, bookTemp, index );



            return author;
        }

        /*
        Method that add author object.
         */
        public static AuthorBook[] addAuthors(AuthorBook [] authorBook, AuthorBook author){

            if(( authorBook != null)){

                if(authorBook == null){

                authorBook = new AuthorBook[0];

                }

            authorBook = Arrays.copyOf(authorBook, authorBook.length +1);
            authorBook[authorBook.length-1] = author;

        }
        return authorBook;
    }

        /*
        Method that sets author and book.
        It uses index to handle if a author exist and then add to correct object.
        */
        private static  AuthorBook [] setAuthorBook(AuthorBook [] author, AuthorBook testAuthor, Books testBook, int index){

            AuthorBook [] authorTemp = Arrays.copyOf(author, author.length);

            if(index == -1){

                authorTemp = addAuthors(author, testAuthor);

                authorTemp[authorTemp.length -1].setAuthorFirstName(testAuthor.getAuthorFirstName());
                authorTemp[authorTemp.length -1].setAuthorLastName(testAuthor.getAuthorLastName());
                authorTemp[authorTemp.length -1].addBook(testBook);

                return authorTemp;

            }else {

                authorTemp[index].addBook(testBook);

            }
        return authorTemp;
        }

        /*
        Method that search for a author and return a int.
         */
        private static int authorSearch( AuthorBook[] author, AuthorBook testAuthor){

            if( author == null){

                return -1;

            }

            for(int i = 0; i < author.length; i++){

                System.out.println("Test av namn: " + author[i].getAuthorFirstName() + "  " + testAuthor.getAuthorFirstName());
                System.out.println("Test av lnamn: " + author[i].getAuthorLastName() + "  " + testAuthor.getAuthorLastName());
                if(author[i].getAuthorFirstName().equalsIgnoreCase(testAuthor.getAuthorFirstName()) &&
                        author[i].getAuthorLastName().equalsIgnoreCase(testAuthor.getAuthorLastName()) ){

                    return i;

                }

            }

        return -1;
        }

        /*
        Method that search for a book and return a boolean
         */
        private static boolean bookSearch(AuthorBook[] author, String book){
            Books []  booksTemp;
            if(author == null){
                return false;
            }
            for(int i = 0; i < author.length; i++){

                booksTemp = author[i].getBooks();

                if(booksTemp == null){
                    return false;
                }

                for(int j = 0; j < booksTemp.length; j++){

                   if (booksTemp[j].getBookName().equals(book)){
                       return true;
                   }

                }
            }

            return false;
        }

        /*
        Method that print out all books of a specific author
         */
        private static void printAllBooksOfAuthor (AuthorBook[] author, Scanner in) {

            int index;

            AuthorBook tempAuthor = new AuthorBook();

            System.out.println("First name of the author: ");
            tempAuthor.setAuthorFirstName(in.next());
            System.out.println("Last name of the author: ");
            tempAuthor.setAuthorLastName(in.next());

            index = authorSearch(  author,  tempAuthor) ;

            if(index == - 1){
                System.out.println(" The author you where looking for don't exist");
            }else{

                Books [] tempBooks = author[index].getBooks();

                for(int i = 0; i < tempBooks.length; i++){

                    System.out.println("Book name : " + tempBooks[i].getBookName());
                }
            }

        }

        /*
        Method that prints out the author of a book
         */
        public static void printAuthorOfBook (AuthorBook[] author, Scanner in) {

            String book;
            int index;

            System.out.println("State the  name of the book you searching for: ");
            book = in.next();

            index = bookSearches(author, book);

            if( index ==-1){
                System.out.println(" The books author don't exist. ");
            }else{

                System.out.println(" The author of " + book + " is " + author[index].getAuthorFirstName() + " " + author[index].getAuthorLastName() + ".");
            }

        }

        /*
        Method that search for a book and return a int
         */
        private static int bookSearches(AuthorBook[] author, String book ){
            Books []  booksTemp;

            if(author == null){
                return -1;
            }
            for(int i = 0; i < author.length; i++){

                booksTemp = author[i].getBooks();

                if(booksTemp == null){
                    return -1;
                }

                for(int j = 0; j < booksTemp.length; j++){


                    if (booksTemp[j].getBookName().equalsIgnoreCase(book)){

                        return i;

                    }

                }
            }

            return -1;
        }

}