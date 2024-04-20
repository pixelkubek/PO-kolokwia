import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LightningGame {
    private static final int SHUFFLES_COUNT = 5;

    private static final int HAND_SIZE = Rank.ranks.length * Color.colors.length;

    private static final int DECK_SIZE = Rank.ranks.length * Color.colors.length;

    private final Player[] _players;

    private final List<DealSummary> _dealSummaries;

    private final int _stake;

    private int _nextDealNo;

    public LightningGame(Player[] players, int stake){
        if(players.length <2)
            throw new IllegalArgumentException("Game must have at least two players");

        _players = new Player[players.length];
        System.arraycopy(players,0,_players,0, players.length);
        _stake=stake;
        _dealSummaries = new ArrayList<DealSummary>();
        _nextDealNo=1;
    }

    public static void main(String[] args){
        // Do sth.
    }

    public void simulate(){
        while(playDeal()) {
        }
    }

    public DealSummary[] getDealSummaries(){
        return _dealSummaries.toArray(DealSummary[]::new);
    }

    private boolean playDeal(){
        for(Player player : _players){
            if(!player.canPlay(_stake) || player.doesResign())
                return false;
        }

        int dealStake = 0;
        for(Player player : _players){
            dealStake+= player.payStake(_stake);
        }

        Deck deck = new Deck(SHUFFLES_COUNT, DECK_SIZE);
        for(int i = 1; i<=HAND_SIZE; i++){
            for(Player player : _players){
                player.claimCard(deck.getTopCard());
            }
        }

        Card[] bestCards= new Card[_players.length];
        int j = 0;
        for(Player player : _players){
            bestCards[j] = player.getTheOldestCard();
        }

        int winnerIndex = CardHelper.getOldestCardIndex(bestCards);
        _players[winnerIndex].claimMoney(dealStake);
        _dealSummaries.add(generateSummary(_nextDealNo++, winnerIndex));
        return true;
    }

    private DealSummary generateSummary(int dealNo, int winnerIndex){
        List<PlayerDealSummary> playerDealSummaries = new ArrayList<PlayerDealSummary>(_players.length);
        for(Player player : _players){
            Card[] previousHand = Arrays.stream(player.giveOutHand()).map(Card::new).toArray(Card[]::new);
            playerDealSummaries.add(new PlayerDealSummary(player.getName(), player.giveOutHand()));
        }
        return new DealSummary(dealNo, _players[winnerIndex].getName(),playerDealSummaries.toArray(PlayerDealSummary[]::new));
    }
}
