package com.ncu.validator;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.*;

import com.ncu.exceptions.*;

public class NameValidator {

    public boolean nameValidator(String filename){

        Properties prop= new Properties(); //To use predefined msgs
        FileInputStream input = null;      //To read the file in which custom msg are stored
        try{
            input=new FileInputStream("C:\\Users\\hp\\Desktop\\Project\\constants\\exception.properties"); // Where ever my custom msg ki .properties file is stored
            prop.load(input);  //Need to load in property object
       
        emptyFileName(filename);  
        emptyDot(filename);
             
        String[] fileSplit = filename.split("\\." ,0);  //To break the filename into components
           

        isCsV(fileSplit[1]);
        filelength(fileSplit[0]);
       }
        catch(EmptyFileNameException q)
        {   String e=prop.getProperty("blankNameMessage");
            System.out.println(e);
            q.getMessage();
        q.printStackTrace();
        return false;}

        catch(MissingExtensionException w)
        { System.out.println(prop.getProperty("extensionMessage"));
            w.printStackTrace();
        return false;}
        catch(InvalidExtensionException t)
       {   System.out.println(prop.getProperty("notCsvMessage"));
           t.printStackTrace();
       return false;}
       catch(FileLengthException y){
           System.out.println(prop.getProperty("longFileNameMessage"));
           y.printStackTrace();
           return false;
       }    
        
        catch(Exception r){r.printStackTrace();
        return false;}


        return true;   //If all the parameters are okay the functions returns the value true
        
    }


   private void emptyFileName(String filename) throws EmptyFileNameException{
        if(filename=="")
        throw new EmptyFileNameException("Blank File name ");
    }

    private void emptyDot(String filename) throws MissingExtensionException{
        Pattern ob1= Pattern.compile("[.]");    //Kya dhundna hai?
        Matcher ob2 = ob1.matcher(filename);     //Kisme dhundna hai?
        if(ob2.find()==false)
        throw new MissingExtensionException("No . in filename"); 
    }
    private void isCsV(String filetype) throws InvalidExtensionException{
        if(filetype.equals("csv")==false)
            throw new InvalidExtensionException("File is not CSV type");
    }

    private void filelength(String filename)throws FileLengthException{
        if(filename.length()>25)
            throw new FileLengthException("FileName too long");

    }

}