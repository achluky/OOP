

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Chromosome 
{
    int maximumLength;
    int mData[];
    double mFitness = 0.0;
    boolean mSelected =  false;
    double mSelectedProbability = 0.0;
    int mConflicts = 0;
    public Chromosome()
    {
        this.maximumLength = GenetikaNQueen.maxLength;
        this.mData =  new int[maximumLength];
        
        for(int i = 0;i<maximumLength;i++)
        {
            this.mData[i] = i;
        }
    }
    public void computeConflicts()
    {
        int x = 0,y = 0;
        int tempX = 0, tempY = 0;
        String board[][] =  new String [maximumLength][maximumLength];
        int conflicts = 0;
        int dx[] = new int[] {-1,1,-1,1};
        int dy[] = new int[] {-1,1,1,-1};
        boolean done = false;
        for(int i =0; i < maximumLength; i++)
        {
            for(int j=0; j < maximumLength; j++)
            {
                board[i][j] = "";
            }
        }
        for(int i = 0; i<maximumLength;i++)
        {
            board[i][this.mData[i]] = "Q";
        }
        for(int i=0;i<maximumLength;i++)
        {
            x = i;
            y = this.mData[i];
            for(int j=0; j <= 3; j++)
            {
                tempX = x;
                tempY = y;
                done = false;
                while(!done)
                {
                    tempX += dx[j];
                    tempY += dy[j];
                    if((tempX < 0 || tempX >=maximumLength) || (tempY < 0 || tempY >= maximumLength))
                    {
                        done = true;
                    }
                    else
                    {
                        if(board[tempX][tempY].compareToIgnoreCase("Q") == 0)
                        {
                            conflicts++;
                        }
                    }
                }
            }
        }
        this.mConflicts = conflicts;
    }
    public void setConflicts(int value)
    {
        this.mConflicts =  value;
    }
    public int getConflicts()
    {
        return this.mConflicts;
    }
    
    public double getSelectionProbability()
    {
        return this.mSelectedProbability;
    }
    public void setSelectionProbability(double selProb)
    {
        this.mSelectedProbability = selProb;
    }
    
    public boolean isSelected()
    {
        return this.mSelected;
    }
    public void setSelected(boolean sValue)
    {
        this.mSelected = sValue;
    }
    
    public double getFitness()
    {
        return this.mFitness;
    }
    public void setFitness(double fitness)
    {
        this.mFitness = fitness;
    }
    
    public int getData(int index)
    {
        return this.mData[index];
    }
    public void setData(int index, int value)
    {
        this.mData[index] =  value;
    }
}
