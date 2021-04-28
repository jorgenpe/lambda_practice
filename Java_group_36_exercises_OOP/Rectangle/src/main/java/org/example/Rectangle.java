package org.example;


public class Rectangle
{
    /*
      Class fields attributes
    */
    private double height;
    private double weight;

    /*
    Empty constructor
     */
    Rectangle() {

    }

    /*
    Constructor with two double as input
     */
    public Rectangle(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    /*
    Set and get methods
     */
    public double getHight() {
        return height;
    }

    public void setHight(double hight) {
        this.height = hight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getArea(){
        return height * weight;
    }

    @Override
    public String toString() {
        return "\nRectangle{ " +
                "height=" + height +
                ", weight = " + weight +
                ", area = " + getArea() +
                "}\n";
    }
}
