// PalmerPenguins.java
// D. Singletary
// 7/15/26
// Refactored Palmer Penguins analysis using object-oriented approach and File I/O
package edu.fscj.cop2800c.penguin;

public class PalmerPenguins {
    public static void main(String[] args) {
        // Create an instance of PenguinAnalyzer
        PenguinAnalyzer analyzer = new PenguinAnalyzer();

        // Read CSV data
        analyzer.readPenguinData();

        // Print formatted output to the console
        analyzer.printPenguinData();

        // Save results to a file
        analyzer.writePenguinData();
        
    }
}