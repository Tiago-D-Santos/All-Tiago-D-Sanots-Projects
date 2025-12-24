package frameFolder;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MenuBar;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

import editorFolder.ConsoleSection;
import editorFolder.MainSection;
import editorFolder.EditorPaneSection;
import sideFolder2.SideSection;

public class Frame extends JFrame {
  public static final int rightBarWidth = 250;
  public static final int leftBarWidth = 40;
  int width = 1000;
  int height = 1000;

  public SideSection sideSection;
  public MenuBarSection menuBar;
  //public ConsoleSection consoleSC;
  //public MainSection mainSection;
  public EditorPaneSection editorPaneSection;
  //private JScrollPane rightMenuScrollPane;
  public JSplitPane splitPane;

  public Frame() {

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(width, height);
    this.setLayout(null);
    this.setTitle("java ass Schäiss");
    //this.getContentPane().setBackground(Color.red);
    this.setIconImage(
        new ImageIcon("sprites\\logo.png").getImage());
    // this.setUndecorated(true);//full screen

    // cosntructor
    sideSection = new SideSection(this);
    //consoleSC = new ConsoleSection();
    //mainSection = new MainSection(this);
    menuBar = new MenuBarSection(this); // Set the menu bar
    editorPaneSection = new EditorPaneSection(this);


 

    // rezise
    editorPaneSection.mainSection.createPanel("Hub", " =( \nI\nhave\nDepression", editorPaneSection.mainSection.counter, "sprites\\center2.png");
    // mainSection.createPanel("sprites\\logo.png","content.toString()",mainSection.counter,"sprites\\logo.png");
    // menuBar.createThePanelInTheMainSection(this,"sprites/logo.png","hub");
    editorPaneSection.mainSection.setTextArea(1);

    // && adding to frame
    //this.add(sideSection);
    //this.add(editorPaneSection);
    //this.add(consoleSC);
    //this.add(mainSection);

    splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                sideSection,
                editorPaneSection
    );

    // Divider size
    //splitPane.setDividerSize(6);

    // Custom divider UI
    splitPane.setUI(new BasicSplitPaneUI() {
    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new BasicSplitPaneDivider(this) {
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.WHITE); // Divider color
                g.fillRect(0, 0, getSize().width, getSize().height);
                redraw();
            }
        };
      }
    });
    splitPane.setDividerSize(2);
    splitPane.setDividerLocation(300);
    splitPane.setBorder(BorderFactory.createEmptyBorder());
    this.add(splitPane);

    //this.add(sideSection.lSection);


    setJMenuBar(menuBar);
    this.setVisible(true);
    selectByButton();// selects the left menu to the right one

    sideSection.settingSectionSection.turnDarkmode();
    redraw();
    this.addComponentListener(new ComponentListener() {
      @Override
      public void componentResized(ComponentEvent e) {
        redraw();
      }

      @Override
      public void componentMoved(ComponentEvent e) {
      }

      @Override
      public void componentShown(ComponentEvent e) {
      }

      @Override
      public void componentHidden(ComponentEvent e) {
      }

    });
  }


  /**
   * rezise every component in the frame
   */
  public void redraw() {
    width = this.getWidth();
    height = this.getContentPane().getHeight();

    /* int sidewidth = leftBarWidth + rightBarWidth;
    int sideheight = height; */

    //
    splitPane.setBounds(0,0,width,height);
    sideSection.lSection.setBounds(0,0,leftBarWidth,height);
    sideSection.rSection.setBounds(leftBarWidth,0,sideSection.getWidth()-leftBarWidth,height);
    sideSection.settingSection.setBounds(leftBarWidth,0,sideSection.getWidth()-leftBarWidth,height);
    sideSection.costumizeSection.setBounds(leftBarWidth,0,sideSection.getWidth()-leftBarWidth,height);
    sideSection.extensionsSection.setBounds(leftBarWidth,0,sideSection.getWidth()-leftBarWidth,height);
    editorPaneSection.consoleSC.setBounds(0, (int) (height * 0.7), editorPaneSection.getWidth(),
        (int) (height * 0.3) - 65);
    editorPaneSection.mainSection.setBounds(0, 0, editorPaneSection.getWidth(), (int) (height * 0.7));
    editorPaneSection.mainSection.resize(editorPaneSection.getWidth(), (int) (height * 0.7)); 


    //sideSection.lSection.setBounds(0,0,Le);
    /* int sidewidth = leftBarWidth + rightBarWidth;
    int sideheight = height;
    sideSection.setBounds(0, 0, sidewidth, sideheight);
    sideSection.lSection.setBounds(0, 0, Frame.leftBarWidth, sideheight - 65);
    sideSection.rSection.setBounds(Frame.leftBarWidth, 0, Frame.rightBarWidth, sideheight - 65);// ---------------------------------
    //rightMenuScrollPane.setBounds(Frame.leftBarWidth, 0, Frame.rightBarWidth, sideheight - 65);
    sideSection.settingSection.setBounds(Frame.leftBarWidth, 0, Frame.rightBarWidth, sideheight - 65); // ------------------------
    sideSection.costumizeSection.setBounds(Frame.leftBarWidth, 0, Frame.rightBarWidth, sideheight - 65);
    consoleSC.setBounds(leftBarWidth + rightBarWidth, (int) (height * 0.7), width - leftBarWidth - rightBarWidth,
        (int) (height * 0.3) - 65);
    mainSection.setBounds(leftBarWidth + rightBarWidth, 0, width - leftBarWidth - rightBarWidth, (int) (height * 0.7));
    mainSection.resize(width - leftBarWidth - rightBarWidth, (int) (height * 0.7)); */
 
    editorPaneSection.consoleSC.repaint();//-------------------------------important
    editorPaneSection.consoleSC.revalidate();//----------------------------important
    repaint();
  }

  
  public void selectByButton() {// can be written more efficient
    sideSection.rSection.clearEverthing();
    sideSection.rSection.resizeFunc();
    sideSection.settingSectionSection.turnDarkmode();

    sideSection.rSection.setVisible(false);
    sideSection.settingSection.setVisible(false);
    sideSection.costumizeSection.setVisible(false);
    sideSection.extensionsSection.setVisible(false);
    switch (Main.activeLeftState) {
      case 1:
        sideSection.rSection.setVisible(true);
        break;
      case 2:
        sideSection.costumizeSection.setVisible(true);
        break;
      case 3:
        sideSection.settingSection.setVisible(true);
        break;
      case 4:
        sideSection.extensionsSection.setVisible(true);
        break;
      case 5:
        
        break;
      default:
        sideSection.rSection.setVisible(true);
        break;
    }


   
  }

}