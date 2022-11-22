import java.util.ArrayList;
import java.util.List;

public class Prime {
    /**
     * A very silly idea to find whether a num id prime or not.
     * Iterate from 2 to num, if find a i that can let num % i == 0, then num is not a prime number.
     */
    public static boolean strawManIsPrime(int num) {
        if (num == 0 || num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * A optimized version of strawman Idea, iterate from 2 to sqrt(num),
     * if a number num is not a prime number, say we have num = a * b
     * a and b could not greater than sqrt(num) simultaneously (one in left side of sqrt(num), one in right side of sqrt(num)
     * so if num has factor in [2,sqrt(num)], then num is not prime
     */
    public static boolean strawManIsPrimeSquare(int num) {
        if (num == 0 || num == 1) return false;
        // attention: this is <= !!!
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * given a numbers, show all the prime numbers less than n
     * O(n^2)
     */
    public static List<Integer> primes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (strawManIsPrimeSquare(i)) primes.add(i);
        }
        return primes;
    }

    public static boolean[] isPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        // if n is not a prime, then n must have a factor between [2, sqrt(n)]
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }

    /**
     * Given a number n, print all primes smaller than or equal to n. It is also given that n is a small number.
     * Sieve of Eratosthenes
     */
    public static List<Integer> Eprimes(int n) {
        boolean[] isPrime = isPrimes(n);
        List<Integer> ret = new ArrayList<>();
        for (int i =0; i <= n; i++) {
            if (isPrime[i]) ret.add(i);
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(strawManIsPrime(12));
        System.out.println(strawManIsPrimeSquare(97));
        System.out.println(primes(100));
        System.out.println(Eprimes(100));
    }
}
