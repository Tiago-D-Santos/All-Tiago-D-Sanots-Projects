package editorFolder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import frameFolder.Main;

public class TextSection extends JPanel {
   public JTextPane textArea1;
   private JTextArea lines;
   private JScrollPane jsp;
   private JLabel imagelabel;
   private Style style;
   private String text;
   private boolean isUpdating;
   StyledDocument doc;
   private String address;

   public TextSection(String text, boolean isAnImage, String address) {
      // this.setBackground(Color.white);
      this.setLayout(new BorderLayout());
      this.text = text;
      this.address = address;
      if (!(isAnImage)) {
         jsp = new JScrollPane();
         jsp.setBorder(BorderFactory.createEmptyBorder());
         textArea1 = new JTextPane();

         // textArea1.setTabSize(2);

         lines = new JTextArea("1");
         drawTextSection();
         lines.setEditable(false);
         textArea1.getDocument().addDocumentListener(new DocumentListener() {// needs fixing
            public String calculateLineNumber() {
               int caretPosition = textArea1.getDocument().getLength();
               Element root = textArea1.getDocument().getDefaultRootElement();
               String text = "1" + System.getProperty("line.separator");
               for (int i = 2; i < root.getElementIndex(caretPosition) + 2; i++) {
                  text += i + System.getProperty("line.separator");
               }
               return text;
               /*
                * String rawText = textArea1.getText();
                * int linesCount = rawText.split("<br>").length;
                * StringBuilder sb = new StringBuilder();
                * for (int i = 1; i <= linesCount; i++) {
                * sb.append(i).append(System.lineSeparator());
                * }
                * return sb.toString();
                */
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
               lines.setText(calculateLineNumber());
               textArea1.setForeground(Color.BLACK);
               updateColorsSafely();

            }

            @Override
            public void insertUpdate(DocumentEvent de) {
               lines.setText(calculateLineNumber());
               textArea1.setForeground(Color.BLACK);
               updateColorsSafely();

            }

            @Override
            public void removeUpdate(DocumentEvent de) {
               lines.setText(calculateLineNumber());

            }

         });
         jsp.getViewport().add(textArea1);
         jsp.setRowHeaderView(lines);
         // this.setPreferredSize(new Dimension(500, 400));
         // textArea1.setContentType("text/html");

         isUpdating = false;
         textArea1.setText(text);
         updateColors();

         this.add(jsp, BorderLayout.CENTER);
      }

      else {

         try {
            this.setOpaque(false);
            BufferedImage originalImage = ImageIO.read(new File(address));

            imagelabel = new JLabel();
            imagelabel.setHorizontalAlignment(JLabel.CENTER);
            imagelabel.setOpaque(false);
            this.add(imagelabel, BorderLayout.CENTER);

            imagelabel.addComponentListener(new java.awt.event.ComponentAdapter() {// chat gbt adjust imnage to 90% of
                                                                                   // window
               public void componentResized(java.awt.event.ComponentEvent evt) {
                  Dimension size = imagelabel.getSize();
                  int targetWidth = (int) (size.width * 0.9);
                  int targetHeight = (int) (size.height * 0.9);

                  if (targetWidth < 1)
                     targetWidth = 1;
                  if (targetHeight < 1)
                     targetHeight = 1;

                  int scaledSize = Math.min(targetWidth, targetHeight);

                  Image scaledImage = originalImage.getScaledInstance(scaledSize, scaledSize, Image.SCALE_SMOOTH);
                  imagelabel.setIcon(new ImageIcon(scaledImage));
               }
            });

         } catch (IOException e) {
            e.printStackTrace();
         }
      }

   }

   public String getFileText1() {
      return textArea1.getText() + "";
      // return "ll";
   }

   public void drawTextSection() {
      Color CA;
      Color CB;
      Color TColor;
      // ,,
      if (Main.darkModeBool) {
         CA = new Color(28, 28, 28);
         CB = new Color(31, 31, 31);
         TColor = Color.WHITE;
      } else {
         CA = Main.lighWhite;
         CB = Main.lighWhite;
         TColor = Color.BLACK;
      }
      if (lines != null) {
         lines.setBackground(CA);
         lines.setForeground(TColor);
         textArea1.setBackground(CB);

         textArea1.setForeground(TColor);
      }

   }

   /**
    * this colors spezific word in the text area
    * 
    * @param textPane the hole text area
    * @param word     the word that you want to high light
    * @param style    the style/color of the word
    */
   public void highlightWord(JTextPane textPane, String word, Style style) {
      StyledDocument doc = textPane.getStyledDocument();
      String content;

      try {
         content = doc.getText(0, doc.getLength());
      } catch (BadLocationException e) {
         e.printStackTrace();
         return;
      }

      // Clear previous styles
      // doc.setCharacterAttributes(0, content.length(),
      // textPane.getStyle(StyleContext.DEFAULT_STYLE), true);

      int index = 0;
      while ((index = content.indexOf(word, index)) >= 0) {
         doc.setCharacterAttributes(index, word.length(), style, false);
         index += word.length();
      }


      
   }




   /**
    * which word are gonna be changed
    */
   public void updateColors() {
      doc = textArea1.getStyledDocument();
      StyleContext context = new StyleContext();
      Style redStyle = context.addStyle("RED", null);
      Style blueStyle = context.addStyle("BLUE", null);
      Style cyanStyle = context.addStyle("CYAN", null);
      Style blackStyle = context.addStyle("BLACK", null);
      
      //doc.setCharacterAttributes(0, (doc.getText(0, doc.getLength()).length()));
      // textPane.getStyle(StyleContext.DEFAULT_STYLE), true);

      StyleConstants.setForeground(redStyle, Color.RED);
      highlightWord(textArea1, "private", redStyle);
      highlightWord(textArea1, "public", redStyle);
      highlightWord(textArea1, "protected", redStyle);

      StyleConstants.setForeground(blueStyle, Color.BLUE);
      highlightWord(textArea1, "byte", blueStyle);
      highlightWord(textArea1, "short", blueStyle);
      highlightWord(textArea1, "int", blueStyle);
      highlightWord(textArea1, "long", blueStyle);
      highlightWord(textArea1, "float", blueStyle);
      highlightWord(textArea1, "double", blueStyle);
      highlightWord(textArea1, "boolean", blueStyle);

      highlightWord(textArea1, "Byte", blueStyle);
      highlightWord(textArea1, "Short", blueStyle);
      highlightWord(textArea1, "Integer", blueStyle);
      highlightWord(textArea1, "Long", blueStyle);
      highlightWord(textArea1, "Float", blueStyle);
      highlightWord(textArea1, "Double", blueStyle);
      highlightWord(textArea1, "Boolean", blueStyle);
      highlightWord(textArea1, "String", blueStyle);

      StyleConstants.setForeground(cyanStyle, Color.CYAN);
      highlightWord(textArea1, "{", cyanStyle);
      highlightWord(textArea1, "}", cyanStyle);

            //StyleConstants.setForeground(blackStyle, Color.BLACK);


   }

   public void updateColorsSafely() {
      if (isUpdating)
         return; // Already updating
      isUpdating = true;

      SwingUtilities.invokeLater(() -> {
         //updateColors();
         updateColorsLoop(textArea1);
         isUpdating = false;
      });
   }

   public void updateColorsLoop(JTextPane textPane) {
    StyledDocument doc = textPane.getStyledDocument();
    String content;

    StyleContext context = new StyleContext();
    Style redStyle = context.addStyle("RED", null);
    Style blueStyle = context.addStyle("BLUE", null);
    Style blackStyle = context.addStyle("BLACK", null);
    Style defaultStyle = textPane.getStyle(StyleContext.DEFAULT_STYLE);

    // Set colors once
    StyleConstants.setForeground(redStyle, Color.RED);
    StyleConstants.setForeground(blueStyle, Color.BLUE);
    StyleConstants.setForeground(blackStyle, Color.BLACK);


    try {
        content = doc.getText(0, doc.getLength());
    } catch (BadLocationException e) {
        e.printStackTrace();
        return;
    }

    // Clear previous styles
    doc.setCharacterAttributes(0, content.length(), defaultStyle, true);

    int wordStart = -1;
    Style currentStyle = defaultStyle;

    for (int i = 0; i <= content.length(); i++) {
        char c = (i < content.length()) ? content.charAt(i) : ' '; // treat end as space

        if (Character.isLetter(c)) {
            // start of a new word
            if (wordStart == -1) {
                wordStart = i;
                if (Character.isUpperCase(c)) {
                    currentStyle = blueStyle; // uppercase word → blue
                } else {
                    currentStyle = blackStyle; // lowercase word → red
                }
            }
        } else {
            // end of a word
            if (wordStart != -1) {
                int wordLength = i - wordStart;
                doc.setCharacterAttributes(wordStart, wordLength, currentStyle, false);
                wordStart = -1;
                currentStyle = defaultStyle;
            }
        }
    }
   }  

   public String getAddress(){
      return address;
   }

}