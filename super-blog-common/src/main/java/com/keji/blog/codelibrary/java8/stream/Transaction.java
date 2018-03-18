package com.keji.blog.codelibrary.java8.stream;

/**
 *
 * @author keji
 * @version $Id: Transaction.java, v 0.1 2018/3/18 下午2:57 keji Exp $
 */
public class Transaction {

	private Trader trader;
	private int year;
	private int value;

	public Transaction(Trader trader, int year, int value)
	{
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader(){ 
		return this.trader;
	}

	public int getYear(){
		return this.year;
	}

	public int getValue(){
		return this.value;
	}

	@Override
	public String toString(){
	    return "{" + this.trader + ", " +
	           "year: "+this.year+", " +
	           "value:" + this.value +"}";
	}
}