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

    public Grid grid;
  
    public Timer timer;
    public int delay=10;
     
    public ArrayList<Rule> ruleList;
    
    TestFrame controlPanel;
    Cell selectedCell;
    
    public DrawingSurface() {
        setBorder(BorderFactory.createLineBorder(Color.black));
       /* timer = new Timer(delay,this);
        
        ruleList = new ArrayList<Rule>();
        grid = new Grid(50,50,10);
        SIRModel sirModel = new SIRModel(grid);
        SIRSModel sirsModel = new SIRSModel(grid);
        SIRModelSwap sirModelSwap = new SIRModelSwap(grid);
        
        //ruleList.add(sirModel);
        ruleList.add(sirsModel);
        ruleList.add(sirModelSwap);*/
        
        this.init();
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                for (int j=0; j<grid.numY; j++) {
                    for (int i=0; i<grid.numX; i++) {
                        if (e.getX() > grid.grid[i][j].x && e.getX() < grid.grid[i][j].x + grid.grid[i][j].width &&
                                e.getY() > grid.grid[i][j].y && e.getY() < grid.grid[i][j].y+grid.grid[i][j].height) {
                           
                            //controlPanel.selectedCell = grid.grid[i][j];
                            
                            controlPanel.setSelectedCell(grid.grid[i][j]);
                            
                            //controlPanel.selectedCellPanel. = grid.grid[i][j];
                            
                            selectedCell = grid.grid[i][j];
                            //System.out.println("Setting selected Cell: " + selectedCell);
                           // Graphics g = controlPanel.selectedCellPanel.getGraphics();
                           // selectedCell.render(g);
                           // controlPanel.selectedCellPanel.repaint();
                            
                            
                            controlPanel.jLabel8.setText(""+selectedCell.node.susceptiblePop);
                            controlPanel.jLabel9.setText(""+selectedCell.node.infectivePop);
                            controlPanel.jLabel10.setText(""+selectedCell.node.removedPop);
                            //controlPanel.nodeControlPane.repaint(10,5,100,100);
                           // controlPanel.nodeControlPane.revalidate();
                            
                            //System.out.println(controlPanel.nodeControlPane.getSize());
                            
                           // System.out.println("ALSKDJALSKDJALSDJLAKSDJ");
                        }
                    }
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {  
            }
        });
    }
    
    public void init() {
        timer = new Timer(delay,this);
        
        ruleList = new ArrayList<Rule>();
        grid = new Grid(50,50,10);
        SIRModel sirModel = new SIRModel(grid);
        SIRSModel sirsModel = new SIRSModel(grid);
        SIRModelSwap sirModelSwap = new SIRModelSwap(grid);
        
        //ruleList.add(sirModel);
        ruleList.add(sirsModel);
        ruleList.add(sirModelSwap);
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
       // System.out.println("YES");
        for (Rule rule : ruleList) {
            rule.performRule();
        }
        repaint();
        Graphics g = this.controlPanel.selectedCellPanel.getGraphics();
        this.selectedCell.render(g);
        this.controlPanel.selectedCellPanel.repaint();
        
        controlPanel.jLabel8.setText(""+selectedCell.node.susceptiblePop);
        controlPanel.jLabel9.setText(""+selectedCell.node.infectivePop);
        controlPanel.jLabel10.setText(""+selectedCell.node.removedPop);
       // controlPanel.nodeControlPane.repaint();
    }
}

