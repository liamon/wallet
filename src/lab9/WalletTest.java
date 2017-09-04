package lab9;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WalletTest {
	
	Wallet myWallet = new Wallet("my trip");
	
	Currency usDollars;
	Currency canDollars;
	Currency sterling;
	Currency ausDollars;


	@Before
	public void setUp() throws Exception {
		
		usDollars = new USD(100);
		canDollars = new CAD(250);
		sterling = new GBP(99);
		ausDollars = new AUD(123);

		myWallet.addCurrency(usDollars);
		myWallet.addCurrency(canDollars);
		myWallet.addCurrency(sterling);
		myWallet.addCurrency(ausDollars);
	}
	
	@Test
	public void testConversion(){
		
		Converter converter= new Converter();
		converter.setEuroValue(usDollars);
		assertEquals(100*0.66, usDollars.getEuroValue(), 0.001);
	}

	
	@Test
	public void testGetTotalEuroValue() {
		
		double expected = 100 * 0.66 + 250 * 0.7 + 99 *1.4 + 123 * 0.93;
		double actual = myWallet.getTotalEuroValue();	
		assertEquals(expected, actual, 0.00001);	
	}

	@Test
	public void testSort() {
		
		myWallet.sort();
		
		String wallet = myWallet.toString(); // get some output
		String[] currencies = wallet.split(","); // splits the String into an array of String entries in the form USD:100
		
		assertEquals("USD:100.0",currencies[0]);
		assertEquals("AUD:123.0",currencies[1]);
		assertEquals("GBP:99.0",currencies[2]);
		assertEquals("CAD:250.0",currencies[3]);
	}

	

}
