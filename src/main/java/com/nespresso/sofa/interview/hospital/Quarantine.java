package com.nespresso.sofa.interview.hospital;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Quarantine {

    private List<Patient> patients;
    private Map<String , Integer> patientCount = new LinkedHashMap<String , Integer>()
                                                {{put("F" , 0); put("H" , 0);put("D" , 0); put("T" , 0); put("X" , 0);}};


    public Quarantine(String patientTypes) {
        patients = Arrays.stream(patientTypes.split(",")).map(patientType -> {
            Patient patient = new Patient();
            patient.setFirstState(patientType);
            return patient;
        }).collect(Collectors.toList());
    }

    public String report() {

        for (Patient patient : patients) {
            String patientState = patient.toString();
            patientCount.put(patientState , patientCount.get(patientState) + 1);
        }

        return patientCount.entrySet().stream().map(x -> {
            return x.getKey() + ":" + x.getValue();
        }).collect(Collectors.joining(" "));
    }

    public void updatePatients(UnaryOperator<Patient> patientHealthStatusUpdater) {
        patients.forEach(patientHealthStatusUpdater::apply);
    }

    public void wait40Days() {
        updatePatients(Patient::wait40Days);
    }

    public void aspirin() {
        updatePatients(Patient::aspirin);
    }

    public void antibiotic() {
        updatePatients(Patient::antibiotic);
    }

    public void insulin() {
        updatePatients(Patient::insulin);
    }

    public void paracetamol() {
        updatePatients(Patient::paracetamol);
    }
}
