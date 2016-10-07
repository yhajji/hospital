package com.nespresso.sofa.interview.hospital;


import java.util.List;

public enum HealthStatus {
	
	DIABETES ('D'){
		@Override
		public HealthStatus next(List<Treatement> treatements) {
			if(treatements.contains(Treatement.INSULIN)) {
				return this;
			}
			return DEAD;
		}
	}, HEALTHY('H') {
		@Override
		public HealthStatus next(List<Treatement> treatements) {
			if(treatements.contains(Treatement.ANTIBIOTIC) && treatements.contains(Treatement.INSULIN)) {
				return FEVER;
			}
			return this;
		}
	},
	DEAD('X') {
		@Override
		public HealthStatus next(List<Treatement> treatements) {
			return this;
		}
	},
	FEVER('F') {
		@Override
		public HealthStatus next(List<Treatement> treatements) {
			if(treatements.contains(Treatement.PARACETAMOL) || treatements.contains(Treatement.ASPIRIN)) {
				return HEALTHY;
			}
			return this;
		}
	},
	TUBERCULUSIS('T') {
		@Override
		public HealthStatus next(List<Treatement> treatements) {
			if(treatements.contains(Treatement.ANTIBIOTIC)) {
				return HEALTHY;
			}
			return this;
		}
	};
	
	private final char code;
	
	private HealthStatus(char code) {
		this.code = code;
	}

	public abstract HealthStatus next(List<Treatement> treatements);
	
	@Override
	public String toString() {
		return String.valueOf(code);
	}
}
