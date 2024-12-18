public class Permutations {

    // Computes the composition of two permutations p1 and p2.
    public static int[] chain(int[] p1, int[] p2) {
        int n = p1.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = p1[p2[i]];
        }
        return result;
    }

    // Computes the inverse of a permutation.
    public static int[] inverse(int[] perm) {
        int n = perm.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[perm[i]] = i;
        }
        return result;
    }

    // Computes the square of a permutation.
    public static int[] square(int[] perm) {
        return chain(perm, perm);
    }

    // Computes the k-th power of a permutation.
    public static int[] power(int[] perm, int k) {
        int n = perm.length;
        if (k == 0) {
            // Identity permutation
            int[] identity = new int[n];
            for (int i = 0; i < n; i++) {
                identity[i] = i;
            }
            return identity;
        }
        if (k == 1) {
            return perm;
        }
        if (k < 0) {
            return power(inverse(perm), -k);
        }

        int[] result = perm.clone();
        int[] base = perm.clone();
        k--;
        while (k > 0) {
            if (k % 2 == 1) {
                result = chain(result, base);
            }
            base = chain(base, base);
            k /= 2;
        }
        return result;
    }
}
