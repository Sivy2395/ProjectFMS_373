package com.checkin.facility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.checkin.facility.model.Facility;
import com.checkin.facility.model.Inspection;
import com.checkin.facility.model.Maintenance;
import com.checkin.facility.model.Person;
import com.checkin.facility.model.Unit;
import com.checkin.facility.view.FacilityClient;

public class TestMain {
	public static void main(String [] args){
		// creating a FacilityClient
		FacilityClient fc = new FacilityClient();
		
		// creating a facility f1
		Facility f1 = new Facility(1);
		f1.setAddress("1209 W. Arthur Ave. Chicago IL 60626");
		f1.setDescription("Condo Building");
		f1.setName("The Morgan at Loyola Station");
		
		Unit u1 = new Unit("Room 101", true);
		u1.addOccupants(new Person("Chris", "Elliot"));
		Person p2 = new Person("Neil", "Christensen");
		p2.setPrimaryOccupant(true);
		u1.addOccupants(p2);
		Unit u2 = new Unit("Room 102", false);
		Unit u3 = new Unit("Room 103", false);
		f1.addUnit(u1);
		f1.addUnit(u2);
		f1.addUnit(u3);
		// --- end of creating a facility f1
		
		// creating a facility f2
		Facility f2 = new Facility(2);
		f2.setAddress("1040 W. Granville Ave. Chicago IL 60626");
		f2.setDescription("Apartment Building");
		f2.setName("The Sovereign");
		
		Unit u4 = new Unit("Room 101", false);
		Unit u5 = new Unit("Room 102", false);
		Unit u6 = new Unit("Room 103", false);
		f2.addUnit(u4);
		f2.addUnit(u5);
		f2.addUnit(u6);
		// --- end of creating a facility f2

		// --------------- Facility related testing
		fc.addNewFacility(f1);
		ArrayList<Facility> facilities = fc.listFacilities();
		fc.getFacilityInformation(f1);
		int availableCapacity = fc.requestAvailableCapacity(f1);
		fc.addFacilityDetail(f1, "This is the new description for f1");
		fc.getFacilityInformation(f1);
		// removing facility with id 1, i.e. f1
		fc.removeFacility(1);
		fc.listFacilities();
		
		// add f1 and f2 back
		fc.addNewFacility(f1);
		fc.addNewFacility(f2);
		fc.listFacilities();
		
		// --------------- Facility Use related testing
		boolean inUse = fc.isInUseDuringInterval(f1);
		System.out.println("f1 is " + (inUse ? "in use" : "not in use"));
		boolean inUse2 = fc.isInUseDuringInterval(f2);
		System.out.println("f2 is " + (inUse2 ? "in use" : "not in use"));
		
		fc.assignFacilityToUse(f2, "Apartment building currently renting units");
		System.out.println("Printing the usage of f2 : " + f2.getCurUsage());
		// uncomment if you want to vacate everyone from f1
		// fc.vacateFacility(f1);
		fc.listInspections(f1);
		// creating a new inspection
		Inspection ins = new Inspection();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		try {
			ins.setDate(sdf.parse("01/26/1990"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ins.setDescription("Fire inspection");
		// end of creating a inspection
		f1.addInspection(ins);
		fc.listInspections(f1);
		int usage = fc.listActualUsage(f1);
		double usageRate = fc.calcUsageRate(f1);
		fc.listActualUsage(f2);
		fc.calcUsageRate(f2);
		
		// ------------ maintenance related testing
		Maintenance m1 = new Maintenance(1);
		m1.setCosts(66);
		m1.setDescription("Toilet leaking");
		fc.makeFacilityMaintRequest(u1, m1);
		try {
			fc.scheduleMaintenance(m1, sdf.parse("22/2/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fc.calcMaintenanceCostForFacility(f1);
		Maintenance m2 = new Maintenance(2);
		m2.setCosts(33);
		m2.setDescription("Heating problem");
		m2.setRepairDays(1);
		fc.makeFacilityMaintRequest(u2, m2);
		try {
			fc.scheduleMaintenance(m2, sdf.parse("23/2/2017"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double costs = fc.calcMaintenanceCostForFacility(f1);
		double unitToBeRepaired = fc.calcProblemRateForFacility(f1);
		double downTime1 = fc.calcDownTimeForFacility(u1);
		double downTime = fc.calcDownTimeForFacility(u2);
		Maintenance m3 = new Maintenance(3);
		m3.setDescription("AC problem");
		fc.makeFacilityMaintRequest(u2, m3);
		ArrayList<Maintenance> maintenancesForUnit2 = fc.listMaintRequests(u2);
		fc.listMaintRequests(u3);
		fc.listMaintenance(u2);
		ArrayList<Maintenance> facilityOutstandingMaintenance = fc.listFacilityProblems(f1);
		fc.listFacilityProblems(f2);
	}
}
