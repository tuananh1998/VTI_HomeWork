package ex1;

import java.util.Comparator;

public class NameComparator implements Comparator<employee> {

	@Override
	public int compare(employee o1, employee o2) {
		return o1.getFullname().compareTo(o2.getFullname());
	}

}
