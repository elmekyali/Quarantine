package com.nespresso.sofa.interview.hospital;

public class Healthy extends State {
    public Healthy() {
        super("H");
    }

    @Override
    protected void updateState(Patient patient) {
        if (patient.isUsingParacetamol() && patient.isUsingAspirin())
            patient.setPatientState(new Dead());
        else if (patient.isUsingInsulin() && patient.isUsingAntibiotic()) {
            patient.setPatientState(new Fever());
        }
    }

}
