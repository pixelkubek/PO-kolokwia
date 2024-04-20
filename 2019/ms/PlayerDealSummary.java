public class PlayerDealSummary {
    private final String _name;

    private final Card[] _cards;

    public PlayerDealSummary(String name, Card[] cards){
        _name=name;
        _cards = new Card[cards.length];
        System.arraycopy(cards,0,_cards,0,cards.length);
    }

    public String getName(){
        return _name;
    }

    public Card[] getCards(){
        return _cards;
    }
}
