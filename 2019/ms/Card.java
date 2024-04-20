public class Card {
    private final Color _color;

    private final Rank _rank;

    public Card(Card card){
        this(card.getColor(), card.getRank());
    }

    public Card(Color color, Rank rank){
        _color=color;
        _rank=rank;
    }

    public Color getColor(){
        return _color;
    }

    public Rank getRank(){
        return _rank;
    }
}
