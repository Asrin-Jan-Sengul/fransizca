import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    Reader reader = new Reader();
    String[] wordsArray1 = reader.okuyucu("siiracma.txt");
    String[] wordsArray2 = reader.okuyucu("siiracma2.txt");

    int counter = 0, wordcount = 0, i=0;
    JButton button1 ,button2 ,button3, button4;
    JLabel  label,label1;
    ImageIcon icon;
    JProgressBar bar;
    
    MyFrame(){

        /*ImageIcon image = new ImageIcon("apoo.png");
        Border border = BorderFactory.createLineBorder(Color.green,3);
        */

        bar = new JProgressBar();
        bar.setBounds(100,330,250,50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.blue);
        bar.setBackground(Color.lightGray);

        icon  = new ImageIcon("angry.png");
        label1 = new JLabel();
        label1.setIcon(icon);
        label1.setBounds(200,150,50,50);
        label1.setVisible(false);

        button1 = new JButton();
        button1.setBounds(50 ,250 ,150 ,50);
        button1.addActionListener(this);     
        button1.setText("New word");
        button1.setFocusable(false);
        button1.setFocusPainted(false);
        button1.setFont(new Font("Cosmic Sans" , Font.BOLD,15));
        button1.setBackground(Color.lightGray);;
        button1.setBorder(BorderFactory.createEtchedBorder());

        button2 = new JButton();
        button2.setBounds(250,250,150,50);
        button2.addActionListener(this);
        button2.setText("Türkçesi");
        button2.setFocusable(false);
        button2.setFocusPainted(false);
        button2.setFont(new Font("Cosmic Sans" , Font.BOLD,15));
        button2.setBackground(Color.lightGray);;
        button2.setBorder(BorderFactory.createEtchedBorder());

        button4 = new JButton();
        button4.setBounds(150,310,150,30);
        button4.addActionListener(this);
        button4.setText("Previous");
        button4.setFocusable(false);
        button4.setFocusPainted(false);
        button4.setFont(new Font("Cosmic Sans", Font.BOLD, 10));
        button4.setBackground(Color.lightGray);;
        button4.setBorder(BorderFactory.createEtchedBorder());


/* 
        JPanel redpanel = new JPanel();
        redpanel.setBackground(Color.red);
        redpanel.setBounds(0,0,250,250);
        redpanel.setLayout(new BorderLayout());
*/
        label = new JLabel();    //Creates a label 
        label.setText("Kelimeler");
        label.setForeground(Color.DARK_GRAY);       // set font text color 
        label.setFont(new Font("MV Boli" ,Font.PLAIN ,20));     //set font of text
        label.setBounds(100,50,250,50);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setHorizontalAlignment(JLabel.CENTER);
 

        /*label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);     // set text left right or center of imageicon
        label.setVerticalTextPosition(JLabel.TOP);       // set text top bottom or center of imageicon
        label.setIconTextGap(-50);       // set gap text to image
        label.setBackground(Color.black);       //set background color
        label.setOpaque(true);      // display background color
        label.setBorder(border);    //adds a border 
        label.setBounds(100 ,100 ,250 ,250);    //adjusts label bounds within the frame
        */

        ImageIcon icon3 = new ImageIcon("trollface.png");
        button3 = new JButton();
        button3.setBounds(380,420,60,60);
        button3.addActionListener(this);
        button3.setBackground(Color.darkGray);
        button3.setIcon(icon3);


        this.setTitle("Fransizca Öğrenme uygulamasi denemesi");    //Sets the title of the main frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //exit out of application 
        this.setResizable(false);   //Prevents the frame from resized
        this.setSize(450,500);     //Sets the x-y dimentions of the frame
        this.setVisible(true);     //makes frame visible
        this.add(label);
        //redpanel.add(label);
        //this.add(redpanel);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(label1);
        this.add(bar);

        this.setLayout(null);   
        ImageIcon logo = new ImageIcon("fransizcalogo.png");   //Create an image icon
        this.setIconImage(logo.getImage());   //Change the icon of the frame
        //  this.getContentPane().setBackground(new Color(90,90,90));   //Adds a Background color
        //  this.pack();    //Sets the size of the frame to include all the components exactly  important to add all components first
        


        this.setLocationRelativeTo(null);       //Sets the frame in the middle of screen  important to add last 
    }

    public void fill(){
        bar.setValue(counter);
        if(counter==100){
            bar.setString("Done ! :)");
            /*try {
                System.out.println("Ending the app in 3sec.");
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.exit(0);*/       // BURASI ÇALIŞMIYOR PROGRESS BAR %90DA TAKILI KALIYOR Done ! :) yazmak yerine 
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button1){
            System.out.println("Sa");
            button2.setEnabled(true);
            label1.setVisible(true);
            counter += 10;
            fill();
            wordcount +=1;
            if(i<wordsArray1.length){
                label.setText(wordsArray1[i]);
                i++;
            }else;
        }

        else if(e.getSource()==button2){
            System.out.println("2. Sa");
            button2.setEnabled(false);
            label1.setVisible(false);

        }
        else if(e.getSource()==button3){
            int i=1;
            while(i<7){
                ImageIcon icon3 = new ImageIcon("tf.png");
                i += JOptionPane.showOptionDialog(null, "Noob got trolled", "", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, icon3, null, 0);
                System.out.println(i); 
            }
        }
        else if(e.getSource()==button4){
            if(i>0){
                i--;
                label.setText(wordsArray1[i]);
            }
            if(counter>0 && counter<100){
                counter -= 10;
            }
            fill();
        }
    }

}
