package mk.dynamic.network;

import mk.dynamic.network.Cell;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author mkirschner
 */
public class Grid {
    
    Cell [][] grid;
    int numX;
    int numY;
    
    public Grid(int numX, int numY, int size) {
        this.numX = numX;
        this.numY = numY;
        
        grid = new Cell[numX][numY];
        int x=0; 
        int y=0;
        
        for (int j=0; j<numY; j++) {
            for (int i=0; i<numX; i++) {
                grid[i][j] = new Cell(x,y);
                grid[i][j].height = size;
                grid[i][j].width = size;
                grid[i][j].xidx=i;
                grid[i][j].yidx=j;
                x+=size;
            }
            y+=size;
            x=0;
        }
        
        setNeighbors();
        
        grid[25][25].node.infectivePop = 0.7;
        grid[25][25].node.susceptiblePop = 0.3;
        
        for (int j=0; j<this.numY; j++) {
            grid[43][j].node.susceptiblePop=0.01;
            grid[43][j].node.infectivePop=0.0;
            grid[43][j].node.removedPop=0.99;
        }
       // for (Node n : grid[40][40].node.friends) {
      //      n.susceptiblePop = 1;
       // }
    }
    
    public void render(Graphics g) {
        for (int j=0; j<numY; j++) {
            for (int i=0; i<numX; i++) {
                grid[i][j].render(g);
            }
        }
    }
    
    public void performRule() {
    //    System.out.println(grid[4][4].node.infectivePop);
        for (int j=0; j<numY; j++) {
            for (int i=0; i<numX; i++) {
                grid[i][j].node.performRule();
            }
        }
        
        for (int j=0; j<numY; j++) {
            for (int i=0; i<numX; i++) {
                grid[i][j].node.swap();
            }
        }
        
     //   System.out.println("4,4= " + grid[4][4].node.infectivePop);
        
       // System.out.println("5,4= "+grid[5][4].node.infectivePop);
    }
    
    public void setNeighbors() {
        for (int j=0; j<numY; j++) {
            for (int i=0; i<numX; i++) {
                
                ArrayList<Node> friends = new ArrayList<Node>();
                
                
                // construct 8 friends
                
                try {
                    friends.add(grid[i-1][j].node);
                } catch(Exception e) {}
                
                try {
                    friends.add(grid[i-1][j-1].node);
                }catch(Exception e) {}
                try {
                    friends.add(grid[i][j-1].node);
                }catch(Exception e) {}
                try {
                    friends.add(grid[i+1][j-1].node);
                }catch(Exception e) {}
                try {
                    friends.add(grid[i+1][j].node);
                }catch(Exception e) {}
                try {
                    friends.add(grid[i-1][j+1].node);
                }catch(Exception e) {}
                try {
                    friends.add(grid[i][j+1].node);
                }catch(Exception e) {}
                
                try {
                    friends.add(grid[i+1][j+1].node);
                } catch(Exception e) {}
                
            
                grid[i][j].node.friends = friends;
              
            }
           
        }
    }
}
