import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class P2J13 {

    // count distinct substrings
    public static int countDistinctSubstrings(String text) {
        if (text == null || text.length() == 0) {
            return 0;
        }

        Set<String> currentSet = new HashSet<>();
        Set<String> nextSet = new HashSet<>();
        currentSet.add(text);

        int count = 0;

        for (int length = text.length(); length > 0; length--) {
            count += currentSet.size();
            for (String s : currentSet) {
                if (s.length() > 1) {
                    nextSet.add(s.substring(1));
                    nextSet.add(s.substring(0, s.length() - 1));
                }
            }
            currentSet = nextSet;
            nextSet = new HashSet<>();
        }

        return count;
    }

    // reverse substrings between parentheses
    public static String reverseSubstringsBetweenParentheses(String text) {
        if (text == null || text.length() == 0) {
            return text;
        }

        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '(') {
                stack.push(result.length());
            } else if (ch == ')') {
                int start = stack.pop();
                String toReverse = result.substring(start);
                result.delete(start, result.length());
                result.append(new StringBuilder(toReverse).reverse());
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
