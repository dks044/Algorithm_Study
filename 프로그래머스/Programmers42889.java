import java.util.*;
class Loser {
    int stage;
    double losing;

    Loser(int stage, double losing) {
        this.stage = stage;
        this.losing = losing;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int entire_person = stages.length;

        // k : 스테이지, v : 사용자수
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int stage : stages) {
            map.put(stage, map.getOrDefault(stage, 0) + 1);
        }

        List<Loser> loser_list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!map.containsKey(i)) {
                loser_list.add(new Loser(i, 0.0));
            } else {
                double losing = (double) map.get(i) / entire_person;
                loser_list.add(new Loser(i, losing));
                entire_person -= map.get(i);
            }
        }

        loser_list.sort((p1, p2) -> Double.compare(p2.losing, p1.losing));

        for (int i = 0; i < N; i++) {
            answer[i] = loser_list.get(i).stage;
        }

        return answer;
    }
}
