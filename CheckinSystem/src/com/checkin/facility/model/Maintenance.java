package com.checkin.facility.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.StringBuilder;

public class Maintenance {
	private int id;
	private String description;
	private int repairDays;
	private Person employee;
	private String comments;
	private double costs;
	private Date repairDate;
	public Maintenance(int id){
		this.setId(id);
		costs = 0;
	}
	public String toString(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Maintenance id:" + id);
		sb.append(",description:" + description);
		sb.append(",repairDays:" + repairDays);
		sb.append(", assigned_employee:" + (employee != null ? employee.toString() : "Craig Smith"));
		sb.append(",comments:" + comments);
		sb.append(",costs: " + costs);
		sb.append(",repairDate:" + (repairDate == null ? "Not set" : sdf.format(repairDate)));
		return sb.toString();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRepairDays() {
		return repairDays;
	}
	public void setRepairDays(int repairDays) {
		this.repairDays = repairDays;
	}
	public Person getEmployee() {
		return employee;
	}
	public void setEmployee(Person employee) {
		this.employee = employee;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public double getCosts() {
		return costs;
	}
	public void setCosts(double costs) {
		this.costs = costs;
	}
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public Date getRepairDate() {
		return repairDate;
	}
	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}
}
