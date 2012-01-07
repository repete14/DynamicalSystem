package mk.dynamic.network;

/**
 *
 * @author mkirschner
 */
public class SIRModelSwap implements Rule {
    Grid grid; 
    
    public SIRModelSwap(Grid grid) {
        this.grid = grid;
    }
    
    public void performRule() {    
        for (int j=0; j<this.grid.numY; j++) {
            for (int i=0; i<this.grid.numX; i++) {
                this.grid.grid[i][j].node.swap();
            }
        }
    }
}
