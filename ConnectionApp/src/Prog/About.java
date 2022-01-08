package Prog;

import helpAction.BotMenuPanel;
import helpAction.Helper;
import helpAction.TopMenuPanel;

import javax.swing.*;
import java.awt.*;

public class About {
    private Container contact;
    public static JFrame frameAbout;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    BotMenuPanel bmp = new BotMenuPanel();
    TopMenuPanel tmp = new TopMenuPanel();
    Helper h = new Helper();


    public About() {
        frameAbout = new JFrame("About Page");
        frameAbout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAbout.setLayout(null);
        frameAbout.setSize(1000, 800);
        frameAbout.setResizable(false);
        frameAbout.setLocationRelativeTo(null);
        frameAbout.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameAbout.setUndecorated(true);
        contact = frameAbout.getContentPane();

        h.setLocation(2);
        tmp.TopMenuPanel();
        bmp.BotMenuPanel();
        BodyPanel();

        frameAbout.pack();
        frameAbout.setVisible(true);
    }



    public void BodyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 200, 800, 500);
        panel.setOpaque(false);
        frameAbout.add(panel);


        JLabel about2 = new JLabel("Who am I: ");
        about2.setFont(MainFont(20));
        about2.setBounds(100,50,150,50);
        about2.setForeground(Color.white);
        about2.setOpaque(false);
        JTextArea about22 = new JTextArea("I am Maliq Dyrma.");
        about22.setBounds(250,50,400,50);
        about22.setFont(MainFont(20));
        about22.setForeground(Color.white);
        about22.setLineWrap(true);
        about22.setWrapStyleWord(true);
        about22.setEditable(false);
        about22.setBackground(Color.decode("#262A2B"));
        about22.setOpaque(true);

        JLabel about11 = new JLabel("About me: ");
        about11.setFont(MainFont(20));
        about11.setBounds(100,150,150,50);
        about11.setForeground(Color.white);
        about11.setOpaque(false);
        JTextArea about1 = new JTextArea("I am a student at University of Portsmouth. " +
                "\nRight now they are learning us about JAVA! " +
                "\nOf course I am doing this in my free time as I like to code! " +
                "\nI am not that good with it, however if you need something just contact me!");
        about1.setBounds(250,150,500,200);
        about1.setFont(MainFont(20));
        about1.setForeground(Color.white);
        about1.setLineWrap(true);
        about1.setWrapStyleWord(true);
        about1.setEditable(false);
        about1.setBackground(Color.decode("#262A2B"));
        about1.setOpaque(true);


        panel.add(about22);
        panel.add(about2);
        panel.add(about11);
        panel.add(about1);
    }
}
