package 카카오인턴코테연습.레벨1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class 신고결과받기 {

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            HashMap<String, Integer> reported = new HashMap<>();
            for (int i=0;i<id_list.length;i++){
                reported.put(id_list[i],0);
            }
            HashMap<String, HashSet<String>> reporting = new HashMap<>();
            for (int i=0;i<report.length;i++){
                String[] temp = report[i].split(" ");
                if (reporting.containsKey(temp[0])){
                    HashSet<String> hs = reporting.get(temp[0]);
                    if (!hs.contains(temp[1])){
                        reported.replace(temp[1],reported.get(temp[1])+1);
                        hs.add(temp[1]);
                    }
                }else{
                    HashSet<String> hs = new HashSet<>();
                    hs.add(temp[1]);
                    reporting.put(temp[0],hs);
                    reported.replace(temp[1],reported.get(temp[1])+1);
                }
            }
            int[] answer = new int[id_list.length];
            for (int i=0;i< id_list.length; i++){
                int cnt =0;
                String curUser = id_list[i];
                if (reporting.containsKey(curUser)){
                    HashSet<String> hs = reporting.get(curUser);
                    for (String s : hs){
                        if (reported.get(s)>=k){
                            cnt++;
                        }
                    }
                }
                answer[i]= cnt;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] res = s.solution(id_list, report, k);
        System.out.println(Arrays.toString(res));
    }

}
