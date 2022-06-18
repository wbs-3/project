package com.project;


import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
 
public class MyFilter implements Filter{
 
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        
        LOGGER.setFilter(new MyFilter());
       
        LOGGER.severe("SEVERE message");
        //This will get published
        LOGGER.warning("Important warning");
 
    }
     
    // This method will return true only if the LogRecord object contains the message which contains the word important 
    @Override
    public boolean isLoggable(LogRecord record) {
        if(record == null)
            return false;
         
        String message = record.getMessage()==null?"":record.getMessage();
         
        if(message.contains("important"))
            return true;
         
        return false;
    }
 
}
