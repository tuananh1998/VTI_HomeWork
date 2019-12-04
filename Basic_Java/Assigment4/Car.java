public class Car {
	int speed;
	double regularPrice;
	String color;

	double getSalePrice() {
		return regularPrice;
	}

	public Car(int speed, double regularPrice, String color) {
		this.speed = speed;
		this.regularPrice = regularPrice;
		this.color = color;
	}

	public Car() {

	}

};
