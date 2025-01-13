import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0, end = 0, sum = 0;
        int len = sequence.length;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (true) {
            if (sum >= k) { // 합이 k 이상인 경우
                if (end - start < minLen) { // 최소 길이 갱신
                    minLen = end - start;
                    answer[0] = start;
                    answer[1] = end - 1;
                }
                sum -= sequence[start++]; // start 포인터를 오른쪽으로 이동
            } else if (end == len) { // end 포인터가 배열 끝에 도달한 경우
                break;
            } else { // 합이 k 미만인 경우
                sum += sequence[end++]; // end 포인터를 오른쪽으로 이동
            }
        }

        return answer;
    }
}

