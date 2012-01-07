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
    
    public Node(int x, int y) {
        //friends = new ArrayList<Node>();
        this.x = x;
        this.y = y;
        
        contactRate=0.01;
        removalRate=0.003;
        susceptiblePop=1;
    }
     
    public void swap() {
        infectivePop = infectivePopTmp;
        susceptiblePop = susceptiblePopTmp;
        removedPop = removedPopTmp;    
    }
    
    public void performRule() {     
            susceptiblePopTmp = susceptiblePop + -1*contactRate*susceptiblePop*infectivePop;
            
            for (Node n2 : friends) {
                susceptiblePopTmp += -1*(contactRate/2)*susceptiblePop*n2.infectivePop;
            }
            
            infectivePopTmp = infectivePop + contactRate*susceptiblePop*infectivePop;
            for (Node n2 : friends) {
                infectivePopTmp += (contactRate/2)*susceptiblePop*n2.infectivePop;
            }
            
            infectivePopTmp += -1*removalRate*infectivePop;
            
            removedPopTmp = removedPop +  removalRate*infectivePop;
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
