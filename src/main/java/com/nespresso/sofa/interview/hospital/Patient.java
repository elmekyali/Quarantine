package com.nespresso.sofa.interview.hospital;

import java.util.function.UnaryOperator;

public class Patient {

    private State   patientState;

    private boolean isWait40Days        = false;
    private boolean isUsingInsulin      = false;
    private boolean isUsingAntibiotic   = false;
    private boolean isUsingAspirin      = false;
    private boolean isUsingParacetamol  = false;

    public State getPatientState() {
        return patientState;
    }

    public void setPatientState(State patientState) {
        this.patientState = patientState;
    }

    public Patient setFirstState (String type) {

        switch (type)
        {
            case "D" : patientState = new Diabetes();      break;
            case "F" : patientState = new Fever();         break;
            case "T" : patientState = new Tuberculosis();  break;
            case "H" : patientState = new Healthy();       break;
            case "X" : patientState = new Dead();          break;
            default  : patientState = null;
        }
        return this;
    }

   public Patient wait40Days() {
       isWait40Days = true ;
       patientState.updateState(this);
        return this;
   }

    public Patient aspirin() {
        isUsingAspirin = true ;
        patientState.updateState(this);
        return this;
    }

    public Patient antibiotic() {
        isUsingAntibiotic = true;
        patientState.updateState(this);
        return this;
    }

    public Patient insulin() {
        isUsingInsulin = true;
        patientState.updateState(this);
        return this;
    }

    public Patient paracetamol() {
        isUsingParacetamol = true ;
        patientState.updateState(this);
        return this;
    }

    @Override
    public String toString() {
        return patientState.toString();
    }

    public boolean isUsingInsulin() {
        return isUsingInsulin;
    }

    public void setUsingInsulin(boolean usingInsulin) {
        isUsingInsulin = usingInsulin;
    }

    public boolean isUsingAntibiotic() {
        return isUsingAntibiotic;
    }

    public void setUsingAntibiotic(boolean usingAntibiotic) {
        isUsingAntibiotic = usingAntibiotic;
    }

    public boolean isUsingAspirin() {
        return isUsingAspirin;
    }

    public void setUsingAspirin(boolean usingAspirin) {
        isUsingAspirin = usingAspirin;
    }

    public boolean isUsingParacetamol() {
        return isUsingParacetamol;
    }

    public void setUsingParacetamol(boolean usingParacetamol) {
        isUsingParacetamol = usingParacetamol;
    }

    public boolean isWait40Days() {
        return isWait40Days;
    }

    public void setWait40Days(boolean wait40Days) {
        isWait40Days = wait40Days;
    }
}
