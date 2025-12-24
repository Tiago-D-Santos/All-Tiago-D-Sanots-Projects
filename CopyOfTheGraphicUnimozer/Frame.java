import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class Frame extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
    JMenuBar menuBar;
    
    JMenu menu1;
    JMenu menu2;
    JMenu menu3;
    JMenu menu4;
    JMenu menu5;
    JMenu menu6;
    JMenu menu7;

    JLabel section1;
    JLabel section2;
    JLabel section3;
    JLabel section4;

    JLabel interSection1;
    JLabel interSection2;
    JLabel interSection3;
    
    JLabel section3subLabel;
    JTextArea section3linecount;

    JLabel section3SourceCodeLabel;

    static JTextArea textArea;
    JScrollPane scrollPane;
    int FrameWidth;
    int FrameHeight;
    boolean interSection1_draged;
    boolean interSection2_draged;
    boolean interSection3_draged;


    int interSection1x;
    int interSection2y;
    int interSection3y;

    JButton section1Button;

    //Point p = MouseInfo.getPointerInfo().getLocation();
    JDialog section1Dialog;

    //------------------------------
    JLabel section1createdClass;
    JLabel seperator1;
    JLabel seperator2;
    boolean section1createdClassclicked=false;
    boolean section1dragClick=false;
    //----------------------------------------

    //--------
    LabelWithClass label1= new LabelWithClass();
    
    //ArrayList<createClass> section1Classarray = new ArrayList<>();
    //-------

     static boolean section1ButtonClosedisActivated;

     static boolean maketheClassVisible= false;

    public Frame(){
        FrameWidth=500;
        FrameHeight=500;
        interSection1_draged=false;
        interSection2_draged=false;
        interSection3_draged=false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FrameWidth,FrameHeight);
        this.setLayout(null);
        this.setTitle("Unimozer");

        //---------------------------------------------
        ImageIcon image = new ImageIcon("unimozer.png");
        this.setIconImage(image.getImage());
        //---------------------------------------------


        //-------------------MenuBar-----------------------
        menuBar = new JMenuBar();
        //menuBar.setBounds(20,0,500,500);

        menu1 = new JMenu("File");
        menu2 = new JMenu("Project");
        menu3 = new JMenu("Edit");
        menu4 = new JMenu("View");
        menu5 = new JMenu("Diagramm");
        menu6 = new JMenu("Options");
        menu7 = new JMenu("Help");


        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);
        menuBar.add(menu5);
        menuBar.add(menu6);
        menuBar.add(menu7);
        //----------------------------------------------------
        
        //-------------------window division-----------------------
        section1 = new JLabel();
        section1.setLayout(null);
        section1.setBackground(Color.white);
        section1.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),1));
        section1.setOpaque(true);
        section1.addMouseListener(this);
        section1.addMouseMotionListener(this);
        section2 = new JLabel();
        section2.setBackground(new Color(192,192,192));
        section2.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),1));
        section2.setOpaque(true);
        section2.setLayout(null);
        section2.addMouseListener(this);
        section2.addMouseMotionListener(this);
        section3 = new JLabel();
        section3.setBackground(new Color(224,224,224));
        section3.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),1));
        section3.setOpaque(true);
        section3.setLayout(null);
        section3.addMouseListener(this);
        section3.addMouseMotionListener(this);
        section4 = new JLabel();
        section4.setBackground(Color.BLACK);
        section4.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),3));
        section4.setOpaque(true);
        section4.setLayout(null);
        section4.addMouseListener(this);
        section4.addMouseMotionListener(this);

        section3subLabel = new JLabel();
        section3subLabel.setBackground(new Color(255,255,170));
        section3subLabel.setOpaque(true);
        section3subLabel.setLayout(null);
   
        section3linecount = new JTextArea();
        section3linecount.setBackground(Color.white);
        section3linecount.setEditable(false);
        section3linecount.setLineWrap(false);
        section3linecount.setWrapStyleWord(false);
        section3linecount.setBorder(BorderFactory.createLineBorder(new Color(224,224,224),1));
 
        interSection1 = new JLabel();
        interSection1.setBackground(new Color(238,238,238));
        interSection1.setOpaque(true);
        interSection1.addMouseListener(this);
        interSection1.addMouseMotionListener(this);

        interSection2 = new JLabel();
        interSection2.setBackground(new Color(238,238,238));
        interSection2.setOpaque(true);
        interSection2.addMouseListener(this);
        interSection2.addMouseMotionListener(this);

        interSection3 = new JLabel();
        interSection3.setBackground(new Color(238,238,238));
        interSection3.setOpaque(true);
        interSection3.addMouseListener(this);
        interSection3.addMouseMotionListener(this);

        section1.setBounds(0,0,(int)(FrameWidth*0.5-10),(int)(FrameHeight/2-10));
        section2.setBounds(0,(int)(FrameHeight/2),(int)(FrameWidth*0.5-10),(int)(FrameHeight/2));
        section3.setBounds((int)(FrameWidth*0.5),0,(int)(FrameWidth/2),(int)(FrameHeight/2-10));
        section4.setBounds((int)(FrameWidth*0.5),(int)(FrameHeight/2),(int)(FrameWidth/2),(int)(FrameHeight/2));
        
        
        //section3linecount.setBounds(15,20,15,section3.getHeight()-20);

        interSection1.setBounds((int)(FrameWidth*0.5-10),0,10,FrameHeight);
        interSection2.setBounds(0,(int)(FrameHeight*0.5-10),(int)(FrameWidth*0.5-10),10);
        interSection3.setBounds((int)(FrameWidth*0.5),(int)(FrameHeight/2-10),(int)(FrameWidth*0.5-10),10);


        //---------------------------------------------------------------------------------------------------------------------------------







        //------------------------------------------------------------------------------
        section3subLabel.setBounds(0,0,section3.getWidth(),20);
        section3subLabel.setText("file.java");

        section3SourceCodeLabel= new JLabel("Source code");
        section3SourceCodeLabel.setBackground(new Color(238,238,238));
        section3SourceCodeLabel.setBounds(section3subLabel.getWidth()-15-80,0,80,section3subLabel.getHeight());
        section3SourceCodeLabel.setBorder(BorderFactory.createLineBorder(new Color(122,138,153),1));
        section3SourceCodeLabel.setOpaque(true);
        //------------------------------------------------------------------------------












        //-------------------------------------------------------------------------
        

        textArea = new JTextArea();
        //textArea.setBackground(Color.DARK_GRAY);
        //textArea.setPreferredSize(new Dimension(250,250));
        //textArea.setBounds(20, 0, (int)(FrameWidth/2)-35, (int)(FrameHeight/2-10));
        textArea.setLineWrap(false);
        textArea.setWrapStyleWord(false);
        textArea.setBackground(Color.white);
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 20, section3.getWidth()-15-10, section3.getHeight()-20);
        //scrollPane.setRowHeaderView(section3linecount); 
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
        //-------------------------------------------------------------------------





        //rootPaneCheckingEnabled
       //----------------------------------------------------------------------------------
        section1Button = new JButton();
        section1Button.setSize(100,25);
        section1Button.setText("add class ... ");
        section1Button.setBackground(new Color(238,238,238));
        section1Button.setFocusable(false);
        section1Button.setVisible(false);
        section1Button.setLocation(50, 50);
        section1Button.addActionListener(e -> section1ButtonClicked());


        //section1Dialog= new JDialog(parentFrame, "Input Dialog", true);
        //JOptionPane.showMessageDialog(null, "You entered: " );
        //System.out.println(JOptionPane.showInputDialog(null, "Enter your input:"));
       //----------------------------------------------------------------------------------








       //-------------------------------------------------------------------------------
       /* 
       section1createdClass = new JLabel("LOlol");
        section1createdClass.setBackground(new Color(255,255,0));
        section1createdClass.setBounds(0,0,60,50);
        section1createdClass.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));
        section1createdClass.setOpaque(true);
        section1createdClass.addMouseListener(this);
        section1createdClass.addMouseMotionListener(this);
        section1createdClass.setVisible(false);

        seperator1 = new JLabel();
        seperator1.setBounds(0,30,60,10);
        seperator1.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));
        */
        /*seperator2 = new JLabel();
        seperator2.setBounds(0,40,60,10);
        seperator2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0),1));*/
       //-------------------------------------------------------------------------------



        //-------------------------------------------------------------
        
        section1.add(label1.section1createdClass);  
        label1.section1createdClass.addMouseListener(this);
        label1.section1createdClass.addMouseMotionListener(this);
        //-------------------------------------------------------------




        //section1createdClass.add(seperator1);
        //section1createdClass.add(seperator2);


        section1.add(section1Button);

        //section1.add(section1createdClass);
        
        section3.add(scrollPane);
        section3.add(section3subLabel);section3subLabel.add(section3SourceCodeLabel);
        //section3.add(section3linecount);
        //section3.add(textArea);
        
        this.add(interSection1);
        this.add(interSection2);
        this.add(interSection3);

        this.add(section1);
        this.add(section2);
        this.add(section3);
        this.add(section4);

        
        
        this.setJMenuBar(menuBar);
        




        //----------------------------chat gbt=(--------------------------------------------------
        // ADD: Add DocumentListener to update line numbers as text changes
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            public void removeUpdate(DocumentEvent e) {
                updateLineNumbers();
            }

            public void changedUpdate(DocumentEvent e) {
                updateLineNumbers();
            }
        });

        updateLineNumbers(); // Initial call to set up line numbers
        // Link the line count area to the scroll pane
        scrollPane.setRowHeaderView(section3linecount);

        // ScrollPane bounds must adjust to new size dynamically
        //scrollPane.setBounds(30, 20, section3.getWidth() - 45, section3.getHeight() - 30);

        //----------------------------------------------------------------------------------------------------------------------------------------


        this.setVisible(true);
    }








    public void updateLineNumbers() {
        String text = "";
        int lines = textArea.getLineCount();
        for (int i = 1; i <= lines; i++) {
            text += i + "\n";
        }
        section3linecount.setText(text);
    }






    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pressed");
        // TODO Auto-generated method stub
        if(e.getSource()==interSection1)
        {
            interSection1_draged=true;
            section1Button.setVisible(false);
            

        }
        if(e.getSource()==interSection2)
        {
            interSection2_draged=true;
            section1Button.setVisible(false);
            

        }
        if(e.getSource()==interSection3)
        {
            interSection3_draged=true;
            section1Button.setVisible(false);

        }
        if(e.getSource()==section2)section1Button.setVisible(false);
        if(e.getSource()==section3)section1Button.setVisible(false);
        if(e.getSource()==section4)section1Button.setVisible(false);

        if(e.getSource()==section1){
            if(e.getButton()==MouseEvent.BUTTON3){
                
                section1Button.setVisible(true);
                section1Button.setLocation(e.getX(),e.getY());
            }
            
        }
        if (e.getSource() == label1.section1createdClass) {
            section1Button.setVisible(false);
        }
        

        /* if(e.getSource()==section1 || e.getSource() == section1createdClass){
            //System.out.println("loooo"); */
        if(e.getSource()==section1 || e.getSource() == label1.section1createdClass){
            int mousex, mousey;
            if(e.getButton()==MouseEvent.BUTTON1 && e.getSource() == label1.section1createdClass){
                section1dragClick=true;

            }
            
            /*if(section1dragClick==true)
            {
                /*if (e.getSource() == section1createdClass) {
                    java.awt.Point pointInSection1 = SwingUtilities.convertPoint(section1createdClass, e.getX(), e.getY(), section1);
                    mousex = pointInSection1.x;
                    mousey = pointInSection1.y;
                 }
                else{
                    mousex=e.getX();
                    mousey=e.getY();

                }
                
                //System.out.println(mousex+"+"+mousey);
            }*/
            
        }
       
        if(e.getSource()==label1.section1createdClass){
            section1createdClassclicked =true;
        }
        if(e.getButton()==MouseEvent.BUTTON3 && e.getSource() == label1.section1createdClass){
            canYouComile=true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        interSection1_draged=false;
        interSection2_draged=false;
        interSection3_draged=false;

        System.out.println(false);
        section1createdClassclicked=false;

        section1dragClick=false;

        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("draged");
        // TODO Auto-generated method stub
        if (interSection1_draged) {
            
            int frameX = e.getXOnScreen() - this.getLocationOnScreen().x;
            interSection1x = frameX-((int)(FrameWidth*0.5));
            
        }
        if (interSection2_draged) {
            
            int frameY = e.getYOnScreen() - this.getLocationOnScreen().y;
            interSection2y = frameY-((int)(FrameHeight*0.5));
            
            
        }
        if (interSection3_draged) {
            
            int frameY = e.getYOnScreen() - this.getLocationOnScreen().y;
            interSection3y = frameY-((int)(FrameHeight*0.5));
            
            
        }
        
        if(section1dragClick==true)
            {
                int mousex, mousey;
                if (e.getSource() == label1.section1createdClass) {
                    java.awt.Point pointInSection1 = SwingUtilities.convertPoint(label1.section1createdClass, e.getX(), e.getY(), section1);
                    mousex = pointInSection1.x;
                    mousey = pointInSection1.y;
                 }
                else{
                    mousex=e.getX();
                    mousey=e.getY();

                }
                
                label1.section1createdClass.setLocation(mousex,mousey);
                System.out.println(mousex+"+"+mousey);
        }
                
            //}
        //}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    public void section1ButtonClicked(){
        section1Button.setVisible(false);
        System.out.println(true);
        new createClass();
        
    }
    public static void section1ButtonClosed(){
        
        textArea.setEditable(true);
        textArea.append(createClass.CodeText);
        
        //--------------------------------
        Frame.maketheClassVisible = true;
    }

    

    /* public void linecountfunc(){
        //if (){}
        String text ="";
        //text+="<html>";
        System.out.println(textArea.getLineCount());
        for(int i=1;i<=textArea.getLineCount();i++){
            text+=i+"\n";
            
        }
        //text+="</html>";

        section3linecount.setText(text); 
        //section1.setText("<html>First Line<br>Second Line<br>Third Line</html>");

    } */
    boolean canYouComile= false;
   
    

 
    
}
