/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.implementation;

import java.util.Random;

/**
 *
 * @author Sarthak
 */
//generates random characters
public class Gene {   
    
    Random random = new Random();
    public char randomGene(){
        char[] punctuations = new char []{',', '.','!','-','{','}','&','*',';',':'};
        char[] numbers = new char[]{'1','2','3','4','5','6','7','8','9','0'};
        char[] space = new char[]{' '};
        
        if(random.nextBoolean()){
            if(random.nextBoolean()){
               return (char)(random.nextInt(26) + 'a');
            }else{
                if (random.nextBoolean()){
                    return punctuations[random.nextInt(punctuations.length)];
                }else{ 
                    return (char) (random.nextInt(26) + 'A');
                }
            }
        }else{ 
            if(random.nextBoolean()){
                return numbers[random.nextInt(numbers.length)];
            }else{
                return space[random.nextInt(space.length)];
            }
        }
    } 
}
