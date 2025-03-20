import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
        
        while (pq.size() > 1) {
            if (pq.peek() >= K) {
                return answer;
            }

            int first = pq.poll();
            int second = pq.poll();
            int newScoville = first + (second * 2);
            pq.add(newScoville);
            answer++;
        }

        return pq.peek() >= K ? answer : -1;
    }
}
