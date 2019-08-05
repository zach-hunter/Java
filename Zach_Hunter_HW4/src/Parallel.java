import java.util.ArrayList;

public class Parallel extends Circuit {
    /**
     * An array list containing all the resistors for the parallel circuit
     */
    private ArrayList<Circuit> circuitList = new ArrayList<>();

    /**
     * Sets the resistance for the whole circuit based on the resistors in the array list
     * using the formula: 1/Rt = 1/R1 + 1/R2 + 1/R3 + 1/R4 + ...
     */
    public void setResistance() {
        double totalResistance = 0;
        for (Circuit circuit : circuitList) {
            totalResistance += 1/circuit.getResistance();
        }
        totalResistance = 1/totalResistance;
        setResistance(totalResistance);
    }

    /**
     * Adds a circuit to the parallel circuit and then recalculates the total resistance
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

        if (!(obj instanceof Parallel)) return false;

        Parallel that = (Parallel) obj;

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
