package mk.dynamic.network;

/**
 *
 * @author mkirschner
 */
public class SIRSModel implements Rule {
    Grid grid; 
    
    public SIRSModel(Grid grid) {
        this.grid = grid;
    }
    
    @Override
    public void performRule() {
        for (Cell [] cellArray : this.grid.grid) {
            for (Cell c : cellArray) {
                Node n = c.node;
                
                n.susceptiblePopTmp = n.susceptiblePop + -1*n.contactRate*n.susceptiblePop*n.infectivePop +n.remToSucRate*n.removedPop;

                for (Node n2 : n.friends) {
                    n.susceptiblePopTmp += -1*(n.contactRate/2)*n.susceptiblePop*n2.infectivePop;
                }

                n.infectivePopTmp = n.infectivePop + n.contactRate*n.susceptiblePop*n.infectivePop;
                for (Node n2 : n.friends) {
                    n.infectivePopTmp += (n.contactRate/2)*n.susceptiblePop*n2.infectivePop;
                }     
                n.infectivePopTmp += -1*n.removalRate*n.infectivePop;   
                n.removedPopTmp = n.removedPop +  n.removalRate*n.infectivePop -n.remToSucRate*n.removedPop;
            }
            
        }
        
        for (int j=0; j<this.grid.numY; j++) {
            for (int i=0; i<this.grid.numX; i++) {
                this.grid.grid[i][j].node.swap();
            }
        }
    }
}
