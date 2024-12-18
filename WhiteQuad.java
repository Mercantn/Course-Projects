public final class WhiteQuad implements QuadTree {
    private static final WhiteQuad INSTANCE = new WhiteQuad();

    private WhiteQuad() { }

    public static WhiteQuad get() {
        return INSTANCE;
    }

    @Override
    public boolean isOneColour() {
        return true;
    }

    @Override
    public long computeArea(int scale) {
        return 0; // White quad has no black pixels
    }
}
