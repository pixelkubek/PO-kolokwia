import java.util.Random;

class Deck {
    private final int _shufflesCount;

    private final int _deckSize;

    private final Card[] _deck;

    private int _currentTopCardIndex;

    public Deck(int shufflesCount, int deckSize){
        _shufflesCount =shufflesCount;
        _deckSize =deckSize;
        _deck = generateDeck();
        _currentTopCardIndex=0;
    }

    private Card[] generateDeck(){
        Card[] deck = getFullDeck();
        for(int i = 1; i<= _shufflesCount; i++){
            deck = shuffleDeck(deck);
            deck = randomSplitDeck(deck);
        }
        return deck;
    }

    public Card getTopCard(){
        if(_currentTopCardIndex >= _deckSize){
            throw new IllegalStateException();
        }
        return _deck[_currentTopCardIndex++];
    }

    private Card[] getFullDeck(){
        Card[] fullDeck = new Card[_deckSize];
        int i = 0;
        for(Rank rank : Rank.ranks){
            for(Color color : Color.colors){
                fullDeck[i++]=new Card(color,rank);
            }
        }
        return fullDeck;
    }

    private Card[] shuffleDeck(Card[] deck){
        Card[] shuffledDeck = new Card[deck.length];
        // Let: full deck is an even number.
        for(int i = 0; i< deck.length/2; i++){
            shuffledDeck[i] = deck[i];
            shuffledDeck[i+1] = deck[deck.length/2 + i];
        }
        return shuffledDeck;
    }

    private Card[] randomSplitDeck(Card[] deck){
        int splitIndex = new Random().nextInt(_deckSize -2) + 1; // We have DECK_SIZE -1 gaps between cards, but the lowBound for random is 0.
        Card[] newDeck = new Card[deck.length];
        int j = 0;
        for(int i = splitIndex; i<=deck.length; i++){
            newDeck[j++]=deck[i];
        }
        for(int i = 0; i<=splitIndex; i++){
            newDeck[j++]=deck[i];
        }
        return newDeck;
    }
}
