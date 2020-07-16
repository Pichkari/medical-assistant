package com.ncu.algo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.io.*;
import au.com.bytecode.opencsv.*;

public class issue {

    public static void updateCSV(String fileToUpdate, String replace,
    int row, int col) throws IOException {

File inputFile = new File(fileToUpdate);

// Read existing file 
CSVReader reader = new CSVReader(new FileReader(inputFile), ',');
List<String[]> csvBody = reader.readAll();
// get CSV row column  and replace with by using row and column
csvBody.get(row)[col] = replace;
reader.close();

// Write to CSV file which is open
CSVWriter writer = new CSVWriter(new FileWriter(inputFile), ',');
writer.writeAll(csvBody);
writer.flush();
writer.close();
}

    public static void IsueBook (){
        FileReader fr = null;
        CSVReader cr = null;
        String [] arr =null;
        int count=0;
     

        try{
            fr = new FileReader("C:\\Users\\hp\\Desktop\\Project\\database\\medicalDatabase.csv");
            cr = new CSVReader(fr);

            while((arr=cr.readNext())!=null){
                count++;
                
                if(arr[0].equals("123")){

                    if(arr[1].equals("Udit")){
                        System.out.println("Book Is Available");
                        fr.close();
                        cr.close();
                        updateCSV("C:\\Users\\hp\\Desktop\\Project\\database\\medicalDatabase.csv","Issued", count-1, 3);
                        break;                        
                    }
                    else{System.out.println("Book Is Already Issued Sorry");}
                }
            }
            fr.close();
            cr.close();           

        }
        catch(Exception q){q.printStackTrace();}
    }

    public static void main(String [] args){
        IsueBook();
    }
    
}