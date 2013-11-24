package market.interfaces;

import java.util.List;

import market.*;

public interface MarketCashier {

	public abstract void msgHereisOrder(MarketCustomer customer, List<Food> food);

	public abstract void msgPayment(MarketCustomer customer, double m);

	public abstract void msgHereisProduct(MarketCustomer customer, List<Food> order);

	public abstract void msgGoToTable(MarketCustomer customer);
	// end of in market scenario

	public abstract void MsgIwantFood(Cook cook, CashAgent ca, List<Food> food);

	public abstract void msgBillFromTheAir(CashAgent ca, double money);
	
	public void msgTruckBack(MarketTruck t);
	
}