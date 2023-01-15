package com.tankGame03;

public class Shot implements Runnable{
    int x;
    int y;
    int direction;
    int speed=2;
    boolean islive = true;

    public void setIslive(boolean islive) {
        this.islive = islive;
    }

    @Override
    public void run() {
        while(islive){
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direction){
                case 0://上
                    y-=speed;
                    break;
                case 1://右
                    x+=speed;
                    break;
                case 2://下
                    y+=speed;
                    break;
                case 3://左
                    x-=speed;
                    break;
            }
            if(!(x>=0&&x<=1000&&y>=0&&y<=750)){
                islive = false;
                break;
            }
            System.out.println("子弹坐标:"+x+" "+y);
        }
    }

    public Shot(int x, int y, int direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

}
