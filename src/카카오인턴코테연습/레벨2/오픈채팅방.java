package 카카오인턴코테연습.레벨2;

import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {
    static class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> map = new HashMap<>();
            int cnt =record.length;
            for (String c : record){
                String[] cmd = c.split(" ");
                if (cmd[0].equals("Enter")){
                    if (!map.containsKey(cmd[1])){
                        map.put(cmd[1],cmd[2]);
                    }else{
                        map.replace(cmd[1],cmd[2]);
                    }
                } else if (cmd[0].equals("Change")){
                    if (!map.containsKey(cmd[1])){
                        map.put(cmd[1],cmd[2]);
                    }else{
                        map.replace(cmd[1],cmd[2]);
                    }
                    cnt--;
                }
            }
            String[] answer = new String[cnt];
            for(int i=0,j=0;i<record.length;i++){
                String[] cmd = record[i].split(" ");
                if (cmd[0].equals("Enter")){
                    answer[j++] = map.get(cmd[1])+"님이 들어왔습니다.";
                }else if (cmd[0].equals("Leave")){
                    answer[j++] = map.get(cmd[1])+"님이 나갔습니다.";
                }
            }
            return answer;
        }
    }


    public static void main(String[] args) {
        Solution s= new Solution();
        String[] ans = s.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(Arrays.toString(ans));
    }
}
