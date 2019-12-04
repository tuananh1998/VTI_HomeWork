
public class Sedan extends Car {
	int length;

	double getSalePrice() {
		double Price = 0;
		if (length > 20) {
			Price = regularPrice * 0.95;
		} else
			Price = regularPrice * 0.9;
		return Price;
	}

	public Sedan(int speed, double regularPrice, String color, int length) {
		super(speed, regularPrice, color);
		this.length = length;
	};

	public Sedan() {
		super();
	}

}
