package com.nespresso.sofa.interview.hospital;

public class Patient {

    private State patientState;
    private int   patientNumber;

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

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }
}
