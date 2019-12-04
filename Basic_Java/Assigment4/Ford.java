
public class Ford extends Car {

	int year;
	int manufacturerDiscount;

	double getSalePrice() {
		double Price = regularPrice - manufacturerDiscount;
		return Price;
	};

	public Ford() {
		super();
	}

	public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.year = year;
		this.manufacturerDiscount = manufacturerDiscount;
	}

}
