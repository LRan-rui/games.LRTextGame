package com.example.lrtextgame.winodw;

import javax.swing.*;

public class Window {
    static JFrame window =  new JFrame();
    static JPanel panel = new JPanel();
    static JEditorPane editor = new JEditorPane();

    public static void run(){

        panel.add(editor);
        window.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
