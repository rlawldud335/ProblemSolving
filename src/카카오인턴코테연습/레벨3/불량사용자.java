package 카카오인턴코테연습.레벨3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class 불량사용자 {
    static class Solution {
        int N,M;
        ArrayList<Integer>[] banned_set;
        HashSet<Integer> answer = new HashSet<>();

        public int solution(String[] user_id, String[] banned_id) {
            N = user_id.length;
            M = banned_id.length;
            banned_set = new ArrayList[M];

            for (int i=0;i<M;i++){//baneed_id
                banned_set[i] = new ArrayList();
                for (int j=0;j<N;j++){//userId
                    String reg = banned_id[i].replace('*','.');
                    if (Pattern.matches(reg,user_id[j])){
                        banned_set[i].add(j);
                    }
                }
            }
            selectAns(0,new LinkedList<>());
            int cnt = answer.size();
            return cnt;
        }

        private void selectAns(int dep, LinkedList<Integer> select){
            if (dep==M){
                int a =0;
                HashSet<Integer> hs = new HashSet<>();
                for (int s: select){
                    a|= (1<<s);
                    hs.add(s);
                }
                if (hs.size()==M){
                    answer.add(a);
                }
                return;
            }
            for (int idx : banned_set[dep]){
                select.addLast(idx);
                selectAns(dep+1, select);
                select.pollLast();
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        int ans = s.solution(user_id, banned_id);
        System.out.println(ans);
    }
}
