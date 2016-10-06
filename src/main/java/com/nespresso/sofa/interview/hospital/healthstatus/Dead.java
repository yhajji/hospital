package com.nespresso.sofa.interview.hospital.healthstatus;

import com.nespresso.sofa.interview.hospital.Patient;

public class Dead extends HealthStatus {

	@Override
	public void changeState(Patient patiant) {
		patiant.setHealthStatus(this);
	}

}
