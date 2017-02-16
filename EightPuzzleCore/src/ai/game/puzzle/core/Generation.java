/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game.puzzle.core;

import java.util.ArrayList;

public class Generation 
{
    private String target;
    private String data;
    private String tempResult;
    private ArrayList<OffSpring> openList;
    private ArrayList<OffSpring> closeList;
    private ManipulasiString manipulasiString;
    private OffSpring offSpring;
    private OffSpring gOS;
    private int parent;
    private int prevParent;
    private String parentMovement;
    private int currentId;
    private int level;
    private String route;
    Generation(String data, String target)
    {
        this.tempResult = "";
        this.target = target;
        this.data = data;
        openList = new ArrayList<>();
        closeList = new ArrayList<>();
        prevParent = 0;
        route = "";
    }
    public ArrayList<OffSpring> getOpenList()
    {
        return openList;
    }
    private int addCurrentId()
    {
        this.currentId += 1;
        return this.currentId;
    }
    private void addLevel()
    {
        this.level += 1;
    }
    private int getLevel()
    {
        return this.level;
    }
    private int defineLevel(int parent)
    {
        int countLevel=0;
        int curParent = parent;
        if(curParent  == 21)
        {
            System.out.println("Level :"+curParent);
            
        }
        return countLevel+1;
    }
    private void setParent(int parent)
    {
        this.parent = parent;
    }
    private int getParent()
    {
        return this.parent;
    }
    public void printOpenList()
    {
        System.out.println("Hasil OpenList : ");
        for (OffSpring s:openList) 
        {
            System.out.println(s.getData()+" - "+s.getId()+""+s.getMovement()+"-"+s.getParent()+"-"+s.getLevel()+""+s.getHeuristicValue());
        }
    }
    public void printCloseList()
    {
        System.out.println("Hasil CloseList: ");
        for (OffSpring s:closeList) 
        {
            System.out.println(s.getData()+" - "+s.getId()+""+s.getMovement()+"-"+s.getParent()+"-"+s.getLevel()+""+s.getHeuristicValue());
        }
    }
    public int getHeuristic(String data)
    {         
        return 0;   
    }          
    public boolean matchTarget()
    {
        for (OffSpring s:openList) 
        {
            if(s.getData().matches(this.target))
            {
                this.gOS = s;
                return true;
            }
        }
        return false;
    }
    public void createChildren()
    {
        while(this.level<20)
        {
            createLeftChild();
            createRightChild();
            createUpChild();
            createBotChild();
            
            if(this.matchTarget())
                break;
            else
            {
                this.data = openList.get(0).getData();
                this.setParent(openList.get(0).getId());
                this.closeList.add(openList.get(0));
                this.openList.remove(0);
            }
        }
        this.printOpenList();
        this.printCloseList();
        this.setRoute();
        this.displayRoute();
    }
    public void createLeftChild()
    {
        String temp[]=null;
        manipulasiString = new ManipulasiString(this.data);
        if(manipulasiString.getLeftSide() != null && !this.isCreated(manipulasiString.getLeftSide()))
        {
            temp = this.manipulasiString.getData();
            temp[this.manipulasiString.getPosition()] = manipulasiString.getLeftSide();
            temp[this.manipulasiString.getPosition()-1] = "0";
            for (int i = 0; i < temp.length; i++) 
            {
                tempResult = tempResult.concat(temp[i]);
                if(i+1 < temp.length)
                    tempResult = tempResult.concat(",");
            }
            this.offSpring = new OffSpring(this.tempResult,"Left",this.getParent(),getHeuristic(this.tempResult),this.addCurrentId(),this.defineLevel(this.getParent()));
            openList.add(this.offSpring);
            this.tempResult = "";
        }
    }
    public void createRightChild()
    {
        String temp[]=null;
        manipulasiString = new ManipulasiString(this.data);
        if(manipulasiString.getRightSide() != null && !this.isCreated(manipulasiString.getRightSide()))
        {
            temp = this.manipulasiString.getData();
            temp[this.manipulasiString.getPosition()] = manipulasiString.getRightSide();
            temp[this.manipulasiString.getPosition()+1] = "0";
            for (int i = 0; i < temp.length; i++) 
            {
                tempResult = tempResult.concat(temp[i]);
                if(i+1 < temp.length)
                    tempResult = tempResult.concat(",");
            }
            this.offSpring = new OffSpring(this.tempResult,"Right",this.getParent(),getHeuristic(this.tempResult),this.addCurrentId(),this.defineLevel(this.getParent()));
            openList.add(this.offSpring);
            this.tempResult = "";
        }
    }
    public void createUpChild()
    {
        String temp[]=null;
        manipulasiString = new ManipulasiString(this.data);
        if(manipulasiString.getUpSide() != null && !this.isCreated(manipulasiString.getUpSide()))
        {
            temp = this.manipulasiString.getData();
            temp[this.manipulasiString.getPosition()] = manipulasiString.getUpSide();
            temp[this.manipulasiString.getPosition() - (int)Math.sqrt(temp.length)] = "0";
            for (int i = 0; i < temp.length; i++) 
            {
                tempResult = tempResult.concat(temp[i]);
                if(i+1 < temp.length)
                    tempResult = tempResult.concat(",");
            }
            this.offSpring = new OffSpring(this.tempResult,"Up",this.getParent(), getHeuristic(this.tempResult), this.addCurrentId(),this.defineLevel(this.getParent()));
            openList.add(this.offSpring);
            this.tempResult = "";
        }
    }
        public void createBotChild()
        {
            String temp[]=null;
            manipulasiString = new ManipulasiString(this.data);
            if(manipulasiString.getBotSide() != null && !this.isCreated(manipulasiString.getBotSide()))
            {
                temp = this.manipulasiString.getData();
                temp[this.manipulasiString.getPosition()] = manipulasiString.getBotSide();
                temp[this.manipulasiString.getPosition() + (int)Math.sqrt(temp.length)] = "0";
                for (int i = 0; i < temp.length; i++) 
                {
                    tempResult = tempResult.concat(temp[i]);
                    if(i+1 < temp.length)
                        tempResult = tempResult.concat(",");
                }
                this.offSpring = new OffSpring(this.tempResult,"Bottom",this.getParent(), getHeuristic(this.tempResult), this.addCurrentId(),this.defineLevel(this.getParent()));
                openList.add(this.offSpring);
                this.tempResult = "";
            }
        }
        public boolean isCreated(String os)
        {
            for (OffSpring s:openList) 
            {
                if(s.getData().matches(os))
                {
                    return true;
                }
            }
            for (OffSpring s:closeList) 
            {
                if(s.getData().matches(os))
                {
                    return true;
                }
            }
            return false;
        }
        public void displayRoute()
        {
            System.out.println("Route : ");
            for (int i = route.length()-1; i >=0; i--) 
            {
                System.out.println(route.charAt(i));
            }
        }
        public void setRoute()
        {
            //lengkapi method ini sesuai tugas no 2     
        }
}