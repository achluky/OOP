/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ai.algorithm;

/**
 *
 * @author Jayuk
 */
public class Chromosome
    {
        int maxLength = NQueenWithGenetika.MAX_LENGTH;
        private int mData[] = new int[NQueenWithGenetika.MAX_LENGTH];
        private double mFitness = 0.0;
        private boolean mSelected = false;
        private double mSelectionProbability = 0.0;
        private int mConflicts = 0;
    
        public Chromosome()
        {
            for(int i = 0; i < maxLength; i++)
            {
                this.mData[i] = i;
            }
        }
        
        public void computeConflicts()
        {
            int x = 0;
            int y = 0;
            int tempx = 0;
            int tempy = 0;
            String board[][] = new String[maxLength][maxLength];
            int conflicts = 0;
            int dx[] = new int[] {-1, 1, -1, 1};
            int dy[] = new int[] {-1, 1, 1, -1};
            boolean done = false;

            // Clear the board.
            for(int i = 0; i < maxLength; i++)
            {
                for(int j = 0; j < maxLength; j++)
                {
                    board[i][j] = "";
                }
            }

            for(int i = 0; i < maxLength; i++)
            {
                board[i][this.mData[i]] = "Q";
            }

            // Walk through each of the Queens and compute the number of conflicts.
            for(int i = 0; i < maxLength; i++)
            {
                x = i;
                y = this.mData[i];

                // Check diagonals.
                for(int j = 0; j <= 3; j++)
                {
                    tempx = x;
                    tempy = y;
                    done = false;
                    while(!done)
                    {
                        tempx += dx[j];
                        tempy += dy[j];
                        if((tempx < 0 || tempx >= maxLength) || (tempy < 0 || tempy >= maxLength))
                        {
                            done = true;
                        }else{
                            if(board[tempx][tempy].compareToIgnoreCase("Q") == 0){
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
            this.mConflicts = value;
        }
        public int getConflicts()
        {
            return this.mConflicts;
        }
    
        public double getSelectionProbability()
        {
            return mSelectionProbability;
        }
        public void setSelectionProbability(double SelProb)
        {
            mSelectionProbability = SelProb;
        }
    
        public boolean isSelected()
        {
            return mSelected;
        }
        public void setSelected(boolean sValue)
        {
            mSelected = sValue;
        }
    
        public double getFitness()
        {
            return mFitness;
        }
        public void setFitness(final double score)
        {
            mFitness = score;
        }
    
        public int getData(final int index)
        {
            return mData[index];
        }
        public void setData(final int index, final int value)
        {
            mData[index] = value;
            return;
        }
    }
