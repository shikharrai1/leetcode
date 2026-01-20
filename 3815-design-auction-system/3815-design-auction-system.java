import java.util.*;

class AuctionSystem {

    // Represents a bid
    private static class Bid {
        int userId;
        int amount;

        Bid(int userId, int amount) {
            this.userId = userId;
            this.amount = amount;
        }
    }

    // itemId -> (userId -> bidAmount)
    private Map<Integer, Map<Integer, Integer>> bids;

    // itemId -> sorted bids
    private Map<Integer, TreeSet<Bid>> itemBids;

    public AuctionSystem() {
        bids = new HashMap<>();
        itemBids = new HashMap<>();
    }

    public void addBid(int userId, int itemId, int bidAmount) {
        bids.putIfAbsent(itemId, new HashMap<>());
        itemBids.putIfAbsent(itemId, new TreeSet<>(
            (a, b) -> {
                if (a.amount != b.amount) {
                    return b.amount - a.amount; // higher bid first
                }
                return b.userId - a.userId;     // higher userId first
            }
        ));

        Map<Integer, Integer> userMap = bids.get(itemId);
        TreeSet<Bid> set = itemBids.get(itemId);

        // If user already has a bid, remove old one
        if (userMap.containsKey(userId)) {
            int oldAmount = userMap.get(userId);
            set.remove(new Bid(userId, oldAmount));
        }

        userMap.put(userId, bidAmount);
        set.add(new Bid(userId, bidAmount));
    }

    public void updateBid(int userId, int itemId, int newAmount) {
        Map<Integer, Integer> userMap = bids.get(itemId);
        TreeSet<Bid> set = itemBids.get(itemId);

        int oldAmount = userMap.get(userId);
        set.remove(new Bid(userId, oldAmount));

        userMap.put(userId, newAmount);
        set.add(new Bid(userId, newAmount));
    }

    public void removeBid(int userId, int itemId) {
        Map<Integer, Integer> userMap = bids.get(itemId);
        TreeSet<Bid> set = itemBids.get(itemId);

        int amount = userMap.get(userId);
        set.remove(new Bid(userId, amount));
        userMap.remove(userId);

        // Optional cleanup
        if (userMap.isEmpty()) {
            bids.remove(itemId);
            itemBids.remove(itemId);
        }
    }

    public int getHighestBidder(int itemId) {
        if (!itemBids.containsKey(itemId) || itemBids.get(itemId).isEmpty()) {
            return -1;
        }
        return itemBids.get(itemId).first().userId;
    }
}
