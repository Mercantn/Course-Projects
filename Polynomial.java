import java.util.Arrays;
import java.util.Objects;


public class Polynomial implements Comparable<Polynomial> {
    private final int[] coefficients;


    public Polynomial(int[] coefficients) {
        this.coefficients = trimCoefficients(Arrays.copyOf(coefficients, coefficients.length));
    }


    private static int[] trimCoefficients(int[] original) {
        int start = original.length - 1;
        while (start >= 0 && original[start] == 0) {
            start--;
        }
        return start < 0 ? new int[] {0} : Arrays.copyOf(original, start + 1);
    }


    @Override
    public String toString() {
        if (coefficients.length == 1 && coefficients[0] == 0) return "0";
        StringBuilder result = new StringBuilder();
        for (int i = coefficients.length - 1; i >= 0; i--) {
            if (coefficients[i] == 0) continue;
            if (result.length() > 0) result.append(" + ");
            if (i == 0 || coefficients[i] != 1) result.append(coefficients[i]);
            if (i > 0) result.append("x");
            if (i > 1) result.append("^").append(i);
        }
        return result.toString();
    }


    public int getDegree() {
        return coefficients.length - 1;
    }


    public int getCoefficient(int k) {
        if (k < 0 || k >= coefficients.length) return 0;
        return coefficients[k];
    }


    public long evaluate(int x) {
        long result = 0;
        for (int i = coefficients.length - 1; i >= 0; i--) {
            result = result * x + coefficients[i];
        }
        return result;
    }


    public Polynomial add(Polynomial other) {
        int maxDegree = Math.max(this.getDegree(), other.getDegree());
        int[] newCoefficients = new int[maxDegree + 1];
        for (int i = 0; i <= maxDegree; i++) {
            newCoefficients[i] = this.getCoefficient(i) + other.getCoefficient(i);
        }
        return new Polynomial(newCoefficients);
    }


    public Polynomial multiply(Polynomial other) {
        int[] result = new int[this.getDegree() + other.getDegree() + 1];
        for (int i = 0; i <= this.getDegree(); i++) {
            for (int j = 0; j <= other.getDegree(); j++) {
                result[i + j] += this.coefficients[i] * other.coefficients[j];
            }
        }
        return new Polynomial(result);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Polynomial)) return false;
        Polynomial other = (Polynomial) obj;
        return Arrays.equals(this.coefficients, other.coefficients);
    }


    @Override
    public int hashCode() {
        return Arrays.hashCode(coefficients);
    }


    @Override
    public int compareTo(Polynomial other) {
        if (this.getDegree() != other.getDegree()) {
            return Integer.compare(this.getDegree(), other.getDegree());
        }
        for (int i = this.getDegree(); i >= 0; i--) {
            if (this.getCoefficient(i) != other.getCoefficient(i)) {
                return Integer.compare(this.getCoefficient(i), other.getCoefficient(i));
            }
        }
        return 0;
    }
}
