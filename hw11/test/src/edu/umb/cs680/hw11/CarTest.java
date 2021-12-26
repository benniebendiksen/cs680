package edu.umb.cs680.hw11;

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
	private static ArrayList<Car> oldCars;	

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
	
	


	public void newArrays() {
		expected = new ArrayList<Object>();
		actual = new ArrayList<Object>();
	}

	@Test
	void verifyPriceComparator() {
		newArrays();
				
		expected.addAll(Arrays.asList(200f, 550f, 900f, 2100f, 3000f, 25000f));		
		Collections.sort(usedCars, new PriceComparator());		
		for (Car car: usedCars) actual.add(car.getPrice());
		
		assertEquals(expected, actual);
	}
	
	@Test
	void verifyYearComparator() {
		newArrays();
		
		expected.addAll(Arrays.asList(2020, 2004, 2001, 2000, 1999, 1998));
		Collections.sort(usedCars, new YearComparator());
		for (Car car: usedCars) actual.add(car.getYear());
		
		assertEquals(expected, actual);
	}
	

	@Test
	void verifyMileageComparator() {
		newArrays();
		
		expected.addAll(Arrays.asList(0, 10000, 100001, 150000, 200000, 250000));
		Collections.sort(usedCars, new MileageComparator());
		for (Car car: usedCars) actual.add(car.getMileage());
		
		assertEquals(expected, actual);
	}
		

	@Test
	void verifyPareTo() {
		newArrays();
		oldCars = new ArrayList<Car>();

		Car carA = new Car("Dodge", "Journey", 30000, 2005, 100);
		Car carB = new Car("Mazda", "Tribute", 45000, 1999, 55000);
		Car carC = new Car("Jeep", "Liberty", 150000, 1999, 550000);
		Car carD = new Car("Nissan", "Ultima", 25000, 2001, 55000);
		Car carE = new Car("Jeep", "Wrangler", 10000, 2001, 55000);
		Car carF = new Car("Volkswagon", "Beetle", 0, 2020, 0);

		
		oldCars.addAll(Arrays.asList(carA,carC, carD,carE, carB, carF));
		expected.addAll(Arrays.asList(carF,carA, carE,carD, carB, carC));
		
		
		for(Car car: oldCars) car.setDominationCount(oldCars);
		Collections.sort(oldCars, new ParetoComparator());

		
		assertEquals(expected, oldCars);

	}
}
