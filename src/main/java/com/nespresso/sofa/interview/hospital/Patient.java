package com.nespresso.sofa.interview.hospital;

public class Patient {

    private State   patientState;
    private boolean isUsedInsulin      = false;
    private boolean isUsedAntibiotic   = false;
    private boolean isUsedAspirin      = false;
    private boolean isUsedParacetamol  = false;

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

    @Override
    public String toString() {
        return patientState.toString();
    }

    public boolean isUsedInsulin() {
        return isUsedInsulin;
    }

    public void setUsedInsulin(boolean usedInsulin) {
        isUsedInsulin = usedInsulin;
    }

    public boolean isUsedAntibiotic() {
        return isUsedAntibiotic;
    }

    public void setUsedAntibiotic(boolean usedAntibiotic) {
        isUsedAntibiotic = usedAntibiotic;
    }

    public boolean isUsedAspirin() {
        return isUsedAspirin;
    }

    public void setUsedAspirin(boolean usedAspirin) {
        isUsedAspirin = usedAspirin;
    }

    public boolean isUsedParacetamol() {
        return isUsedParacetamol;
    }

    public void setUsedParacetamol(boolean usedParacetamol) {
        isUsedParacetamol = usedParacetamol;
    }
}
