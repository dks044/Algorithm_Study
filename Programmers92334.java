import java.util.*;
class Solution {
    static int banCount(Set<String> reports,List<String>banUserIdList){
        int banCount =0;
        for(String report : reports){
            if(banUserIdList.contains(report)){
                banCount++;
            }
        }
        return banCount;
    }
    
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length];
        Map<String,Set<String>> reportRecord = new HashMap<>();
        for(String script : report){
            String[] record = script.split(" ");
            String userId = record[0];
            String reportId = record[1];
            if(!reportRecord.containsKey(userId)){
                reportRecord.put(userId,new HashSet<>());
                reportRecord.get(userId).add(reportId);
            }else reportRecord.get(userId).add(reportId);
        }
        
        Map<String,Integer> reportCount = new HashMap<>();
        for(Map.Entry<String,Set<String>> entry : reportRecord.entrySet()){
            for(String reportId : entry.getValue()){
                if(!reportCount.containsKey(reportId)) reportCount.put(reportId,1);
                else reportCount.put(reportId,reportCount.get(reportId)+1);
            }
        }
        
        List<String> banUserIdList = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : reportCount.entrySet()){
            if(entry.getValue()>=k) banUserIdList.add(entry.getKey());
        }
        
        for(int i=0;i<id_list.length;i++){
            //본인이 신고한 목록중에 정지당한 계정이 있을경우
            if(reportRecord.containsKey(id_list[i])){
                int banCount = banCount(reportRecord.get(id_list[i]),banUserIdList);
                answer[i] +=  banCount;
            }
        }
        
        return answer;
    }
}
