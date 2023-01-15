package com.tankGame03;

import com.tankGame02.tank;

public class tank1 extends tank {
    private int x;
    private int y;
    private int direction;
    private int speed;
    private int color;
    Shot shot =null;

    public void shotEnemy(){
        switch (direction){
            case 0://
                shot = new Shot(getX()+20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX()+60,getY()+20,1);
                break;
            case 2:
                shot = new Shot(getX()+20,getY()+60,2);
                break;
            case 3:
                shot = new Shot(getX(),getY()+20,3);
                break;
        }
        new Thread(shot).start();
    }

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

    public Shot getShot() {
        return shot;
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

    public tank1(int x, int y, int direction,int color) {
        super(x, y,direction);
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.color = color;
    }
}
