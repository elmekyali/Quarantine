package com.nespresso.sofa.interview.hospital;

public class Healthy extends State {
    public Healthy() {
        super("H");
    }

    @Override
    public State wait40Days(Patient patient) {
        if(patient.isUsedInsulin() && patient.isUsedAntibiotic()) return new Fever();
        return this;
    }

    @Override
    protected State aspirin(Patient patient) {
        patient.setUsedAspirin(true);
        if(patient.isUsedParacetamol()) return new Dead();
        return this;
    }

    @Override
    protected State paracetamol(Patient patient) {
        patient.setUsedParacetamol(true);
        if(patient.isUsedAspirin()) return new Dead();
        return this;
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
