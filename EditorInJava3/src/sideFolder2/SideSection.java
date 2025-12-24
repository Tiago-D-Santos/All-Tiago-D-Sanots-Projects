package sideFolder2;
import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import frameFolder.Frame;

public class SideSection extends JPanel {

  public LeftMenuSection2 lSection;
  public FileExplorerSection rSection;
  public SettingSection settingSectionSection;
  public JScrollPane settingSection;
  public CostumizeSection costumizeSection;
  public ExtensionsSection extensionsSection;
  //public JScrollPane rSection;

  public SideSection(Frame frame) {
    this.setLayout(null);
    this.setBackground(Color.LIGHT_GRAY);
    this.setOpaque(true);
    lSection = new LeftMenuSection2(frame);
    this.add(lSection);
    rSection = new FileExplorerSection(frame);
    /* rSection = new JScrollPane(rSectionPanel);
    rSection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    rSection.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    rSection.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
      @Override
      protected void configureScrollBarColors() {
        this.thumbColor = new Color(194, 194, 194);
      }
    }); */

    this.add(rSection);

    settingSectionSection = new SettingSection(frame);
    settingSection = new JScrollPane(settingSectionSection);
    settingSection.setBorder(BorderFactory.createEmptyBorder());

    settingSection.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    settingSection.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    // settingSection.getVerticalScrollBar().setBackground(Color.BLACK);
    // settingSection.getHorizontalScrollBar().setBackground(Color.BLACK);
    settingSection.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
      @Override
      protected void configureScrollBarColors() {
        this.thumbColor = new Color(194, 194, 194);// cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc
      }
    });
    this.add(settingSection);

    costumizeSection = new CostumizeSection();
    this.add(costumizeSection);

    extensionsSection = new ExtensionsSection();
    this.add(extensionsSection);
  }

}