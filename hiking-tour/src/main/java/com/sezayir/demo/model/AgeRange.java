package com.sezayir.demo.model;

public class AgeRange {

	private int low;
	private int high;

	public AgeRange(int low, int high){
	    this.low = low;
	    this.high = high;
	}

	@Override
	public String toString() {
		return "AgeRange [low=" + low + ", high=" + high + "]";
	}

	public boolean contains(int age){
	    return (age >= low && age <= high);
	}


}
