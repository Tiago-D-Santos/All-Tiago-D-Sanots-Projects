package sideFolder2;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import frameFolder.Frame;
import frameFolder.Main;

import java.util.*;
import java.io.*;

public class FileExplorerSection extends JPanel {

  ArrayList<Object> alPathsList = new ArrayList<>();
  ArrayList<Object> alPathsNameList = new ArrayList<>();

  JLabel titleLabel;
  ArrayList<JButton> buttonsList = new ArrayList<JButton>();
  ArrayList<Integer> buttonsListCord = new ArrayList<Integer>();

  JButton folderNameButton;

  public Object[] pathThough(String newPath, int index) {
    ArrayList<Object> list = new ArrayList<Object>();
    File path = new File(newPath);
    File[] files = path.listFiles();

    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        list.add(files[i].getName());
        alPathsList.add(files[i] + "");
        alPathsNameList.add(files[i].getName());
      } else {
        alPathsList.add("-1");
        alPathsNameList.add("-1");
        list.add("\uD83D\uDCC1  " + files[i].getName());
        list.add(pathThough((files[i] + ""), i));
      }
    }
    return list.toArray();
  }

  public void read(Object[] objList) {// this function does nothing is only for debuggin
    for (int i = 0; i < objList.length; i++) {
      if (objList[i] instanceof Object[])
        read((Object[]) objList[i]);
      else {
        System.out.println("f1:" + objList[i]);
      }
    }
  }

  public void readAndCreateButton(Object[] objList, int index) {// creates the button to open the files

    this.add(titleLabel);// must add it again because there is an clear everthing bevor
    this.add(folderNameButton);

    // buttonsList.clear();
    // buttonsListCord.clear();
    for (int i = 0; i < objList.length; i++) {
      if (objList[i] instanceof Object[]) {
        readAndCreateButton((Object[]) objList[i], index + 1);
      } else {
        buttonsList.add(new JButton("" + String.valueOf(objList[i])));
        buttonsListCord.add(index);

      }
    }

    int xSpace = 10;// smaller buttons size
    int ySpace = 5;
    int xSize = 300;
    int ySize = 20;
    for (int i = 0; i < buttonsList.size(); i++) {
        buttonsList.get(i).setBounds(xSpace * buttonsListCord.get(i), ySpace * i + ySize * i + 75,
            xSize - xSpace * buttonsListCord.get(i), ySize);
        buttonsList.get(i).setContentAreaFilled(false);
        // buttonsList.get(i).setOpaque(false);
        // buttonsList.get(i).setBackground(Color.gray);
        buttonsList.get(i).setHorizontalAlignment(SwingConstants.LEFT);
        buttonsList.get(i).setBorderPainted(false);
        int indexf = i;

        for (ActionListener al : buttonsList.get(i).getActionListeners()) {
          buttonsList.get(i).removeActionListener(al);
        }

        buttonsList.get(i).addActionListener(e -> {
          if (alPathsList.get(indexf) != "-1") {// check it it is a file or a folder(-1)
            if(!frame.editorPaneSection.mainSection.isTheFileAlreadyOpened(alPathsList.get(indexf)+"")){
              frame.menuBar.createThePanelInTheMainSection(frame, alPathsList.get(indexf) + "",
              alPathsNameList.get(indexf) + "");
            // frame.redraw();
            }
              
          } else
            System.out.println("folder");
        });
        this.add(buttonsList.get(i));
    }
  }

  /*
   * public void readAndCreateButton(Object[] objList){
   * /* int i1=0;//--is this necessary??????????????????????????
   * for(int i = 0; i < objList.length; i++){
   * JButton b = new JButton(""+objList[i]);
   * if(!(objList[i] instanceof Object[]))
   * b.setText(""+objList[i]);
   * else readAndCreateButton((Object[])(objList[i]));
   * b.setBounds(0,20*i,250,20);
   * b.setBackground(new Color(150,150,150));
   * b.setHorizontalAlignment(SwingConstants.LEFT);
   * b.setBorderPainted(false);
   * b.addActionListener(l->{
   * System.out.println("Hello World");
   * });
   * i1++;
   * this.add(b);
   * 
   * }
   * }
   */

  public void resizeFunc() {
    // System.out.println("exectuted");
    Object[] newf = pathThough(Main.absulutPath, 0);
    readAndCreateButton(newf, 0);// herer errooooooooooooooooooooooooooooooooooooooooooooooooor
    File path = new File(Main.absulutPath);

    folderNameButton.setText("\uD83D\uDCC1  " + path.getName());

    // System.out.println("finally"+frame.sideSection.settingSectionSection);
    // frame.sideSection.settingSectionSection.turnDarkmode();
  }

  public void clearEverthing() {
    buttonsList.clear();
    buttonsListCord.clear();
    alPathsList.clear();
    alPathsNameList.clear();
    this.removeAll();
    this.revalidate();
    this.repaint();

  }

  public void changeTextColor() {
    Color cha;
    if (Main.darkModeBool)
      cha = Color.WHITE;
    else
      cha = Color.BLACK;
    for (int i = 0; i < buttonsList.size(); i++) {
      // System.out.println(cha+" "+buttonsList.get(i));
      buttonsList.get(i).setForeground(cha);
    }
    titleLabel.setForeground(cha);
  }

  Frame frame;

  FileExplorerSection(Frame frame) {
    this.setFocusTraversalKeysEnabled(false);
    this.setLayout(null);
    this.setBorder(null);
    this.frame = frame;

    titleLabel = new JLabel("Files");
    // titleLabel.setBackground(new
    // Color(120,120,120));//ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
    titleLabel.setOpaque(true);
    titleLabel.setBounds(30, 15, 180, 30);
    titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
    titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

    folderNameButton = new JButton();
    folderNameButton.setBounds(-11, 48, 300, 30);
    folderNameButton.setContentAreaFilled(false);
    folderNameButton.setHorizontalAlignment(SwingConstants.LEFT);
    folderNameButton.setBorderPainted(false);
    folderNameButton.setFont(new Font("Dialog", Font.BOLD, 15));
    folderNameButton.setForeground(Color.BLACK);// REMOVE--------------------------------------------------------------------
    folderNameButton.addActionListener(e -> {
      System.out.println("folder");
    });

    this.add(folderNameButton);
    this.add(titleLabel);

    clearEverthing();
    resizeFunc();

  }
}