import java.util.LinkedList;
import java.util.List;

public class Tail extends FileProcessor<List<String>> {
    private final int n;
    private LinkedList<String> lines;

    public Tail(int n) {
        this.n = n;
    }

    @Override
    protected void startFile() {
        lines = new LinkedList<>();
    }

    @Override
    protected void processLine(String line) {
        if (lines.size() == n) {
            lines.removeFirst();
        }
        lines.addLast(line);
    }

    @Override
    protected List<String> endFile() {
        return new LinkedList<>(lines);
    }
}
