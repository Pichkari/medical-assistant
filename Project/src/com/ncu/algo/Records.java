package com.ncu.algo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import au.com.bytecode.opencsv.*;     //we used an external jar class

import com.ncu.algo.MedicalDatabse;

public class Records {
                        
    public void writeData(String filename , MedicalDatabse ob) 
{ 
    // first create file object for file placed at location 
    // specified by filepath 
    String filePath = "C:\\Users\\hp\\Desktop\\Project\\database\\" +filename;
    File test = new File(filePath); 
    try { 
        // FileWriter object with file as parameter     
        FileWriter outputfile = new FileWriter(test , true); 
  
        // CSVWriter object filewriter object as parameter 
        CSVWriter writer = new CSVWriter(outputfile); 
  
        // adding header to csv 
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        if(br.readLine()==null)
        {String[] header = { "ID", "PatientName", "Symptoms" ,"Diseases" }; 
        writer.writeNext(header); }
  
        // add data to csv 
        ArrayList<String> rec1 = ob.getSymptoms(); //Getting the ArrayList
        String Symptoms = String.join(" ",rec1);   // Joining all elements in 1 String
        ArrayList<String> rec2 = ob.getDisease();  
        String Disease = String.join(" ",rec2);
        String[] data1 = { ob.getId(), ob.getName() , Symptoms , Disease};
       
        writer.writeNext(data1); 
          
        // closing writer connection 
        writer.close(); 
    } 
    catch (IOException e) { 
        e.printStackTrace(); 
    } 
}

}