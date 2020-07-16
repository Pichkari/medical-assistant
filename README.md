# medical-assistant
Medical Assistant: Design a Java application named Medical Assistant, 
which contains a MedicalDataBase class that maintains the following sets of information:
· Symptom information that specifies, for each symptom recognized by the program, a set of possible diseases that the symptom might indicate · 
Disease information that specifies, for each disease recognized by the program, a set of necessary symptoms that must accompany the disease 
· A possible diagnosis test (optional) The MedicalDataBase class will read the first two sets of information from the user/patient and writes the information into a csv file 
with the name "medicalDatabase.csv" in the following format: "patient id" | "patient name" | "symptoms list" | "possible disease" 
Definition of Done i. The program will maintain two text files containing a list of symptoms and possible diseases, namely “symptom.txt” &amp; “disease.txt” respectively 
. Two methods will be used: a. void addSymptom(String symptom) that adds the symptoms for a given patient into an array of String and throws UnrecognizedSymptomException
if the symptom added does not appear in the "symptoms.txt" file b. String[] diagnosis() returns the list of possible disease consistent with the symptoms submitted thus
far and throws UnrecognizedDiseaseException if the disease does not appear in the "disease.txt" file iii. The patient record should be saved in a csv file
namely “medicalDatabase.csv” iv. Apply proper validation checks on csv filename &amp; filetype attributes
