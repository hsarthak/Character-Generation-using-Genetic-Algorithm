# Character-Generation-using-Genetic-Algorithm
# Final Project on Genetic Algorithm Implementation

Genetic Algorithm:
Genetic Algorithm are commonly used to generate high-quality solutions for optimization problems and search problems.  Genetic algorithms are based on the ideas of natural selection and genetics. These are intelligent exploitation of random search provided with historical data to direct the search into the region of better performance in solution space. Genetic algorithms are based on an analogy with genetic structure and behavior of chromosome of the population

Genetic algorithms simulate the process of natural selection which means those species who can adapt to changes in their environment are able to survive and reproduce and go to next generation. In simple words, they simulate “survival of the fittest” among individual of consecutive generation for solving a problem. Each generation consist of a population of individuals and each individual represents a point in search space and possible solution. Each individual is represented as a string of character/integer/float/bits. This string is analogous to the Chromosome.

# Working :
1) Randomly initialize populations p
2) Determine fitness of population
3) Untill convergence repeat:
      a) Select parents from population
      b) Crossover and generate new population
      c) Perform mutation on new population
      d) Calculate fitness for new population
      
 # Logs: There is a file, logger.log in the default package which displays the logs for the current session.

# Application of Genetic Algorithim :

I f we want to determine exact characters of String using normal program, it is feasible if the length of the string is small, but determining the characters of a big string is not feasible as the time taken will increase exponentially with the length, and eventually the application will need thousands of years to determine the exact string. The reason for more time is as the number of characters increase the probability to find the exact same characters decreases exponentially
   
Using genetic algorithm it becomes very easy and can be done in few seconds. So we r going to use genetic algorithim to predict the characters in String

# Testing the project:
Test run the GeneticAlgorithmImplTest.java file

# References
“Introduction To Genetic Algorithms” featured at www.towardsdatascience.com 
Paper on “A NEW APPROACH FOR DATA ENCRYPTION USING GENETIC ALGORITHMS” featured at www.researchgate.net
https://www.geeksforgeeks.org/genetic-algorithms/
https://www.mathworks.com/help/gads/what-is-the-genetic-algorithm.html
