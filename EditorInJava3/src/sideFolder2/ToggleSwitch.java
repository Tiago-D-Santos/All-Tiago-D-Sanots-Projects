package sideFolder2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class ToggleSwitch extends JPanel {
    private boolean activated;
    
    public ToggleSwitch(){
        
        super();
        activated=true;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
                activated = !activated;
                repaint();
            }
        });
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        //setBounds(0, 0, 41, 21);
        setOpaque(false);
        setVisible(true);
    }

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g; // Use Graphics2D for advanced rendering
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Background
    g2.setColor(Color.WHITE);
    g2.fillRect(0, 0, this.getWidth(), this.getHeight());

    // Main shape color
    if (activated) g2.setColor(new Color(33, 150, 243));
    else           g2.setColor(new Color(204, 204, 204));

    g2.fillOval(0, 0, getHeight(), getHeight());
    g2.fillOval(getWidth() - getHeight(), 0, getHeight(), getHeight());
    g2.fillRect((int) (this.getHeight() / 2), 0, this.getWidth() - this.getHeight(), this.getHeight());

    // Circle 
    g2.setColor(Color.WHITE);
    if (activated)
        g2.fillOval(this.getWidth() - this.getHeight() + 2, 2, this.getHeight() - 4, this.getHeight() - 4);
    else
        g2.fillOval(2, 2, this.getHeight() - 4, this.getHeight() - 4);
}


    public boolean isActivated(){
        return activated;
    }


}
