package com.nespresso.sofa.interview.hospital;

public class Diabetes extends State{

    public Diabetes() {
        super("D");
    }

    @Override
    public State wait40Days(Patient patient) {
        if (patient.isUsingInsulin()) return this;
        return new Dead();
    }

    @Override
    protected State aspirin(Patient patient) {
        patient.setUsingAspirin(true);
        if(patient.isUsingParacetamol()) return new Dead();
        return this;
    }

    @Override
    protected State paracetamol(Patient patient) {
        patient.setUsingParacetamol(true);
        if(patient.isUsingAspirin()) return new Dead();
        return this;
    }

    @Override
    protected State antibiotic(Patient patient) {
        return this;
    }

    @Override
    protected State insulin(Patient patient) {
        patient.setUsingInsulin(true);
        return this;
    }
}
