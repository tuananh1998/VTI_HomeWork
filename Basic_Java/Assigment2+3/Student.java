import java.time.LocalDate;
import java.util.Random;

public class Student {

	public static void main(String[] args) {
		String[] first = new String[] { "Nguyen", "Tran", "Can", "Tan", "Mai", "Le", "Cao" };
		String[] second = new String[] { "Van", "Thi", "Uy", "Thi1", "Thi2", "Thi3", "Thi4" };
		String[] last = new String[] { "Hanh", "Ha", "Tuan", "Toan", "Duy", "Phong", "Tu" };
		String[] hvt = new String[10];
		String[] id = new String[10];
		String[] birth = new String[10];
		int[] RA = new int[10];
		int[] SD = new int[10];
		int[] CP = new int[10];
		int[] CUT = new int[10];
		int[] FMT = new int[10];
		double[] AVG = new double[10];
		Random r = new Random();

		for (int i = 0; i < 10; i++) {
			int r1 = r.nextInt(7);
			int r2 = r.nextInt(7);
			int r3 = r.nextInt(7);
			int id1 = r.nextInt(999999 + 1) + 9999999;
			int minDay = (int) LocalDate.of(1900, 2, 1).toEpochDay();
			int maxDay = (int) LocalDate.of(2015, 12, 31).toEpochDay();
			long randomDay = minDay + r.nextInt(maxDay - minDay);
			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
			birth[i] = "" + randomBirthDate;
			hvt[i] = first[r1] + " " + second[r2] + " " + last[r3];
			id[i] = "SV" + id1;

		}

		Integer r4 = r.nextInt(10 - 8 + 1) + 8;
		Integer r5 = r.nextInt(7 - 5 + 1) + 5;
		Integer r6 = r.nextInt(4 - 3 + 1) + 3;
		Integer r7 = r.nextInt(2 - 1 + 1) + 1;
		Integer r8 = 0;
		SD[0] = r8;
		RA[0] = r4;
		CUT[0] = r8;
		CP[0] = r4;
		FMT[0] = r8;
		for (int i = 1; i < 4; i++) {
			SD[i] = r5;
			RA[i] = r5;
			CUT[i] = r5;
			CP[i] = r5;
			FMT[i] = r5;
		}
		for (int i = 4; i < 7; i++) {
			SD[i] = r6;
			RA[i] = r6;
			CUT[i] = r6;
			CP[i] = r6;
			FMT[i] = r6;
		}
		for (int i = 8; i < 10; i++) {
			SD[i] = r7;
			RA[i] = r7;
			CUT[i] = r7;
			CP[i] = r7;
			FMT[i] = r7;
		}
		SD[9] = r4;
		RA[9] = r8;
		CUT[9] = r4;
		CP[9] = r8;
		FMT[9] = r4;

		for (int i = 0; i < 10; i++) {
			AVG[i] = ((RA[i] + SD[i] + CP[i] + CUT[i] + FMT[i]) / 5);
		}

		for (int i = 0; i < 10; i++) {
			System.out.printf("%20s%15s%15s%12s%12s%12s%12s%12s%12s\n", hvt[i], id[i], birth[i], RA[i], SD[i], CP[i],
					CUT[i], FMT[i], AVG[i]);
		}

	}
}
