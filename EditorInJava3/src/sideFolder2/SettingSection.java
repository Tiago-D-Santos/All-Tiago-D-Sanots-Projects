package sideFolder2;







import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import frameFolder.Frame;
import frameFolder.Main;

public class SettingSection extends JPanel {
    Frame frame;
    JLabel titleLabel;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;

    JLabel label7a;
    JLabel label8a;

    public SettingSection(Frame frame) {
        this.frame = frame;
        this.setBackground(new Color(150, 150, 150));
        this.setOpaque(true);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(100, 500)); // Adjust width and height as needed
        this.setBorder(BorderFactory.createEmptyBorder());

        titleLabel = new JLabel("SETTINGS");
        titleLabel.setOpaque(true);
        titleLabel.setBackground(new Color(120, 120, 120));
        titleLabel.setBounds(35, 5, 165, 35);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        label1 = new JLabel("Dark Mode");
        // label1.setOpaque(true);
        label1.setBounds(35, 60, 90, 20);
        // label1.setBackground(Color.red);
        ToggleSwitch ts1 = new ToggleSwitch();
        ts1.setBounds(150, 60,40,20);
        // ts1.setBorderRadius(10);

        label2 = new JLabel("AutoSave");
        // label2.setOpaque(true);
        label2.setBounds(35, 85, 90, 20);
        // label2.setBackground(Color.red);
        ToggleSwitch ts2 = new ToggleSwitch();
        ts2.setBounds(150, 85,40,20);
        // ts2.setBorderRadius(10);

        label3 = new JLabel("option3");
        // label3.setOpaque(true);
        label3.setBounds(35, 110, 90, 20);
        // label3.setBackground(Color.red);
        ToggleSwitch ts3 = new ToggleSwitch();
        ts3.setBounds(150, 110,40,20);
        // ts3.setBorderRadius(10);

        label4 = new JLabel("option3");
        // label4.setOpaque(true);
        label4.setBounds(35, 135, 90, 20);
        // label4.setBackground(Color.red);
        ToggleSwitch ts4 = new ToggleSwitch();
        ts4.setBounds(150, 135,40,20);
        // ts4.setBorderRadius(10);

        label5 = new JLabel("Editor: Size");
        // label5.setOpaque(true);
        label5.setBounds(35, 180, 140, 20);
        // label5.setBackground(Color.red);
        JLabel label5a = new JLabel("width: ");
        // label5a.setOpaque(true);
        label5a.setBounds(35, 200, 50, 20);
        // label5a.setBackground(Color.red);
        JLabel label5b = new JLabel("height: ");
        // label5b.setOpaque(true);
        label5b.setBounds(35, 222, 50, 20);
        // label5b.setBackground(Color.red);
        JTextField field5a = new JTextField();
        field5a.setBounds(90, 200, 110, 20);
        field5a.setBackground(Color.white);
        JTextField field5b = new JTextField();
        field5b.setBounds(90, 222, 110, 20);
        field5b.setBackground(Color.white);

        JLabel label6 = new JLabel("Editor: Textfont");
        // label5.setOpaque(true);
        label6.setBounds(35, 260, 140, 20);
        JLabel label6a = new JLabel("Font: ");
        // lable6a.setOpaque(true);
        label6a.setBounds(35, 280, 50, 20);
        JTextField field6a = new JTextField();
        field6a.setBounds(90, 280, 110, 20);
        field6a.setBackground(Color.white);

        label7 = new JLabel("Code: Textfont");
        // label5.setOpaque(true);
        label7.setBounds(35, 320, 140, 20);
        label7a = new JLabel("Font: ");
        // lable6a.setOpaque(true);
        label7a.setBounds(35, 340, 50, 20);
        JTextField field7a = new JTextField();
        field7a.setBounds(90, 340, 110, 20);
        field7a.setBackground(Color.white);

        label8 = new JLabel("Code TabSize");
        // label5.setOpaque(true);
        label8.setBounds(35, 380, 140, 20);
        label8a = new JLabel("Tab: ");
        // lable6a.setOpaque(true);
        label8a.setBounds(35, 400, 50, 20);
        JTextField field8a = new JTextField();
        field8a.setBounds(90, 400, 110, 20);
        field8a.setBackground(Color.white);

        JButton saveButton = new JButton("Save");
        // label5.setOpaque(true);
        saveButton.setBounds(110, 440, 90, 30);
        saveButton.setBackground(new Color(120, 120, 120));
        saveButton.addActionListener(e -> {
            System.out.println("save settings");

            Main.darkModeBool = ts1.isActivated();
            turnDarkmode();
        });

        this.add(ts1);
        this.add(ts2);
        this.add(ts3);
        this.add(ts4);

        this.add(field5a);
        this.add(field5b);
        this.add(field6a);
        this.add(field7a);
        this.add(field8a);

        this.add(titleLabel);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label5a);
        this.add(label5b);
        this.add(label6);
        this.add(label6a);
        this.add(label7);
        this.add(label7a);
        this.add(label8);
        this.add(label8a);

        this.add(saveButton);

    }

    public void turnDarkmode() {
        Color veryDarkColor;
        Color darkColor;
        Color middleColor;
        Color lighColor;
        Color neutralColor;
        Color borderColor;

        if (Main.darkModeBool) {
            veryDarkColor = new Color(16, 16, 16);
            darkColor = new Color(23, 23, 23);
            middleColor = new Color(26, 26, 26);
            lighColor = new Color(31, 31, 31);
            neutralColor = Color.WHITE;
            borderColor = new Color(36, 36, 36);
        } else {
            veryDarkColor = new Color(225, 241, 242);
            darkColor = new Color(248, 248, 248);
            middleColor = new Color(248, 248, 248);
            lighColor = new Color(255, 255, 255);
            neutralColor = Color.BLACK;
            borderColor = new Color(229, 229, 229);

        }

        frame.editorPaneSection.consoleSC.console.setBackground(Color.RED);
        frame.editorPaneSection.consoleSC.optionsBar.setBackground(darkColor);
        frame.editorPaneSection.consoleSC.textArea.setBackground(darkColor);
        frame.editorPaneSection.consoleSC.textArea.setForeground(neutralColor);
        frame.sideSection.lSection.setBackground(darkColor);
        frame.editorPaneSection.mainSection.upperPanel.setBackground(darkColor);

        frame.sideSection.rSection.setBackground(middleColor);
        frame.sideSection.costumizeSection.setBackground(middleColor);
        frame.sideSection.settingSectionSection.setBackground(middleColor);
        frame.sideSection.rSection.titleLabel.setBackground(middleColor);

        frame.sideSection.settingSectionSection.titleLabel.setBackground(lighColor);
        frame.sideSection.settingSectionSection.titleLabel.setForeground(Color.WHITE);

        frame.editorPaneSection.mainSection.runButton.setBackground(darkColor);
        frame.editorPaneSection.mainSection.compileButton.setBackground(darkColor);
        frame.menuBar.setBackground(darkColor);

        frame.editorPaneSection.mainSection.recolorAllTextAreas();
        frame.sideSection.rSection.changeTextColor();

        frame.sideSection.lSection.setBorder(BorderFactory.createLineBorder(borderColor));
        frame.sideSection.rSection.setBorder(BorderFactory.createLineBorder(borderColor));
        frame.menuBar.setBorder(BorderFactory.createLineBorder(borderColor));
        frame.editorPaneSection.consoleSC.setBorder(BorderFactory.createLineBorder(borderColor));
        frame.editorPaneSection.mainSection.upperPanel.setBorder(BorderFactory.createLineBorder(borderColor));
        frame.sideSection.costumizeSection.setBorder(BorderFactory.createLineBorder(borderColor));
        frame.sideSection.settingSectionSection.setBorder(BorderFactory.createLineBorder(borderColor));

        changeColorOfAllLabels(neutralColor, darkColor, borderColor);

    }

    public void changeColorOfAllLabels(Color TextColor, Color BackgroundColor, Color borderColor) {
        // System.out.println(this.getComponentCount());
        for (int i = 0; i < this.getComponentCount(); i++) {
            if (this.getComponent(i) instanceof JLabel) {
                this.getComponent(i).setForeground(TextColor);
            }

            if (this.getComponent(i) instanceof JTextField) {
                this.getComponent(i).setBackground(BackgroundColor);
                this.getComponent(i).setForeground(TextColor);
                ((JComponent) this.getComponent(i)).setBorder(BorderFactory.createLineBorder(borderColor));
            }

            // System.out.println(this.getComponent(i));

        }
    }

}
