package com.nespresso.sofa.interview.hospital;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quarantine {

    List<Patient> patients;

    public Quarantine(String patientsType) {

        patients = Arrays.stream(patientsType.split(",")).map(patientType -> {
            Patient patient = new Patient();
            patient.setFirstState(patientsType);
            patient.setPatientNumber(1);
            return patient;
        }).collect(Collectors.toList());

        Patient deadPatient = new Patient().setFirstState("X");
        deadPatient.setPatientNumber(0);
        patients.add(deadPatient);

    }

    public String report() {
        String out = "";
        Set<Patient> uniqueSet = new HashSet<Patient>(patients);
        for (Patient temp : uniqueSet) {
            out += temp + ":" + Collections.frequency(patients, temp) + " ";
        }
        return out;
    }

    public void wait40Days() {
    }

    public void aspirin() {
    }

    public void antibiotic() {
    }

    public void insulin() {
    }

    public void paracetamol() {
    }
}
