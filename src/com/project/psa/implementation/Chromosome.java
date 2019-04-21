/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.implementation;

import com.project.psa.model.ChromosomeModel;
import java.util.Random;

/**
 *
 * @author Sarthak
 */
public class Chromosome implements Comparable<Chromosome> {
    private ChromosomeModel chromosomeModel;
    Random random;

    /*
     * Calls generateChromosome() with chromosome length as argument
     * @param inputString
     */
    public Chromosome(String inputString) {
        this.random = new Random();
        this.chromosomeModel = new ChromosomeModel(inputString);
        generateChromosome(chromosomeModel.getChromosomeLength());

    }

    public Chromosome() {
        this.chromosomeModel = new ChromosomeModel();
    }

    public int range() {
        int minRange = 1;
        int maxRange = chromosomeModel.getChromosomeLength();
        return (random.nextInt((maxRange - minRange) + 1) + minRange);
    }
   /*
    * Accepts chromosome length as argument and adds gene in a loop till the chromosome length is not attained
    * @param chromosomeLength
    */
    public void generateChromosome(int chromosomeLength) {
        int maxRange = chromosomeLength;
        String randomWord = generateWord(range());
        while (!(randomWord.length() == maxRange)) {
            randomWord = randomWord + " " + generateWord(random.nextInt(maxRange - randomWord.length()));
        }
        chromosomeModel.setCandidateString(randomWord);
        chromosomeModel.setFitness(getFitness(chromosomeModel.getCandidateString()));
    }

    public String generateWord(int size) {
        char[] chr = new char[size];
        for (int i = 0; i < size; i++) {
            chr[i] = new Gene().randomGene();
        }
        return String.valueOf(chr);
    }
    /*
     * Accepts a string and calculate the fitness by comparing its genes with each character of the 
       target string.
     * @param inputString
     * @return 
    *****************************************************************************/
    public double getFitness(String inputString) {
        double score = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == chromosomeModel.getTarget().charAt(i)) {
                score++;
            }
        }
        chromosomeModel.setFitness((score / chromosomeModel.getTarget().length()) + 0.01);
        return chromosomeModel.getFitness();
    }

    public ChromosomeModel getChromosomeModel() {
        return chromosomeModel;
    }

    public void setChromosomeModel(ChromosomeModel chromosomeModel) {
        this.chromosomeModel = chromosomeModel;
    }

    @Override
    public String toString() {
        return chromosomeModel.getCandidateString();
    }

    @Override
    public int compareTo(Chromosome c) {
        return c.chromosomeModel.getFitness().compareTo(this.chromosomeModel.getFitness());
    }
}
