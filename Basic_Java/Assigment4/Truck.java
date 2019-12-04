
public class Truck extends Car {
	int weight;

	Truck() {
		super();
	}

	Truck(int speed, double regularPrice, String color, int weight) {
		super(speed, regularPrice, color);
		this.weight = weight;
		//
	}

	double getSalePrice() {
		double Price = 0;
		if (weight > 2000) {
			Price = regularPrice * 0.1;
		} else
			Price = regularPrice;
		return Price;
	}

}
