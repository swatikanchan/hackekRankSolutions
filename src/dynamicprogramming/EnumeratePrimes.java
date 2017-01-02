package dynamicprogramming;

import java.util.Scanner;

/**
 * Created by Swati on 11-11-2016.
 */
public class EnumeratePrimes {
    public static void main(String[] args) {
        EnumeratePrimes enumPrimes = new EnumeratePrimes();
        System.out.println("Please enter a positive integer: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        enumPrimes.validateNumber(n);
    }

    private void validateNumber(int n) {
        if(n==0 || n==1)
            System.out.println("No Primes");
        else
        {
            EnumeratePrimes enumeratePrimes = new EnumeratePrimes();
            enumeratePrimes.printPrimes(n);
        }
    }

    public void printPrimes(int n)
    {
        boolean flag=false;
        String primes = "2";
        for(int num=3;num<=n;num++) {
            flag=false;
            for (int i = 2; i < Math.sqrt(n); i++) {
                if(num%i==0 && i!=num)
                {
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                primes=primes+","+num;
            }
        }
        System.out.println(primes);
    }
}
