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
//import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

/**
 *
 * @author mkirschner
 */
public class ControlPanel extends JPanel {
    DrawingSurface drawingSurface;
    JTextField timerDelayField;
    
    public ControlPanel(DrawingSurface drawingSurface) {
        this.drawingSurface = drawingSurface;
        
        this.setLayout(new BorderLayout());
        
        JButton timerStartButton = new JButton("Start");
        timerStartButton.addActionListener(new ButtonTimer());
        timerStartButton.setActionCommand("START");
        //this.add(timerStartButton, BorderLayout.NORTH);
        
        JButton timerStopButton = new JButton("Stop");
        timerStopButton.addActionListener(new ButtonTimer());
        timerStopButton.setActionCommand("STOP");
        //this.add(timerStopButton, BorderLayout.SOUTH);
        
        /**********/
        /*JPanel timerPanel = new JPanel();
        timerPanel.setLayout(new BoxLayout(timerPanel, BoxLayout.PAGE_AXIS));
        
        
        JLabel l1 = new JLabel("Delay");
        timerPanel.add(l1);
       
        JTextField timerDelayField = new JTextField(5);
        timerPanel.add(timerDelayField);
        */
        
        //Lay out the text controls and the labels.
        JPanel textControlsPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        textControlsPane.setLayout(gridbag);

       /* JLabel[] labels = {textFieldLabel, passwordFieldLabel, ftfLabel};
        JTextField[] textFields = {textField, passwordField, ftf};
        addLabelTextRows(labels, textFields, gridbag, textControlsPane); */

        c.gridwidth = GridBagConstraints.REMAINDER; //last
        c.anchor = GridBagConstraints.WEST;
        c.weightx = 1.0;
        //textControlsPane.add(actionLabel, c);
        textControlsPane.setBorder(
                BorderFactory.createCompoundBorder(
                                BorderFactory.createTitledBorder("Sim Control"),
                                BorderFactory.createEmptyBorder(5,5,5,5)));
        
        
        JLabel l1 = new JLabel("Delay");
        textControlsPane.add(l1);
        timerDelayField = new JTextField(5);
        timerDelayField.setText(Integer.toString(drawingSurface.delay));
        
        textControlsPane.add(timerDelayField);
        textControlsPane.add(timerStartButton);
        textControlsPane.add(timerStopButton);
        /**************/
       // this.add(timerPanel, BorderLayout.WEST);
        JButton resetButton = new JButton("Initialize");
        resetButton.addActionListener(new ButtonReset());
        textControlsPane.add(resetButton);
        
       this.add(textControlsPane, BorderLayout.PAGE_START);
        
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,400);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        
    }  
    
    class ButtonTimer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("START")) {
                try {
                drawingSurface.timer.setDelay(Integer.parseInt(timerDelayField.getText()));
                } catch(Exception e) {
                    System.out.println(e);
                }
                drawingSurface.timer.start();
                System.out.println(drawingSurface.timer.getDelay());
                
                
            }
            if (ae.getActionCommand().equals("STOP")) {
                drawingSurface.timer.stop();
            }
        }
        
    }
    
    class ButtonReset implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            drawingSurface.timer.stop();
            drawingSurface.init();
            drawingSurface.repaint();
        }
    }
    
}
