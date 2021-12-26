package edu.umb.cs680.hw12.APFS;
import java.util.Comparator;

public class ReverseAlphabeticalComparator implements Comparator<ApfsElement>{

	@Override
	public int compare(ApfsElement elem1, ApfsElement elem2) {
		return elem2.getName().compareTo(elem1.getName());
	}

}
