import java.util.*;
class Solution {
    public int solution(int chicken) {
        double coupon = chicken;
        int count = 0; //최대 서비스 치킨
        double temp = 0; //나머지 쿠폰

        while(coupon >=10){
            temp += coupon%10;
            coupon /=10;
            count += coupon;
        }
        temp += coupon;
        count += temp/10;
        
        return count;
    }
}
