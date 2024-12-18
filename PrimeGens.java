import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PrimeGens {
    // check if a number is prime
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    //generates primes that are greater than the average of the previous and next prime
    public static class StrongPrimes implements Iterator<Integer> {
        private List<Integer> primes = new ArrayList<>();
        private int index = 0;

        public StrongPrimes() {
            int num = 2;
            while (primes.size() < 100) {
                if (isPrime(num)) {
                    primes.add(num);
                }
                num++;
            }
        }

        private boolean isStrongPrime(int idx) {
            if (idx == 0 || idx + 1 >= primes.size()) return false;
            int prev = primes.get(idx - 1);
            int curr = primes.get(idx);
            int next = primes.get(idx + 1);
            return curr > (prev + next) / 2;
        }

        @Override
        public boolean hasNext() {
            return true; // Infinite sequence
        }

        @Override
        public Integer next() {
            while (true) {
                if (index >= primes.size() - 1) {
                    extendPrimeList();
                }
                if (isStrongPrime(index)) {
                    return primes.get(index++);
                }
                index++;
            }
        }

        private void extendPrimeList() {
            int lastKnownPrime = primes.get(primes.size() - 1);
            for (int num = lastKnownPrime + 1; primes.size() <= index + 100; num++) {
                if (isPrime(num)) {
                    primes.add(num);
                }
            }
        }
    }
    public static int kthPrime(int k) {
        int count = 0;
        int num = 2;
        while (true) {
            if (isPrime(num)) {
                count++;
                if (count == k) return num;
            }
            num++;
        }
    }

    public static class TwinPrimes implements Iterator<Integer> {
        private int currentPrime = 2;
        @Override
        public boolean hasNext() {
            return true; // Infinite sequence
        }
        @Override
        public Integer next() {
            while (true) {
                if (isPrime(currentPrime) && isPrime(currentPrime + 2)) {
                    int result = currentPrime;
                    currentPrime += 2; // move to next potential twin prime
                    return result;
                }
                currentPrime++;
            }
        }
    }
    public static class SafePrimes implements Iterator<Integer> {
        private int currentPrime = 2;
        @Override
        public boolean hasNext() {
            return true; // Infinite sequence
        }
        @Override
        public Integer next() {
            while (true) {
                if (isPrime(currentPrime) && isPrime((currentPrime - 1) / 2)) {
                    int result = currentPrime;
                    currentPrime += 2; // move to next potential safe prime
                    return result;
                }
                currentPrime++;
            }
        }
    }

    // Main
    public static void main(String[] args) {
        Iterator<Integer> strongPrimeIterator = new StrongPrimes();
        for (int i = 0; i < 20; i++) {
            if (strongPrimeIterator.hasNext()) {
                System.out.println(strongPrimeIterator.next());
            }
        }
    }
}

