/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Tugas 
{
    String findWord(char[][] board, String word)
    {
        String finalResult=null;
        int x = board.length;
        int y = board[0].length;
        
        for(int i=0; i<x;i++)
        {
            for(int j =0;i<y;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    
                }
            }
        }
        
        return finalResult;
    }
    
    private static boolean horizontalContains(char[][] grid, String word) {
    int wordLength = word.length();
    int max = grid.length - wordLength;
    char[] wordArray = word.toCharArray();
    for (int i = 0, length = grid[0].length; i < length; i++) {
        loop: for (int j = 0; j < max; j++) {
            for (int k = j; k < wordArray.length; k++) {
                if (wordArray[k - j] != grid[k][i]) {
                    continue loop;
                }
            }
            return true;
        }
    }
}
    
    public boolean verticalDownContains(int x, int y, String word)
    {
        if(x>word.length())
        {
            return false;
        }
        else
        {
            if()
        }
        return false;
    }
    public boolean verticalUpContains()
    {
        return false;
    }
    public boolean horizontalLeftContains()
    {
        return false;
    }
    public boolean horizontalRightContains()
    {
        return false;
    }
}
