package _2022카카오인턴코테;

import java.util.ArrayList;

public class _3번 {

    static class Solution {
        public int solution(int alp, int cop, int[][] problems) {
            ArrayList<int[]> notUsable = new ArrayList<>();
            ArrayList<int[]> usable = new ArrayList<>();
            for (int[] pb : problems){
                if(pb[0]<=alp&&pb[1]<=cop){usable.add(pb);}
                else{notUsable.add(pb);}
            }

            int answer = 0;
            //현재 가장 빨리 배울 수 있는것 고르기,
            while(!notUsable.isEmpty()){
                int minLearn = Integer.MAX_VALUE;
                int NB=-1;
                int UB=-1;
                for (int i=0;i<notUsable.size();i++){
                    int ndAl = notUsable.get(i)[0]-alp;
                    int ndCo = notUsable.get(i)[1]-cop;
                    //i번째 문제를 푸는 최소시간
                    //공부를 푸는 경우
                    int minTime = ndAl+ndCo;
                    int minIdx = -1;
                    //문제를 이용해서 푸는 경우
                    for (int j=0;j<usable.size();j++){
                        int[] t = usable.get(j);
                        //al을 기준으로 구하기(올림,내림+add)
                        int alup = (int) Math.ceil(t[2]==0?0:(ndAl/t[2]));
                        int aldown = (int) Math.floor(t[2]==0?0:(ndAl/t[2]));
                        int coup = (int) Math.ceil(t[3]==0?0:(ndCo/t[3]));
                        int codown = (int) Math.floor(t[3]==0?0:(ndCo/t[3]));

                        //co를 기준 으로 구하기(올림, 내림+add)
                        int times = Math.min(t[2]==0?0:(ndAl/t[2]),t[3]==0?0:(ndCo/t[3]));
                        int added = (ndAl-times*t[2])+(ndCo-times*t[3]);
                        int sumTime = times*t[4]+added;

                        if (minTime>sumTime){minTime = sumTime;minIdx=j;}
                    }
                    if (minLearn>minTime){minLearn=minTime;NB=i;UB=minIdx;}
                }
                //NB를 UB로 풀기
                int[] nb = notUsable.remove(NB);
                usable.add(nb);
                if (UB==-1){
                    answer += nb[0]-alp+nb[1]-cop;
                    alp += nb[0]-alp;
                    cop += nb[1]-cop;
                    continue;
                }
                int[] ub = usable.get(UB);
                int times = Math.min(ub[2]==0?0:((nb[0]-alp)/ub[2]),ub[3]==0?0:((nb[1]-cop)/ub[3]));
                int alpAdd = ((nb[0]-alp)-times*ub[2]);
                int copAdd = ((nb[1]-cop)-times*ub[3]);
                answer+= times*ub[4]+alpAdd+copAdd;
                alp += times*ub[2]+alpAdd;
                cop += times*ub[3]+copAdd;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.solution(0,0,new int[][]{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
//        int ans = s.solution(10,10, new int[][]{{10,15,2,1,2},{20,20,3,3,4}});
        System.out.println(ans);
    }
}
