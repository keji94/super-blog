package com.keji.blog.codelibrary.java8.stream;

/**
 *
 * @author keji
 * @version $Id: Trader.java, v 0.1 2018/3/18 下午2:55 keji Exp $
 */
public class Trader {
	
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