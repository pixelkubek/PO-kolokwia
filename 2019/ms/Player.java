import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String _name;

    private final List<Card> _currentHand;

    private int _money;

    public Player(String name,int money){
        if(money<0)
            throw new IllegalArgumentException("Money cannot be a negative number.");
        _money=money;
        _currentHand = new ArrayList<Card>();
        _name=name;
    }

    public boolean canPlay(int stake){
        // Here should be logic for voluntary resign.
       return false;
    }

    public boolean doesResign(){
        return false;
    }

    public int payStake(int stake){
        if(_money<stake)
            throw new IllegalStateException("Player has lower balance than the stake.");
        _money-=stake;
        return stake;
    }

    public String getName(){
        return _name;
    }

    public void claimMoney(int sum){
        if(sum<0){
            throw new IllegalArgumentException("Sum cannot be negative.");
        }
        _money+=sum;
    }

    public void claimCard(Card card){
        _currentHand.add(card);
    }

    public Card getTheOldestCard(){
        if(_currentHand.isEmpty()){
            throw new IllegalStateException("Hand is empty.");
        }
        return _currentHand.get(CardHelper.getOldestCardIndex(_currentHand.toArray(Card[]::new)));
    }

    public Card[] giveOutHand(){
        Card[] wholeHand = _currentHand.toArray(Card[]::new);
        _currentHand.clear();
        return wholeHand;
    }

    private boolean doMustResign(int stake){
        return _money<stake;
    }
}
