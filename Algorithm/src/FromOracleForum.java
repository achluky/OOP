/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author Jayuk
 */
public class FromOracleForum 
{
    public static void main(String[] args) {
        /*
   if(args.length!=2) {
     System.err.println("Usage: java -cp . BFMatch <String> <match>");
     System.exit(1);
   }
*/
        String data="abc";
        String match="bac";

   List l = bruteForceMatch(data,match);
   Iterator i = l.iterator();
   while(i.hasNext()){
     System.out.println(i.next());
   }
        System.out.println(l);

}


    public static List bruteForceMatch(String data, String match) {
   // do some valididity checks here

   // create results 
        List list = new LinkedList();
        for(int n=0;n<(data.length()-match.length());n++){
        for(int m=0;(m<match.length())&&(data.charAt(m+n)==match.charAt(m));m++)   
            if(m>=match.length()-1) list.add(new Integer(n));
        }
        return list;
    }
}