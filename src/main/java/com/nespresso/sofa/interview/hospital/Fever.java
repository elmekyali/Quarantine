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
        patient.setUsedAspirin(true);
        if(patient.isUsedParacetamol()) return new Dead();
        return new Healthy();
    }

    @Override
    protected State paracetamol(Patient patient) {
        patient.setUsedParacetamol(true);
        if(patient.isUsedAspirin()) return new Dead();
        return new Healthy();
    }

    @Override
    protected State antibiotic(Patient patient) {
        patient.setUsedAntibiotic(true);
        return this;
    }

    @Override
    protected State insulin(Patient patient) {
        patient.setUsedInsulin(true);
        return this;
    }
}
