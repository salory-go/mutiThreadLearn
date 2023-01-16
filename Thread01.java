package com.Thread.use;

public class Thread01 {

    public static void main(String[] args) {
        Cat cat =  new Cat();
        cat.start();
        Dog dog = new Dog();
        dog.start();
        while (true) {

            System.out.println("主线程正在运行....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Cat extends Thread{
    @Override
    public void run() {
        while (true) {

            super.run();
            System.out.println("cat线程正在进行。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Dog extends Thread{
    @Override
    public void run() {
        super.run();
        while (true) {
            super.run();
            System.out.println("dog线程正在进行。。。");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}