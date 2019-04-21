/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Sarthak
 * @param <X>
 */
public class Population<X extends Comparable<Chromosome>> {

    private ArrayList<Chromosome> generation; 
    private ArrayList<Chromosome> matingPool;
    private int populationSize;
    private String inputString;
    private float mutationRate;
    private int generationCount = 0;
    private double perfectScore = 1.01;
    private boolean finished = false;
    private Chromosome best;
    private Gene gene;
    Random random = new Random();

    /*
     * Creates a population of chromosomes equal to the passed population size
     * @param populationSize
     * @param inputString
     * @param 
     */
    public Population(int populationSize, String inputString, float mutationRate) {
        this.generation = new ArrayList<Chromosome>();
        this.matingPool = new ArrayList<Chromosome>();
        this.populationSize = populationSize;
        this.inputString = inputString;
        this.mutationRate = mutationRate;
        getPopulation(generation);
    }

    public Population() {
        
    }

    public void getPopulation(ArrayList<Chromosome> generation) {
        while (!(generation.size() == populationSize)) {
            generation.add(new Chromosome(inputString));
        }
        Collections.sort(generation);
    }

   /*
    * Creates a mating pool consisting of the fittest 80% population of the given generation
    * Also produces a child from two randomly picked partners
    */ 

    public void NaturalSelection() {
        generationCount++;
        matingPool.clear();
        for (int i = 0; i < generation.size() * 0.8; i++) {
            matingPool.add(generation.get(i));
        }
        Collections.sort(generation);
        for (int j = 0; j < generation.size() * 0.2; j++) {
            int random1 = (random.nextInt(matingPool.size()));
            int random2 = (random.nextInt(matingPool.size()));
            Chromosome partner1 = matingPool.get(random1);
            Chromosome partner2 = matingPool.get(random2);
            Chromosome cObj = crossover(partner1, partner2, inputString);
            mutate(cObj, mutationRate);
            generation.set(generation.size() - (j + 1), cObj);    
        }
        evaluate(generation);
    }
    
    /*
     * Accepts 2 partner chromosomes and randomly selects a index 
     * produces a child by merging the two partners
     * @param partnerA
     * @param partnerB
     * @param target
     * @return the produce
     */
    public Chromosome crossover(Chromosome partner1, Chromosome partner2, String target) {
        Chromosome cObj = new Chromosome(target);
        int midpoint = (random.nextInt(target.length()));
        char[] chr = new char[target.length()];
        for (int i = 0; i < target.length(); i++) {
            if (i > midpoint) {
                chr[i] = partner1.getChromosomeModel().getCandidateString().charAt(i);
            } else {
                chr[i] = partner2.getChromosomeModel().getCandidateString().charAt(i);
            }
        }
        String string = String.valueOf(chr);
        cObj.getChromosomeModel().setCandidateString(string);
        cObj.getChromosomeModel().setFitness(cObj.getFitness(string));
        return cObj;
    }

   
    /* Accepts a chromosome and the mutation rate
     * Mutates a random gene of child with a randomly generated gene depending on the mutation rate
     * @param child
     * @param mutationRate 
     */
    public void mutate(Chromosome cObj, double mutationRate) {
        double rangeMin = 0.0f;
        double rangeMax = 1.0f;
        double randomNum = 0;

        char[] childChars = cObj.getChromosomeModel().getCandidateString().toCharArray();
        for (int i = 0; i < childChars.length; i++) {
            randomNum = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
            if (randomNum < mutationRate) {
                gene = new Gene();
                childChars[i] = (char) gene.randomGene();
            }
        }
        cObj.getChromosomeModel().setCandidateString(String.valueOf(childChars));
    }
    /*
     * identifies the highest level of fitness and the chromosome with that level
     * @param generation
     * @return the best chromosome 
     */
    public double evaluate(ArrayList<Chromosome> generation) {
        double worldrecord = 0.0;
        int index = 0;
        for (int i = 0; i < generation.size(); i++) {
            if (generation.get(i).getChromosomeModel().getFitness() > worldrecord) {
                index = i;
                worldrecord = generation.get(i).getChromosomeModel().getFitness();
            }
        }
        if (worldrecord == perfectScore) {
            finished = true;
        }
        best = new Chromosome(inputString);
        best.getChromosomeModel().setCandidateString(generation.get(index).getChromosomeModel().getCandidateString());
    return worldrecord;
    }

    public boolean isFinished() {
        return finished;
    }

    public int getGenerations() {
        return generationCount;
    }

    public String getBest() {
        return best.getChromosomeModel().getCandidateString();
    }

    /**
     *
     * @return average fitness level
     */
    public double getAverageFitness() {
        double total = 0;
        for (int i = 0; i < generation.size(); i++) {
            total += generation.get(i).getChromosomeModel().getFitness();
        }
        return total / (generation.size());
    }
}
