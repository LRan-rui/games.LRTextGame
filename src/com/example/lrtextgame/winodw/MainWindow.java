package com.example.lrtextgame.winodw;

import com.example.lrtextgame.central.CentralHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainWindow {

    private static final JTextArea area = new JTextArea();

    public static void addTaxt(String str) {
        area.append(str + "\n");
    }


    public static void start() {

        final String[] str = new String[2];    //每次的命令保存
        final int[][] x = {{0}};               //已执行命令计数
        final String[][] ml = {new String[3]}; //字符串str分割后的字符串数组


        final String[] ccml = {"帮助"};         //命令缓存初始化


        JFrame frame = new JFrame("LR命令程序");
        JPanel mainpanel = new JPanel();


        mainpanel.setBackground(new Color(43, 43, 43));

        area.setBackground(new Color(43, 43, 43));
        area.setForeground(new Color(244, 244, 244));
        area.setCaretColor(new Color(244, 244, 244));
        area.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        area.append(">>>");
        area.setCaretPosition(area.getText().length());


        area.setColumns(55);
        area.setRows(28);
        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    str[0] = area.getText();

                    str[1] = str[0].substring(str[0].lastIndexOf(">") + 1, str[0].lastIndexOf("\n"));

                    CentralHandler.getHandler().Input(str[1]);
                    area.append(CentralHandler.getHandler().ReturnText());
                    ccml[0] = str[1];

                    area.append("\n>>>");

                }

            }
        });
        area.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    frame.dispose();
                    System.exit(0);
                } else if (e.getKeyCode() == KeyEvent.VK_F1) {

                    area.append(ccml[0]);
                    area.setCaretPosition(area.getText().length());

                }

            }
        });

        frame.setSize(784, 603);

        mainpanel.add(area);
        mainpanel.add(new JScrollPane(area));
        frame.add(mainpanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
