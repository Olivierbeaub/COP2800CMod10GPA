// PenguinAnalyzer.java
// D. Singletary
// 7/15/26
// Handles Reading, Processing, and Writing Penguin Data
package edu.fscj.cop2800c.penguin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PenguinAnalyzer {
   private ArrayList<PenguinData> penguinList;
   // Matched to the file name casing from your previous assignment
   private static final String FILE_NAME = "PalmerPenguins.csv"; 

   // Read all columns from the CSV File using BufferedReader[cite: 1]
   public void readPenguinData() {
      penguinList = new ArrayList<>();
      try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
         String line;
         reader.readLine(); // Skip header
         
         while ((line = reader.readLine()) != null) {
            String[] tokens = line.split(",");
            
            // Check for 7 columns[cite: 1]
            if (tokens.length >= 7) { 
               try {
                  int sampleNumber = Integer.parseInt(tokens[0].trim());
                  String species = tokens[1].trim();
                  double billLength = Double.parseDouble(tokens[2].trim());
                  double billDepth = Double.parseDouble(tokens[3].trim()); 
                  double flipperLength = Double.parseDouble(tokens[4].trim());
                  double bodyMass = Double.parseDouble(tokens[5].trim());
                  String sex = tokens[6].trim();
                  
                  PenguinData penguin = new PenguinData(sampleNumber, species, billLength, 
                                                       billDepth, flipperLength, bodyMass, sex);
                  penguinList.add(penguin);
               } catch (NumberFormatException e) {
                  System.err.println("Skipping invalid row: " + line);
               }
            } else {
               System.err.println("Skipping malformed row: " + line);
            }
         }
      } catch (IOException e) {
         System.err.println("Error reading file: " + e.getMessage());
      }
   }

   // Print Penguins with Formatted Output[cite: 1]
   public void printPenguinData() {
      System.out.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-8s%n",
                        "ID", "Species", "Bill Len", "Bill Dep", "Flipper Len", "Mass", "Sex");
      System.out.println("-------------------------------------------------------------------------");
      
      for (PenguinData penguin : penguinList) {
         System.out.printf("%-5d %-10s %-10.1f %-10.1f %-15.1f %-10.1f %-8s%n",
                           penguin.getSampleNumber(), penguin.getSpecies(), penguin.getBillLength(),
                           penguin.getBillDepth(), penguin.getFlipperLength(),
                           penguin.getBodyMass(), penguin.getSex());
      }
   }

   // Write Processed Data to a New File
   public void writePenguinData() {
      try (PrintWriter writer = new PrintWriter(new FileWriter("PenguinOutput.txt"))) {
         writer.printf("%-5s %-10s %-10s %-10s %-15s %-10s %-8s%n",
                       "ID", "Species", "Bill Len", "Bill Dep", "Flipper Len", "Mass", "Sex");
         writer.println("-------------------------------------------------------------------------");
         
         for (PenguinData penguin : penguinList) {
            writer.printf("%-5d %-10s %-10.1f %-10.1f %-15.1f %-10.1f %-8s%n",
                          penguin.getSampleNumber(), penguin.getSpecies(), penguin.getBillLength(),
                          penguin.getBillDepth(), penguin.getFlipperLength(),
                          penguin.getBodyMass(), penguin.getSex());
         }
         System.out.println("Penguin data successfully written to PenguinOutput.txt.");
      } catch (IOException e) {
         System.err.println("Error writing to file: " + e.getMessage());
      }
   }
}