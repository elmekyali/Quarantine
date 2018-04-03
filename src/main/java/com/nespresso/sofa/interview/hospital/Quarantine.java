package com.nespresso.sofa.interview.hospital;

import java.util.*;
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

    public void wait40Days() {
        for (Patient patient : patients) {
            State newState = patient.getPatientState().wait40Days(patient);
            patient.setPatientState(newState);
        }
    }

    public void aspirin() {
        for (Patient patient : patients) {
            State newState = patient.getPatientState().aspirin(patient);
            patient.setPatientState(newState);
        }
    }

    public void antibiotic() {
        for (Patient patient : patients) {
            State newState = patient.getPatientState().antibiotic(patient);
            patient.setPatientState(newState);
        }
    }

    public void insulin() {
        for (Patient patient : patients) {
            State newState = patient.getPatientState().insulin(patient);
            patient.setPatientState(newState);
        }
    }

    public void paracetamol() {
        for (Patient patient : patients) {
            State newState = patient.getPatientState().paracetamol(patient);
            patient.setPatientState(newState);
        }
    }
}
