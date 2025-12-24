
package editorFolder;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ConsoleSection extends JPanel {

  public JPanel optionsBar;
  public JScrollPane console;
  public JTextArea textArea;



  
  public ConsoleSection() {// black panel for the concole
    this.setLayout(new BorderLayout());
    this.setBorder(BorderFactory.createEmptyBorder());

    optionsBar = new JPanel();
    optionsBar.setPreferredSize(new Dimension(10, 20));
    optionsBar.setOpaque(true);

    textArea = new JTextArea("Dont test your code \n");
    textArea.setEditable(false);
    textArea.setOpaque(true);

    console = new JScrollPane(textArea);
    console.setBorder(BorderFactory.createEmptyBorder());
    console.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


    this.add(optionsBar, BorderLayout.NORTH);
    this.add(console);

  }

  /**
   * // is used from the other files to write new messages in the console
   * @param txt text that you want to add in the console
   */
  public void addTextToConsole(String txt) {
    textArea.append("\n" + txt);
  }
}