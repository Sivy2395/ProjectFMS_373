package com.checkin.facility.model;

import java.util.ArrayList;
import java.lang.StringBuilder;

public class Facility {
	private int id;
	private ArrayList<Unit> units;
	private String name;
	private String description;
	private String address;
	// default to empty string "", empty string means there is no usage message.
	private String curUsage;
	private ArrayList<Inspection> inspections;
	
	public Facility(int id){
		this.id = id;
		units = new ArrayList<Unit>();
		inspections = new ArrayList<Inspection>();
		this.curUsage = "";
	}
	public void addUnit(Unit unit){
		units.add(unit);
	}
	public void printUnits(){
		for(Unit u : units){
			System.out.println(u.toString());
		}
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Facility:" + name);
		sb.append(",address:" + address);
		sb.append(",description:" + description);
		sb.append(",units:");
		for(Unit u : units){
			sb.append("{" + u.toString() + "}");
		}
		return sb.toString();
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Unit> getUnits() {
		return units;
	}
	public String getCurUsage() {
		return curUsage;
	}
	public void setCurUsage(String curUsage) {
		this.curUsage = curUsage;
	}
	public ArrayList<Inspection> getInspections() {
		return inspections;
	}
	public void addInspection(Inspection inspection) {
		this.inspections.add(inspection);
	}
}
