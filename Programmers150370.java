import java.util.*;
class User{
    int number;
    int year;
    int month;
    int day; // 28일까지
    User(int number,int year,int month,int day){
        this.number = number;
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getNumber(){
        return number;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public int getDay(){
        return day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setDay(int day){
        this.day = day;
    }
}
class UserService{
    private static final int DECEMBER = 12;
    private static final int DAY = 28;
    
    public static void setByTerms(User user, int privacieMonth){
        int userMonth = user.getMonth();
        int userYear = user.getYear();
        int userDay = user.getDay();
        
        userMonth += privacieMonth;
        userDay--;
        if(userMonth > DECEMBER){
            while(userMonth > DECEMBER){
                userMonth -= DECEMBER;
                userYear++;
                if(userMonth < 0) userMonth *= -1;
            }
        }
        if(userDay == 0){
            userMonth--;
            userDay=DAY;
        }
        if(userMonth == 0){
            userYear--;
            userMonth=DECEMBER;
        }
        
        user.setMonth(userMonth);
        user.setYear(userYear);
        user.setDay(userDay);
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //유효기간 Map에 담기
        Map<String,Integer> termsGraph = new HashMap<>();
        for(String term : terms){
            String[] time = term.split(" ");
            String privacieCase = time[0];
            int privacieMonth = Integer.valueOf(time[1]);
            termsGraph.put(privacieCase,privacieMonth);
        }
        List<User> userList = new ArrayList<>();
        int number = 1;
        for(String record : privacies){
                int year = Integer.valueOf(record.substring(0, 4));
                int month = Integer.valueOf(record.substring(5, 7));
                int day = Integer.valueOf(record.substring(8, 10));
                String alphabet = record.substring(11, 12);
                //System.out.println(number+" "+year+" "+month+" "+day);
                User user = new User(number++,year,month,day);
                UserService.setByTerms(user,termsGraph.get(alphabet));
                userList.add(user);
        }
        
        System.out.println("==약관 적용 후==");
        for(User user : userList){
            int userNumber = user.getNumber();
            int userYear = user.getYear();
            int userMonth = user.getMonth();
            int userDay = user.getDay();
            System.out.println(user.getNumber()+"<-이놈의 적용 후 날짜 : "+userYear+" "+userMonth+" "+userDay);
        }
        System.out.println("==약관 적용 후==");
        
        int todayYear = Integer.valueOf(today.substring(0, 4));
        int todayMonth = Integer.valueOf(today.substring(5, 7));
        int todayDay = Integer.valueOf(today.substring(8, 10));
        //System.out.println("오늘의 날짜는 : "+todayYear+" "+todayMonth+" "+todayDay);
        
        List<Integer> deleteUserList = new ArrayList<>();
        for(User user : userList){
            int userNumber = user.getNumber();
            int userYear = user.getYear();
            int userMonth = user.getMonth();
            int userDay = user.getDay();
            //오늘년도가 더 높을경우
            if(todayYear > userYear){
                deleteUserList.add(userNumber);
                continue;
            }
            //년도는 오늘년도랑 같은데, 오늘달이 더 높을경우
            if(todayYear == userYear && todayMonth > userMonth){
                deleteUserList.add(userNumber);
                continue;
            }
            if((todayYear == userYear && todayMonth == userMonth) && todayDay > userDay){
                deleteUserList.add(userNumber);
                continue;
            }
        }

        int[] answer = new int[deleteUserList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = deleteUserList.get(i);
        }
        
        
        return answer;
    }
}
