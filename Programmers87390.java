import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int size = (int)(right - left + 1);  // 출력 배열의 크기
        int[] answer = new int[size];  // 출력 배열을 생성

        // 각 위치에 대해
        for (int i = 0; i < size; i++) {
            // 현재 위치의 행과 열을 계산
            long row = (left + i) / n;
            long col = (left + i) % n;

            // 행과 열 중 큰 값이 현재 위치의 값이므로, 그것을 배열에 저장
            answer[i] = (int)(Math.max(row, col) + 1);
        }

        return answer;.
    }
