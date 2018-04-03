package com.nespresso.sofa.interview.hospital;

public class Diabetes extends State{

    public Diabetes() {
        super("D");
    }


    @Override
    protected void updateState(Patient patient) {
        if ((patient.isUsingParacetamol() && patient.isUsingAspirin()) || (!patient.isUsingInsulin() && patient.isWait40Days()))
            patient.setPatientState(new Dead());
    }


}
