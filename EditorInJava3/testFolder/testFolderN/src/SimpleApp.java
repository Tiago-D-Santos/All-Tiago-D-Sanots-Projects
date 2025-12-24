package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 

public class SimpleApp {

    public SimpleApp() {
        // Create the main frame
        JFrame frame = new JFrame("Simple App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a panel to hold components
        JPanel panel = new JPanel();

        // Create a button
        JButton button = new JButton("Click Me");

        // Add action listener to the button
        button.addActionListener(e -> System.out.println("Hello! The button was clicked."));

        // Add button to panel
        panel.add(button);

        // Add panel to frame
        frame.add(panel);

        // Make frame visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(SimpleApp::new);
    }
}
