package com.nespresso.sofa.interview.hospital;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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
    }

    public String report() {
        return "";
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
