import java.math.BigInteger;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        ArrayList<BigInteger> arr = new ArrayList<>();
        arr.add(BigInteger.ZERO);
        arr.add(BigInteger.ONE);
        for (int i = 2; i <= n; i++) {
            BigInteger a = arr.get(i - 1).add(arr.get(i - 2));
            arr.add(a);
        }
        BigInteger b = new BigInteger("1234567");
        answer = arr.get(arr.size() - 1).remainder(b).intValue();
        
        return answer;
    }
}
