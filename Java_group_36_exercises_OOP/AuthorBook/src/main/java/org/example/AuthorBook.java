package org.example;

import java.util.Arrays;


public class AuthorBook
{
    /*
      Class fields attributes
    */
    private String authorFirstName;
    private String authorLastName;
    private int numberOfBooks;
    private Books [] books = new Books[0];

    /*
    Empty constructor
    */
    public AuthorBook() {

    }

    /*
    Constructor with three strings as input.
    */
    public AuthorBook(String authorFirstName, String AuthorLastName, Books[] books) {
        this.authorFirstName = authorFirstName;
        this.authorLastName = AuthorLastName;
        this.numberOfBooks = numberOfBooks;
        this.books = books;
    }

    /*
    set and get methods of the class
     */
    public String getAuthorFirstName() {

        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {

        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {

        return authorLastName;
    }

    public void setAuthorLastName(String AuthorLastName) {
        this.authorLastName = AuthorLastName;
    }

    public int getNumberOfBooks() {

        return numberOfBooks;
    }

    private void setNumberOfBooks(int numberOfBooks) {

        this.numberOfBooks = numberOfBooks;
    }

    public Books[] getBooks() {

        if(books == null){
            books = new Books[0];
        }

        return books;
    }

    public void setBooks(Books [] book) {
        setNumberOfBooks( getNumberOfBooks() + 1);

        this.books = book;
    }

    /*
    Method that expands object array of books and adds a objet of book into it.
    */
    public void addBook(Books book){
        if((books != null)){
            if(books == null){
                books = new Books[0];
            }
            books = Arrays.copyOf(books, books.length +1);
            books[books.length-1] = book;

        }

    }
}
