import javax.swing.*;
import java.awt.*;

public class createClass extends JDialog{

    JLabel input1text;
    JTextField input1;
    JCheckBox input1CheckBox;

    JLabel input2text;
    JTextField input2;

    JLabel input3text;
    JTextField input3;
    
    JLabel VisibilityLabel;
    JCheckBox VisibilityLabelcheckBoxoption1;
    JCheckBox VisibilityLabelcheckBoxoption2;
    JCheckBox VisibilityLabelcheckBoxoption3;
    JCheckBox VisibilityLabelcheckBoxoption4;

    JLabel ModifierLabel;
    JCheckBox ModifierLabelCheckBox1;
    JCheckBox ModifierLabelCheckBox2;

    JLabel CodeGenerationLabel;
    JCheckBox CodeGenerationCheckBox1;
    JCheckBox CodeGenerationCheckBox2;

    JButton okButton;
    JButton cancelButton;

    static String CodeText;

    

    createClass(){
        this.setModal(true);
        this.setBounds(850,400,300,450);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Add a new class");
        this.setIconImage(null);
        

        input1text= new JLabel("Name:");
        input1text.setBounds(30,20,150,20);
        input1 = new JTextField();
        input1.setBounds(100,20 ,180,20);
        input1CheckBox = new JCheckBox("interface");
        input1CheckBox.setBounds(100,45 ,150,20);

        input2text= new JLabel("Extends:");
        input2text.setBounds(30,70,150,20);
        input2 = new JTextField();
        input2.setBounds(100,70,180,20);

        input3text= new JLabel("Package:");
        input3text.setBounds(30,95,150,20);
        input3 = new JTextField();
        input3.setBounds(100,95,180,20);

        VisibilityLabel = new JLabel();
        VisibilityLabel.setBounds(15,130,120,130);
        VisibilityLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));
        VisibilityLabel.setLayout(new GridLayout(4,1));

        VisibilityLabelcheckBoxoption1 = new JCheckBox("public");
        VisibilityLabelcheckBoxoption2 = new JCheckBox("protected");
        VisibilityLabelcheckBoxoption3 = new JCheckBox("default");
        VisibilityLabelcheckBoxoption4 = new JCheckBox("private");

        ModifierLabel = new JLabel();
        ModifierLabel.setBounds(180,130,100,140);
        ModifierLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));
        //ModifierLabel.setLayout(new GridLayout(4,1));

        ModifierLabelCheckBox1 = new JCheckBox("final");
        ModifierLabelCheckBox1.setBounds(5,30,85,15);
        //ModifierLabelCheckBox1.setBackground(Color.BLACK);
        ModifierLabelCheckBox2 = new JCheckBox("abstract");
        ModifierLabelCheckBox2.setBounds(5,60,85,15);
        //ModifierLabelCheckBox2.setBackground(Color.BLACK);


        CodeGenerationLabel= new JLabel();
        CodeGenerationLabel.setBounds(15, 290, 250, 70);
        CodeGenerationLabel.setBackground(Color.red);
        CodeGenerationLabel.setBorder(BorderFactory.createLineBorder(Color.lightGray,1));
        CodeGenerationLabel.setLayout(new GridLayout(2,1));

        CodeGenerationCheckBox1= new JCheckBox("Main Method");
        CodeGenerationCheckBox1.setPreferredSize(getPreferredSize());
        CodeGenerationCheckBox2= new JCheckBox("JavaDoc Comments");
        CodeGenerationCheckBox2.setPreferredSize(getPreferredSize());


        okButton = new JButton("OK");
        okButton.setBounds(10,380,60,25);
        okButton.addActionListener(e -> setCodeforLabel3func());
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(175,380,90,25);
        cancelButton.addActionListener(e -> this.dispose());//Frame.section1ButtonClosed()






        VisibilityLabel.add(VisibilityLabelcheckBoxoption1);
        VisibilityLabel.add(VisibilityLabelcheckBoxoption2);
        VisibilityLabel.add(VisibilityLabelcheckBoxoption3);
        VisibilityLabel.add(VisibilityLabelcheckBoxoption4);

        
        ModifierLabel.add(ModifierLabelCheckBox1);
        ModifierLabel.add(ModifierLabelCheckBox2);

        CodeGenerationLabel.add(CodeGenerationCheckBox1);
        CodeGenerationLabel.add(CodeGenerationCheckBox2);



        this.add(ModifierLabel);
        this.add(input1text);
        this.add(input1);
        this.add(input1CheckBox);
        this.add(input2text);
        this.add(input2);
        this.add(input3text);
        this.add(input3);
        this.add(VisibilityLabel);
        this.add(CodeGenerationLabel);
        this.add(okButton);
        this.add(cancelButton);

        
        this.setVisible(true);


    }
    public void setCodeforLabel3func(){
        boolean cancel = false;
        String accesModifier="";
        String nameOfTheClass="";

        if(VisibilityLabelcheckBoxoption1.isSelected()){accesModifier="public";}
        else if(VisibilityLabelcheckBoxoption2.isSelected()){accesModifier="protected";}
        else if(VisibilityLabelcheckBoxoption3.isSelected()){accesModifier="";}
        else if(VisibilityLabelcheckBoxoption4.isSelected()){accesModifier="private";}
        else{cancel = true;}

        if(input1.getText()!=""){
            nameOfTheClass = input1.getText();
        }
        else{cancel = true;}



        //System.out.println(input1CheckBox.isSelected());
        
        if(cancel!=true){
            CodeText=accesModifier+" "+nameOfTheClass+"{ \n   \n }";
            //System.out.println(CodeText);
            Frame.section1ButtonClosed();
            this.dispose();
        }
        else{
            System.out.println("invalid");
        }
     
    }
}
