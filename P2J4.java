import java.util.*;

public class P2J4 {

    // Method to compute the running median of three
    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        List<Integer> result = new ArrayList<>(items);

        if (items.size() < 3) {
            return new ArrayList<>(items);
        }

        // Set first two elements as they are
        result.set(0, items.get(0));
        result.set(1, items.get(1));

        // Calculate the median of each subarray of size 3
        for (int i = 2; i < items.size(); i++) {
            List<Integer> subList = items.subList(i - 2, i + 1);
            List<Integer> sortedSubList = new ArrayList<>(subList);
            Collections.sort(sortedSubList);
            result.set(i, sortedSubList.get(1)); // Set the median (middle element) at the current position
        }

        return result;
    }

    // Method to find the first missing positive integer
    public static int firstMissingPositive(List<Integer> items) {
        int size = items.size();
        boolean[] present = new boolean[size + 1];

        // Mark the numbers that are in the list
        for (int num : items) {
            if (num > 0 && num <= size) {
                present[num] = true;
            }
        }

        // Find the first missing positive integer
        for (int i = 1; i <= size; i++) {
            if (!present[i]) {
                return i;
            }
        }

        return size + 1;
    }

    // Method to sort the list by element frequency
    public static void sortByElementFrequency(List<Integer> items) {
        // Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : items) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Sort the list based on frequency and value
        Collections.sort(items, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int freq1 = frequencyMap.get(o1);
                int freq2 = frequencyMap.get(o2);

                // Compare by frequency (descending), then by value (ascending)
                if (freq1 != freq2) {
                    return Integer.compare(freq2, freq1);
                } else {
                    return Integer.compare(o1, o2);
                }
            }
        });
    }

    // Method to return the list of prime factors of factorial of n
    public static List<Integer> factorFactorial(int n) {
        List<Integer> primeFactors = new ArrayList<>();

        // Prime factorization of numbers from 2 to n
        for (int i = 2; i <= n; i++) {
            int num = i;
            for (int div = 2; div <= num; div++) {
                while (num % div == 0) {
                    primeFactors.add(div);
                    num /= div;
                }
            }
        }

        // Sort the prime factors in ascending order
        Collections.sort(primeFactors);

        return primeFactors;
    }
}
