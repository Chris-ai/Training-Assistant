package com.example.trainingassistant;

public class SpinnerListItem {

    private String spinnerText;
    private String spinnerMuscleParts;
    private String spinnerDescription;

    public SpinnerListItem(String spinnerText, String spinnerMuscleParts, String spinnerDescription)
    {
        this.spinnerText = spinnerText;
        this.spinnerMuscleParts = spinnerMuscleParts;
        this.spinnerDescription = spinnerDescription;

    }


    public String getSpinnerText() {
        return spinnerText;
    }

    public String getSpinnerMuscleParts() {
        return spinnerMuscleParts;
    }

    public String getSpinnerDescription() {
        return spinnerDescription;
    }
}
