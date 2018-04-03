package com.nespresso.sofa.interview.hospital;

public class Tuberculosis extends State {
    public Tuberculosis() {
        super("T");
    }

    @Override
    protected void updateState(Patient patient) {
        if (patient.isUsingParacetamol() && patient.isUsingAspirin())
            patient.setPatientState(new Dead());
        else if (patient.isUsingAntibiotic()) {
            patient.setPatientState(new Healthy());
            patient.setUsingAntibiotic(false);
        }
    }


}
