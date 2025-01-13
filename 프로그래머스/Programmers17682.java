import java.util.*;


class Point{
    int num; //점수
    char option; //옵션
    int point = 0; // 점수 결과값 
    Point(int num){
        this.num = num;
    }
    public int setPoint(int point){
        return this.point = point;
    }
    public int getPoint(){
        return this.point;
    }
    
    public char setOption(char option){
        return this.option = option;
    }
    public char getOption(){
        return this.option;
    }
    
}

class Solution {
    public static final int SINGLE = 1;
    public static final int DOUBLE = 2;
    public static final int TRIPLE = 3;

    static int bonusNum(char c,int num){
        if(c == 'S') return (int)Math.pow(num,SINGLE);
        else if(c == 'D') return (int)Math.pow(num,DOUBLE);
        else if(c == 'T') return (int)Math.pow(num,TRIPLE);
        else return 0;
    }
    
    static boolean isOptionValid(char c){
        char[] option_arr = {'*','#'};
        for(char word : option_arr){
            if(word == c) return true;
        }
        return false;
    }
    
    public int solution(String dartResult) {
        //구성:  점수|보너스|[옵션]
        //보너스 S, D, T
        //옵션 *, # (없을 수도 있음.)
        char[] dart_arr = dartResult.toCharArray();
        ArrayList<Point> point_list = new ArrayList<>();
        StringBuilder num_sb = new StringBuilder();
        
        for(int i=0;i<dart_arr.length;i++){
            if(Character.isDigit(dart_arr[i])) num_sb.append(dart_arr[i]);
            else if(!Character.isDigit(dart_arr[i]) 
                    && !isOptionValid(dart_arr[i])){
                int num = Integer.parseInt(num_sb.toString());
                Point p = new Point(num);
                p.setPoint(bonusNum(dart_arr[i],num));
                point_list.add(p);
                num_sb.setLength(0);
            }else if(isOptionValid(dart_arr[i])){
                point_list.get(point_list.size()-1).setOption(dart_arr[i]);
            }
        }
        
        for(int i=0;i<point_list.size();i++){
            if(i==0 && point_list.get(i).getOption()=='*'){//스타상이 첫번쨰에 나올경우
                int temp = point_list.get(i).getPoint();
                point_list.get(i).setPoint(temp*2);
            }else if(point_list.get(i).getOption()=='#'){//야차상
                int minus = point_list.get(i).getPoint() * -1;
                point_list.get(i).setPoint(minus);
            }else if(i>0 && point_list.get(i).getOption()=='*'){//스타상
                int n1 = point_list.get(i-1).getPoint();
                int n2 = point_list.get(i).getPoint();
                point_list.get(i-1).setPoint(n1*2);
                point_list.get(i).setPoint(n2*2);
            }
        }
        int answer = 0;
        for(Point p : point_list){
            answer += p.getPoint();
        }

        return answer;
    }
}
