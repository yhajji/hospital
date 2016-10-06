package com.nespresso.sofa.interview.hospital.healthstatus;

import com.nespresso.sofa.interview.hospital.Patient;
import com.nespresso.sofa.interview.hospital.Treatement;

public class Diabetes extends HealthStatus {

	@Override
	public void changeState(Patient patient) {
		if (days >= 40 && !traitements.contains(Treatement.INSULIN)) {
			patient.setHealthStatus(new Dead());
		}
		checkParacetamolPlusAspirin(patient);
	}

}
