package 카카오인턴코테연습.레벨1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 실패율 {

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] reached = new int[N+2];
            int[] dontClear = new int[N+2];
            for(int s : stages){
                for(int i=1;i<=s;i++){
                    reached[i]++;
                }
                dontClear[s]++;
            }
            ArrayList<Stage> stg = new ArrayList<>();
            for(int i=1;i<=N;i++){
                float fail = reached[i]==0?0:((float)dontClear[i]/(float)reached[i]);
                stg.add(new Stage(i, fail));
            }
            Collections.sort(stg);
            int[] answer = new int[N];
            for (int i=0;i<N;i++){
                answer[i] = stg.get(i).num;
            }

            return answer;
        }

        static class Stage implements Comparable<Stage>{
            int num = 0;
            float fail = 0;

            public Stage(int num, float fail) {
                this.num = num;
                this.fail = fail;
            }

            @Override
            public int compareTo(Stage o) {
                if (fail>o.fail){
                    return -1;
                }else if(fail<o.fail){
                    return 1;
                }else{
                    return num-o.num;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans = s.solution(4,new int[]{4,4,4,4,4});
        System.out.println(Arrays.toString(ans));
    }
}
