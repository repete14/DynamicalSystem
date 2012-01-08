package mk.dynamic.network;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;

/**
 *
 * @author mkirschner
 */
public class Node {
    public ArrayList<Node> friends;
    
    int x, y;
    
    public double infectivePop;
    public double susceptiblePop;
    public double removedPop;
    
    public double infectivePopTmp;
    public double susceptiblePopTmp;
    public double removedPopTmp;
    
    public double contactRate;
    public double removalRate;
    public double remToSucRate;
    
    public Node(int x, int y) {
        //friends = new ArrayList<Node>();
        this.x = x;
        this.y = y;
        
        contactRate=Math.random()/10;
        removalRate=Math.random()/10;
        
        //System.out.println("Contact Rate=" + contactRate + ", removalRate=" + removalRate);
        
    //    susceptiblePop=Math.random();
     //   infectivePop=1-susceptiblePop;
        
        susceptiblePop = 1;
        
       remToSucRate=Math.random();//0.04;
    }
     
    public void swap() {
        infectivePop = infectivePopTmp;
        susceptiblePop = susceptiblePopTmp;
        removedPop = removedPopTmp;    
    }
   
    /* Mutators */
    public void setInf(double i) {
        this.infectivePop = i;
    }
    public void setSus(double s) {
        this.susceptiblePop = s;
    }
    public void setRem(double r) {
        this.removedPop = r;
    }
    
    public ArrayList<Node> getNodeList() { return friends; }
    
    public void setNodeList(ArrayList<Node> nodeList) { 
        this.friends = nodeList; 
    }
}
