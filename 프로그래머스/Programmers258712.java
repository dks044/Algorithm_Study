import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, HashMap<String, Integer>> giftGraph = new HashMap<>();
        Map<String, Integer> giftPoints = new HashMap<>();
        Map<String, Integer> nextGifts = new HashMap<>();

        for(String friend : friends){
            giftGraph.put(friend, new HashMap<>());
            giftPoints.put(friend, 0);
            nextGifts.put(friend, 0);
            for(String f : friends){
                giftGraph.get(friend).put(f, 0);
            }
        }

        for(String gift : gifts){
            String[] pair = gift.split(" ");
            String giver = pair[0];
            String receiver = pair[1];
            giftPoints.put(giver, giftPoints.get(giver) + 1);
            giftPoints.put(receiver, giftPoints.get(receiver) - 1);
            giftGraph.get(giver).put(receiver, giftGraph.get(giver).get(receiver) + 1);
        }

        for (String friendA : friends) {
            for (String friendB : friends) {
                if(friendA.equals(friendB)) continue;
                int sendCount = giftGraph.get(friendA).get(friendB); 
                int receiveCount = giftGraph.get(friendB).get(friendA); 

                if((sendCount == 0 && receiveCount == 0) || sendCount == receiveCount){
                    int giftPointA = giftPoints.get(friendA);
                    int giftPointB = giftPoints.get(friendB);
                    if(giftPointA > giftPointB) nextGifts.put(friendA, nextGifts.get(friendA) + 1);
                } else if(sendCount > receiveCount) {
                    nextGifts.put(friendA, nextGifts.get(friendA) + 1);
                }
            }
        }

        return Collections.max(nextGifts.values());
    }
}
