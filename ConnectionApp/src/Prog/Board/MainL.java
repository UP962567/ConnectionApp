package Prog.Board;

import helpAction.BotMenuLoginPanel;
import helpAction.Helper;
import helpAction.TopMenuLoginPanel;
import helpAction.Users;

import javax.swing.*;
import java.awt.*;

public class MainL {
    private Container contact;
    public static JFrame frameBoardMain;

    private static Font MenuFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}
    private static Font LogoFont(int size){return  new Font("Time New Roman", Font.BOLD,size);}
    private static Font MainFont(int size){return  new Font("Time New Roman", Font.PLAIN,size);}

    BotMenuLoginPanel bmp = new BotMenuLoginPanel();
    TopMenuLoginPanel tmp = new TopMenuLoginPanel();
    Helper h = new Helper();


    public MainL() {
        frameBoardMain = new JFrame("Main Page");
        frameBoardMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameBoardMain.setLayout(null);
        frameBoardMain.setSize(1000, 800);
        frameBoardMain.setResizable(false);
        frameBoardMain.setLocationRelativeTo(null);
        frameBoardMain.setContentPane(new JLabel(new ImageIcon("src/IMG/bg.jpg")));
        frameBoardMain.setUndecorated(true);
        contact = frameBoardMain.getContentPane();

        h.setBoardLocation(1);
        tmp.TopMenuLoginPanel();
        bmp.BotMenuLoginPanel();
        BodyPanel();

        frameBoardMain.pack();
        frameBoardMain.setVisible(true);
    }



    public void BodyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(100, 200, 800, 500);
        panel.setBackground(Color.pink);
        //panel.setOpaque(false);
        frameBoardMain.add(panel);


        JLabel username = new JLabel("Username: " + Users.getLoginUsername());
        username.setBounds(250,150,100,50);
        username.setFont(MainFont(20));
        username.setForeground(Color.white);
        username.setOpaque(false);

        panel.add(username);
    }
}
