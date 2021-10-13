import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    JFrame f;
    JLabel img = new JLabel(new ImageIcon("icon.png"));
    JLabel text = new JLabel("Welcome to Hibernate Info-System");
    JProgressBar progressBar = new JProgressBar();
    JLabel message = new JLabel();

    SplashScreen() {
        createGUI();
        addImage();
        addText();
        addProgressBar();
        addMessage();
        runningPBar();
    }
    public void createGUI(){
        f = new JFrame("Welcome to Hibernate Info-System");


        f.getContentPane().setLayout(null);
        f.setUndecorated(true);
        f.setSize(600,400);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.GRAY);
        f.setVisible(true);
    }
    public void addImage(){
        img.setSize(600,200);
        f.add(img);
    }
    public void addText() {
        text.setFont(new Font("arial",Font.BOLD,20));
        text.setBounds(30,220,600,30);
        text.setForeground(Color.ORANGE);
        f.add(text);
    }
    public void addMessage() {
        message.setBounds(200,320,200,40);
        message.setForeground(Color.ORANGE);
        message.setFont(new Font("arial",Font.BOLD,20));
        f.add(message);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,280,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.ORANGE);
        progressBar.setValue(0);
        f.add(progressBar);
    }
    public void runningPBar(){
        int i=0;

        while(i<=100) {
            try {
                Thread.sleep(50);
                progressBar.setValue(i);
                message.setText("PLEASE WAIT: "+Integer.toString(i)+"%");
                i++;
                if(i==100) {
                    f.dispose();
                    new FinalApp();

                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}

