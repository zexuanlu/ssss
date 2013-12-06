package restaurant6.gui;

import restaurant6.Restaurant6CustomerRole;
import restaurant6.Restaurant6HostRole;
import restaurant6.Restaurant6Table;
import restaurant6.Restaurant6WaiterRole;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import agent.Gui;

public class Restaurant6CustomerGui implements Gui{

	private Restaurant6CustomerRole agent = null;
	private boolean isPresent = false;
	private boolean isHungry = false;
	private boolean isEating = false;
	private boolean hasOrdered = false;
	Random waitingSpotGenerator = new Random(); // To determine random amount of money

	private Restaurant6HostRole host = new Restaurant6HostRole("Sarah");
	//RestaurantGui gui;

	private int xPos, yPos;
	private int xDestination, yDestination;
	private String foodChoice;
	private enum Command {noCommand, GoToSeat, LeaveRestaurant};
	private Command command=Command.noCommand;

	public int tableXPos = 50;
	public int tableYPos = 50;
	
	private final int pickUpX = 10;
	private final int pickUpY = 250;
	
	private int waitingX;
	private int waitingY;

	public Restaurant6CustomerGui(Restaurant6CustomerRole c) { //, RestaurantGui gui){ //HostAgent m) {
		agent = c;
		xPos = -40;
		yPos = -40;
		xDestination = -40;
		yDestination = -40;
		//this.gui = gui;
	}

	// Generate random waiting spot
	public int generateWaitingSpot(int max, int min) {
		int r = waitingSpotGenerator.nextInt((max - min) + 1) + min;
		return r; 
	}
	
	public void updatePosition() {
		if (xPos < xDestination)
			xPos++;
		else if (xPos > xDestination)
			xPos--;

		if (yPos < yDestination)
			yPos++;
		else if (yPos > yDestination)
			yPos--;

		if (xPos == xDestination && yPos == yDestination) {
			if (command==Command.GoToSeat) 
				agent.msgAnimationFinishedGoToSeat();
			else if (command==Command.LeaveRestaurant) 
			{
				agent.msgAnimationFinishedLeaveRestaurant();
				//System.out.println("about to call gui.setCustomerEnabled(agent);");
				isHungry = false;
				//gui.setCustomerEnabled(agent);
			}
			command=Command.noCommand;
		}
		
		if (xPos == 20 && yPos == 50) {
			agent.msgAtCashier();
		}
		
		if (xPos == pickUpX && yPos == pickUpY) {
			agent.msgAtPickupSpot();
		}
	}

	public void draw(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fillRect(xPos, yPos, 20, 20);
	}
	
	// Draws if the customer has ordered
	public void drawOrdered(Graphics2D g) {
		g.setColor(Color.BLACK);
		
		String choice = agent.getChoice();
		foodChoice = choice.substring(0, 2) + "?";
		
		g.fillRect(xPos, yPos, 20, 20);
		g.drawString(foodChoice, xPos, yPos);
	}
	
	// Draws the customer is eating
	public void drawEating(Graphics2D g) {
		g.setColor(Color.BLACK);
		
		String choice = agent.getChoice();
		foodChoice = choice.substring(0, 2);
		
		g.fillRect(xPos, yPos, 20, 20);
		g.drawString(foodChoice, xPos, yPos);
	}

	public boolean isPresent() {
		return isPresent;
	}
	
	public boolean isEating() {
		return isEating;
	}
	
	public void setEating(boolean p) {
		isEating = p;
	}
	
	public boolean hasOrdered() {
		return hasOrdered;
	}
	
	public void setOrdered(boolean p) {
		hasOrdered = p;
	}
	
	public void setHungry() {
		isHungry = true;
		agent.gotHungry();
		setPresent(true);
	}
	
	public boolean isHungry() {
		return isHungry;
	}

	public void setPresent(boolean p) {
		isPresent = p;
	}

	public void DoGoToSeat(int seatnumber) {
		for (Restaurant6Table t : host.tables) {
				if (t.getTableNum() == seatnumber) {
					xDestination = t.getXPos();
					yDestination = t.getYPos();
				}
		}
		command = Command.GoToSeat;
	}
	
	public void DoGoToRestaurant() {
		xDestination = -30;
		yDestination = -30;
	}
	
	public void DoGoToWaitingArea() {
		xDestination = generateWaitingSpot(130, 45);
		yDestination = generateWaitingSpot(180, 45);
	}
	
	public void DoGoToPickupSpot() {
		xDestination = pickUpX;
		yDestination = pickUpY;
	}
	
	public void DoGoToCashier() {
		xDestination = 20;
		yDestination = 50;
	}

	public void DoExitRestaurant() {
		xDestination = -40;
		yDestination = -40;
		command = Command.LeaveRestaurant;
	}
}