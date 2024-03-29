import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hello{
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        Runnable statusReporter = () -> {
            try {
                while(true){                
                    Thread.sleep(5000);                
                    printThreads(threads);
                }
            } catch (InterruptedException e) {
                System.out.println("Status report thread interrupted. Ending status updates...");
            }
        };
        Thread reporterThread = new Thread(statusReporter);
        reporterThread.setDaemon(true);
        reporterThread.start();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n I can tell you the nth prime number. Enter n: ");
            int n = sc.nextInt();

            if (n == 0){
                reporterThread.interrupt();
                try{
                    System.out.println("Waiting for all threads to finish");
                    waitForThreads(threads);
                    System.out.println("Done with the application. " + threads.size() + " primes");
                } catch (InterruptedException e){
                    System.out.println("\n Got interrupted when waiting for threads. Quitting");
                }
                break;
            }
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\n Result : ");
                    System.out.println("\n Value of " + n + "th prime: " + number);
                }
            };
            Thread t = new Thread(r);
            threads.add(t);
            t.start();
        }
    }
    private static void waitForThreads(List<Thread> threads) throws InterruptedException{
        for(Thread thread : threads){
            thread.join();
        }
    }
    private static void printThreads(List<Thread> threads) {
        System.out.print("\n Threads status: ");
        threads.forEach(thread -> {
            System.out.print(thread.getState() + " ");
        });
        System.out.println("");
    }
}
class PrimeNumberUtil{
    public static int calculatePrime(int n) {
        int number;
        int numberOfPrimesFound;
        int i;        
        number = 1;
        numberOfPrimesFound = 0;

        while (numberOfPrimesFound < n){
            number++;            
            for (i = 2; i <= number && number % i != 0; i++) {
            }
            if (i == number) {
                numberOfPrimesFound++;
            }
        }
        return number;
    }
}