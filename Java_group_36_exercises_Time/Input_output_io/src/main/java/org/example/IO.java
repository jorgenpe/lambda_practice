package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class IO extends Io_exceptionHandle {


    public void createTextFile(String sourceString){

        File source = new File("source/testText.txt");
        FileWriter inFile = null;

        try{

            inFile = new FileWriter(source);

            if(!source.exists()){
                source.createNewFile();
            }
            inFile.write(sourceString);

        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{

            closeAll(inFile);
        }
    }



    public void createTextLineFile(List<String> sourceString){

        File source = new File("source/testTextLine.txt");
        BufferedWriter inFile = null;

        try{

            inFile = new BufferedWriter(new FileWriter(source));

            for(int i = 0; i< sourceString.size(); i++)
            {
                inFile.write(sourceString.get(i));

                if(!source.exists()){
                    source.createNewFile();
                }

                if(i != sourceString.size()){
                    inFile.newLine();
                }
                inFile.flush();
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{

            closeAll(inFile);
        }


    }


    public String fileReaderFile(File sourceFile){

        char letter ='a';
        StringBuilder testString = new StringBuilder();
        FileReader inFile = null;

        try{

            inFile = new FileReader(sourceFile);

            int i;
            while((i = inFile.read()) != -1 ){

                letter = (char) i;
                testString.append(letter);
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{

            closeAll(inFile);
        }
        return testString.toString();
    }
}
