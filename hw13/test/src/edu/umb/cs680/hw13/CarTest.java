package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class CarTest {	
	private static ArrayList<Car> usedCars;
	private static ArrayList<Object> expected;
	private static ArrayList<Object> actual;
	private static ArrayList<Car> usedCarsDom;	

	@BeforeAll
	public static void intializeCars() {
		
		usedCars = new ArrayList<Car>();
		usedCars.add(new Car("Mercedes", "A", 200000, 2001, 900));
		usedCars.add(new Car("Audi", "A3", 150000, 2004, 200));
		usedCars.add(new Car("Honda", "Accord", 0, 2020, 25000));
		usedCars.add(new Car("Nissan", "Altima", 250000, 1998, 550));
		usedCars.add(new Car("Mazda", "Civic", 10000, 2000, 2100));
		usedCars.add(new Car("Nissan", "Ariya", 100001, 1999, 3000));	
	}
	

	@Test
	void verifyPriceComparator() {
		expected = new ArrayList<Object>();
		actual = new ArrayList<Object>();
		// comparing : Accepts a function that extracts a Comparable sort key from a type T,
		//  and returns a Comparator<T> that compares by that sort key.
		expected.addAll(Arrays.asList(200f, 550f, 900f, 2100f, 3000f, 25000f));		
		Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getPrice()));		
		for (Car car: usedCars) actual.add(car.getPrice());
		
		assertEquals(expected, actual);
	}
	
	@Test
	void verifyYearComparator() {
		expected = new ArrayList<Object>();
		actual = new ArrayList<Object>();
		
		expected.addAll(Arrays.asList(2020, 2004, 2001, 2000, 1999, 1998));
		Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getYear(), Comparator.reverseOrder()));
		for (Car car: usedCars) actual.add(car.getYear());
		
		assertEquals(expected, actual);
	}
	

	@Test
	void verifyMileageComparator() {
		expected = new ArrayList<Object>();
		actual = new ArrayList<Object>();
		
		expected.addAll(Arrays.asList(0, 10000, 100001, 150000, 200000, 250000));
		Collections.sort(usedCars, Comparator.comparing((Car car) -> car.getMileage()));
		for (Car car: usedCars) actual.add(car.getMileage());
		
		assertEquals(expected, actual);
	}
		

	@Test
	void verifyPareTo() {
		expected = new ArrayList<Object>();
		actual = new ArrayList<Object>();
		usedCarsDom = new ArrayList<Car>();

		usedCarsDom = new ArrayList<Car>();
		Car carA = new Car("Mercedes", "A", 2000, 2001, 900);
		Car carB = new Car("Audi", "A3", 150, 2004, 200);
		Car carC = new Car("Honda", "Accord", 0, 2020, 20);
		Car carD = new Car("Nissan", "Altima", 250000, 1998, 5500);
		Car carE = new Car("Mazda", "Civic", 10000, 2000, 2100);

		usedCarsDom.addAll(Arrays.asList(carA,carB,carC, carD, carE));
		expected.addAll(Arrays.asList(carC,carB, carA,carE, carD));
		for(Car car: usedCarsDom) car.setDominationCount(usedCarsDom);
		Collections.sort(usedCarsDom, Comparator.comparing((Car car) -> car.getDominationCount()));
		
		
		assertEquals(expected, usedCarsDom);

	}
}
