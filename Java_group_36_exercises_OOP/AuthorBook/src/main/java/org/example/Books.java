package org.example;

public class Books {

    /*
    Class fields attributes
    */
    private String bookName;
    private String numberOfPages;

    /*
    Empty constructor
     */
    public Books() {

    }

    /*
    Constructor with two strings as input.
     */
    public Books(String bookName, String numberOfPages) {

        this.bookName = bookName;
        this.numberOfPages = numberOfPages;
    }

    /*
    Set and get Methods of the class
     */
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookName='" + bookName + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}
