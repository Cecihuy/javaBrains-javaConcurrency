class Hello{
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("I am running!");
        Thread t = new Thread(r);
        t.start();
        
        //or
        new Thread(() -> System.out.println("I am running! in one line")).start();
        
        //or extends Thread in custom class
        new MyThread().start();
    }
}
class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("I am running! from custom class extends Thread");
    }
}