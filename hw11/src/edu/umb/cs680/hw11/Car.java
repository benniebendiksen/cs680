package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Car {

public LinkedList<Car> dominationList = new LinkedList<Car>();


	private String make, model;
	private int mileage, year;
	private float price;
	private int dominationCount = 0;
	
	protected Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
		this.dominationCount = dominationCount;

	}
	
	public void setDominationCount( ArrayList<Car> car){
		int ycv, pcv, mcv;
		Comparator<Car> PriceComparator = (Comparator<Car>) new PriceComparator();
		Comparator<Car> YearComparator = (Comparator<Car>) new YearComparator();	
		Comparator<Car> MileageComparator = (Comparator<Car>) new MileageComparator();
		

		if (car.size() > 1) {

			for (int i = 0; i < car.size(); i++) {
				
				ycv = YearComparator.compare(this, car.get(i));
				pcv = PriceComparator.compare(this, car.get(i));	
				mcv = MileageComparator.compare(this, car.get(i));	
			
				if((pcv >= 0 && mcv >= 0 &&  ycv >= 0) && (pcv > 0 || mcv > 0 || ycv > 0)) {
					this.dominationCount++;
				}
			}
		}
	}

	public String getMake() {
		return this.make;
	}
	public void setDomCount(int dCount) {
		this.dominationCount = dCount;
	}
	
	public String getModel() {
		return this.model;
	}

	public int getDomCount() {
		return this.dominationCount;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public float getPrice() {
		return this.price;
	}
		
	
	public int getDominationCount() {	
		return this.dominationCount;
	}
	
	
    public static void main(String args[]) {
		Car someCar = new Car("Dodge", "Journey", 90000, 2011, 10000);
		System.out.printf("Your car is a: \"%s\"\n", someCar.getMake());
	}
    

}