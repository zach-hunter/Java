public class Main {

    public static void main(String[] args) {
	Parallel circuit1 = new Parallel();

	Serial circuit2 = new Serial();
	circuit2.add(new Resistor(100));
	circuit2.add(new Resistor(200));

	Serial circuit3 = new Serial();
	circuit3.add(new Resistor(200));
	circuit3.add(new Resistor(300));

	circuit1.add(circuit2);
	circuit1.add(circuit3);

	System.out.printf("First combined resistance: %s", circuit1);
    }
}
