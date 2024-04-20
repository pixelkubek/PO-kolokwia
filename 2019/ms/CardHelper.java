class CardHelper {
    public static int getOldestCardIndex(Card[] cards){
        if(cards.length == 0){
            throw new IllegalStateException("Hand is empty.");
        }

        int currentBestIndex = 0;
        for(int i = 1; i<cards.length; i++){
            if(isBetterCard(cards[currentBestIndex],cards[i])){
                currentBestIndex=i;
            }
        }
        return currentBestIndex;
    }

    private static boolean isBetterCard(Card currentBest, Card card){
        if(currentBest.getRank().getValue() > card.getRank().getValue())
            return false;
        if(currentBest.getRank().getValue() < card.getRank().getValue())
            return true;
        return currentBest.getColor().getValue() < card.getColor().getValue();
    }
}
