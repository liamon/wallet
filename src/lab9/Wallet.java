package lab9;

import java.util.ArrayList;
import java.util.Collections;

public class Wallet {
	private String name;
	private ArrayList<Currency> currencies;
	private Converter converter;
	
	public Wallet(String name) {
		this.name = name;
		currencies = new ArrayList<Currency>();
		converter = new Converter();
	}
	public void addCurrency(Currency currency){
		currencies.add(currency);
		converter.setEuroValue(currency);
	}
	
	/*
	 * This method calculates and returns the total Euro value of 
	 * each currency in the wallet
	*/
	public double getTotalEuroValue(){
		double totalEuroValue = 0;
		for (Currency c : currencies) {
			totalEuroValue += c.getEuroValue();
		}
		return totalEuroValue;
	}
	
	/*
	 * This method sorts the currencies in ascending order according to their euro Values
	*/
	public void sort(){
		Collections.sort(currencies);
	}
	
	@Override
	/*
	 * The toString() method returns a String value of each currency and its amount in the wallet
	 * each currency- amount pair is separated by a comma
	 * e.g. USD:100,CAD:250,GBP:99,AUD:123
	 * 
	*/
	public String toString(){
		String string = "";
		for (Currency c : currencies) {
			if (string.length() > 0) { // So comma is not added first time around but is afterwards
				string += ",";
			}
			string += c.getCurrencyName() + ":" + c.getAmount();
		}
		return string;
	}
	
}
