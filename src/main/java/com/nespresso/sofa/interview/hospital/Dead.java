package com.nespresso.sofa.interview.hospital;

public class Dead extends State {
    public Dead() {
        super("X");
    }

    @Override
    public State wait40Days(Patient patient) {
        return this;
    }

    @Override
    protected State aspirin(Patient patient) {
        return this;
    }

    @Override
    protected State antibiotic(Patient patient) {
        return this;
    }

    @Override
    protected State insulin(Patient patient) {
        return this;
    }

    @Override
    protected State paracetamol(Patient patient) {
        return this;
    }
}
