package com.nespresso.sofa.interview.hospital;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.nespresso.sofa.interview.hospital.HealthStatus.*;

public class PatientCounter {

	private Map<String, Integer> healthCounter;

	public PatientCounter() {
		healthCounter = new LinkedHashMap<String, Integer>();
		healthCounter.put("F", 0);
		healthCounter.put("H", 0);
		healthCounter.put("D", 0);
		healthCounter.put("T", 0);
		healthCounter.put("X", 0);
	}

	public void count(List<Patient> patients) {
		for (Patient patient : patients) {
			if (patient.check(FEVER))
				healthCounter.replace("F", healthCounter.get("F") + 1);
			else if (patient.check(HEALTHY))
				healthCounter.replace("H", healthCounter.get("H") + 1);
			else if (patient.check(DIABETES))
				healthCounter.replace("D", healthCounter.get("D") + 1);
			else if (patient.check(TUBERCULUSIS))
				healthCounter.replace("T", healthCounter.get("T") + 1);
			else if (patient.check(DEAD))
				healthCounter.replace("X", healthCounter.get("X") + 1);
		}
	}

	public String report() {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : healthCounter.entrySet()) {
			builder.append(entry.getKey()).append(":").append(entry.getValue()).append(" ");
		}
		return builder.toString().replaceAll(" $", "");
	}

}
