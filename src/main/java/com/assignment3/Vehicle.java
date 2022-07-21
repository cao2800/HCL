package com.assignment3;

import java.util.Scanner;

class Vehicle {
	
	int vehicleNumber;
	String vehicleModel;
	String manufacturer;
	String color;
	
	Vehicle(int vehicleNumber, String vehicleModel, String manufacturer, String color) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleModel = vehicleModel;
		this.manufacturer = manufacturer;
		this.color = color;
	}


	public static class Truck extends Vehicle {
		int loadCapacity;
		
		Truck(int vehicleNumber, String vehicleModel, String manufacturer, String color, int loadCapacity) {
			super(vehicleNumber, vehicleModel, manufacturer, color);
			this.loadCapacity = loadCapacity;
		}
		
		public void print() {
			System.out.println("Vehicle Number is: " + vehicleNumber);
			System.out.println("Vehicle Model is: " + vehicleModel);
			System.out.println("Vehicle Manufacturer is: " + manufacturer);
			System.out.println("Vehicle Color is: " + color);
			System.out.println("Vehicle Loading Capacity is: " + loadCapacity + " tons");
		}
		
	}
	

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter a Truck Number: ");
		int truckNumber = scnr.nextInt();
		
		System.out.println("Enter a Truck Model: ");
		String truckModel = scnr.next();
		
		System.out.println("Enter a Truck Manufacturer: ");
		String truckManufacturer = scnr.next();
		
		System.out.println("Enter a Truck Color: ");
		String truckColor = scnr.next();
		
		System.out.println("Enter the Loading Capacity for the Truck (MAX 100 TONS)");
		int truckCapacity = scnr.nextInt();
		
		Truck truck = new Truck(truckNumber, truckModel, truckManufacturer, truckColor, truckCapacity);
		System.out.println("Truck Details");
		truck.print();
		scnr.close();
		
	}
}
