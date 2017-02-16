
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class GenetikaNQueen 
{
    final int startSize = 75;
    final int maxEpochs = 1000;
    final double mating_Probability = 0.7;
    final double mutationRate = 0.001;
    final int minSelect = 10;
    final int maxSelect = 50;
    final int offSpringPerGeneration = 20;
    final int minShuffles = 8;
    final int maxShuffles = 20;
    final int pcbMax = 4;
    public static final int maxLength = 8;
    
    int epoch = 0;
    int childCount = 0;
    int nextMutation = 0;
    int mutations = 0;
    
    ArrayList<Chromosome> population = new ArrayList<>();
    
    public void algorithm()
    {
        int popSize = 0;
        Chromosome thisChromo = null;
        boolean done = false;
        
        initializeChromosome();
        mutations = 0;
        nextMutation = getRandomNumber(0,(int)Math.round(1.0/mutationRate));
        while(!done)
        {
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                thisChromo = population.get(i);
                if((thisChromo.getConflicts() == 0)|| epoch == maxEpochs)
                    done = true;
            }
            getFitness();
            rouletteSelection();
            mating();
            prepNextEpoch();
            epoch++;
            System.out.println("Epoch : "+epoch);
        }
        System.out.println("done. ");
        if(epoch != maxEpochs)
        {
            popSize = population.size();
            for(int i = 0; i < popSize; i++)
            {
                thisChromo = population.get(i);
                if(thisChromo.getConflicts() == 0)
                    printBestSolution(thisChromo);
            }
        }
        System.out.println("Completed " +epoch+" epochs.");
        System.out.println("Encountered "+mutations+" mutations in "+childCount+" offSpring");
    }
    public void getFitness()
    {
        int popSize = population.size();
        Chromosome thisChromo = null;
        double bestScore = 0,worstScore = 0;
        worstScore = population.get(maximum()).getConflicts();
        bestScore = worstScore - population.get(minimum()).getConflicts();
        for(int i=0; i < popSize;i ++)
        {
            thisChromo = population.get(i);
            thisChromo.setFitness((worstScore - thisChromo.getConflicts()) *100.0 / bestScore);
        }
    }
    public void rouletteSelection()
    {
        int j = 0;
        double genTotal=0.0,selTotal =0.0,rouletteSpin = 0.0;
        int maximumToSelect = getRandomNumber(minSelect,maxSelect);
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int popSize = population.size();
        boolean done = false;
        for(Chromosome chromosome : population)
        {
            genTotal += chromosome.getFitness();
        }
        genTotal *= 0.01;
        for(Chromosome chromosome : population)
        {
            chromosome.setSelectionProbability(chromosome.getFitness()/genTotal);
        }
        for(int i = 0; i < maximumToSelect; i++)
        {
            rouletteSpin = getRandomNumber(0,99);
            j = 0;
            selTotal = 0;
            done = false;
            while(!done)
            {
                thisChromo = population.get(j);
                selTotal += thisChromo.getSelectionProbability();
                if(selTotal >= rouletteSpin)
                {
                    if(j == 0)
                    {
                        thatChromo = population.get(j);
                    }
                    else if(j >= popSize -1)
                    {
                        thatChromo = population.get(popSize -1);
                    }
                    else
                    {
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
    public void mating()
    {
        int getRand = 0;
        int parentA = 0   ,parentB=0;
        int newIndex1 = 0 ,newIndex2=0;
        Chromosome newChromo1 = null, newChromo2=null;
        for(int i=0; i < offSpringPerGeneration; i++)
        {
            parentA = chooseParent();
            getRand = getRandomNumber(0,100);
            if(getRand <= mating_Probability * 100)
            {
                parentB = chooseParent(parentA);
                newChromo1 = new Chromosome();
                newChromo2 = new Chromosome();
                population.add(newChromo1);
                newIndex1 = population.indexOf(newChromo1);
                population.add(newChromo2);
                newIndex2 = population.indexOf(newChromo2);

                partiallyMappedCrossover(parentA,parentB,newIndex1,newIndex2);
                if(childCount - 1 == nextMutation)
                {
                    exchangeMutation(newIndex1,1);
                }
                else if(childCount == nextMutation)
                {
                    exchangeMutation(newIndex2,1);
                }
                population.get(newIndex1).computeConflicts();
                population.get(newIndex2).computeConflicts();

                childCount += 2;
                if(childCount % (int)Math.round(1.0 /mutationRate)==0)
                {
                    nextMutation = childCount + getRandomNumber(0,(int)Math.round(1.0/mutationRate));
                }
            }
        }
    }
    public void partiallyMappedCrossover(int chromA, int chromB,int child1, int child2)
    {
        int j = 0;
        int item1 = 0, item2 = 0;
        int pos1 = 0, pos2 = 0;
        Chromosome thisChromo = population.get(chromA);
        Chromosome thatChromo = population.get(chromB);
        Chromosome newChromo1 = population.get(child1);
        Chromosome newChromo2 = population.get(child2);
        
        int crossPoint1 = getRandomNumber(0,maxLength -1 );
        int crossPoint2 = getExclusiveRandomNumber(maxLength -1,crossPoint1);
        
        if(crossPoint2 < crossPoint1)
        {
            j = crossPoint1;
            crossPoint1 = crossPoint2;
            crossPoint2 = j;
        }
        for(int i = 0; i<maxLength;i++)
        {
            newChromo1.setData(i, thisChromo.getData(i));
            newChromo2.setData(i, thatChromo.getData(i));
        }
        for(int i =crossPoint1;i<=crossPoint2;i++)
        {
            item1 = thisChromo.getData(i);
            item2 = thatChromo.getData(i);
            for( j = 0; j < maxLength; j++)
            {
                if(newChromo1.getData(j) == item1)
                {
                    pos1 = j;
                }
                else if(newChromo2.getData(j)== item2)
                {
                    pos2 = j;
                }
            }
            if(item1 != item2)
            {
                newChromo1.setData(pos1,item2);
                newChromo1.setData(pos2,item1);
            }
            for(j = 0;j < maxLength; j++)
            {
                if(newChromo2.getData(j) == item2)
                {
                    pos1 = j;
                }
                else if(newChromo2.getData(j) == item1)
                {
                    pos2 = j;
                }
            }
            if(item1 != item2)
            {
                newChromo2.setData(pos1, item1);
                newChromo2.setData(pos2, item2);
            }
        }   
    }
    //tidak di gunakan
    public void positionBasedCrossover(int chromA, int chromB,int child1, int child2)
    {
        int k = 0, numPoints = 0;
        int tempArray1[] = new int [maxLength];
        int tempArray2[] = new int [maxLength];
        boolean matchFound =  false;
        Chromosome thisChromo = population.get(chromA);
        Chromosome thatChromo = population.get(chromB);
        Chromosome newChromo1 = population.get(child1);
        Chromosome newChromo2 = population.get(child2);
        
        numPoints = getRandomNumber(0,pcbMax);
        int crossPoints[] =  new int[numPoints];
        for(int i = 0;i<numPoints;i++)
        {
            crossPoints[i] =  getRandomNumber(0,maxLength-1,crossPoints);
        }
        k=0;
        for(int i = 0;i<maxLength;i++)
        {
            matchFound = false;
            for(int j = 0 ;j<numPoints;j++)
            {
                if(thatChromo.getData(i) == thisChromo.getData(crossPoints[j]))
                {
                    matchFound = true;
                }
            }
            if(matchFound ==  false)
            {
                tempArray1[k] = thatChromo.getData(i);
                k++;
            }
        }
        for(int i = 0;i<numPoints;i++)
        {
            newChromo1.setData(crossPoints[i], thisChromo.getData(crossPoints[i]));
        }
        k=0;
        for(int i = 0; i<maxLength;i++)
        {
            matchFound = false;
            for(int j = 0; j<numPoints;j++)
            {
                if(i == crossPoints[j])
                {
                    matchFound = true;
                }
                if(matchFound == false)
                {
                    newChromo1.setData(i, tempArray1[k]);
                    k++;
                }
            }
        }
        k=0;
        for(int i = 0;i<maxLength;i++)
        {
            matchFound =  false;
            for(int j=0;j<numPoints;j++)
            {
                if(thisChromo.getData(i) == thatChromo.getData(crossPoints[j]))
                {
                    matchFound = true;
                }
            }
            if(matchFound ==  false)
            {
                tempArray2[k] =  thisChromo.getData(i);
                k++;
            }
        }
        for(int i=0;i<numPoints;i++)
        {
            newChromo2.setData(crossPoints[i],thatChromo.getData(crossPoints[i]));
        }
        k=0;
        for(int i = 0;i<maxLength;i++)
        {
            matchFound =  false;
            for(int j =0;j<maxLength;j++)
            {
                if(i ==  crossPoints[j])
                {
                    matchFound = true;
                }
            }
            if(matchFound ==  false)
            {
                newChromo2.setData(i, tempArray2[k]);
                k++;
            }
        }
    }
    public void exchangeMutation(int index, int exchanges)
    {
        int i = 0, tempData = 0;
        Chromosome thisChromo = null;
        int gene1 = 0;
        int gene2 = 0;
        boolean done = false;
        thisChromo = population.get(index);
        while(!done)
        {
            gene1 = getRandomNumber(0, maxLength - 1);
            gene2 = getExclusiveRandomNumber(maxLength, gene1);
            
            tempData = thisChromo.getData(gene1);
            thisChromo.setData(gene1,thisChromo.getData(gene2));
            thisChromo.setData(gene2, tempData);
            
            if(i == exchanges)
            {
                done = true;
            }
            i++;
        }
        mutations++;
    }
    public int chooseParent()
    {
        int parent = 0;
        Chromosome thisChromo = null;
        boolean done = false;
        
        while(!done)
        {
            parent = getRandomNumber(0,population.size()-1);
            thisChromo = population.get(parent);
            if(thisChromo.isSelected() == true)
            {
                done = true;
            }
        }
        return parent;
    }
    public int chooseParent(int parentA)
    {
        int parent = 0;
        Chromosome thisChromo = null;
        boolean done =  false;
        while(!done)
        {
            parent = getRandomNumber(0,population.size()-1);
            if(parent != parentA)
            {
                thisChromo = population.get(parent);
                if(thisChromo.isSelected() == true)
                {
                    done = true;
                }
            }
        }
        return parent;
    }
    public void prepNextEpoch()
    {
        int popSize = 0;
        Chromosome thisChromo = null;
        popSize = population.size();
        for(int i = 0; i < popSize; i++)
        {
            thisChromo = population.get(i);
            thisChromo.setSelected(false);
        }
    }
    public void printBestSolution(Chromosome bestSolution)
    {
        String board[][] = new String [maxLength][maxLength];
        for(int x=0;x < maxLength; x++)
        {
            for(int y = 0;y < maxLength; y++)
            {
                board[x][y] = "";
            }
        }
        for(int x = 0; x < maxLength; x++)
        {
            board[x][bestSolution.getData(x)] = "Q";
        }
        System.out.println("Board : ");
        for(int y =0;y < maxLength; y++)
        {
            for(int x=0; x <maxLength; x++)
            {
                if(board[x][y] == "Q")
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.print("\n");
        }
    }
    public int getRandomNumber(int low, int high)
    {
        return (int) Math.round((high -  low) * new Random().nextDouble()+low);
    }
    public int getExclusiveRandomNumber(int high, int except)
    {
        boolean done =  false;
        int getRand = 0;
        while(!done)
        {
            getRand =  new Random().nextInt(high);
            if(getRand !=except)
            {
                done = true;
            }
        }
        return getRand;
    }
    public int getRandomNumber(int low, int high, int[] except)
    {
        boolean done =  false;
        int getRand = 0;
        if(high !=  low)
        {
            while(!done)
            {
                done = true;
                getRand = (int)Math.round((high -  low) * new Random().nextDouble() + low);
                for(int i = 0;i < except.length; i++)
                {
                    if(getRand ==  except[i])
                    {
                        done =  false;
                    }
                }
            }
            return getRand;
        }
        else
        {
            return high;
        }
    }
    public int minimum()
    {
        int popSize = 0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done = false;
        
        while(!done)
        {
            foundNewWinner =  false;
            popSize = population.size();
            for(int i=0;i<popSize;i++)
            {
                if(i != winner)
                {
                    thisChromo = population.get(i);
                    thatChromo = population.get(winner);
                    if(thisChromo.getConflicts() < thatChromo.getConflicts())
                    {
                        winner = i;
                        foundNewWinner =  true;
                    }
                }
            }
            if(foundNewWinner ==  false)
            {
                done = true;
            }
            
        }
        return winner;
    }
    public int maximum()
    {
        int popSize = 0;
        Chromosome thisChromo = null;
        Chromosome thatChromo = null;
        int winner = 0;
        boolean foundNewWinner = false;
        boolean done =  false;
        while(!done)
        {
            foundNewWinner = false;
            popSize = population.size();
            for(int i = 0;i<popSize;i++)
            {
                if(i != winner)
                {
                    thisChromo = population.get(i);
                    thatChromo = population.get(winner);
                    if(thisChromo.getConflicts() > thatChromo.getConflicts())
                    {
                        winner = i;
                        foundNewWinner = true;
                    }
                }
            }
            if(foundNewWinner ==  false)
            {
                done =true;
            }
        }
        return winner;
    }
    public void initializeChromosome()
    {
        int shuffles = 0;
        Chromosome newChromo = null;
        int chromoIndex=0;
        for(int i =0; i < startSize; i++)
        {
            newChromo =  new Chromosome();
            population.add(newChromo);
            chromoIndex = population.indexOf(newChromo);
            shuffles = getRandomNumber(minShuffles, maxShuffles);
            exchangeMutation(chromoIndex, shuffles);
            population.get(chromoIndex).computeConflicts();
        }
    }
}
