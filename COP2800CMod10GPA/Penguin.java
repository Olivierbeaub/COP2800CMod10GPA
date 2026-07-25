// Olivier Beaubrun 
// D. Singletary 
// 7/15/2026 
public class Penguin extends Bird {

    // Penguin-specific fields
    private String species;
    private double flipperLength;

   
    public Penguin(int sampleNum, String species, double culmenLength, double culmenDepth, 
                   double bodyMass, String sex, double flipperLength) {
        // Pass common fields to the Bird base class constructor
        super(sampleNum, culmenLength, culmenDepth, bodyMass, sex);
        
        // Initialize Penguin-specific fields
        this.species = species;
        this.flipperLength = flipperLength;
    }


    public String getSpecies() {
        return species;
    }

    public double getFlipperLength() {
        return flipperLength;
    }
}