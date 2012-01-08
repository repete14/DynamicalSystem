/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mkirschner
 */
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

public class DrawingSurface extends JPanel implements ActionListener {

    Grid grid;
  
    Timer timer;
    
    ArrayList<Rule> ruleList;
    
    public DrawingSurface() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        timer = new Timer(1,this);
        
        ruleList = new ArrayList<Rule>();
        grid = new Grid(50,50,10);
        SIRModel sirModel = new SIRModel(grid);
        SIRSModel sirsModel = new SIRSModel(grid);
        SIRModelSwap sirModelSwap = new SIRModelSwap(grid);
        
        //ruleList.add(sirModel);
        ruleList.add(sirsModel);
        ruleList.add(sirModelSwap);
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {  
            }
        });
        
       timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        int x=this.grid.numX*this.grid.size+this.grid.size;
        int y=this.grid.numY*this.grid.size+this.grid.size;
        return new Dimension(x,y);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        grid.render(g);
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Rule rule : ruleList) {
            rule.performRule();
        }
        repaint();
    }
}

