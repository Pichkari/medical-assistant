package com.ncu.algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import com.ncu.exceptions.*;

public class MedicalDatabse {

    private String id;
    private String PatientName;
    private ArrayList<String> symptoms;
    private ArrayList<String> disease;
     
    public MedicalDatabse (){
        id=null;
        PatientName=null;
        symptoms = new ArrayList<>();
        disease = new ArrayList<>();
    }
    public MedicalDatabse(String id , String PatientName){
        this.id = id;
        this.PatientName = PatientName;
        symptoms = new ArrayList<>();
        disease = new ArrayList<>();
    }

    public void set(String id, String PatientName) {
        this.id = id;
        this.PatientName = PatientName;
        symptoms = new ArrayList<>();
        disease = new ArrayList<>();
    }

    public String getId() {return id;}

    public String getName() {
        return PatientName;
    }

    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public ArrayList<String> getDisease() {
        return disease;
    }

    public void addSymptom(String symptom) throws UnrecognizedSymptomException {

        // Symptom nam ki string ai
        // 2 usko hamne ek TEXT file se check kara
        // agar check shi rha
        // toh symptoms nam ki array mai add
        // agar match nhi kari
        // Exception throw Unrecognised symptom

        FileReader fr = null; // Initialized with null
        BufferedReader br = null;

        Properties prop = new Properties(); // To use predefined msgs
        FileInputStream input = null; // To read the file in which custom msg are stored

        try {
            fr = new FileReader("C:\\Users\\hp\\Desktop\\Project\\textFiles\\symptoms.txt");
            br = new BufferedReader(fr);
            String fileString;
            boolean b = false;

            input = new FileInputStream("C:\\Users\\hp\\Desktop\\Project\\constants\\exception.properties"); 
            prop.load(input); // Need to load in property object

            while ((fileString = br.readLine()) != null) {
                // System.out.println(fileString);
                // System.out.println(symptom);

                if (symptom.equals(fileString)) {
                    b = true;
                    System.out.println("Symptom found in text file");
                    break;
                }
            }

            br.close();
            fr.close();
            if (b == true) {
                symptoms.add(symptom);
            } else {
                throw new UnrecognizedSymptomException("Symptom Not found in File");
            }

        } catch (UnrecognizedSymptomException q) {
            String e = prop.getProperty("sym");
            System.out.println(e);
            q.printStackTrace();
        } catch (Exception q) {
            q.printStackTrace();
        }

    }

    public ArrayList<String> diagnosis() throws UnrecognizedDiseaseException {

        FileReader fr = null;
        BufferedReader br = null;

        Properties prop = new Properties(); // To use predefined msgs
        FileInputStream input = null; // To read the file in which custom msg are stored

        try {

            fr = new FileReader("C:\\Users\\hp\\Desktop\\Project\\textFiles\\diseases.txt");
            br = new BufferedReader(fr);
            int count = 0;
            String diseaseData;
            String[] splitData = null;

            input = new FileInputStream("C:\\Users\\hp\\Desktop\\Project\\constants\\exception.properties"); 
            prop.load(input); // Need to load in property object

            while ((diseaseData = br.readLine()) != null) {

                count = 0;
                splitData = diseaseData.split(" ");

                // for (int k=0 ; k < splitData.length ; k++)
                // System.out.println(splitData[k]);
                // System.out.println();

                for (int i = 1; i < splitData.length; i++) { // To access predefined data of txt file
                    for (int j = 0; j < symptoms.size(); j++) { // To access the symptoms of the object
                        if (splitData[i].equals(symptoms.get(j)))
                            {count++;}
                    }
                    
                }
                if (count >= 2) {
                    disease.add(splitData[0]);
                }

            }
            fr.close();
            br.close();

            if (disease.size() == 0) {
                throw new UnrecognizedDiseaseException("Diesease Not Found in File");
            }
            // Symptoms ki array list se symptom leke
            // diseases.txt file mai search karke possible
            // diseases add krane hai ek ArrayList mai
            // Jo return hogi main mai aur diseases nam ki array list mai add hogi
        } catch (UnrecognizedDiseaseException q) {
            String e = prop.getProperty("dys");
            System.out.println(e);
            q.printStackTrace();
        } catch (Exception q) {
            q.printStackTrace();
        }

        return disease;

    }

}
