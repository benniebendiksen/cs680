package edu.umb.cs680.hw13;

import java.util.Comparator;

public class MileageComparator implements Comparator<Car> {
	public int compare(Car car1, Car car2) {
		
		return (int) (car1.getMileage() - car2.getMileage());
	}
}
