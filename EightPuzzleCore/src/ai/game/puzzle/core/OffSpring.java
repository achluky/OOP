package ai.game.puzzle.core;

public class OffSpring {
    private String data;
    private String movement;
    private int parent;
    private int id;
    private int heuristicValue;
    private int level;
    public OffSpring() {
    }
    public OffSpring(String data, String movement, int parent, int heuristicValue, int id, int level)
    {
        this.data = data;
        this.movement = movement;
        this.parent = parent;
        this.id=id;
        this.level = level;
        this.heuristicValue = heuristicValue;
    } 
 
    public void setId(int id) 
    {
        this.id = id;
    } 
 
    public int getLevel() 
    {
        return level;
    } 
 
    public void setLevel(int level) 
    {
        this.level = level;
    }
    public void setData(String data) 
    {
        this.data = data;
    } 
 
    public void setMovement(String movement) 
    {
        this.movement = movement;
    } 
 
    public void setParent(int parent) 
    {
        this.parent = parent;
    }
     public void setHeuristicValue(int heuristicValue) 
     {
         this.heuristicValue = heuristicValue;
     }          
     public int getId() 
     {
         return id;
     }
     public String getData() 
     {
         return data;
     } 
 
    public String getMovement() 
    {
        return movement;
    } 
 
    public int getParent() 
    {
        return parent;
    }
    public int getHeuristicValue() 
    {
        return heuristicValue;
    }          
    public String toString()
    {
        return this.id+"-"+this.movement+"-"+this.parent+""+this.getLevel()+"-"+this.data;
    }
} 