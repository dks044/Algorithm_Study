import java.util.*;

class Solution {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        int answer = 0;

        for (String s : cities) {
            String upperCity = s.toUpperCase();

            if (cache.contains(upperCity)) {
                // 캐시 히트
                answer += CACHE_HIT;
                // 캐시에서 해당 도시를 제거하고 가장 최근에 사용된 것으로 추가
                cache.remove(upperCity);
                cache.add(upperCity);
            } else {
                // 캐시 미스
                answer += CACHE_MISS;
                if(cacheSize == 0) continue;
                if (cache.size() < cacheSize) {
                    cache.add(upperCity); // 캐시에 추가
                } else {
                    if (cacheSize > 0) { // 캐시 크기가 0이 아닐 때만 제거
                        cache.poll(); // 가장 오래된 항목 제거
                    }
                    cache.add(upperCity); // 새로운 도시 추가
                }
            }
        }

        return answer;
    }
}
