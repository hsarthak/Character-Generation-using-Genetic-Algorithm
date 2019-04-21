package com.project.psa.implementation;

import com.project.psa.model.InputModel;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sarthak
 */
public class GA {
    
    public void GAImplementation(InputModel inputModel) throws IOException{
        final Logger logger = Logger.getLogger(GA.class.getName());
        FileHandler fh;   
        fh = new FileHandler("logger.log");   
        logger.addHandler(fh); 
        logger.setUseParentHandlers(false);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
        
        String best;
        int populationSize = 10000;
        float mutationRate = (float) 0.01;
        String inputString = "Final Project PSA";
        try {          
        // Validations for input
        if(("".equals(inputModel.getInputString())) || "".equals(inputModel.getMutationRate())){
            System.out.println("Input String and input mutation rate cannot be empty.");
            return;
        }
            mutationRate = Float.valueOf(inputModel.getMutationRate());
            inputString = inputModel.getInputString();

            // First Population
            Population population = new Population(populationSize, inputString, mutationRate);
            double first = System.currentTimeMillis();
            
           // Application will stop working when the number of generations = populationSize
            int endOfapplication = 0;
            while (!(population.isFinished()) && (endOfapplication < populationSize)) {
                population.NaturalSelection();
                best = population.getBest();
                inputModel.setOutputString(population.getBest());
                logger.info(best);
                endOfapplication++;
            } 
            double second = System.currentTimeMillis();       
            System.out.println("Number of generations: " + population.getGenerations());
            
            inputModel.setGenNumber(String.valueOf(population.getGenerations()));
            inputModel.setFitnessAvg(String.valueOf(population.getAverageFitness()));
            
            double timeDiff = second - first;
            inputModel.setTimeElapsed(String.valueOf(timeDiff) + "ms");
            System.out.println("Time Elapsed: " + timeDiff + " ms");

            // If output string is not equal to the input string then consider different input mutation rate
            if(!inputModel.getOutputString().equals(inputString)){
                System.out.println("String will not be generated using given input mutation rate.");
            }
            
            if(inputModel.getOutputString()!= null){
                System.out.println("Regenerated String: " + inputModel.getOutputString());
            }
        }catch (NumberFormatException e) {
            if ((inputModel.getInputString().equals("")) || inputModel.getMutationRate().equals("")) {
                System.out.println("Input String and input mutation rate cannot be empty.");
            }else if ((inputModel.getInputString().length() == 1)) {
                System.out.println("Please enter a string instead of character.");
            }else {
                System.out.println("Enter float value as mutation rate.");
            }
        }  
    }  
}
