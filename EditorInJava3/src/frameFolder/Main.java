
package frameFolder;
import java.awt.*;
import javax.swing.SwingUtilities;

/* import org.json.simple.JSONArray;

import org.json.simple.JSONObject;

import org.json.simple.parser.*; */

/*
 * known errors
 * 
 * -doesnt find the image in the same folder
 * -lines counter doesnt work
 * -//close open file fix
 * 
 * 
 */
/*
 * thigs to do
 * - AN POP up like in satisfactory that tels you when the autoupdate is  going to execute
 * -Extention menu: add real extension
 * -Costummize menu 
 * -loop and update the rightmenubar with the updated folder
 * -create new file/folder via editor
 * -save button in the menubar
 * -make the terminal work better
 * -make the logo icon have an historic
 * finsish the colorr
 * -rename files 
 * -drag and drop files
 * 
 */
public class Main {
  // public static String
  // absulutPath="C:\\Users\\user\\Desktop\\programation\\CompileJavaFileFromFile\\src";
  public static String absulutPath = "C:\\Users\\user\\OneDrive\\programation\\EditorInJava3\\testFolder";
  public static int activeLeftState = 1;
  public static boolean darkModeBool = false;
  public static Color bitdarkWhite = new Color(225, 241, 242);
  public static Color darkWhite = new Color(248, 248, 248);
  public static Color middlWhite = new Color(248, 248, 248);
  public static Color lighWhite = new Color(255, 255, 255);// new Color(255, 255, 255);

  public static void main(String[] args) {
    /*
     * Object o = new JSONParser().parse(new FileReader(File.json));
     * JSONObject j = (JSONObject) o;
     * 
     * try {
     * Frame frame=new Frame();
     * /* while(true){
     * frame.mainSection.saveAllFiles();
     * Thread.sleep(10000);
     * 
     * 
     * } catch (Exception e) {
     * /* ystem.out.println("-------------"+e.getCause());
     * System.err.println(e);
     */
    try {
      SwingUtilities.invokeLater(() -> {
        try {
          System.out.println("lalal");
          Frame frame = new Frame();
          System.out.println("whyy");

        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("system error");
          System.exit(1); // force exit
        }
      });
    } catch (Throwable t) {
      System.out.println("something whent wrong");
      t.printStackTrace();
    }

  }
}
