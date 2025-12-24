public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Frame frame = new Frame();
        

        compileLabelClass compileMenu=new compileLabelClass();
        

        
        while (true) {
           
            //System.out.println(i+": "+frame.FrameWidth+" + "+frame.getWidth());
            if(frame.FrameWidth!=frame.getWidth()||frame.FrameHeight!=frame.getHeight())
            {
                frame.FrameHeight=frame.getHeight();
                frame.FrameWidth=frame.getWidth();

                
                frame.interSection1.setBounds((int)(frame.FrameWidth*0.5-10+frame.interSection1x),0,10,frame.FrameHeight);
                frame.interSection2.setBounds(0,(int)(frame.FrameHeight*0.5-10+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),10);
                frame.interSection3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2-10+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),10);

                
                frame.section1.setBounds(0,0,(int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2-10+frame.interSection2y));
                frame.section2.setBounds(0,(int)(frame.FrameHeight*0.5+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection2y));
                frame.section3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),0,(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y));
                frame.section4.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection3y));
                
                
                frame.scrollPane.setBounds(10, 20, frame.section3.getWidth()-25, frame.section3.getHeight()-10-20);
                frame.scrollPane.revalidate();
                frame.scrollPane.repaint();
                frame.section3subLabel.setBounds(0,0,frame.section3.getWidth(),20);
                frame.section3linecount.setBounds(15,20,15,frame.section3.getHeight()-20);

                frame.section3SourceCodeLabel.setBounds(frame.section3subLabel.getWidth()-15-80,0,80,frame.section3subLabel.getHeight());
                
            }
            if(frame.interSection1_draged){
                //System.out.println("x"+frame.interSection1x);
                frame.interSection1.setBounds((int)(frame.FrameWidth*0.5-10+frame.interSection1x),0,10,frame.FrameHeight);
                frame.interSection2.setBounds(0,(int)(frame.FrameHeight*0.5-10+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),10);
                frame.interSection3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2-10+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),10);

                

                
                frame.section1.setBounds(0,0,(int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection2y));
                frame.section2.setBounds(0,(int)(frame.FrameHeight*0.5+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection2y));
                frame.section3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),0,(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y));
                frame.section4.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection3y));
                
            
                frame.scrollPane.setBounds(10, 20, frame.section3.getWidth()-15-10, frame.section3.getHeight()-10-20);
                frame.scrollPane.revalidate();
                frame.scrollPane.repaint();
                frame.section3subLabel.setBounds(0,0,frame.section3.getWidth(),20);
                frame.section3linecount.setBounds(15,20,15,frame.section3.getHeight()-20);
            
                frame.section3SourceCodeLabel.setBounds(frame.section3subLabel.getWidth()-15-80,0,80,frame.section3subLabel.getHeight());
            }
            if(frame.interSection2_draged){
                frame.interSection1.setBounds((int)(frame.FrameWidth*0.5-10+frame.interSection1x),0,10,frame.FrameHeight);
                frame.interSection2.setBounds(0,(int)(frame.FrameHeight*0.5+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),10);
                frame.interSection3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2-10+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),10);


                frame.section1.setSize((int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection2y));
                frame.section2.setBounds(0,(int)(frame.FrameHeight*0.5+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection2y));
                frame.section3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),0,(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y));
                frame.section4.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection3y));
                
                
                frame.scrollPane.setBounds(10, 20, frame.section3.getWidth()-15-10, frame.section3.getHeight()-10-20);
                frame.scrollPane.revalidate();
                frame.scrollPane.repaint();
                frame.section3subLabel.setBounds(0,0,frame.section3.getWidth(),20);
                frame.section3linecount.setBounds(15,20,15,frame.section3.getHeight()-20);
            
                frame.section3SourceCodeLabel.setBounds(frame.section3subLabel.getWidth()-15-80,0,80,frame.section3subLabel.getHeight());
            }
            if(frame.interSection3_draged){
                frame.interSection1.setBounds((int)(frame.FrameWidth*0.5-10+frame.interSection1x),0,10,frame.FrameHeight);
                frame.interSection2.setBounds(0,(int)(frame.FrameHeight*0.5-10+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),10);
                frame.interSection3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2-10+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),10);

                
                frame.section1.setSize((int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection2y));
                frame.section2.setBounds(0,(int)(frame.FrameHeight*0.5+frame.interSection2y),(int)(frame.FrameWidth*0.5-10+frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection2y));
                frame.section3.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),0,(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y));
                frame.section4.setBounds((int)(frame.FrameWidth*0.5+frame.interSection1x),(int)(frame.FrameHeight/2+frame.interSection3y),(int)(frame.FrameWidth/2-frame.interSection1x),(int)(frame.FrameHeight/2-frame.interSection3y));
                
                
                frame.scrollPane.setBounds(10, 20, frame.section3.getWidth()-15-10, frame.section3.getHeight()-10-20);
                frame.scrollPane.revalidate();
                frame.scrollPane.repaint();
                frame.section3subLabel.setBounds(0,0,frame.section3.getWidth(),20);
                frame.section3linecount.setBounds(15,20,15,frame.section3.getHeight()-20);

                frame.section3SourceCodeLabel.setBounds(frame.section3subLabel.getWidth()-15-80,0,80,frame.section3subLabel.getHeight());
            }


            if(Frame.maketheClassVisible == true){
                frame.label1.section1createdClass.setVisible(true);
                frame.section1.add(frame.label1.section1createdClass);  

                System.out.println("i see this");
                Frame.maketheClassVisible=false;
            }

            

            //-------------------------------------------------------------
            if(frame.canYouComile==true){
                frame.canYouComile = false;
                
                frame.section1.add(compileMenu.CompileLabel1);
                System.out.println("hohoho");
                //frame.section1.repaint();
            }



            //-------------------------------------------------------------

            //System.out.println(i+": "+frame.FrameWidth+" + "+frame.getWidth());
            //frame.section3linecount.setBounds(15,20,15,frame.section3.getHeight()-20);
            //frame.scrollPane.repaint();
            //frame.linecountfunc();
            frame.scrollPane.repaint();
            //frame.section3SourceCodeLabel.setBounds(frame.section3subLabel.getWidth()-60,0,30,30);
            frame.section3SourceCodeLabel.setBounds(frame.section3subLabel.getWidth()-15-80,0,80,frame.section3subLabel.getHeight());
            Thread.sleep(25);
        }
        
        
        
    }
    
    
}
