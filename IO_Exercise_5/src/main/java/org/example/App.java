package org.example;


import Cars.Car;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        List<Car> carList = new ArrayList<>();
        List<Car> carListFile = new ArrayList<>();
        String path = "CarsOut/Cars.ser";

        carList = createCars(carList);

        outputCarFile(carList,path);

        carListFile = inputCarFile(path);

        for(Car m: carListFile){

            System.out.println(m.toString());
        }



    }

    public static void outputCarFile(List<Car> carList, String path){

        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));

            //for(Car m : carList){

                out.writeObject(carList);
            //}

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Car> inputCarFile(String path){

        List<Car> carList = new ArrayList<>();

        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));

            //while( in.readObject()){

                carList = (List<Car>) in.readObject();
            //}

        }catch(Exception e){
            e.printStackTrace();
        }





        return carList;
    }

    public static List<Car> createCars(List<Car> carList){

        Car car = new Car();

        car.setCarId(123);
        car.setBrand("Ford");
        car.setCarReg("FGH 505");
        car.setModel("Focus");
        carList.add(car);

        car = new Car();
        car.setCarId(123);
        car.setBrand("Volvo");
        car.setCarReg("DRT 591");
        car.setModel("v40");
        carList.add(car);

        car = new Car();
        car.setCarId(123);
        car.setBrand("Audi");
        car.setCarReg("FLK 452");
        car.setModel("A3");
        carList.add(car);

        car = new Car();
        car.setCarId(124);
        car.setBrand("Volvo");
        car.setCarReg("FGH 515");
        car.setModel("v60");
        carList.add(car);

        return carList;
    }
}
