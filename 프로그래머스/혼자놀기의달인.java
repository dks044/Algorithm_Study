import java.util.*;
class Solution {
    int[] parents;
    public int solution(int[] cards) {
        parents = cards;
        boolean[] visited = new boolean[cards.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<cards.length;i++) parents[i]--;
        
        for(int i=0;i<cards.length;i++){
            int box = 0;
            if(!visited[i]){
                box = find(i,visited);
            }else{
                box = parents[i];
            }
            map.put(box,map.getOrDefault(box,0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            list.add(entry.getValue());
        }
        if(list.size() == 1) return 0;
        Collections.sort(list,(o1,o2) -> o2 - o1);
        
        return list.get(0) * list.get(1);
    }
    int find(int index, boolean[] visited){
        if(index == parents[index] || visited[index]){
            return index;
        }
        visited[index] = true;
        return parents[index] = find(parents[index],visited);
    }
}
