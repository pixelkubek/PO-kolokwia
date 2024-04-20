public enum Rank {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(14);

    private final int value;

    Rank(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    public static final Rank[] ranks = {Two,Three,Four, Five, Six, Seven,Eight,Nine,Ten, Jack,Queen,King,Ace};
}