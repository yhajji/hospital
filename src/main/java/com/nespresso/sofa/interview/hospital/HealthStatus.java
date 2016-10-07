package com.nespresso.sofa.interview.hospital.healthstatus;

import java.util.ArrayList;
import java.util.List;

import com.nespresso.sofa.interview.hospital.Patient;
import com.nespresso.sofa.interview.hospital.Treatement;

public abstract class HealthStatus {
	protected final List<Treatement> traitements;
	protected int days;

	public HealthStatus() {
		traitements = new ArrayList<Treatement>();
		days = 0;
	}

	public void applyTraitement(Treatement traitement) {
		traitements.add(traitement);
	}

	public void addPeriod(int days) {
		this.days += days;
	}

	protected void checkParacetamolPlusAspirin(Patient patiant) {
		if (traitements.contains(Treatement.ASPIRIN) && traitements.contains(Treatement.PARACETAMOL)) {
			patiant.setHealthStatus(new Dead());
		}
	}

	public abstract void changeState(Patient patiant);
}
