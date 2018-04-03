package com.nespresso.sofa.interview.hospital;

public abstract class State {

    private String range;

    protected abstract State wait40Days(Patient patient);
    protected abstract State aspirin(Patient patient);
    protected abstract State antibiotic(Patient patient);
    protected abstract State insulin(Patient patient);
    protected abstract State paracetamol(Patient patient);

    public State(String range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return range;
    }

}
