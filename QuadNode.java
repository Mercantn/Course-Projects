import java.util.Arrays;

public final class QuadNode implements QuadTree {
    private final QuadTree[] children;
    private long area = 0;
    private int lastScale = Integer.MAX_VALUE;

    private QuadNode(QuadTree[] children) {
        this.children = Arrays.copyOf(children, children.length);
    }

    public static QuadTree of(QuadTree... children) {
        if (children.length != 4) {
            throw new IllegalArgumentException("Exactly 4 children required");
        }

        if (children[0] == WhiteQuad.get() &&
                children[1] == WhiteQuad.get() &&
                children[2] == WhiteQuad.get() &&
                children[3] == WhiteQuad.get()) {
            return WhiteQuad.get();
        }

        if (children[0] == BlackQuad.get() &&
                children[1] == BlackQuad.get() &&
                children[2] == BlackQuad.get() &&
                children[3] == BlackQuad.get()) {
            return BlackQuad.get();
        }

        return new QuadNode(children);
    }

    @Override
    public boolean isOneColour() {
        return false;
    }

    @Override
    public long computeArea(int scale) {
        if (lastScale != scale) {
            // Recalculate area if the scale is different
            area = 0;
            for (QuadTree child : children) {
                area += child.computeArea(scale - 1);
            }
            lastScale = scale;
        }
        return area;
    }
}
