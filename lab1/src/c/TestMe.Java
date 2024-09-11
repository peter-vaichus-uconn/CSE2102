package c;

public class TestMe {
	private double value = Double.NaN;

	public static void main(String[] args) {
		System.out.println("Hello world!");
	}

	public TestMe() {}

	public double square() { return value*value; }
	public void setValue(double v) {
		value = v;
	}

}
// add source to class path
// @Test 
// public void squareTest()[
//     double miles = 41;
//     double gallons = 1.2
//     double expectedMPG = miles/gallons;
//     hybrid.setMilesfromGas(miles);
//     hybrid.setGallonsfromGas(gallons);

//     double actualMPG = hybrid.calculate
]