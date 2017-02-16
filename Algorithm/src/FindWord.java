
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class FindWord 
{
    private final char[][] grid;
    int length;

    public FindWord(char[][] grid) 
    {
        length = grid.length;
        this.grid = copyArray(grid);
    }

    public char[][] getGrid() {
        return copyArray(grid);
    }

    private char[][] copyArray(char[][] array) {
        char[][] result = Arrays.copyOf(array, length);
        for (int i = 0; i < length; i++) {
            result[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return result;
    }

    public boolean contains(String word) {
        return verticalContains(grid, word) || horizontalContains(grid, word);
    }

    private boolean verticalContains(char[][] grid1, String word) {
        for (char[] row : grid) {
            if (new String(row).contains(word)) {
                return true;
            }
        }
        return false;
    }

    private boolean horizontalContains(char[][] grid1, String word) 
    {
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
        return false;
    }

}
