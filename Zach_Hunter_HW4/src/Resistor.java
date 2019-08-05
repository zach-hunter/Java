public class Resistor extends Circuit {

    /**
     * Constructs a new instance of Resistor and sets the resistance using the passed resistance peram
     * @param resistance the resistance of the resistor
     */
    public Resistor(double resistance) {
        setResistance(resistance);
    }

    @Override
    public String toString() {
        return String.format("%.3f", this.getResistance());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Resistor)) return false;

        Resistor that = (Resistor) obj;

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
