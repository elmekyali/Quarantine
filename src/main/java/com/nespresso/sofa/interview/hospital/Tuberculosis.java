package com.nespresso.sofa.interview.hospital;

public class Tuberculosis extends State {
    public Tuberculosis() {
        super("T");
    }

    @Override
    public State wait40Days(Patient patient) {
        return this;
    }

    @Override
    protected State aspirin(Patient patient) {
        patient.setUsingAspirin(true);
        if(patient.isUsingParacetamol()) return new Dead();
        return this;
    }

    @Override
    protected State antibiotic(Patient patient) {
        return new Healthy();
    }

    @Override
    protected State insulin(Patient patient) {
        return this;
    }

    @Override
    protected State paracetamol(Patient patient) {
        patient.setUsingParacetamol(true);
        if(patient.isUsingAspirin()) return new Dead();
        return this;
    }
}
