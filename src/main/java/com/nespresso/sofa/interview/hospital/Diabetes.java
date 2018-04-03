package com.nespresso.sofa.interview.hospital;

public class Diabetes extends State{

    public Diabetes() {
        super("D");
    }

    @Override
    public State wait40Days(Patient patient) {
        if (patient.isUsedInsulin()) return this;
        return new Dead();
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
        return this;
    }

    @Override
    protected State insulin(Patient patient) {
        patient.setUsedInsulin(true);
        return this;
    }
}
