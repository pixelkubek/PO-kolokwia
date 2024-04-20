import java.security.KeyPair;
import java.util.List;

public class DealSummary {
    private final PlayerDealSummary[] _playersSummaries;

    private final String _winnerName;

    private final int _dealNo;

    public DealSummary(int dealNo, String winnerName, PlayerDealSummary[] playerDealSummaries){
        _dealNo=dealNo;
        _winnerName=winnerName;
        _playersSummaries = new PlayerDealSummary[playerDealSummaries.length];
        System.arraycopy(playerDealSummaries, 0, _playersSummaries,0, playerDealSummaries.length);
    }

    public int getDealNo(){
        return _dealNo;
    }

    public String getWinnerName(){
        return _winnerName;
    }

    public PlayerDealSummary[] getPlayerDeals(){
        return _playersSummaries;
    }
}
