package sideFolder2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ExtensionsSection extends JScrollPane {

    private JTextField searchBar;
    private JPanel contentPanel;
    private JLabel titleLabel;

    private ArrayList<JPanel> extensionList = new ArrayList<>();
    private ArrayList<String> extensionListNames = new ArrayList<>();

    public ExtensionsSection() {
        /* this.setLayout(null); */
        // thistitelLabel

        titleLabel = new JLabel("Extensions");
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(255, 255, 255));
        titleLabel.setBounds(20, 20, 200, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        contentPanel = new JPanel(null) {
            @Override
            public Dimension getPreferredSize() {
                Rectangle r = new Rectangle();
                for (Component c : getComponents())
                    r = r.union(c.getBounds());
                r.grow(50, 50); // margin

                return r.getSize();

            }
        };
        contentPanel.setBackground(new Color(248, 248, 248));
        contentPanel.setLayout(null);
        searchBar = new JTextField();
        searchBar.setBounds(20, 95, 200, 30);
        searchBar.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {

                // TODO Auto-generated method stub
                drawPanels_2_0(ExtensionsSection.this.searchBar.getText());
                // throw new UnsupportedOperationException("Unimplemented method
                // 'insertUpdate'");
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                drawPanels_2_0(ExtensionsSection.this.searchBar.getText());

                // throw new UnsupportedOperationException("Unimplemented method
                // 'removeUpdate'");
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // TODO Auto-generated method stub
                drawPanels_2_0(ExtensionsSection.this.searchBar.getText());

                // throw new UnsupportedOperationException("Unimplemented method
                // 'changedUpdate'");
            }
        });

        contentPanel.add(searchBar);
        contentPanel.add(titleLabel);

        // contentPanel.setPreferredSize(new Dimension(600, 1000));

        this.setViewportView(contentPanel);

        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.setBorder(null);

        JScrollBar vBar = getVerticalScrollBar();
        vBar.setUI(new BasicScrollBarUI() {

            // Thumb (the draggable part)
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                g.setColor(new Color(225, 241, 242));
                g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
            }

            // Track (the background)
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                g.setColor(new Color(225,225,225));
                g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }

            // Make the up/left arrow
            /* @Override
            protected JButton createDecreaseButton(int orientation) {
                return createArrowButton(orientation);
            }

            // Make the down/right arrow
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createArrowButton(orientation);
            }

            // Helper to create a white arrow button
            private JButton createArrowButton(int orientation) {
                JButton button = new JButton() {
                    @Override
                    public void paint(Graphics g) {
                        super.paint(g);
                        int w = getWidth();
                        int h = getHeight();
                        g.setColor(Color.WHITE); // arrow color
                        int[] xPoints = null;
                        int[] yPoints = null;
                        switch (orientation) {
                            case SwingConstants.NORTH:
                                xPoints = new int[] { 0, w / 2, w };
                                yPoints = new int[] { h, 0, h };
                                break;
                            case SwingConstants.SOUTH:
                                xPoints = new int[] { 0, w / 2, w };
                                yPoints = new int[] { 0, h, 0 };
                                break;
                            case SwingConstants.WEST:
                                xPoints = new int[] { w, 0, w };
                                yPoints = new int[] { 0, h / 2, h };
                                break;
                            case SwingConstants.EAST:
                                xPoints = new int[] { 0, w, 0 };
                                yPoints = new int[] { 0, h / 2, h };
                                break;
                        }
                        g.fillPolygon(xPoints, yPoints, 3);
                    }
                };
                button.setOpaque(false);
                button.setBorder(null);
                button.setBackground(new Color(0, 0, 0, 0)); // transparent background
                return button;
            }*/
        }); 

        createExtensionPanel("name1", "desccription1: lallalalallalalallalalallalala", "creator1");
        createExtensionPanel("name2", "desccription2: lallalalallalalallalalallalala", "creator2");
        createExtensionPanel("name3", "desccription3: lallalalallalalallalalallalala", "creator3");
        createExtensionPanel("ImageFilter",
                "Adds advanced filtering options to images: blur, sharpen, contrast adjustment", "Alice");
        createExtensionPanel("CodeFormatter", "Automatically formats source code according to style guidelines", "Bob");
        createExtensionPanel("WeatherTracker", "Displays real-time weather updates inside the dashboard", "Carla");
        createExtensionPanel("MusicVisualizer", "Generates colorful animations that react to music playback", "David");
        createExtensionPanel("DataCruncher", "Analyzes large datasets and generates visual reports", "Eva");
        createExtensionPanel("NoteSync", "Synchronizes your notes seamlessly across multiple devices", "Frank");
        createExtensionPanel("ThemeSwitcher", "Allows quick switching between light, dark, and custom themes", "Grace");
        createExtensionPanel("ChatAssistant", "Provides AI-powered autocomplete and suggestions in chat", "Henry");

        drawPanels_2_0("");
        // drawPanels("");

    }

    private void createExtensionPanel(String name, String description, String creator) {
        JPanel panel = new JPanel(null);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setBounds(0, 0, 200, 20);

        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setBounds(0, 20, 200, 20);

        JLabel creatorLabel = new JLabel(creator);
        creatorLabel.setBounds(0, 40, 200, 20);

        panel.add(nameLabel);
        panel.add(descriptionLabel);
        panel.add(creatorLabel);

        extensionListNames.add(name);
        extensionList.add(panel);

    }

    private void drawPanels_2_0(String text) {
        int validIndex = 0;
        for (int i = 0; i < extensionList.size(); i++) {
            if (extensionListNames.get(i).toLowerCase().startsWith(text.toLowerCase())) {
                extensionList.get(i).setBounds(20, validIndex * (70 + 5) + 150, 200, (60));
                contentPanel.add(extensionList.get(i));

               
                validIndex++;

            } else {
                contentPanel.remove(extensionList.get(i));
               
            }

        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }
    /*
     * private void drawPanels(String search){
     * //contentPanel.removeAll();
     * for(int i=0;i<contentPanel.getComponentCount();i++){
     * if(contentPanel.getComponent(i)!=searchBar){
     * contentPanel.getComponent(i).setBackground(Color.yellow);
     * contentPanel.getComponent(i).setVisible(false);
     * }
     * 
     * 
     * }
     * //contentPanel.add(searchBar);
     * 
     * int initX= 50;
     * int initY=200;
     * String nameText="";
     * int validIndex=0;
     * 
     * int index=0;
     * for (Component c : extensionList.get(index).getComponents()) {
     * if (c instanceof JLabel) {
     * nameText = ((JLabel) c).getText();
     * break; //first label is the name
     * }
     * }
     * System.out.println(nameText);
     * for (int i=0; i<extensionList.size(); i++) {
     * 
     * 
     * System.out.println("c true="+nameText+"--------------"+search);
     * if(nameText.toLowerCase().startsWith("n")){
     * 
     * extensionList.get(i).setSize(200-initX*2,60);//
     * extensionList.get(i).setLocation(initX, validIndex*(70)+initY);
     * contentPanel.add(extensionList.get(i));
     * contentPanel.setVisible(true);
     * validIndex++;
     * }else{
     * System.out.println("faals");
     * }
     * 
     * 
     * }
     * }
     */

}
