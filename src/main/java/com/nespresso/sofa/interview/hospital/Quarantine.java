package com.nespresso.sofa.interview.hospital;

import java.util.List;

public class Quarantine {

	final List<Patient> patients;

	public Quarantine(String patients) {
		this.patients = PatientsFactory.create(patients);
	}

	public void wait40Days() {
		int days = 40;
		for (Patient patient : patients) {
			patient.addTimeInQuarantine(days);
		}
	}

	public void antibiotic() {
		applyTreatement(Treatement.ANTIBIOTIC);
	}

	public void insulin() {
		applyTreatement(Treatement.INSULIN);
	}

	public void paracetamol() {
		applyTreatement(Treatement.PARACETAMOL);

	}

	public void aspirin() {
		applyTreatement(Treatement.ASPIRIN);
	}

	private void applyTreatement(Treatement treatement) {
		for (Patient patient : patients) {
			patient.applyTreatement(treatement);
		}
	}
	
	public String report() {
		PatientCounter counter = new PatientCounter();
		counter.count(patients);
		return counter.report();
	}
}
