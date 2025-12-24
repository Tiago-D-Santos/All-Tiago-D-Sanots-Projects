package editorFolder;

import javax.swing.BorderFactory;

//import java.awt.Frame;

import javax.swing.JPanel;
import frameFolder.*;


public class EditorPaneSection extends JPanel {
    public MainSection mainSection;
    public ConsoleSection consoleSC;
    //Frame frame;
    public EditorPaneSection(Frame frame){
        this.setLayout(null);
        //this.frame = frame;
        this.setBorder(BorderFactory.createEmptyBorder());

        mainSection = new MainSection(frame);
        consoleSC = new ConsoleSection();
        this.add(mainSection);
        this.add(consoleSC);

    }
}
