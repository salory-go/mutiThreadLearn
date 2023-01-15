package com.tankGame03;

import com.tankGame02.tank;

public class tank2 extends tank {
    private int x;
    private int y;
    private int direction;
    private int speed;
    private int color;


    public void moveUp(){
        y-=speed;
    }
    public void moveRight(){
        x+=speed;
    }
    public void moveDown(){
        y+=speed;
    }
    public void moveLeft(){
        x-=speed;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public tank2(int x, int y, int direction,int color) {
        super(x, y,direction);
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.color = color;
    }
}
