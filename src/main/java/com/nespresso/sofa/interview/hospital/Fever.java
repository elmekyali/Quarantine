package com.nespresso.sofa.interview.hospital;

public class Fever extends State {
    public Fever() {
        super("F");
    }

    @Override
    public State wait40Days(Patient patient) {
        return this;
    }

    @Override
    protected State aspirin(Patient patient) {
        patient.setUsingAspirin(true);
        if(patient.isUsingParacetamol()) return new Dead();
        return new Healthy();
    }

    @Override
    protected State paracetamol(Patient patient) {
        patient.setUsingParacetamol(true);
        if(patient.isUsingAspirin()) return new Dead();
        return new Healthy();
    }

    @Override
    protected State antibiotic(Patient patient) {
        patient.setUsingAntibiotic(true);
        return this;
    }

    @Override
    protected State insulin(Patient patient) {
        patient.setUsingInsulin(true);
        return this;
    }
}
