


package sideFolder2;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import frameFolder.Frame;
import frameFolder.Main;

public class LeftMenuSection2 extends JPanel {

  JLabel label1;
  JButton button1;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton button5;

  LeftMenuSection2(Frame frame) {
    this.setLayout(null);// coninue here
    this.setOpaque(true);
    // this.setBorder(BorderFactory.createLineBorder(new Color(229,229,229)));

    // ImageIcon icon1 = new
    // ImageIcon("C:\\Users\\user\\Desktop\\programation\\EditorInJava\\sprites\\folder.png.png");
    button1 = createLeftMenuButton("sprites\\BlackFolder.png");
    button1.addActionListener(e -> {
      System.out.println("button1");
      Main.activeLeftState = 1;
      frame.selectByButton();
    });
    // ImageIcon icon2 = new
    // ImageIcon("C:\\Users\\user\\Desktop\\programation\\EditorInJava\\sprites\\ns.png");
    button2 = createLeftMenuButton("sprites\\options.png");
    button2.addActionListener(e -> {
      System.out.println("button2");
      Main.activeLeftState = 2;
      frame.selectByButton();

    });
    // ImageIcon icon3 = new
    // ImageIcon("C:\\Users\\user\\Desktop\\programation\\EditorInJava\\sprites\\settings.png");
    button3 = createLeftMenuButton("sprites\\settings.png");
    button3.addActionListener(e -> {
      System.out.println("button3");
      Main.activeLeftState = 3;
      frame.selectByButton();

    });
    // ImageIcon icon4 = new
    // ImageIcon("C:\\Users\\user\\Desktop\\programation\\EditorInJava\\sprites\\window.png");
    button4 = createLeftMenuButton("sprites\\window.png");
    button4.addActionListener(e -> {
      System.out.println("button4");
      Main.activeLeftState = 4;
      frame.selectByButton();

    });
    // ImageIcon icon5 = new
    // ImageIcon("C:\\Users\\user\\Desktop\\programation\\EditorInJava\\sprites\\logo.png");
    button5 = createLeftMenuButton("sprites\\logo.png");
    button5.addActionListener(e -> {
      System.out.println("button5");
      Main.activeLeftState = 5;
      frame.selectByButton();

    });

    button1.setBounds(0, 10, Frame.leftBarWidth, Frame.leftBarWidth);
    button2.setBounds(0, 50, Frame.leftBarWidth, Frame.leftBarWidth);
    button3.setBounds(0, 90, Frame.leftBarWidth, Frame.leftBarWidth);
    button4.setBounds(0, 130, Frame.leftBarWidth, Frame.leftBarWidth);
    button5.setBounds(0, 170, Frame.leftBarWidth, Frame.leftBarWidth);

    this.add(button1);
    this.add(button2);
    this.add(button3);
    this.add(button4);
    this.add(button5);

  }

  /**
   * creates the buttons on the left to avoid repetition
   * @param iconAdress adress of a icon as a String
   * @return a normal button with a icon as background
   */
  private JButton createLeftMenuButton(String iconAdress) {
    ImageIcon icon = new ImageIcon(iconAdress);
    JButton button = new JButton(icon);
    button.setBorderPainted(false);
    button.setContentAreaFilled(false);
    button.setFocusPainted(false);
    return button;
  }
}