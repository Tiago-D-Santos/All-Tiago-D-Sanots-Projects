package editorFolder;


import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import frameFolder.Frame;
import frameFolder.Main;



public class MainSection extends JPanel {

    private HashMap<Integer, TextSection> openTextArea;
    private HashMap<Integer, JPanel> openButtons;
    private HashMap<JButton, Integer> indexList;
    private HashMap<Integer, String> PathList;

    public int counter;

    public JPanel upperPanel;
    public JPanel secUpperPanel;
    public JPanel fullTextPanel;
    public JButton runButton;
    public JButton compileButton;
    private Frame frame;

    private String lastMainPath;
    private String targetFolderPath = "C:\\Users\\user\\OneDrive\\programation\\EditorInJava3\\editorBin";;
    private String mainClassName;

    private Thread crThread;

    public MainSection(Frame frame) {
        this.frame = frame;
        this.setLayout(null);
        this.setBackground(Color.blue);
        this.setOpaque(true);

        counter = 0;

        secUpperPanel = createMainSectionPanel();
        upperPanel = createMainSectionPanel();
        fullTextPanel = createMainSectionPanel();

        runButton = createMainSectionButton("\u25B7");
        runButton.addActionListener(e -> {
            crThread = new Thread(()->runAndCompile());
            crThread.start();

        });
        compileButton = createMainSectionButton("\u2713");
        
        compileButton.addActionListener(e -> 
            System.out.println("compile ")
        ); 

        runButton.setBounds(0, 0, 30, 30);
        compileButton.setBounds(30, 0, 30, 30);
        runButton.setOpaque(true);
        compileButton.setOpaque(true);

        secUpperPanel.add(runButton);
        secUpperPanel.add(compileButton);

        this.add(upperPanel);
        this.add(secUpperPanel);
        this.add(fullTextPanel);

        PathList = new HashMap<>();
        openButtons = new HashMap<>();
        openTextArea = new HashMap<>();
        indexList = new HashMap<>();
    }

    public JPanel createMainSectionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);/*
                               * panel.setBackground(color);
                               * panel.setOpaque(true);
                               */
        return panel;
    }

    private void deleteEverythingFromBin(File folder){
       File[] files = folder.listFiles();  

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //recursively delete the subfolder first
                    deleteEverythingFromBin(file);
                }
                //then delete the file or empty folder
                if (file.delete()) {
                    //System.out.println("Deleted: " + file.getAbsolutePath());
                } else {
                    System.err.println("Failed to delete: " + file.getAbsolutePath());
                }
            }
        }
    }


    private void runAndCompile(){
        deleteEverythingFromBin(new File("C:\\Users\\user\\OneDrive\\programation\\EditorInJava3\\editorBin"));
            System.out.println("run");
            // saveAllFiles();
            // compileAndRun();
            try {
                String compileCmd = "javac -d \"" + targetFolderPath + "\" \"" + lastMainPath + "\"";
                String runCmd = "java -cp \"" + targetFolderPath + "\" " + mainClassName;
                frame.editorPaneSection.consoleSC.addTextToConsole("RUN: "+compileCmd+ "&& "+runCmd);
                
                System.out.println("Compiling: " + compileCmd);
                runCommand(compileCmd);
                //System.out.println("-----------------------------------------------------------");
                System.out.println("Running: " + runCmd);
                runCommand(runCmd);

                frame.editorPaneSection.consoleSC.addTextToConsole("");
                
                

                //System.out.println("la");
            } catch (Exception ex) {
                // TODO: handle exception
                System.err.println("runing problem");
            }
    }

    public JButton createMainSectionButton(String name) {
        JButton button = new JButton(name);
        button.setFont(new Font("Dialog", Font.PLAIN, 15));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setFocusable(false);
        // button2.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        return button;
    }

    public void testCompile() {

    }

    /*
     * public void compileAndRun() {
     * try {
     * 
     * String sourceDir = Main.absulutPath;
     * 
     * String[] mainClassName = new String[1]; // mutable container
     * 
     * Files.list(Paths.get(sourceDir))
     * .filter(path -> path.toString().endsWith(".java"))
     * .forEach(path -> {
     * try {
     * String content = Files.readString(path);
     * if (containsMainMethod(content) && mainClassName[0] == null) {
     * mainClassName[0] = getClassName(content, path);
     * System.out.println("Found main class: " + mainClassName[0]);
     * }
     * } catch (IOException e) {
     * e.printStackTrace();
     * System.out.println("compiling errir");
     * // System.out.println(e.getStackTrace());
     * 
     * }
     * });
     * 
     * // Compile all Java files
     * // System.out.println(sourceDir);
     * String javacCommand = String.format("javac %s%c*.java", sourceDir,
     * File.separatorChar);
     * 
     * @SuppressWarnings("deprecation")
     * Process compile = Runtime.getRuntime().exec(javacCommand);
     * // Process compile = Runtime.getRuntime().exec("javac " + sourceDir+ "
     * // \\*.java");
     * 
     * compile.waitFor();
     * System.out.println("compile------------------------------");
     * System.out.println("javac " + sourceDir + "\\*.java");
     * 
     * System.out.println("compile2");
     * 
     * // launch the main class in a new command prompt window
     * // System.out.println(mainClassName[0]);
     * if (mainClassName[0] != null) {
     * String command = String.format(
     * "cmd /c start cmd /k java -cp \"%s\" %s", sourceDir, mainClassName[0]);
     * Runtime.getRuntime().exec(command);
     * frame.editorPaneSection.consoleSC.addTextToConsole("\n Run&Compile : " +
     * Main.absulutPath);
     * 
     * System.out.println("executed");
     * } else {
     * frame.editorPaneSection.consoleSC.addTextToConsole("\n no main class");
     * System.out.println("no main class");
     * // ---------------------------------
     * }
     * 
     * } catch (IOException | InterruptedException e) {
     * e.printStackTrace();
     * System.out.println(e + "compiling error 2");
     * 
     * frame.editorPaneSection.consoleSC.addTextToConsole(e + "");
     * }
     * }
     */

    private void runCommand(String command) throws IOException {
        
    try {
        Process process = Runtime.getRuntime().exec(command);

        // Read standard output
        BufferedReader outputReader = new BufferedReader(
            new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = outputReader.readLine()) != null) {
            System.out.println(line);
            frame.editorPaneSection.consoleSC.addTextToConsole(line);
        }

        // Read error output
        BufferedReader errorReader = new BufferedReader(
            new InputStreamReader(process.getErrorStream()));
        while ((line = errorReader.readLine()) != null) {
            System.err.println("ERROR: " + line);
            frame.editorPaneSection.consoleSC.addTextToConsole("error"+line);

        }

        // Wait until the process finishes
        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("✅ Command succeeded: " + command);
         
        } else {
            System.err.println("❌ Command failed with exit code " + exitCode + ": " + command);
          
        }

    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
       
    }
}

    // Looks for the main method
    private static boolean containsMainMethod(String path) throws IOException {

        Path newPath = Path.of(path);
        String content = Files.readString(newPath);

        return content.contains("public static void main(String[] args)")
                || content.contains("public static void main(String args[])");
    }

    // Tries to find the class name by looking for 'public class ...''
    private static String getClassName(String content, Path filePath) {
        Pattern pattern = Pattern.compile("public\\s+class\\s+(\\w+)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        } else {
            // Fallback: use the file name without extension
            return filePath.getFileName().toString().replace(".java", "");
        }
    }

    private void printProcessOutput(Process process) throws IOException {
        try (InputStream is = process.getErrorStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                frame.editorPaneSection.consoleSC.addTextToConsole(line);
            }
        } catch (Exception e) {
            frame.editorPaneSection.consoleSC.addTextToConsole(e + "");
            System.out.println(e);
        }
        frame.editorPaneSection.consoleSC.addTextToConsole("");// add an empty line between the error messages
    }

    public void resize(int width, int height) {
        upperPanel.setBounds(0, 0, width - 75, 30);
        secUpperPanel.setBounds(width - 75, 0, 80, 30);
        fullTextPanel.setBounds(0, 30, width, height - 30);
        // openButtons.get(0).setBounds(getVisibleRect());
        for (Integer i : openTextArea.keySet()) {
            openTextArea.get(i).setBounds(getVisibleRect());
        }

    }

    public void createPanel(String name, String inputtxt, int c1, String address) {
        // create the full panel
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);

        // layout
        JButton nameButton1 = createPanelButton(name + "");
        JButton button1 = createPanelButton("\u25A0");
        JButton button2 = createPanelButton("x");

        /*
         * JButton nameButton1 = new JButton(name+"");
         * JButton button1 = new JButton("\u25A0");
         * JButton button2 = new JButton("x");
         * 
         * nameButton1.setFont(new Font("Dialog", Font.PLAIN, 15));
         * nameButton1.setMargin(new Insets(0, 0, 0, 0)); // Remove internal padding
         * nameButton1.setFocusable(false); // Optional: prevents focus border
         * //button1.setBorderPainted(false); // Optional: makes it flat
         * nameButton1.setContentAreaFilled(false); // Optional: makes it look cleaner
         * nameButton1.addActionListener(e -> {System.out.println(c1+"");
         * setTextArea(c1);
         * });
         * 
         * button1.setFont(new Font("Dialog", Font.PLAIN, 15));
         * button1.setMargin(new Insets(0, 0, 0, 0)); // Remove internal padding
         * button1.setFocusable(false); // Optional: prevents focus border
         * //button1.setBorderPainted(false); // Optional: makes it flat
         * button1.setContentAreaFilled(false); // Optional: makes it look cleaner
         * 
         * button2.setFont(new Font("Dialog", Font.PLAIN, 15));
         * button2.setMargin(new Insets(0, 0, 0, 0));
         * button2.setFocusable(false);
         * //button2.setBorderPainted(false);
         * button2.setContentAreaFilled(false);
         * button2.addActionListener(e-> {
         * System.out.println("exit");
         * removeUpperPanel(counter-1);
         * });
         */

        // bar button sizes
        int panelWIDTH = 180;
        panel1.setSize(panelWIDTH, 30);
        nameButton1.setBounds(0, 0, panelWIDTH - 60, 30);
        button1.setBounds(panelWIDTH - 60, 0, 30, 30);
        button2.setBounds(panelWIDTH - 30, 0, 30, 30);

        panel1.setBorder(BorderFactory.createLineBorder(Color.black));

        nameButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        button1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        button2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Color testColor = Main.bitdarkWhite;

        panel1.setOpaque(true);
        nameButton1.setOpaque(true);
        button1.setOpaque(true);
        button2.setOpaque(true);

        nameButton1.setBackground(testColor);
        button1.setBackground(testColor);
        button2.setBackground(testColor);

        if (counter != 0) {// in case ther is no upperbuttton more there
            panel1.add(nameButton1);
            panel1.add(button1);
            panel1.add(button2);
        } else {
            panel1.setBounds(0, 0, 0, 30);
            nameButton1.setBounds(0, 0, 0, 30);
            panel1.add(nameButton1);
        }

        counter++;
        PathList.put(counter, address);
        // upperPanel.add(panel1);
        openButtons.put(counter, panel1);
        indexList.put(button2, counter);
        updateUpperPanel();
        if (address != null && (address.endsWith(".jpeg") || address.endsWith(".png") || address.endsWith(".jpg")
                || address.endsWith(".gif")))
            createTextArea(inputtxt, true, address);
        else
            createTextArea(inputtxt, false, address);

        button1.addActionListener(e -> {// cube button
            // saveText(1, address);
            System.out.println(inputtxt);
            TextSection txtSection = new TextSection(inputtxt, false, address);
            new openEditorWindow(txtSection, address);
        });
        int newindex = counter;
        System.out.println(newindex);
        int c = counter;
        button2.addActionListener(e -> {// close button
            System.out.println("exit");
            //
            setTextArea(1);// HATE THIS LINE
            removeUpperPanel(indexList.get(e.getSource()));
            indexList.remove(e.getSource());// removes JButton because there would be a problem probably
            System.out.println(c);

            this.repaint();
            revalidate();

        });
        nameButton1.addActionListener(e -> {
            // System.out.println(newindex+"");
            setTextArea(newindex);
            // System.out.println("new index: "+newindex);
        });
        //
        setTextArea(c);
    }

    public void saveText(int index, String address) {
        if (address == null)
            System.out.println("Fuck it");
        System.out.println("provisor save");
        if (!address.isBlank()) {
            // System.out.println("index: "+index+"adress: "+address);
            try {
                // Creates a Writer using FileWriter
                Writer output = new FileWriter(address);
                // output.write(openTextArea.get(0)+"--------------------------------");
                output.write(openTextArea.get(index).getFileText1());
                // System.out.println(address+"---->"+openTextArea.get(index ).getFileText1());
                output.close();
            } catch (Exception e1) {
                e1.getStackTrace();
                System.out.println(e1.toString() + "save text");
            }
        }

    }

    public void saveAllFiles() {
        for (int i = 1; i <= counter; i++) {
            // System.out.println(i);
            saveText(i, PathList.get(i));
        }
        // System.out.println("----------------------------------------------");
    }

    public JButton createPanelButton(String name) {
        JButton button = new JButton(name);
        button.setFont(new Font("Dialog", Font.PLAIN, 15));
        button.setMargin(new Insets(0, 0, 0, 0)); // Remove internal padding
        button.setFocusable(false); // Optional: prevents focus border
        // button1.setBorderPainted(false); // Optional: makes it flat
        button.setContentAreaFilled(false); // Optional: makes it look cleaner
        return button;
    }

    public void updateUpperPanel() {
        /*
         * for(int i = 1; i<=openButtons.size();i++){
         * int panelWIDTH =180;
         * openButtons.get(i).setLocation(panelWIDTH*(i-1)+5*i,0);
         * upperPanel.add(openButtons.get(i));
         * }
         */
        int j = 0;
        for (Integer i : openButtons.keySet()) {
            int panelWIDTH = 180;
            openButtons.get(i).setLocation(panelWIDTH * (j - 1) + 5 * j, 0);
            upperPanel.add(openButtons.get(i));
            j++;
            // System.out.println(i);
        }
    }

    public void debugLoop() {
        // for(int i=0;i<arr1.size();i++)System.out.println("debug"+arr1.get(i));7
        if (PathList.isEmpty())
            for (Integer i : PathList.keySet()) {
                System.out.println("key: " + i + "  +  value:  " + PathList.get(i));
            }
    }

    public void recolorAllTextAreas() {
        for (Integer i : openTextArea.keySet()) {
            openTextArea.get(i).drawTextSection();
            // System.out.println("color from"+openTextArea.get(i));
        }
    }

    public void removeUpperPanel(int index) {
        // debugLoop(openButtons);
        // System.out.println(index +".........");
        // System.out.println("index...."+index);
        upperPanel.removeAll();

        // System.out.println("size"+openButtons.size());
        // openTextArea.remove(index);//dont use remove becausecthe index dont combine
        // openTextArea.set(index, null);

        PathList.remove(index);
        openTextArea.remove(index);
        openButtons.remove(index);

        // PathList.remove(index);
        updateUpperPanel();

        repaint();
    }

    public void setTextArea(int index) {// sets the corect textarea visible
        if (!openTextArea.containsKey(index)) {
            System.out.println("Invalid index: " + index);
            return;
        }

        for (Integer i : openTextArea.keySet()) {
            openTextArea.get(i).setBounds(fullTextPanel.getVisibleRect());
            fullTextPanel.add(openTextArea.get(i));
            if (index == i) {
                openTextArea.get(i).setVisible(true);

                try {
                    if (containsMainMethod(openTextArea.get(i).getAddress())) {
                        System.out.println("test");
                        lastMainPath = openTextArea.get(i).getAddress();
                        File file = new File(lastMainPath);
                        System.out.println("!!!package"+searchForPackage(lastMainPath));
                        if(searchForPackage(lastMainPath)==null){
                            mainClassName = file.getName().replace(".java", "");
                        }else{
                            mainClassName = searchForPackage(lastMainPath)+"."+ file.getName().replace(".java", "");
                        }
                        System.out.println("}}}}}}}}}}}}}}}}}}"+mainClassName);
                        
                        //System.out.println("main  " + lastMainPath);
                        //System.out.println("path  " + file.getName());
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    
                    System.out.println("smt worng"+e);
                }

            } else {
                openTextArea.get(i).setVisible(false);
            }

            //System.out.println(openTextArea.get(i).getX());

        }

        fullTextPanel.revalidate();
        fullTextPanel.repaint();
        updateUpperPanel();

        // System.out.println("Switched to index: " + index);

        /*
         * for(int i=1;i<=counter;i++){
         * 
         * if(openButtons.get(i)!=null){
         * openTextArea.get(i).setBounds(getVisibleRect());
         * fullTextPanel.add(openTextArea.get(i));
         * 
         * openTextArea.get(i).setVisible(true);
         * }
         * 
         * }
         */

        /*
         * for(int i=0;i<openTextArea.size();i++){
         * openTextArea.get(i).setBounds(getVisibleRect());
         * fullTextPanel.add(openTextArea.get(i));
         * if(index ==i) openTextArea.get(i).setVisible(true);
         * else openTextArea.get(i).setVisible(false);
         * }
         */

        /*
         * for (Integer i : openTextArea.keySet()) {
         * 
         * System.out.println("sss"+i);
         * openTextArea.get(i).setBounds(getVisibleRect());
         * fullTextPanel.add(openTextArea.get(i));
         * if(index ==i) openTextArea.get(i).setVisible(true);
         * else openTextArea.get(i).setVisible(true);
         * System.out.println("---"+i+"---"+openTextArea.get(i));
         * }
         */

        /*
         * for (Integer i : openButtons.keySet()) {
         * //System.out.println("sss"+i+"::"+index);
         * openTextArea.get(i).setBounds(getVisibleRect());
         * fullTextPanel.add(openTextArea.get(i));
         * if(index ==i) {
         * openTextArea.get(i).setVisible(true);
         * System.out.println("true"+i);
         * }
         * else {
         * openTextArea.get(i).setVisible(false);
         * System.out.println("false"+i);
         * }
         * System.out.println("---"+i+"---"+openTextArea.get(i));
         * }
         */

    }

    public void getIndex() {

    }

    public void createTextArea(String inputTxt, boolean isPicture, String adress) {
        // counter++;//could lead to errror
        // counter++;
        TextSection txtSection = new TextSection(inputTxt, isPicture, adress);
        openTextArea.put(counter, txtSection);

    }

    public boolean isTheFileAlreadyOpened(String path) {
        for (int key : PathList.keySet()) {
            if (PathList.get(key).equals(path)) {
                setTextArea(key);
                return true;
            }
        }
        return false;
    }

     
    public String searchForPackage(String filePath){
        File file = new File(filePath);
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line= br.readLine();
            while(line!=null){
                
                if((line.indexOf("package")!=-1)&&(line.indexOf(";")!=-1)){
                    return line.substring(line.indexOf("package")+7, line.indexOf(";"));
                }
                line= br.readLine();
            }
            
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
