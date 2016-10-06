package com.nespresso.sofa.interview.hospital;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.nespresso.sofa.interview.hospital.healthstatus.Dead;
import com.nespresso.sofa.interview.hospital.healthstatus.Diabetes;
import com.nespresso.sofa.interview.hospital.healthstatus.Fever;
import com.nespresso.sofa.interview.hospital.healthstatus.Healthy;
import com.nespresso.sofa.interview.hospital.healthstatus.Tuberculusis;

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
			if (patient.getHealthStatus() instanceof Fever)
				healthCounter.replace("F", healthCounter.get("F") + 1);
			else if (patient.getHealthStatus() instanceof Healthy)
				healthCounter.replace("H", healthCounter.get("H") + 1);
			else if (patient.getHealthStatus() instanceof Diabetes)
				healthCounter.replace("D", healthCounter.get("D") + 1);
			else if (patient.getHealthStatus() instanceof Tuberculusis)
				healthCounter.replace("T", healthCounter.get("T") + 1);
			else if (patient.getHealthStatus() instanceof Dead)
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
