package com.nespresso.sofa.interview.hospital;

public abstract class State {

    private String range;

    protected abstract void updateState(Patient patient);

    public State(String range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return range;
    }

}
