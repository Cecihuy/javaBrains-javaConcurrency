class Hello{
    public static void main(String[] args) {
        Runnable r = new MyRunnable();
        // r.run();
        Thread t = new Thread(r);
        t.start();
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("I am running!");
    }    
}