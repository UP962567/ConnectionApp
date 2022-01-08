package Prog;

import helpAction.BotMenuPanel;
import helpAction.Helper;
import helpAction.TopMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings {
    private Container contact;
    public static JFrame frameSettings;
    public JButton music1, music,music2;
    public long clipTimePosition;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    BotMenuPanel bmp = new BotMenuPanel();
    TopMenuPanel tmp = new TopMenuPanel();
    Helper h = new Helper();


    public Settings() {
        frameSettings = new JFrame("Contact Page");
        frameSettings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameSettings.setLayout(null);
        frameSettings.setSize(1000, 800);
        frameSettings.setResizable(false);
        frameSettings.setLocationRelativeTo(null);
        frameSettings.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameSettings.setUndecorated(true);
        contact = frameSettings.getContentPane();

        h.setLocation(5);
        tmp.TopMenuPanel();
        bmp.BotMenuPanel();
        BodyPanel();

        frameSettings.pack();
        frameSettings.setVisible(true);
    }

    public void BodyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 200, 800, 500);
        //panel.setBackground(Color.orange);
        panel.setOpaque(false);
        frameSettings.add(panel);

        music = new JButton("Play");
        music.setOpaque(true);
        music.setBounds(200,200,100,100);
        music.setFont(LogoFont(24));
        music.setContentAreaFilled(false);
        music.setBorderPainted(true);
        music.setForeground(Color.white);
        music.setFocusPainted(true);
        music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h.setMusicnr(1);
                h.playMusic();
            }
        });


        music1 = new JButton("Stop");
        music1.setOpaque(true);
        music1.setBounds(200,300,100,100);
        music1.setFont(LogoFont(24));
        music1.setContentAreaFilled(false);
        music1.setBorderPainted(true);
        music1.setForeground(Color.white);
        music1.setFocusPainted(true);
        music1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                h.setMusicnr(2);
                h.playMusic();
            }
        });

        panel.add(music1);
        panel.add(music);
    }

}





