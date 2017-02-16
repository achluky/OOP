/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game.puzzle.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;


/**
 *
 * @author Jayuk
 */
public class GamePlay implements Initializable
{
    boolean isCompleted=false;
    @FXML
    private GridPane gpBoard; 
    Button bt1,bt2, bt3,bt4,bt5,bt6,bt7,bt8;
    int listIndex[] [] = new int [3][3] ;
    
    ObservableList<String> list =  FXCollections.observableArrayList();
    
    @FXML
    private ListView<String> MovementLV;
    
    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        MovementLV.setEditable(false);
        MovementLV.setItems(list);
        
        bt1 = new Button("1");
        bt1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt1.setOnAction(myHandler1);
        
        bt2 = new Button("2");
        bt2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt2.setOnAction(myHandler2);
        
        bt3 = new Button("3");
        bt3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt3.setOnAction(myHandler3);
        
        bt4 = new Button("4");
        bt4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt4.setOnAction(myHandler4);
        
        bt5 = new Button("5");
        bt5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt5.setOnAction(myHandler5);
        
        bt6 = new Button("6");
        bt6.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt6.setOnAction(myHandler6);
        
        bt7 = new Button("7");
        bt7.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt7.setOnAction(myHandler7);
        
        bt8 = new Button("8");
        bt8.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        bt8.setOnAction(myHandler8);
        
        List<Integer> listBaris =  new ArrayList<>();
        List<Integer> listKolom =  new ArrayList<>();
        listBaris.add(0);
        listBaris.add(1);
        listBaris.add(2);
        Collections.shuffle(listBaris);
        listKolom.add(0);
        listKolom.add(1);
        listKolom.add(2);
        Collections.shuffle(listKolom);
        
        gpBoard.add(bt1 , listBaris.get(0), listKolom.get(0));
        listIndex[listBaris.get(0)] [listKolom.get(0)] = 1;
        gpBoard.add(bt2 , listBaris.get(0), listKolom.get(1));
        listIndex[listBaris.get(0)] [listKolom.get(1)] = 2;
        gpBoard.add(bt3 , listBaris.get(0), listKolom.get(2));
        listIndex[listBaris.get(0)] [listKolom.get(2)] = 3;
        gpBoard.add(bt4 , listBaris.get(1), listKolom.get(0));
        listIndex[listBaris.get(1)] [listKolom.get(0)] = 4;
        gpBoard.add(bt5 , listBaris.get(1), listKolom.get(1));
        listIndex[listBaris.get(1)] [listKolom.get(1)] = 5;
        gpBoard.add(bt6 , listBaris.get(1), listKolom.get(2));
        listIndex[listBaris.get(1)] [listKolom.get(2)] = 6;
        gpBoard.add(bt7 , listBaris.get(2), listKolom.get(0));
        listIndex[listBaris.get(2)] [listKolom.get(0)] = 7;
        gpBoard.add(bt8 , listBaris.get(2), listKolom.get(1));
        listIndex[listBaris.get(2)] [listKolom.get(1)] = 8;
        listIndex[listBaris.get(2)] [listKolom.get(2)] = 0;
        
        printArray(listIndex);
    }
    
    final EventHandler<ActionEvent> myHandler1 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt1);
            Integer x = GridPane.getColumnIndex(bt1);
            int point[] = null;
            point = getMovement(x, y);
            if(point!=null)
            {
                gpBoard.getChildren().removeAll(bt1);
                gpBoard.add(bt1 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler2 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt2);
            Integer x = GridPane.getColumnIndex(bt2);
            int point[] = null;
            point = getMovement(x, y);
            if(point!=null)
            {
                gpBoard.getChildren().removeAll(bt2);
                gpBoard.add(bt2 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler3 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt3);
            Integer x = GridPane.getColumnIndex(bt3);
            int point[] = null;
            point = getMovement(x, y);
            if(point!=null)
            {
                gpBoard.getChildren().removeAll(bt3);
                gpBoard.add(bt3 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler4 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt4);
            Integer x = GridPane.getColumnIndex(bt4);
            int point[] = null;
            point = getMovement(x, y);
            if(point != null)
            {
                gpBoard.getChildren().removeAll(bt4);
                gpBoard.add(bt4 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler5 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt5);
            Integer x = GridPane.getColumnIndex(bt5);
            int point[] = null;
            point = getMovement(x, y);
            if(point != null)
            {
                gpBoard.getChildren().removeAll(bt5);
                gpBoard.add(bt5 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler6 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt6);
            Integer x = GridPane.getColumnIndex(bt6);
            int point[] = null;
            point = getMovement(x, y);
            if(point!=null)
            {
                gpBoard.getChildren().removeAll(bt6);
                gpBoard.add(bt6 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler7 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt7);
            Integer x = GridPane.getColumnIndex(bt7);
            int point[] = null;
            point = getMovement(x, y);
            if(point!=null)
            {
                gpBoard.getChildren().removeAll(bt7);
                gpBoard.add(bt7 ,point[0] , point[1]);
            }
        }
    };
    
    final EventHandler<ActionEvent> myHandler8 = new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(final ActionEvent event) 
        {
            Integer y = GridPane.getRowIndex(bt8);
            Integer x = GridPane.getColumnIndex(bt8);
            int point[] = null;
            point = getMovement(x, y);
            if(point !=null)
            {
                gpBoard.getChildren().removeAll(bt8);
                gpBoard.add(bt8 ,point[0] , point[1]);
            }
        }
    };
    
    
    public void printArray(int list[] [])
    {
        int k=1;
        for(int x =0;x<list.length;x++)
        {
            for(int y=0;y<list.length;y++)
            {
                if(k % 3 == 0)
                    System.out.println(list[y][x]);
                else
                    System.out.print(list[y][x]);
                k++;
            }
        }
    }
    
    public int[] getMovement(int x, int y)
    {
        cekComplete();
        if(isCompleted == false)
        {
            int point[]=new int[2];
            int a=-1,b=-1,c=-1,d=-1;
            try
            {
                a=listIndex[x-1][y];
            }
            catch(IndexOutOfBoundsException iobe)
            {
                System.out.println("-");;
            }
            try
            {
                b=listIndex[x][y-1];
            }
            catch(IndexOutOfBoundsException iobe)
            {
                System.out.println("-");;
            }
            try
            {
                c=listIndex[x+1][y];
            }
            catch(IndexOutOfBoundsException iobe)
            {
                System.out.println("-");;
            }
            try
            {
                d=listIndex[x][y+1] ;
            }
            catch(IndexOutOfBoundsException iobe)
            {
                System.out.println("-");
            }

            if(a == 0 )
            {
                System.out.println("Event Move Left");
                list.add("Event Move Left");
                point[0]=x-1;
                point[1]=y;
                int temp = listIndex[x-1][y];
                listIndex[x-1][y] = listIndex[x][y];
                listIndex[x][y] = temp; 
                cekComplete();
                return point;
            }
            else if (b == 0)
            {
                System.out.println("Event Move Up");
                list.add("Event Move Up");
                point[0]=x;
                point[1]=y-1;
                int temp = listIndex[x][y-1];
                listIndex[x][y-1] = listIndex[x][y];
                listIndex[x][y] = temp;
                cekComplete();
                return point;
            }
            else if (c == 0)
            {
                System.out.println("Event Move Right");
                list.add("Event Move Right");
                point[0]=x+1;
                point[1]=y;
                int temp = listIndex[x+1][y];
                listIndex[x+1][y] = listIndex[x][y];
                listIndex[x][y] = temp;
                cekComplete();
                return point;
            }
            else if (d== 0)
            {
                System.out.println("Event Move Down");
                list.add("Event Move Down");
                point[0]=x;
                point[1]=y+1;
                int temp = listIndex[x][y+1];
                listIndex[x][y+1] = listIndex[x][y];
                listIndex[x][y] = temp;
                cekComplete();
                return point;
            }
            else
                System.out.println("---");
        }
        return null;
    }
    
    public void cekComplete()
    {
        int temp[][] = {{1,2,3},{4,5,6},{7,8,0}};
        int a=0;
        for(int i=0;i<temp.length;i++)
        {
            for(int j=0;j<listIndex.length;j++)
            {
                System.out.println(temp[i][j] +""+ listIndex[j][i]);
                if(temp[j][i] == listIndex[i][j])
                {
                    a++;
                }
            }
        }
        if(a==9)
        {
            System.out.println("Completed");
            isCompleted=true;
            list.add("Completed");
        }     
        
    }

    @FXML
    private void playBruteForce(ActionEvent event) throws InterruptedException 
    {
        while(isCompleted!= true)
        {
            int a = new Random().nextInt(7);
            if(a == 0)
                myHandler1.handle(event);
            else if(a == 1)
                myHandler2.handle(event);
            else if(a == 2)
                myHandler3.handle(event);
            else if(a == 3)
                myHandler4.handle(event);
            else if(a == 4)
                myHandler5.handle(event);
            else if(a == 5)
                myHandler6.handle(event);
            else if(a == 6)
                myHandler7.handle(event);
            else if(a == 7)
                myHandler8.handle(event);
        //Thread.sleep(1000);
        }
    }
    
}