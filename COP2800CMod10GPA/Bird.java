// Olivier Beaubrun 
// D. Singletary 
// 7/15/2026 
public class Bird implements Comparable<Bird> {

    // Private fields for encapsulation
    private int sampleNum;
    private double culmenLength;
    private double culmenDepth;
    private double bodyMass;
    private String sex;

    
    public Bird(int sampleNum, double culmenLength, double culmenDepth, double bodyMass, String sex) {
        this.sampleNum = sampleNum;
        this.culmenLength = culmenLength;
        this.culmenDepth = culmenDepth;
        this.bodyMass = bodyMass;
        this.sex = sex;
    }

    

    public int getSampleNum() {
        return sampleNum;
    }

    public double getCulmenLength() {
        return culmenLength;
    }

    public double getCulmenDepth() {
        return culmenDepth;
    }

    public double getBodyMass() {
        return bodyMass;
    }

    public String getSex() {
        return sex;
    }

    
   
    public int compareTo(Bird other) {
        int result = Integer.compare(this.sampleNum, other.sampleNum);
        if (result != 0) return result;

        result = Double.compare(this.culmenLength, other.culmenLength);
        if (result != 0) return result;

        result = Double.compare(this.culmenDepth, other.culmenDepth);
        if (result != 0) return result;

        result = Double.compare(this.bodyMass, other.bodyMass);
        if (result != 0) return result;

        return this.sex.compareTo(other.sex);
    }
}