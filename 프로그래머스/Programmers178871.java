import java.util.*;
class Solution {
    static int[] createIndexArr(String[] players){
        int length = players.length;
        int[] playIndex = new int[length];
        for(int i=0;i<length;i++){
            playIndex[i] = i;
        }
        return playIndex;
    }
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        //인덱스, 선수명
        Map<Integer,String> indexPlayer = new HashMap<>();
        Map<String,Integer> playerOfIndex = new HashMap<>();
        for(int i=0;i<players.length;i++){
            indexPlayer.put(i,players[i]);
            playerOfIndex.put(players[i],i);
        }

        //인덱스 int배열
        int[] playerIndex = createIndexArr(players);
        //callings int배열
        int[] callIndex = new int[callings.length];
        for(int i=0;i<callIndex.length;i++){
            callIndex[i] = playerOfIndex.get(callings[i]);
        }
        
        int cIndex = 0;
        while(cIndex < callings.length){
            for(int i=1;i<playerIndex.length;i++){
                if(playerIndex[i]==callIndex[cIndex]){
                    int temp = playerIndex[i];
                    playerIndex[i] = playerIndex[i-1];
                    playerIndex[i-1] = temp;
                    cIndex++;
                    break;
                }
            }   
        }
        
        
        for(int i=0;i<answer.length;i++){
            answer[i] = indexPlayer.get(playerIndex[i]);
        }
        
        
        
        
        return answer;
    }
}
