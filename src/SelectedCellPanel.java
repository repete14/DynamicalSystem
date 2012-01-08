import javax.swing.*;
import java.awt.Graphics;

import mk.dynamic.network.*;
/**
 *
 * @author mkirschner
 */
public class SelectedCellPanel extends JPanel {
    
    public Cell selectedCell;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
      //  g.drawString("Hello World", 10, 10);
        
        selectedCell.render(g, 0,0, 188,161);
    }  
    
    
    public void setSelectedCell(Cell selectedCell) {
        this.selectedCell = selectedCell;
        repaint();
        System.out.println("ASLKJASLKDJALKSDJ");
    }
    
    public void update() {
        repaint();
    }
}
