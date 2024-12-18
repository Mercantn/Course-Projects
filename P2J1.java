public class P2J1 {

    public static long fallingPower(int n, int k) {
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= n - i;
        }
        return result;
    }

    public static int[] everyOther(int[] arr) {
        int length = (arr.length + 1) / 2;
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = arr[i * 2];
        }
        return result;
    }

    public static int[][] createZigZag(int rows, int cols, int start) {
        int[][] result = new int[rows][cols];
        int current = start;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < cols; j++) {
                    result[i][j] = current++;
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    result[i][j] = current++;
                }
            }
        }
        return result;
    }

    public static int countInversions(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
