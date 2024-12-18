import java.util.*;

public class P2J14 {

    public static int[] distanceFromCharacter(String text, char c) {
        int n = text.length();
        int[] result = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        int distance = n + 1;

        // Fill left array
        for (int i = 0; i < n; i++) {
            if (text.charAt(i) == c) {
                distance = 0;
            } else {
                distance++;
            }
            left[i] = distance;
        }

        distance = n + 1;

        // Fill right array
        for (int i = n - 1; i >= 0; i--) {
            if (text.charAt(i) == c) {
                distance = 0;
            } else {
                distance++;
            }
            right[i] = distance;
        }

        // Combine left and right arrays
        for (int i = 0; i < n; i++) {
            result[i] = Math.min(left[i], right[i]);
        }

        return result;
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] result = dominoes.toCharArray();
        int[] forces = new int[n];

        // Calculate forces to the right
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == 'R') {
                force = n;
            } else if (result[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        // Calculate forces to the left
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] == 'L') {
                force = n;
            } else if (result[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        // final state of each domino
        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                sb.append('R');
            } else if (f < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
