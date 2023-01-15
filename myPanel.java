package com.tankGame03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class myPanel extends JPanel implements KeyListener,Runnable {
    tank1 Tank1 = null;
    tank2 Tank2 = null;
    tank2 Tank3 = null;
    tank2 Tank4 = null;

    public myPanel() {
        Tank1 = new tank1(100,100,1,0);
        Tank1.setSpeed(1);
        Tank2 = new tank2(200,200,1,1);
        Tank2.setSpeed(1);
        Tank3 = new tank2(300,200,1,1);
        Tank3.setSpeed(1);
        Tank4 = new tank2(400,200,1,1);
        Tank4.setSpeed(1);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
//        paintTank(Tank1.getX(),Tank1.getY(),g,0,0);
        paintTank(Tank1.getX(),Tank1.getY(),g,Tank1.getDirection(),Tank1.getColor());
        if(Tank1.getShot()!=null&&Tank1.shot.islive==true){
//            g.fill3DRect(Tank1.shot.getX(),Tank1.shot.getY(),1,1,false);
            g.draw3DRect(Tank1.shot.getX(),Tank1.shot.getY(),1,1,false);
        }
        paintTank(Tank2.getX(),Tank2.getY(),g,Tank2.getDirection(),Tank2.getColor());
        paintTank(Tank3.getX(),Tank3.getY(),g,Tank3.getDirection(),Tank3.getColor());
        paintTank(Tank4.getX(),Tank4.getY(),g,Tank4.getDirection(),Tank4.getColor());
    }
//    x,y is location
    public void paintTank(int x,int y,Graphics g,int direction,int type){
        switch (type){
            case 0://己方坦克
                g.setColor(Color.cyan);
                break;
            case 1://
                g.setColor(Color.yellow);
                break;
        }
//        0向上1向右2向下3向左
        switch (direction){
            case 0:
                g.fill3DRect(x,y,10,60,false);//画出左轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出盖子
                g.fill3DRect(x+30,y,10,60,false);//画出右轮子
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y-20);
                break;
            case 1:
                g.fill3DRect(x,y,60,10,false);//画出上轮子
                g.fill3DRect(x,y+30,60,10,false);//画出下边轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出盖子
                g.drawOval(x+20,y+10,20,20);//画出圆形盖子
                g.drawLine(x+30,y+20,x+80,y+20);//画出炮管
                break;
            case 2:
                g.fill3DRect(x,y,60,10,false);//画出上轮子
                g.fill3DRect(x,y+30,60,10,false);//画出下边轮子
                g.fill3DRect(x+10,y+10,40,20,false);//画出盖子
                g.drawOval(x+20,y+10,20,20);//画出圆形盖子
                g.drawLine(x-20,y+20,x+30,y+20);//画出炮管
                break;
            case 3:
                g.fill3DRect(x,y,10,60,false);//画出左轮子
                g.fill3DRect(x+10,y+10,20,40,false);//画出盖子
                g.fill3DRect(x+30,y,10,60,false);//画出右轮子
                g.drawOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+80,x+20,y+30);
                break;
            default:
                System.out.println("invalid");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            Tank1.setDirection(0);
            Tank1.moveUp();
        }
        else if(e.getKeyCode()== KeyEvent.VK_D){
            Tank1.setDirection(1);
            Tank1.moveRight();
        }
        else if(e.getKeyCode()== KeyEvent.VK_A){
            Tank1.setDirection(2);
            Tank1.moveLeft();
        }
        else if(e.getKeyCode()== KeyEvent.VK_S){
            Tank1.setDirection(3);
            Tank1.moveDown();
        }
        else if(e.getKeyCode()== KeyEvent.VK_J){
            Tank1.shotEnemy();
            System.out.println("子弹射击");
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }
}
