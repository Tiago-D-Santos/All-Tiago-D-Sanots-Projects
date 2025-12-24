import javax.swing.*;
import java.awt.*;
public class compileLabelClass {
    JLabel CompileLabel1;
    compileLabelClass(){
        System.out.println("loooooo");
        CompileLabel1 = new JLabel();
        CompileLabel1.setBounds(20,20,50,50);
        CompileLabel1.setBackground(Color.red);
        CompileLabel1.setVisible(true);
        CompileLabel1.setOpaque(true);
        
    }
}
