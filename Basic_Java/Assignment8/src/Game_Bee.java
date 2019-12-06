import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game_Bee {
	public static void creatBee(List<Bee> arrBee, Random r) {
		arrBee.clear();
		int ran = r.nextInt(2);
		if (ran == 0) {
			arrBee.add(new Worker());
		} else if (ran == 1) {
			arrBee.add(new Qeen());
		} else {
			arrBee.add(new Drone());
		}
		for (Bee bee2 : arrBee) {
			System.out.println(bee2.toString() + " " + bee2.getHealth());

		}
	}

	public static void attackBee(List<Bee> arrBee, Random r) {
		String status = "";
		for (Bee bee2 : arrBee) {
			int ran = r.nextInt(81);
			bee2.Damage(ran);
			if (bee2.CheckHealthStatus())
				status = "died";
			System.out.println(bee2.toString() + "\t " + bee2.getHealth() + "\t " + status);

		}
	}

	public static void main(String[] args) {
		List<Bee> arrBee = new ArrayList<Bee>();
		int key = 0;
		Random r = new Random();
		boolean kt = false;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			arrBee.add(new Worker());
			arrBee.add(new Qeen());
			arrBee.add(new Drone());
		}
		do {
			System.out.println("Game BEE");
			System.out.println("1. Create Bee");
			System.out.println("2. Attack Bee");
			System.out.println("3. Exit");
			System.out.println("Choose option!");
			try {
				key = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Wrong format!!!");
				key = Integer.parseInt(sc.nextLine());
			}
			switch (key) {
			case 1: {
				creatBee(arrBee, r);
				kt = true;
				break;
			}
			case 2: {

				attackBee(arrBee, r);
				kt = true;
				break;
			}
			case 3: {

				kt = false;
				break;
			}
			default: {
				System.out.println("Wrong, Please choose true format!");
				kt = true;
			}

			}
		} while (kt == true);

	}

}
