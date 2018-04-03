package com.nespresso.sofa.interview.hospital;

public class Fever extends State {
    public Fever() {
        super("F");
    }

    @Override
    protected void updateState(Patient patient) {
        if (patient.isUsingParacetamol() && patient.isUsingAspirin())
            patient.setPatientState(new Dead());
        else if (patient.isUsingAspirin() || patient.isUsingParacetamol()) {
            patient.setPatientState(new Healthy());
        }
    }

}
