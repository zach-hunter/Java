
public class Circuit {
    /**
     * The resistance of the circuit
     */
    private double resistance;

    /**
     * Sets the resistance of the circuit
     * @param resistance the resistance of the circuit
     */
    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    /**
     * Gets the resistance of the circuit
     *
     * @return the circuit's resistance
     */
    public double getResistance() {
        return this.resistance;
    }

    @Override
    public String toString() {
        return String.format("%.3f",this.getResistance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Circuit)) return false;

        Circuit that = (Circuit) obj;

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
