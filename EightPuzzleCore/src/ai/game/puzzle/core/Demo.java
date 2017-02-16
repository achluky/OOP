/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game.puzzle.core;

/**
 *
 * @author Jayuk
 */
public class Demo 
{
    public static void main(String[] args)
    {
        Generation g;
        String goal = "0,1,2,3,4,5,6,7,8";
        String current = "1,2,5,3,4,8,6,7,0";
        g = new Generation(current,goal);
        g.createChildren();
    }
}
