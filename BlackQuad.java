public final class BlackQuad implements QuadTree {
    private static final BlackQuad INSTANCE = new BlackQuad();

    private BlackQuad() { }

    public static BlackQuad get() {
        return INSTANCE;
    }

    @Override
    public boolean isOneColour() {
        return true;
    }

    @Override
    public long computeArea(int scale) {
        return 1L << (2 * scale); // Black quad area calculation
    }
}
