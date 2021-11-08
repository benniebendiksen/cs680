package edu.umb.cs680.hw05;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

import org.junit.jupiter.api.Test;


class CarTest {	
	private String[] carToStringArray(Car c) {
		String[] carInfo = {c.getMake(),
							c.getModel(),
							String.valueOf(c.getYear()) };
		return carInfo;
	}

	@Test
	void verifyCarEqualityWithMakeModelYear() {
		String[] strArray = {"Dodge", "Journey", "2011"};
		Car someCar  = new Car("Dodge", "Journey", 90000, 2011, 10000);
		assertArrayEquals(strArray, carToStringArray(someCar));
	}
}
