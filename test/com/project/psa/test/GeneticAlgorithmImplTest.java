/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.test;

import com.project.psa.implementation.Chromosome;
import com.project.psa.implementation.Population;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sarthak
 */
public class GeneticAlgorithmImplTest {
   
    @Test
    public void testGenerateChromosome() {
        int cLength = 1;
        Chromosome cObj = new Chromosome(",");
        cObj.generateChromosome(cLength);
        }

    @Test
    public void testGetFitness() {
        String testString = " ";
        Chromosome cObj = new Chromosome(testString);
        double expOutput = 1.01;
        double output = cObj.getFitness(testString);
        assertEquals(expOutput, output, 1.01);
        
    }

      public void testGetPopulation() {
        String inputString = ";";
        int pSize = 20;
        float inputMutation = (float) 0.01;
        Population pObj = new Population(pSize, inputString, inputMutation);
        ArrayList<Chromosome> arrList = new ArrayList<Chromosome>();
        pObj.getPopulation(arrList);
    }

     //Test for crossover method.
     
    @Test
    public void testCrossover() {
        String inputString = "cd";
        Set<String> expOutput = new HashSet<>(Arrays.asList("cc", "cd", "ce", "cf", "dd", "dc", "de", "df", "ee", "ec", "ed", "ef", "ff", "fc", "fd", "fe"));
        Chromosome cObj1 = new Chromosome(inputString);
        cObj1.getChromosomeModel().setCandidateString("cd");
        Chromosome cObj2 = new Chromosome(inputString);
        cObj2.getChromosomeModel().setCandidateString("ef");
        Population pObj = new Population();
        Chromosome result = pObj.crossover(cObj1, cObj2, inputString);
        assertTrue(expOutput.contains(result.getChromosomeModel().getCandidateString()));
    }
      
     //Test for NaturalSelection method.
     
    @Test
    public void testNaturalSelection() {
        String inputString = ";";
        int pSize = 20;
        float inputMutation = (float) 0.01;
        Population pObj = new Population(pSize, inputString, inputMutation);
        pObj.NaturalSelection();
    }
    
     @Test
    public void testGetAverageFitness() {
       String inputString = "a";
       int pSize = 20;
       float inputMutation = (float) 0.01;
       Population instance = new Population(pSize, inputString, inputMutation);
       double expOutput = 0.11;
       double output = instance.getAverageFitness();
       assertEquals(expOutput, output, 0.11);
    }   
    
      //Test for mutate method.
    
    @Test
    public void testMutate() {   
        Chromosome cObj = new Chromosome();
        cObj.getChromosomeModel().setCandidateString("a!");
        double inputMutation = 0.01;
        Population instance = new Population();
        Set<String> set;
        set = new HashSet<>(Arrays.asList("a,", "a.", "a!", "a-", "a{", "a}", "a&", "a*", "a;", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "a0", "a ", "aa", "ab", "ac", "ad", "ae", "af", "ag", "ah", "ai", "aj", "ak", "al", "am", "an", "ao", "ap", "aq", "ar", "as", "at", "au", "av", "aw", "ax", "ay", "az", "ba", "ca", "da", "ea", "fa", "ga", "ha", "ia", "ja", "ka", "la", "ma", "na", "oa", "pa",
                "qa", "ra", "sa", "ta", "ua", "va", "wa", "xa", "ya", "za", ",a", ".a", "!a", "-a", "{a", "}a", "&a", "*a", ";a", "1a", "2a", "3a", "4a", "5a", "6a", "7a", "8a", "9a", "0a", " a"));
        Chromosome expOutput = new Chromosome();
        expOutput.getChromosomeModel().setCandidateString("a;");
        instance.mutate(cObj, inputMutation);
        assertTrue(set.contains(cObj.getChromosomeModel().getCandidateString()));
    }
}
         
    
   
    