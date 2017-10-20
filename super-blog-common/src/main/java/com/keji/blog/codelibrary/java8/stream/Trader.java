package com.keji.blog.codelibrary.java8.stream;

/**
 * @author: wb-ny291824
 * @description
 * @date: Created in 2017/9/18
 * @modified: By:
 */
public  class Trader {
	
	private String name;
	private String city;

	public Trader(String n, String c){
		this.name = n;
		this.city = c;
	}

	public String getName(){
		return this.name;
	}

	public String getCity(){
		return this.city;
	}

	public void setCity(String newCity){
		this.city = newCity;
	}

	@Override
	public String toString(){
		return "Trader:"+this.name + " in " + this.city;
	}
}