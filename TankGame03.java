package com.tankGame03;

import javax.swing.*;
import java.awt.*;

public class TankGame03 extends JFrame {
    private myPanel mp =  null;

    public TankGame03() throws HeadlessException {
        mp = new myPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
//        重绘子弹的一个方法
//        while (true) {
//            mp.repaint();
//        }
        new Thread(mp).start();
//        或者这种方式建线程
//        Thread thread = new Thread(mp);
//        thread.start();
    }

    public static void main(String[] args) {
        new TankGame03();
    }

}
