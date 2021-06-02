package org.example;

public abstract class Io_exceptionHandle {

    public void closeAll(AutoCloseable...closeables){
        if(closeables == null)return;

        for(AutoCloseable close: closeables){

            if(close != null){
                try{
                    close.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
