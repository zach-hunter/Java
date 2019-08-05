import java.util.ArrayList;

public class Serial extends Circuit {
    /**
     * An array list containing all the resistors for the serial circuit
     */
    private ArrayList<Circuit> circuitList = new ArrayList<>();

    /**
     * Sets the resistance for the whole circuit based on the resistors in the array list
     * using the formula: Rt = R1 + R2 + R3 + R4 + R5 +...
     */
    public void setResistance() {
        double totalResistance = 0;
        for (Circuit circuit : circuitList) {
            totalResistance += circuit.getResistance();
        }
        setResistance(totalResistance);
    }

    /**
     * Adds a circuit to the serial circuit and then recalculates the total resistance
     * @param circuit Any circuit(resistor, serial, parallel)
     */
    public void add(Circuit circuit) {
        this.circuitList.add(circuit);
        setResistance();
    }

    @Override
    public String toString() {
        return String.format("%.3f",this.getResistance());
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Serial)) return false;

        Serial that = (Serial) obj;

        return this.getResistance() == that.getResistance();
    }

    @Override
    public int hashCode() {
        int result = 19;
        long l = Double.doubleToLongBits(getResistance());
        result = 31 * result + (int)(l ^ (l >>>32));
        return result;
    }
}
