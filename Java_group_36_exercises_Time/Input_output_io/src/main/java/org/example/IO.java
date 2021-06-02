package org.example;

import java.io.*;
import java.util.Collection;
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

                if(i != sourceString.size()-1){
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
            while((i =inFile.read()) != -1 ){

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

    public Collection<String> collectionTextLine(Collection<String> name, File source){


        BufferedReader inFile = null;

        try{

            inFile = new BufferedReader(new FileReader(source));
            String line;
            while((line = inFile.readLine()) != null){

                name.add(line);
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{

            closeAll(inFile);
        }

        return name;
    }


    public void bufferedStreamCopy(File source, File destination){


        InputStream inFile = null;
        OutputStream outFile = null;

        try{

            inFile = new FileInputStream(source);
            outFile = new FileOutputStream(destination);

            int index;
            while((index = inFile.read()) != -1){

                outFile.write(index);
            }


        }catch(Exception ex){
            ex.printStackTrace();
        }
        finally{

            closeAll(inFile);
        }

    }

}
