import java.util.ArrayList;
import java.util.List;

public class Primes {

    private static List<Integer> primes = new ArrayList<>();

    static {
        // Initialize
        primes.add(2);
    }

    // check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (primes.contains(n)) return true;

        int sqrt = (int) Math.sqrt(n);
        expandPrimes(sqrt);

        for (int prime : primes) {
            if (prime > sqrt) break;
            if (n % prime == 0) return false;
        }

        return true;
    }

    //find the k-th prime
    public static int kthPrime(int k) {
        while (primes.size() <= k) {
            expandPrimes(primes.get(primes.size() - 1) + 1);
        }
        return primes.get(k);
    }

    //factorize a number into its prime factors
    public static List<Integer> factorize(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n < 2) return factors;

        expandPrimes((int) Math.sqrt(n));

        for (int prime : primes) {
            while (n % prime == 0) {
                factors.add(prime);
                n /= prime;
            }
            if (n == 1) break;
        }

        if (n > 1) {
            factors.add(n);
        }

        return factors;
    }

    //expand the list of known primes up to a certain limit
    private static void expandPrimes(int limit) {
        int candidate = primes.get(primes.size() - 1) + 1;

        while (primes.get(primes.size() - 1) <= limit) {
            boolean isPrime = true;

            int sqrt = (int) Math.sqrt(candidate);
            for (int prime : primes) {
                if (prime > sqrt) break;
                if (candidate % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primes.add(candidate);
            }
            candidate++;
        }
    }
}