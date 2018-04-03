package com.nespresso.sofa.interview.hospital;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static javax.swing.UIManager.put;

public class Quarantine {

    private List<Patient> patients;
    private Map<String , Integer> patientsCount = new LinkedHashMap<String , Integer>(){{
                                        put("F" , 0); put("H" , 0);put("D" , 0); put("T" , 0); put("X" , 0);}};


    public Quarantine(String patientsType) {

        patients = Arrays.stream(patientsType.split(",")).map(patientType -> {
            Patient patient = new Patient();
            patient.setFirstState(patientType);
            return patient;
        }).collect(Collectors.toList());

    }

    public String report() {

        for (Patient patient : patients) {
            String patientState = patient.toString();
            patientsCount.put(patientState , patientsCount.get(patientState) + 1);
        }

        String out = patientsCount.entrySet().stream().map(x -> {
            String outrange = x.getKey() + ":" + x.getValue();
            return outrange;
        }).collect(Collectors.joining(" "));

        return out;
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
