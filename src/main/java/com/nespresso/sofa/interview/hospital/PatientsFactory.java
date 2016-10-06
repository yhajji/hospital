package com.nespresso.sofa.interview.hospital;

import java.util.ArrayList;
import java.util.List;

import com.nespresso.sofa.interview.hospital.healthstatus.*;

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
			return new Patient(new Healthy());
		case 'F':
			return new Patient(new Fever());
		case 'D':
			return new Patient(new Diabetes());
		case 'T':
			return new Patient(new Tuberculusis());

		default:
			return new Patient(new Healthy());
		}
	}
}
