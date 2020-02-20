package com.algorithms.dp;

public class TestThread {

    public static class T implements Runnable {
        public  void run() {
            while(true) {
                System.out.println("");
                try {
                    Thread.sleep(2);
                }catch (Exception ex) {

                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        int i=0;
        while(i < 10000) {
            T t = new T();
            new Thread(t).start();
            i++;
            Thread.sleep(10);
        }

        Thread.sleep(100000);
    }
}
