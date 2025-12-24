package frameFolder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBarSection extends JMenuBar {
  // JMenuBar menuBar;
  JMenu FileMenu;
  JMenu EditMenu;
  JMenu ViewMenu;
  JMenu RunMenu;
  JMenu TerminalMenu;
  JMenu HelpMenu;

  JMenuItem FileI1, FileI2, FileI3, FileI4, FileI5, FileI6, FileI7, FileI8, FileI9, FileI10;
  JMenuItem EditI1, EditI2, EditI3, EditI4, EditI5;
  JMenuItem ViewI1, ViewI2, ViewI3, ViewI4, ViewI5;
  JMenuItem RunI1, RunI2, RunI3, RunI4, RunI5;
  JMenuItem TerminalI1, TerminalI2, TerminalI3, TerminalI4, TerminalI5;
  JMenuItem HelpI1, HelpI2, HelpI3, HelpI4, HelpI5;

  public void fileChosingFunc(Frame frame) {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setCurrentDirectory(new File("."));
    int resonse = fileChooser.showOpenDialog(null);// select file to open
    if (resonse == JFileChooser.APPROVE_OPTION) {// or ==0
      String filePath = fileChooser.getSelectedFile().getAbsolutePath(); // Replace with your file path
      createThePanelInTheMainSection(frame, filePath, fileChooser.getSelectedFile().getName());
    }
  }

  public void createThePanelInTheMainSection(Frame frame, String filePath, String fileName) {
    StringBuilder content = new StringBuilder();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n"); // Don't add a newline here!
      }
      frame.editorPaneSection.mainSection.createPanel(fileName, content.toString(), frame.editorPaneSection.mainSection.counter, filePath);
      // frame.mainSection.setTextArea(frame.mainSection.counter);//---------------------------------------------------------------
      frame.redraw();
    } catch (IOException e) {
      System.out.println("An error occurred., in file chooser Menubar");
    }
  }

  public void folderChoosingFunc() {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("user.dir"));
    chooser.setDialogTitle("java ass schaiss");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    //
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      // System.out.println("getCurrentDirectory(): " +
      // chooser.getCurrentDirectory());
      Main.absulutPath = chooser.getSelectedFile().getAbsolutePath() + "";

      // System.out.println(Main.absulutPath+"");
    } else {
      // System.out.println("No Selection ");

    }

  }

  public void createNewFile() {
    try {
      System.out.println();
      String filename = JOptionPane.showInputDialog(this, "FileName", null);

      Path filePath = Paths.get(Main.absulutPath, filename);

      File myObj = new File(filePath + "");
      frame.sideSection.rSection.clearEverthing();
      frame.sideSection.rSection.resizeFunc();
      if (!myObj.createNewFile()) {
        System.out.println("File already exists.");
        frame.editorPaneSection.consoleSC.addTextToConsole("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  Frame frame;

  // public JFrame frame;
  MenuBarSection(Frame frame) {
    this.frame = frame;
    // menuBar= new JMenuBar();
    FileMenu = new JMenu("file");
    EditMenu = new JMenu("edit");
    ViewMenu = new JMenu("view");
    RunMenu = new JMenu("run");
    TerminalMenu = new JMenu("terminal");
    HelpMenu = new JMenu("help");

    /*
     * FileMenu.setForeground(Color.white);
     * EditMenu.setForeground(Color.white);
     * ViewMenu.setForeground(Color.white);
     * RunMenu.setForeground(Color.white);
     * TerminalMenu.setForeground(Color.white);
     * HelpMenu.setForeground(Color.white);
     */

    FileMenu.add(FileI1 = new JMenuItem("New File"));// add file input for here
    FileI1.addActionListener(e -> {
      createNewFile();
    });
    FileMenu.add(FileI2 = new JMenuItem("New Window"));
    FileMenu.add(FileI3 = new JMenuItem("Open File"));
    FileI3.addActionListener(e -> {
      fileChosingFunc(frame);
    });
    FileMenu.add(FileI4 = new JMenuItem("Open Folder"));
    FileI4.addActionListener(e -> {
      folderChoosingFunc();
      frame.sideSection.rSection.clearEverthing();
      frame.sideSection.rSection.resizeFunc();
    });
    FileMenu.add(FileI5 = new JMenuItem("Save"));
    FileI5.addActionListener(e -> {

    });
    FileMenu.add(FileI6 = new JMenuItem("Save As"));
    FileMenu.add(FileI7 = new JMenuItem("Save All"));
    FileMenu.add(FileI8 = new JMenuItem("Close Editor"));
    FileMenu.add(FileI9 = new JMenuItem("Close Folder"));
    FileMenu.add(FileI10 = new JMenuItem("Exit"));
    FileI10.addActionListener(e -> {
      System.exit(0);
    });

    EditMenu.add(EditI1 = new JMenuItem("nothing"));
    EditMenu.add(EditI2 = new JMenuItem("nil"));
    EditMenu.add(EditI3 = new JMenuItem("zero"));
    EditMenu.add(EditI4 = new JMenuItem("nix"));
    EditMenu.add(EditI5 = new JMenuItem("nada"));

    ViewMenu.add(ViewI1 = new JMenuItem("Command Palette"));
    ViewMenu.add(ViewI2 = new JMenuItem("Edit Layout"));
    ViewMenu.add(ViewI3 = new JMenuItem("Edit Settings"));
    ViewMenu.add(ViewI4 = new JMenuItem("Edit Extensions"));
    ViewMenu.add(ViewI5 = new JMenuItem("Edit FIles"));

    RunMenu.add(RunI1 = new JMenuItem("Run"));
    RunMenu.add(RunI2 = new JMenuItem("Compile"));
    RunMenu.add(RunI3 = new JMenuItem("Nothing"));

    TerminalMenu.add(TerminalI1 = new JMenuItem("New Terminal"));
    TerminalMenu.add(TerminalI2 = new JMenuItem("Add something to the terminal"));

    HelpMenu.add(HelpI1 = new JMenuItem("Creator"));

    this.setOpaque(true);
    // this.setBorder(javax.swing.BorderFactory.createEmptyBorder());

    this.add(FileMenu);
    this.add(EditMenu);
    this.add(ViewMenu);
    this.add(RunMenu);
    this.add(TerminalMenu);
    this.add(HelpMenu);
    this.setVisible(true);

    // this.setBackground(new Color(150,150,150));

  }

}