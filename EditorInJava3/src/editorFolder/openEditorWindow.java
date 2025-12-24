package editorFolder;

import java.io.FileWriter;
import java.io.Writer;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class openEditorWindow extends JFrame {
    TextSection textSection;
    String address;

    public openEditorWindow(TextSection txt, String address) {
        this.address = address;
        textSection = txt;
        this.add(textSection);
        this.setTitle(address);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                saveFile();
                dispose();
            }
        });
        this.setVisible(true);
    }

    public void saveFile() {
        if (address == null)
            System.out.println("Fuck it");
        System.out.println("provisor save");
        if (!address.isBlank()) {
            try {
                Writer output = new FileWriter(address);
                output.write(textSection.getFileText1());
                output.close();
            } catch (Exception e1) {
                e1.getStackTrace();
                System.out.println(e1.toString() + "save text");
            }
        }

    }

}
