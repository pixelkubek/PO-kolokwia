public enum Color {
    Clubs(0),
    Diamonds(1),
    Hearts(2),
    Spades(3);

    private final int value;

   Color(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    public static final Color[] colors = {Clubs, Diamonds, Hearts, Spades};
}
