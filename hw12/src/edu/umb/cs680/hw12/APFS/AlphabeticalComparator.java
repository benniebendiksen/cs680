package edu.umb.cs680.hw12.APFS;
import java.util.Comparator;

public class AlphabeticalComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement elem1, ApfsElement elem2) {
		return elem1.getName().compareTo(elem2.getName());
	}

}
