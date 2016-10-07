package com.nespresso.sofa.interview.hospital;

import java.util.ArrayList;
import java.util.List;
import static com.nespresso.sofa.interview.hospital.HealthStatus.*;;



public class PatientsFactory {

	public static List<Patient> create(String input) {
		List<Patient> patients = new ArrayList<>();

		for (String character : input.split(",")) {
			patients.add(createPatient(character));
		}
		return patients;
	}

	private static Patient createPatient(String input) {
		switch (input.toCharArray()[0]) {
		case 'H':
			return new Patient(HEALTHY);
		case 'F':
			return new Patient(FEVER);
		case 'D':
			return new Patient(DIABETES);
		case 'T':
			return new Patient(TUBERCULUSIS);

		default:
			return new Patient(HEALTHY);
		}
	}
}
