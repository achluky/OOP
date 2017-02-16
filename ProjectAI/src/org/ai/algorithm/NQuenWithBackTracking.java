package org.ai.algorithm;

// Nama :   - Jaya Haryono Manik
//          - Wahyu A.P Nainggolan
//          - Paradena Turnip
//          - Amanda Fujianti Simamora
//          - Minarti Siahaan

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class NQuenWithBackTracking 
{
    private int[] perm;
    private boolean[] used;
    private int numsols;
    String alamatFile = "C:\\Users\\Jayuk\\Documents\\NetBeansProjects\\ProjectAI\\src\\org\\ai\\io\\BackTrackingLog.txt";
    BufferedWriter writer = null;
    int counterSimpulHidup = 0;
    int counterSimpulMati = 0;
    int counterSemuaIterasi=0;
    int counterIterasiBoard=0;
    
    public NQuenWithBackTracking(int n) throws FileNotFoundException, IOException 
    {
        FileOutputStream outputStream = new FileOutputStream(alamatFile);
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outputStream);
        writer = new BufferedWriter(outStreamWriter);
        perm = new int[n];
        used = new boolean[n];
        numsols = 0;

        for (int i=0; i<n; i++) {
            counterSemuaIterasi++;
                perm[i] = -1;
                used[i] = false;
        }
    }

    // Solves the 8-Queens problem for this object. This is just a 
    // wrapper function.
    public void solveIt() throws IOException {

    // Call the recursive function.
    System.out.println("Daftar Solusi yang didapatkan");
    solveItRec(0);
    }

    // Pre-condition: perm stores a permutation of queens from index 0 to location-1
    //                that is valid for a set of location number of non-conflicting
    //                queens. location represents the column we are placing the next
    //                queen, and usedList keeps track of the rows in which queens
    //                have already been placed.
    public void solveItRec(int location) throws IOException {

    int i;

    // We've found a solution to the problem, so print it!
    if (location == perm.length) 
    {
        printSol();
        numsols++;
    }

    // Loop through possible locations for the next queen to place.
    for (i=0; i<perm.length; i++) {
        counterSemuaIterasi++;
            // Only try this row if it hasn't already been used.
            if (used[i] == false) {

            // We can actually place this particular queen without conflict!                     
            if (!conflict(location, i)) {

                    // Place the new queen!                
                    perm[location] = i;

                    // We've used this row now, so mark that.
                    used[i] = true;

                    // Recursively solve this board.
                    solveItRec(location+1);

                    // Unselect this square, so that we can continue trying to
                    // fill it with the next possible choice.
                    used[i] = false;
            }                         

            }    
    }

    } 

    private boolean conflict(int location, int row) {

    int i;

    // See if the grid spot (location, row) shares a diagonal with any of
    // the previously placed queens.
    for (i=0; i<location; i++)
    {
        counterIterasiBoard++;
        counterSemuaIterasi++;
        // Diagonals have equal distance in the x and y axes.
            if (Math.abs(location - i) == Math.abs(perm[i] - row))
            {
                System.out.println("mati "+location+"  "+row);
                counterSimpulMati++;
                return true;
            }
    }
        // No conflict, so we could place a queen there.
        System.out.println("hidup "+location+" "+row);
        counterSimpulHidup++;
        return false;    
    }

    // Prints a two-dimensional representation of the solution stored in perm for
    // the eight queens problem. 
    public void printSol() throws IOException {
    
    int i,j;
    // Loop through each row.
    System.out.println("Solusi dengan Representasi String   :");
    writer.write("Solusi dengan Representasi String   :");
    writer.newLine();
    for(int k=0;k<perm.length;k++)
    {
        counterSemuaIterasi++;
        System.out.print(perm[k]);  
        writer.write(" "+perm[k]);
    }
    System.out.println("");
    writer.newLine();
    System.out.println("Solusi dengan Representasi Board    :");
    writer.write("Solusi dengan Representasi Board    :");
    writer.newLine();
    for (i=0; i<perm.length; i++) {

            // Go through each column in row i.
            for (j=0; j<perm.length; j++) 
            {
                counterSemuaIterasi++;
                // This means that the queen in column j resides in row i.
                if (perm[j] == i)     
                {
                    System.out.print("Q ");
                    writer.write("Q ");
                }
                // No queen here, so print a blank.
                else
                {
                        System.out.print(". ");
                        writer.write(". ");
                }    
            }
            if(perm.length-1 == i)
                {
                    System.out.println("");
                    writer.newLine();
                    System.out.println("Simpul Hidup sebanyak :"+counterSimpulHidup);
                    writer.write("Simpul Hidup sebanyak :"+counterSimpulHidup);
                    writer.newLine();
                    System.out.println("Simpul Mati sebanyak :"+counterSimpulMati);
                    writer.write("Simpul Mati sebanyak :"+counterSimpulMati);
                    counterSimpulHidup=0;
                    counterSimpulMati=0;
                }
            System.out.println("");
            writer.newLine();
        }
    }

    public void printNumSols() throws IOException 
    {
            System.out.println("Terdapat  "+numsols+" solusi yang berbeda.");
            writer.write("Terdapat  "+numsols+" solusi yang berbeda.");
            writer.newLine();
            //System.out.println("Simpul Hidup sebanyak :"+counterSimpulHidup);
            //System.out.println("Simpul Mati sebanyak :"+counterSimpulMati);
            System.out.println("Dengan Total Semua Iterasi :"+counterSemuaIterasi);
            
            //writer.write("Simpul Hidup sebanyak :"+counterSimpulHidup);
            //writer.write("Simpul Mati sebanyak :"+counterSimpulMati);
            writer.write("Jumlah Iterasi Board :"+counterIterasiBoard);
            writer.write("Dengan Total Semua Iterasi :"+counterSemuaIterasi);
            writer.close();
    }
}
