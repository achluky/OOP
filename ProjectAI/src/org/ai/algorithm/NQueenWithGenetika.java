/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ai.algorithm;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Jayuk
 */
public class NQueenWithGenetika
{
    private  int startSize = 10;                    // Population size at start.
    private  int maxEpochs = 1000;                  // Arbitrary number of test cycles.
    private  double matingProbability = 0.7;        // Probability of two chromosomes mating. Range: 0.0 < matingProbability < 1.0
    private  double mutationRate = 0.001;           // Mutation Rate. Range: 0.0 < mutationRate < 1.0
    private  int minSelect = 10;                    // Minimum parents allowed for selection.
    private  int maxSelect = 50;                    // Maximum parents allowed for selection. Range: minSelect < maxSelect < startSize
    private  int offSpringPerGeneration = 20;      // New offspring created per generation. Range: 0 < offSpringPerGeneration < maxSelect.
    private  int minimumShuffles = 8;               // For randomizing starting chromosomes
    private  int maximumShuffles = 20;
    private  int pbcMax = 4;                        // Maximum Position-Based Crossover points. Range: 0 < pbcMax < 8 (> 8 isn't good).
    
    public static int MAX_LENGTH = 8;                    // chess board width.

    private  int epoch = 0;
    private  int childCount = 0;
    private  int nextMutation = 0;                         // For scheduling mutations.
    private  int mutations = 0;

    private  ArrayList<Chromosome> population = new ArrayList<Chromosome>();
    
    public NQueenWithGenetika()
    {
        
    }
    public NQueenWithGenetika(int MAX_LENGTH)
    {
        this.MAX_LENGTH = MAX_LENGTH;
    }
    
    public  void algorithm()
    {
        int popSize = 0;
        Chromosome thisChromo = null;
        boolean done = false;

        initializeChromosomes();
        mutations = 0;
        nextMutation = getRandomNumber(0, (int)Math.round(1.0 / mutationRate));
        while(!done)
        {
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                thisChromo = population.get(i);
                if((thisChromo.getConflicts() == 0) || epoch == maxEpochs){
                    done = true;
                }
            }
            
            getFitness();
            
            rouletteSelection();
            
            mating();

            prepNextEpoch();
            
             epoch++;
            // This is here simply to show the runtime status.
            System.out.println("Epoch: " + epoch);
        }
        
        System.out.println("done.");
        
        if(epoch != maxEpochs){
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                thisChromo = population.get(i);
                if(thisChromo.getConflicts() == 0){
                    printbestSolution(thisChromo);
                }
            }
        }
        System.out.println("Completed " + epoch + " epochs.");
        System.out.println("Encountered " + mutations + " mutations in " + childCount + " offspring.");
        
    }
    
    private  void getFitness()
    {
        // Lowest errors = 100%, Highest errors = 0%
        int popSize = population.size();
        Chromosome thisChromo = null;
        double bestScore = 0;
        double worstScore = 0;

        // The worst score would be the one with the highest energy, best would be lowest.
        worstScore = population.get(maximum()).getConflicts();

        // Convert to a weighted percentage.
        bestScore = worstScore - population.get(minimum()).getConflicts();

        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.setFitness((worstScore - thisChromo.getConflicts()) * 100.0 / bestScore);
        }
        
        
    }
    
    private  void rouletteSelection()
    {
        int j = 0;
        int popSize = population.size();
        double genTotal = 0.0;
        double selTotal = 0.0;
        int maximumToSelect = getRandomNumber(minSelect, maxSelect);
        double rouletteSpin = 0.0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        boolean done = false;

        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            genTotal += thisChromo.getFitness();
        }

        genTotal *= 0.01;

        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.setSelectionProbability(thisChromo.getFitness() / genTotal);
        }

        for(int i = 0; i < maximumToSelect; i++)
        {
            rouletteSpin = getRandomNumber(0, 99);
            j = 0;
            selTotal = 0;
            done = false;
            while(!done)
            {
                thisChromo = population.get(j);
                selTotal += thisChromo.getSelectionProbability();
                if(selTotal >= rouletteSpin){
                    if(j == 0){
                        thatChromo = population.get(j);
                    }
                    else if(j >= popSize - 1){
                        thatChromo = population.get(popSize - 1);
                    }
                    else{
                        thatChromo = population.get(j - 1);
                    }
                    thatChromo.setSelected(true);
                    done = true;
                }
                else
                {
                    j++;
                }
            }
        }
        
    }
    
    //  This is where you can choose between options:

    //  To choose between crossover options, uncomment one of: 
    //     partiallyMappedCrossover(),
    //     positionBasedCrossover(), while keeping the other two commented out.

    //  Keep in mind that the code will still run if(you try combinations or uncomment all of them,
    //  but this might hinder the algorithm in general.
    //  Of course, I could always be wrong, try it and find out!
    private  void mating()
    {
        int getRand = 0;
        int parentA = 0;
        int parentB = 0;
        int newIndex1 = 0;
        int newIndex2 = 0;
        Chromosome newChromo1 = null;
        Chromosome newChromo2 = null;

        for(int i = 0; i < offSpringPerGeneration; i++)
        {
            parentA = chooseParent();
            // Test probability of mating.
            getRand = getRandomNumber(0, 100);
            if(getRand <= matingProbability * 100){
                parentB = chooseParent(parentA);
                newChromo1 = new Chromosome();
                newChromo2 = new Chromosome();
                population.add(newChromo1);
                newIndex1 = population.indexOf(newChromo1);
                population.add(newChromo2);
                newIndex2 = population.indexOf(newChromo2);
                
                // Choose either, or both of these:
                partiallyMappedCrossover(parentA, parentB, newIndex1, newIndex2);
                //positionBasedCrossover(parentA, parentB, newIndex1, newIndex2);

                if(childCount - 1 == nextMutation){
                    exchangeMutation(newIndex1, 1);
                }else if(childCount == nextMutation){
                    exchangeMutation(newIndex2, 1);
                }

                population.get(newIndex1).computeConflicts();
                population.get(newIndex2).computeConflicts();

                childCount += 2;

                // Schedule next mutation.
                if(childCount % (int)Math.round(1.0 / mutationRate) == 0){
                    nextMutation = childCount + getRandomNumber(0, (int)Math.round(1.0 / mutationRate));
                }
            }
        } // i
        
    }
    
    private  void partiallyMappedCrossover(int chromA, int chromB, int child1, int child2)
    {
        int j = 0;
        int item1 = 0;
        int item2 = 0;
        int pos1 = 0;
        int pos2 = 0;
        Chromosome thisChromo = population.get(chromA);
        Chromosome thatChromo = population.get(chromB);
        Chromosome newChromo1 = population.get(child1);
        Chromosome newChromo2 = population.get(child2);
        int crossPoint1 = getRandomNumber(0, MAX_LENGTH - 1);
        int crossPoint2 = getExclusiveRandomNumber(MAX_LENGTH - 1, crossPoint1);
        
        if(crossPoint2 < crossPoint1){
            j = crossPoint1;
            crossPoint1 = crossPoint2;
            crossPoint2 = j;
        }

        // Copy Parent genes to offspring.
        for(int i = 0; i < MAX_LENGTH; i++)
        {
            newChromo1.setData(i, thisChromo.getData(i));
            newChromo2.setData(i, thatChromo.getData(i));
        }

        for(int i = crossPoint1; i <= crossPoint2; i++)
        {
            // Get the two items to swap.
            item1 = thisChromo.getData(i);
            item2 = thatChromo.getData(i);

            // Get the items//  positions in the offspring.
            for(j = 0; j < MAX_LENGTH; j++)
            {
                if(newChromo1.getData(j) == item1){
                    pos1 = j;
                }else if(newChromo1.getData(j) == item2){
                    pos2 = j;
                }
            } // j

            // Swap them.
            if(item1 != item2){
                newChromo1.setData(pos1, item2);
                newChromo1.setData(pos2, item1);
            }

            // Get the items//  positions in the offspring.
            for(j = 0; j < MAX_LENGTH; j++)
            {
                if(newChromo2.getData(j) == item2){
                    pos1 = j;
                }else if(newChromo2.getData(j) == item1){
                    pos2 = j;
                }
            } // j

            // Swap them.
            if(item1 != item2){
                newChromo2.setData(pos1, item1);
                newChromo2.setData(pos2, item2);
            }

        } // i
        
    }
    
    private  void exchangeMutation( int index,  int exchanges)
    {
        int i =0;
        int tempData = 0;
        Chromosome thisChromo = null;
        int gene1 = 0;
        int gene2 = 0;
        boolean done = false;
        
        thisChromo = population.get(index);

        while(!done)
        {
            gene1 = getRandomNumber(0, MAX_LENGTH - 1);
            gene2 = getExclusiveRandomNumber(MAX_LENGTH - 1, gene1);

            // Exchange the chosen genes.
            tempData = thisChromo.getData(gene1);
            thisChromo.setData(gene1, thisChromo.getData(gene2));
            thisChromo.setData(gene2, tempData);

            if(i == exchanges)
            {
                done = true;
            }
            i++;
        }
        mutations++;
        
    }
    
    private  int chooseParent()
    {
        // Overloaded function, see also "chooseparent(ByVal parentA As Integer)".
        int parent = 0;
        Chromosome thisChromo = null;
        boolean done = false;

        while(!done)
        {
            // Randomly choose an eligible parent.
            parent = getRandomNumber(0, population.size() - 1);
            thisChromo = population.get(parent);
            if(thisChromo.isSelected() == true){
                done = true;
            }
        }

        return parent;
    }

    private  int chooseParent( int parentA)
    {
        // Overloaded function, see also "chooseparent()".
        int parent = 0;
        Chromosome thisChromo = null;
        boolean done = false;

        while(!done)
        {
            // Randomly choose an eligible parent.
            parent = getRandomNumber(0, population.size() - 1);
            if(parent != parentA){
                thisChromo = population.get(parent);
                if(thisChromo.isSelected() == true){
                    done = true;
                }
            }
        }

        return parent;
    }
    
    private  void prepNextEpoch()
    {
        int popSize = 0;
        Chromosome thisChromo = null;

        // Reset flags for selected individuals.
        popSize = population.size();
        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.setSelected(false);
        }
        
    }
    
    private  void printbestSolution(Chromosome bestSolution)
    {
        String board[][] = new String[MAX_LENGTH][MAX_LENGTH];
        
        // Clear the board.
        for(int x = 0; x < MAX_LENGTH; x++)
        {
            for(int y = 0; y < MAX_LENGTH; y++)
            {
                board[x][y] = "";
            }
        }

        for(int x = 0; x < MAX_LENGTH; x++)
        {
            board[x][bestSolution.getData(x)] = "Q";
        }

        // Display the board.
        for(int y = 0; y < MAX_LENGTH; y++)
        {
            for(int x = 0; x < MAX_LENGTH; x++)
            {
                if(board[x][y]=="Q")
                {
                    System.out.print(x);
                }
            }
        }
        System.out.println("");
        System.out.println("Board:");
        for(int y = 0; y < MAX_LENGTH; y++)
        {
            for(int x = 0; x < MAX_LENGTH; x++)
            {
                if(board[y][x] == "Q"){
                    System.out.print("Q ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.print("\n");
        }

        
    }
    
    private  int getRandomNumber( int low,  int high)
    {
        return (int)Math.round((high - low) * new Random().nextDouble() + low);
    }
    
    private  int getExclusiveRandomNumber( int high,  int except)
    {
        boolean done = false;
        int getRand = 0;

        while(!done)
        {
            getRand = new Random().nextInt(high);
            if(getRand != except){
                done = true;
            }
        }

        return getRand;
    }
    
    private  int getRandomNumber(int low, int high, int[] except)
    {
        boolean done = false;
        int getRand = 0;

        if(high != low){
            while(!done)
            {
                done = true;
                getRand = (int)Math.round((high - low) * new Random().nextDouble() + low);
                for(int i = 0; i < except.length; i++) //UBound(except)
                {
                    if(getRand == except[i]){
                        done = false;
                    }
                } // i
            }
            return getRand;
        }else{
            return high; // or low (it doesn't matter).
        }
    }
    
    private  int minimum()
    {
        // Returns an array index.
        int popSize = 0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                if(i != winner){             // Avoid self-comparison.
                    thisChromo = population.get(i);
                    thatChromo = population.get(winner);
                    if(thisChromo.getConflicts() < thatChromo.getConflicts()){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }
            if(foundNewWinner == false){
                done = true;
            }
        }
        return winner;
    }
    
    private  int maximum()
    {
        // Returns an array index.
        int popSize = 0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;

        while(!done)
        {
            foundNewWinner = false;
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                if(i != winner){             // Avoid self-comparison.
                    thisChromo = population.get(i);
                    thatChromo = population.get(winner);
                    if(thisChromo.getConflicts() > thatChromo.getConflicts()){
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }
            if(foundNewWinner == false){
                done = true;
            }
        }
        return winner;
    }
    
    private  void initializeChromosomes()
    {
        int shuffles = 0;
        Chromosome newChromo = null;
        int chromoIndex = 0;

        for(int i = 0; i < startSize; i++)
        {
            newChromo = new Chromosome();
            population.add(newChromo);
            chromoIndex = population.indexOf(newChromo);

            // Randomly choose the number of shuffles to perform.
            shuffles = getRandomNumber(minimumShuffles, maximumShuffles);

            exchangeMutation(chromoIndex, shuffles);

            population.get(chromoIndex).computeConflicts();
        }
        
    }
}
