import java.util.Arrays;

public class P2J9 {

    public static boolean[] sumOfTwoDistinctSquares(int n) {
        boolean[] result = new boolean[n];
        // Check all pairs (a, b) where a and b are distinct positive integers
        for (int a = 1; a * a < n; a++) {
            for (int b = a + 1; b * b < n; b++) {
                int sum = a * a + b * b;
                if (sum < n) {
                    result[sum] = true;
                }
            }
        }
        return result;
    }

    public static boolean[] subtractSquare(int n) {
        boolean[] result = new boolean[n];
        // Initialize the result array
        Arrays.fill(result, false);
        result[0] = false; // Base case: 0 is a losing state

        for (int i = 1; i < n; i++) {
            boolean isHot = false;
            for (int j = 1; j * j <= i; j++) {
                if (!result[i - j * j]) {
                    isHot = true;
                    break;
                }
            }
            result[i] = isHot;
        }
        return result;
    }
}
