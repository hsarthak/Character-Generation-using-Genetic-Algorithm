/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.model;

/**
 *
 * @author Sarthak
 */
public class InputModel {
    
    private String inputString;
    private String mutationRate;
    private String outputString;
    private String genNumber;
    private String fitnessAvg;
    private String timeElapsed;

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public String getMutationRate() {
        return mutationRate;
    }

    public void setMutationRate(String mutationRate) {
        this.mutationRate = mutationRate;
    }

    
    public String getOutputString() {
        return outputString;
    }

    public void setOutputString(String outputString) {
        this.outputString = outputString;
    }

    public String getGenNumber() {
        return genNumber;
    }

    public void setGenNumber(String genNumber) {
        this.genNumber = genNumber;
    }

    public String getFitnessAvg() {
        return fitnessAvg;
    }

    public void setFitnessAvg(String fitnessAvg) {
        this.fitnessAvg = fitnessAvg;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

}
