package lab9;

public abstract class Currency implements Comparable<Currency> {

	protected String country; // e.g. Canada
	protected String currencyName; // Canadian Dollar
	protected double amount; // e.g. 100.0
	protected double euroValue; // e.g. 70.03 (the value in euros)

	public String getCountry(){
		return this.country;
	}
	
	public String getCurrencyName(){
		return this.currencyName;
	}
	
	public double getAmount(){
		return amount;
	}
	
	public void setAmount(double amt) {
		if(amt < 0){
			throw new IllegalArgumentException("amount cannot be less than zero: " + amt);
		}
		this.amount = amt;
	}
	public double getEuroValue(){
		return this.euroValue;
	}
	
	public void setEuroValue(double val){
		this.euroValue = val;
	}
	
	@Override
	public int compareTo(Currency o) {	
		if (euroValue > o.getEuroValue()) {
			return 1;
		} else if (euroValue < o.getEuroValue()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}
