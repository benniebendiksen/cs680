package edu.umb.cs680.hw13;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {
	
	public int compare(Car car1, Car car2) {
		
		return (int) (car1.getDominationCount() - car2.getDominationCount());
	}
}

