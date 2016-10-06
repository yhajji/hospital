package com.nespresso.sofa.interview.hospital;

import com.nespresso.sofa.interview.hospital.healthstatus.HealthStatus;

public class Patient {

	private HealthStatus healthStatus;

	public Patient(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public void setHealthStatus(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}

	public void addTimeInQuarantine(int days) {
		healthStatus.addPeriod(days);
		healthStatus.changeState(this);
	}

	public void applyTreatement(Treatement traitement) {
		healthStatus.applyTraitement(traitement);
		healthStatus.changeState(this);
	}

}
