
public class MyOwnAutoShop {

	public static void main(String[] args) {
		Sedan sedan = new Sedan(100, 5856, "Red", 25);
		Ford ford = new Ford(130, 6000, "Red", 1898, 20);
		Ford ford1 = new Ford(130, 9000, "Blue", 1858, 20);
		Car car = new Car(130, 9000, "Yellow");

		System.out.println("\n\tPrice sale sedan \t" + sedan.getSalePrice());
		System.out.println("\tPrice sale ford \t" + ford.getSalePrice());
		System.out.println("\tPrice sale ford1 \t" + ford1.getSalePrice());
		System.out.println("\tPrice sale Car  \t" + car.getSalePrice());
	}

}
