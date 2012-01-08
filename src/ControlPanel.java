import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import javax.swing.Timer;
import java.util.ArrayList;

/*import mk.dynamic.network.SIRModel;
import mk.dynamic.network.SIRModelSwap;
import mk.dynamic.network.Grid;
import mk.dynamic.network.Rule;*/

import mk.dynamic.network.*;


/**
 *
 * @author mkirschner
 */
public class ControlPanel extends JPanel {
    DrawingSurface drawingSurface;
    
    public ControlPanel(DrawingSurface drawingSurface) {
        this.drawingSurface = drawingSurface;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        
    }  
    
}
