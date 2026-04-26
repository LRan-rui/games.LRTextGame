package com.example.lrtextgame.winodw;

import javax.swing.*;
import java.awt.*;

public class Window {
    static JFrame window =  new JFrame();
    static JPanel panel = new JPanel();
    static JEditorPane editorShow = new JEditorPane();
    static JEditorPane editorInput = new JEditorPane();
    static JEditorPane editorFill = new JEditorPane();
    static JScrollPane scroll = new JScrollPane(panel);

    public static void run(){


        editorShow.setEditable(false);
        editorShow.setContentType("text/html");
        editorShow.setSize(Integer.MAX_VALUE,Integer.MAX_VALUE);
        editorShow.setText("<html><body style='width: 100%;'>你的内容</body></html>");
        editorInput.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        editorInput.setText(">>>");
        editorFill.setEditable(false);
        editorFill.setText("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        Color color = new Color(70, 70, 70);
        panel.setBackground(new Color(230, 240, 255));
        scroll.setBackground(color);
        editorShow.setBackground(color);
        editorInput.setBackground(color);
        editorFill.setBackground(color);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUI(new UI());
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(editorShow);
        panel.add(editorInput);
        panel.add(editorFill);
        window.add(scroll);



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        run();
    }
}
