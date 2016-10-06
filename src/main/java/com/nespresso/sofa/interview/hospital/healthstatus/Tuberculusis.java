package com.nespresso.sofa.interview.hospital.healthstatus;

import com.nespresso.sofa.interview.hospital.Patient;
import com.nespresso.sofa.interview.hospital.Treatement;

public class Tuberculusis extends HealthStatus {

	@Override
	public void changeState(Patient patient) {
		if (days >= 40 && traitements.contains(Treatement.ANTIBIOTIC)) {
			patient.setHealthStatus(new Healthy());
		}
		checkParacetamolPlusAspirin(patient);
	}

}
