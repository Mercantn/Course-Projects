import java.util.ArrayList;
import java.util.List;

public class P2J15 {

    // Binary search to find the position of x
    private static int binarySearch(int[] a, int x) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // x is guaranteed to be in the array, so this should not happen
    }

    public static int[] findClosestElements(int[] a, int x, int k) {
        int pos = binarySearch(a, x);
        int left = pos - 1;
        int right = pos + 1;
        List<Integer> result = new ArrayList<>();
        result.add(a[pos]);

        while (result.size() < k) {
            if (left < 0) {
                result.add(a[right++]);
            } else if (right >= a.length) {
                result.add(a[left--]);
            } else {
                int leftDiff = Math.abs(a[left] - x);
                int rightDiff = Math.abs(a[right] - x);
                if (leftDiff <= rightDiff) {
                    result.add(a[left--]);
                } else {
                    result.add(a[right++]);
                }
            }
        }

        result.sort(Integer::compareTo); // Ensure the result is in sorted order
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static int countSubarraysWithSum(int[] arr, int sum) {
        int count = 0;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            while (currentSum > sum && start <= end) {
                currentSum -= arr[start++];
            }

            if (currentSum == sum) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test findClosestElements
        int[] a1 = {1, 2, 3, 4, 5};
        int[] result1 = findClosestElements(a1, 3, 4);
        for (int i : result1) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Test countSubarraysWithSum
        int[] a2 = {6, 3, 1, 2, 3};
        int result2 = countSubarraysWithSum(a2, 6);
        System.out.println(result2);
    }
}
