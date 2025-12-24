import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
public class LabelWithClass{
    JLabel seperator1;
    JLabel seperator2;

    JLabel nameoftheclassLabel;
    
    JLabel section1createdClass;
    public LabelWithClass(){
        section1createdClass = new JLabel();
        section1createdClass.setBackground(new Color(255,255,0));
        section1createdClass.setBounds(50,50,60,50);
        section1createdClass.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));
        section1createdClass.setOpaque(true);
        //section1createdClass.addMouseListener(this);
        //section1createdClass.addMouseMotionListener(this);
        section1createdClass.setVisible(false);
        

        seperator1 = new JLabel();
        seperator1.setBounds(0,30,60,10);
        seperator1.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));

        nameoftheclassLabel = new JLabel("class name");
        nameoftheclassLabel.setBounds(0,0,60,30);
        //nameoftheclassLabel.setBackground(Color.red);
        //nameoftheclassLabel.setOpaque(true);
        //nameoftheclassLabel.setVisible(true);

        section1createdClass.add(seperator1);
        section1createdClass.add(nameoftheclassLabel);
        
    }
    
}
