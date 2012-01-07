package mk.dynamic.network;

import mk.dynamic.network.Cell;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author mkirschner
 * 
 * 
 * The Grid will setup the Cell Lists and Render the cells to the screen
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
        
        grid[10][10].node.infectivePop = 1;
        grid[10][10].node.susceptiblePop = 0;
        grid[10][10].node.removedPop = 0;
        
        grid[10][12].node.infectivePop = 0;
        grid[10][12].node.susceptiblePop = 1;
        grid[10][12].node.removedPop = 0;
        
        grid[10][14].node.infectivePop = 0;
        grid[10][14].node.susceptiblePop = 0;
        grid[10][14].node.removedPop = 1;
        
        //grid[25][25].node.infectivePop = 0.7;
        //grid[25][25].node.susceptiblePop = 0.3;
        
      //  grid[30][30].node.infectivePop = 1;
       // grid[][25].node.susceptiblePop = 0;
        
   /*     for (int j=0; j<this.numY; j++) {
            grid[43][j].node.susceptiblePop=0.01;
            grid[43][j].node.infectivePop=0.0;
            grid[43][j].node.removedPop=0.99;
        }
        
        for (int j=0; j<this.numY; j++) {
            grid[15][j].node.susceptiblePop=0.01;
            grid[15][j].node.infectivePop=0.49;
            grid[15][j].node.removedPop=0.5;
        } */
     
    }
    
    public void render(Graphics g) {
        for (int j=0; j<numY; j++) {
            for (int i=0; i<numX; i++) {
                grid[i][j].render(g);
            }
        }
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
