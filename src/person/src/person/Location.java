package person;

import person.interfaces.Host;
import agent.Agent;
import agent.Role;

public class Location {

	public String building;
	Host contact;
	public enum LocationType {Restaurant, Bank, Market, Home};
	public LocationType type;
	private int x;
	private int y;
	
	Location(String buildingName, LocationType type, int id, int x, int y){
		
		this.building = buildingName;
		this.type = type;
		this.x = x;
		this.y = y;
		
	}
	Location(){
		
	}
	public Location(int x, int y, String bn){
		
		this.building = bn;
		this.x = x;
		this.y = y;
	}
	public Location(String bn, Host c, LocationType t, int x, int y){
		
		this.building = bn;
		this.contact = c;
		this.type = t;
		this.x = x;
		this.y = y;
		
	}
	public Location(String bn, LocationType t, int x, int y){
		
		this.building = bn;
		this.type = t;
		this.x = x;
		this.y = y;
		
	}
	void setX(int x){
		this.x = x;
	}
	void setY(int y){
		this.y = y;
	}
	void setType(LocationType type){
		this.type = type;
	}
	int getX(){
		return x;
	}
	int getY(){
		return y;
	}
	LocationType getType(){
		return type;
	}
	String getName(){
		return this.building;
	}
	

}
