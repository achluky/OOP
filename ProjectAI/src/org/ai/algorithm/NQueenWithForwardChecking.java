/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
// Nama :   - Jaya Haryono Manik
//          - Wahyu A.P Nainggolan
//          - Paradena Turnip
//          - Amanda Fujianti Simamora
//          - Minarti Siahaan
package org.ai.algorithm;


import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

/**
 *
 * @author USER
 */

public class NQueenWithForwardChecking {

    public  int N;
    public  int numberOfSolutions=0;
    public  LinkedHashMap<Integer,int[]> results=new LinkedHashMap<Integer, int[]>();
    public  int[][] markKeeper;
    String alamatFile = "C:\\Users\\Jayuk\\Documents\\NetBeansProjects\\ProjectAI\\src\\org\\ai\\io\\ForwardCheckingLog.txt";
    BufferedWriter writer = null;
    int counterSimpulHidup = 0;
    int counterSimpulMati = 0;
    int counterSemuaIterasi=0;
    int counterIterasiBoard=0;
    int counterQueen=0;

    public NQueenWithForwardChecking() throws FileNotFoundException 
    {
        FileOutputStream outputStream = new FileOutputStream(alamatFile);
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outputStream);
        writer = new BufferedWriter(outStreamWriter);
    }

    public NQueenWithForwardChecking(int N, int[][] markKeeper) throws FileNotFoundException 
    {
        FileOutputStream outputStream = new FileOutputStream(alamatFile);
        OutputStreamWriter outStreamWriter = new OutputStreamWriter(outputStream);
        writer = new BufferedWriter(outStreamWriter);
        this.N = N;
        this.markKeeper = markKeeper;
    }
  
    
    public  boolean placeNQueens(int[] X, int N, int i)
    {
        if(i==N){
            int[] result=new int[N];
            System.arraycopy(X,0,result,0,N);
            results.put(numberOfSolutions,result);
            numberOfSolutions++;
            return true;
        }
        
        for (int j = 0; j < N; j++) 
        {
            counterSemuaIterasi++;
            X[i]=j;
            boolean flag=checkConstraints(X,N,i);
            if(counterQueen==4)
            {
                System.out.println("-------------------------------------");
                counterQueen=0;
            }
            
            if(flag)
                System.out.println("hidup"+j+i);
            else
                System.out.println("mati"+j+i);
            if(!flag)continue;
            boolean succ=placeNQueens(X,N,i+1);
            counterQueen++;
            
            
            //if (succ)return true; 
        }
        return false;
    }
    

    
    public  boolean isNoMoreRows(int[] X){
        for (int i = 0; i < N; i++) 
        {
            counterSemuaIterasi++;
            if(X[i]==-1)return false;
        }
        return true;
    }

    
    public  boolean checkConstraints(int[] A, int n, int r){
        for (int i = 0; i <= r-1; i++) 
        {
            counterSemuaIterasi++;
            if(A[i]==A[r] || A[r]-(r-i)==A[i] || A[r]+(r-i)==A[i])
            {
                
                return false;
            }
        } 
        return true;
    }
    
    public  boolean forwardCheck(int[] X,int i, int j){
        int m=i;
        
        for(int k=0; k<N ; k++,m--)
        {
            counterSemuaIterasi++;
            if(X[k]==-1)
            {
                markKeeper[k][j]-=1;
                if(j+m >= 0 && j+m < N)markKeeper[k][j+m]-=1;
                if(j-m >= 0 && j-m < N)markKeeper[k][j-m]-=1;
           }
        }
        return true;
    }
    
    public  void unmark(int[] X,int i, int j){
        int m=i;
        for(int k=0; k<N ; k++,m--)
        {
            counterSemuaIterasi++;
            if(X[k]==-1 && k!=i)
            {
                markKeeper[k][j]+=1;
                if(j+m >= 0 && j+m < N)markKeeper[k][j+m]+=1;
                if(j-m >= 0 && j-m < N)markKeeper[k][j-m]+=1;
            }
        }
    }
    
    
    public  void printResult(int N) throws IOException
    {
        for(int i =0 ;i<results.size();i++)
        {
            int[] result = results.get(i);
            int matrixTemp [][] = new int[result.length][result.length];
            for(int a =0;a<result.length;a++)
            {
                for(int b=0;b<result.length;b++)
                {
                    counterSemuaIterasi++;
                    matrixTemp[a][b] = 0;
                }
            }
            for(int a =0;a<result.length;a++)
            {
                counterSemuaIterasi++;
                matrixTemp [a][result[a]] = 1;
            }
            System.out.println("Solusi dengan Representasi Board    :");
            writer.write("Solusi dengan Representasi Board    :");
            writer.newLine();
            for(int a =0;a<result.length;a++)
            {
                for(int b=0;b<result.length;b++)
                {
                    counterSemuaIterasi++;
                    if(matrixTemp[b][a] == 0)
                    {
                        System.out.print(". ");
                        writer.write(". ");
                    }
                    else
                    {
                        System.out.print("Q ");
                        writer.write("Q ");
                    }
                }
                System.out.println("");
                writer.newLine();
            }
            System.out.println("solusi selanjutnya");
            writer.write("Solusi selanjutnya");
            writer.newLine();
            
        }
        if(!results.isEmpty()){
            int[] first=results.get(0);
            System.out.println("Total solutions: "+numberOfSolutions);
            writer.write("Total solutions: "+numberOfSolutions);
            writer.newLine();
            System.out.println("Solusi dengan Representasi String   :");
            writer.write("Solusi dengan Representasi String   :");
            writer.newLine();
            for (int i = 0; i < results.size(); i++) 
            {
                int[] result=results.get(i);
                for (int j = 0; j < N; j++) 
                {
                    counterSemuaIterasi++;
                    System.out.print((result[j]+1)+" ");
                    writer.write((result[j]+1)+" ");
                }
                System.out.println();
                writer.newLine();
            }
        }
        else 
            System.out.println("No solution found!!");
        writer.newLine();
        System.out.println("Simpul Hidup sebanyak :"+counterSimpulHidup);
        System.out.println("Simpul Mati sebanyak :"+counterSimpulMati);
        System.out.println("Dengan Total Semua Iterasi :"+counterSemuaIterasi);

        writer.write("Simpul Hidup sebanyak :"+counterSimpulHidup);
        writer.newLine();
        writer.write("Simpul Mati sebanyak :"+counterSimpulMati);
        writer.newLine();
        writer.write("Jumlah Iterasi Board :"+counterIterasiBoard);
        writer.newLine();
        writer.write("Dengan Total Semua Iterasi :"+counterSemuaIterasi);
        writer.close();
    }
    
}