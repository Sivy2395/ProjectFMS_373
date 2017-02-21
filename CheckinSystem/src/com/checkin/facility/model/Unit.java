package com.checkin.facility.model;

import java.util.ArrayList;

public class Unit {
	private boolean occupied;
	private String name;
	private ArrayList<Person> occupants;
	private ArrayList<Maintenance> outstandingMaintenance;
	private ArrayList<Maintenance> previousMaintenance;
	public Unit(String name, boolean occupied){
		this.name = name;
		this.occupied = occupied;
		this.occupants = new ArrayList<Person>();
		this.outstandingMaintenance = new ArrayList<Maintenance>();
		this.previousMaintenance = new ArrayList<Maintenance>();
	}
	public String toString(){
		String rtn = name + " occupied:[" + occupied + "]" 
				+ (occupants.size() > 0 ? ",occupants:" : "");
		for(Person p : occupants){
			rtn += p.toString() + ",";
		}
		return rtn;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Person> getOccupants() {
		return occupants;
	}
	public void addOccupants(Person occupant) {
		this.occupants.add(occupant);
	}
	public ArrayList<Maintenance> getOutstandingMaintenance() {
		return outstandingMaintenance;
	}
	public void addOutstandingMaintenance(Maintenance outstandingMaintenance) {
		this.outstandingMaintenance.add(outstandingMaintenance);
	}
	public ArrayList<Maintenance> getPreviousMaintenance() {
		return previousMaintenance;
	}
	public void addPreviousMaintenance(Maintenance previousMaintenance) {
		this.previousMaintenance.add(previousMaintenance);
	}
}
