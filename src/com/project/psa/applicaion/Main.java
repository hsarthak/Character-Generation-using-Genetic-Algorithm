/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.psa.applicaion;

import com.project.psa.implementation.GA;
import com.project.psa.model.InputModel;
import java.util.Scanner;

/**
 *
 * @author Sarthak
 */
public class Main {
    
    public static void main(String args[]){   
        Scanner myObj = new Scanner(System.in);
        InputModel input = new InputModel();
        GA ga = new GA();
        System.out.println("Enter the following values: "); 
        System.out.println("String: ");
        String string = myObj.nextLine();
        input.setInputString(string);
        System.out.println("Mutation Rate: ");
        String mutation = myObj.nextLine();
        input.setMutationRate(mutation);
        ga.GAImplementation(input);   
    }
}
