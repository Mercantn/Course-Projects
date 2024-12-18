import java.util.Arrays;

public class Clique {

    private static int[] bestSoFar;

    public static int[] findFirstClique(boolean[][] adjacencyMatrix) {
        bestSoFar = new int[0];  // Initialize the best clique as empty
        int n = adjacencyMatrix.length;
        int[] clique = new int[n]; // Temporary array for the current clique
        findFirstClique(adjacencyMatrix, clique, 0);
        return bestSoFar;
    }

    private static boolean findFirstClique(boolean[][] adjacencyMatrix, int[] clique, int k) {
        if (k > bestSoFar.length) {
            bestSoFar = Arrays.copyOfRange(clique, 0, k); // Update best clique
        }

        int n = adjacencyMatrix.length;
        for (int i = (k == 0 ? 0 : clique[k - 1] + 1); i < n - (bestSoFar.length - k); i++) {
            boolean isValid = true;
            for (int j = 0; j < k; j++) {
                if (!adjacencyMatrix[clique[j]][i]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                clique[k] = i;
                if (findFirstClique(adjacencyMatrix, clique, k + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
