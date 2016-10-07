package com.nespresso.sofa.interview.hospital;

import java.util.ArrayList;
import java.util.List;

public class Patient {

	private HealthStatus healthStatus;
	private final List<Treatement> treatements = new ArrayList<>();

	public Patient(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

	public void apply(Treatement traitement) {
		treatements.add(traitement);
		if(treatements.contains(Treatement.ASPIRIN) && treatements.contains(Treatement.PARACETAMOL) ) this.healthStatus = HealthStatus.DEAD;
	}

	public void changeState() {
		this.healthStatus = healthStatus.next(treatements);
	}

	public boolean check(HealthStatus healthStatus) {
		return this.healthStatus == healthStatus;
	}

}
