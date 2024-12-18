import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordCount extends FileProcessor<List<Integer>> {

    private int charCount;
    private int wordCount;
    private int lineCount;

    @Override
    protected void startFile() {
        charCount = 0;
        wordCount = 0;
        lineCount = 0;
    }

    @Override
    protected void processLine(String line) {
        lineCount++;
        charCount += line.length();

        boolean isPrevWhitespace = true;
        for (char c : line.toCharArray()) {
            if (Character.isWhitespace(c)) {
                isPrevWhitespace = true;
            } else {
                if (isPrevWhitespace) {
                    wordCount++;
                }
                isPrevWhitespace = false;
            }
        }
    }

    @Override
    protected List<Integer> endFile() {
        System.out.println("Final Line Count: " + lineCount);  // Debugging line count
        List<Integer> counts = new ArrayList<>();
        counts.add(charCount);
        counts.add(wordCount);
        counts.add(lineCount);
        return counts;
    }
}
