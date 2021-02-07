package demos.threadtest;

public class VolatileDemo {
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
        for (;;) {
            if ((myThread.isFlag())){
                System.out.println("东西");
            }
            /*synchronized (myThread){
                if ((myThread.isFlag())){
                    System.out.println("东西");
                }
            }*/
        }
    }

    static class MyThread extends Thread{
//        private volatile boolean flag = false;
        private boolean flag = false;
        public boolean isFlag(){
            return flag;
        }
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag=" + flag);
        }
    }
}
