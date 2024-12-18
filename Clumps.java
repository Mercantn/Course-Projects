public class Clumps {
    private int[] parent;
    private int[] size;

    // initialize the disjoint set with n elements
    public Clumps(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    // Finds the representative of the set containing element a with path compression
    private int findRepresentative(int a) {
        if (parent[a] != a) {
            parent[a] = findRepresentative(parent[a]); // Path compression
        }
        return parent[a];
    }

    // Checks if elements a and b are in the same clump
    public boolean sameClump(int a, int b) {
        return findRepresentative(a) == findRepresentative(b);
    }

    // Merges the clumps containing a and b
    public boolean meld(int a, int b) {
        int rootA = findRepresentative(a);
        int rootB = findRepresentative(b);

        if (rootA == rootB) {
            return false;
        }

        // attach smaller tree to the root of the larger tree
        if (size[rootA] < size[rootB]) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
        } else {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
        return true;
    }

    // Returns the size of the clump
    public int clumpSize(int a) {
        return size[findRepresentative(a)];
    }
}
