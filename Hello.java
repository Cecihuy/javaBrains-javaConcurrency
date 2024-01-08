import java.util.Scanner;

class Hello{
    public static void main(String[] args) {
        int number;

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n I can tell you the nth prime number. Enter n: ");
            int n = sc.nextInt();
            if (n == 0) break;

            Runnable r = new Runnable() {
                @Override
                public void run() {
                    int number = PrimeNumberUtil.calculatePrime(n);
                    System.out.println("\n Result : ");
                    System.out.println("\n Value of " + n + "th prime: " + number);
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
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