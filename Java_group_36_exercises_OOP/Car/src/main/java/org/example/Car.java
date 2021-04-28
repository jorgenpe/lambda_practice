package org.example;


public class Car
{

    /*
      Class fields attributes
    */
    private int id;
    private int year;
    private String model;
    private String colour;
    private String motorSize;

    /*
    Empty constructor that set all attributes to default values.
     */
    Car(){
        this(0, 0, "Undefined", "Undefined", "Undefined");
    }

    /*
    Constructor with two int and three strings
     */
    Car(int id, int year, String model, String colour, String motorSize){

        this.id = id;
        this.year = year;
        this.model = model;
        this.colour = colour;
        this.motorSize = motorSize;
    }

    /*
    Method that print out model and motor size
     */
    public void drive(){

         System.out.println("\n" + model + " With " + motorSize + " can drive now.\n");
    }

    /*
    Set and get methods
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMotorSize() {
        return motorSize;
    }

    public void setMotorSize(String motorSize) {
        this.motorSize = motorSize;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                ", motorSize='" + motorSize + '\'' +
                '}';
    }
}
