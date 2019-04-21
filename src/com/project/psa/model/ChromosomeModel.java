/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.model;

import com.project.psa.implementation.Gene;

/**
 *
 * @author Sarthak
 */
public class ChromosomeModel {
    private String candidateString;
    private Double fitness;
    private int chromosomeLength;
    private String target;
    private Gene gene;

    public ChromosomeModel() {
    }

     public ChromosomeModel(String target){
        this.fitness = 0.01;
        this.target = target;
        this.chromosomeLength = target.length();
    }
     
    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    public int getChromosomeLength() {
        return chromosomeLength;
    }

    public void setChromosomeLength(int chromosomeLength) {
        this.chromosomeLength = chromosomeLength;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    public String getCandidateString() {
        return candidateString;
    }

    public void setCandidateString(String candidateString) {
        this.candidateString = candidateString;
    }

    public Gene getGene() {
        return gene;
    }

    public void setGene(Gene gene) {
        this.gene = gene;
    }

}
