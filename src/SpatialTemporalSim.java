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
import java.awt.Toolkit;

/*import mk.dynamic.network.SIRModel;
import mk.dynamic.network.SIRModelSwap;
import mk.dynamic.network.Grid;
import mk.dynamic.network.Rule;*/

import mk.dynamic.network.*;

public class SpatialTemporalSim {
    
    static DrawingSurface drawingSurface;
    static ControlPanel controlPanel;
   
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }

    private static void createAndShowGUI() {
        
        drawingSurface = new DrawingSurface();
        controlPanel = new ControlPanel(drawingSurface);
        
        System.out.println("Created GUI on EDT? "+
        SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Graphical Model");
        // Set Location
         
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        
        f.setLocation(dim.width/10,dim.height/10);
                
                
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.add(drawingSurface);
        f.pack();
        
        f.setVisible(true);
        
        JFrame controlPanelFrame = new JFrame("Control Panel");
        controlPanelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlPanelFrame.add(new ControlPanel(drawingSurface));
        controlPanelFrame.setLocation(f.getLocation().x+f.getWidth(), f.getLocation().y);
        controlPanelFrame.pack();
        
        controlPanelFrame.setVisible(true);
        
        
        
        
    }
}
