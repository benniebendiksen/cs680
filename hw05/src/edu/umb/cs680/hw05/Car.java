package edu.umb.cs680.hw05;

public class Car {
	private String make, model;
	private int mileage, year;
	private float price;
	
	//sets private atrributes
	protected Car(String make, String model, int mileage, int year, float price) {
		this.make = make;
		this.model = model;
		this.mileage = mileage;
		this.year = year;
		this.price = price;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
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
	
    public static void main(String args[]) {
		Car someCar = new Car("Dodge", "Journey", 90000, 2011, 10000);
		System.out.printf("Your car is a: \"%s\"\n", someCar.getMake());


    }
}	
