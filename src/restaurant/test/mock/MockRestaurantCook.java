package restaurant.test.mock;

import java.util.List;

import market.Food;
import market.interfaces.MarketTruck;
import restaurant.interfaces.Cook;
import restaurant.interfaces.Waiter;

public class MockRestaurantCook extends Mock implements Cook{

	public MockRestaurantCook(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void msghereisorder(Waiter w, String choice, int table) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void msgHereisYourFood(MarketTruck t, List<Food> fList) {
		// TODO Auto-generated method stub
		
	}

}
