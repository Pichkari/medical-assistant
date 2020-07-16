package com.ncu.main;

import java.util.ArrayList;
import java.util.Scanner;
import com.ncu.algo.*;
import com.ncu.validator.*;
import com.ncu.exceptions.UnrecognizedDiseaseException;
import com.ncu.exceptions.UnrecognizedSymptomException;

public class mainDriver {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        char a='y';
        while(a=='y' || a=='Y'){
        System.out.println("************************** Welcome to Medical Assistance System *******************************");
        System.out.println("Enter Your Name");
        String name = scn.next();
        System.out.println("Enter Your ID");
        String id = scn.next();
    


        MedicalDatabse ob = new MedicalDatabse(id , name);
        //ob.set(id, name);

        
        char ch = 'y';
       // scn.nextLine(); // Dummy Line

        while (ch == 'y' || ch == 'Y') {
           
            System.out.println("Enter Your Symptom");
            String userSymptom = scn.next();
            
            try {
                ob.addSymptom(userSymptom);
            } catch (UnrecognizedSymptomException e) {
                e.printStackTrace();
            }

            System.out.println("Do You Want To Add more? (Y/N)");
            ch = scn.next().charAt(0);
            //if(temp=='y'||temp=='n')
            //ch=temp;
            //ch='n';
        }

        try {
           //  RETURN Type   var name  =   function name();
            ArrayList<String> diagnosis = ob.diagnosis();
            System.out.print("Possible Diseases are : ");
            for(int i = 0 ; i<diagnosis.size() ; i++)            
            System.out.print(diagnosis.get(i)+" ");   
        } catch (UnrecognizedDiseaseException e) {
            e.printStackTrace();
        }

        //Now we will validate the csv file  
        NameValidator nm = new NameValidator();
        boolean b = nm.nameValidator(args[0]); 
        if(b==true){
            //Now We Will Add the object ob in CSV File 
            Records q= new Records();
            q.writeData(args[0], ob);
            System.out.println();
            System.out.println("Success ... Record Written in CSV");

        }
        else{
            System.out.println("Could Not Write The record because Filename is wrong");
        }
        System.out.println("Do you want to check again ? (y/n)");
        a=scn.next().charAt(0);
    }

    }
}








