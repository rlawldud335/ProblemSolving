package _2022카카오인턴코테;

public class _2번 {
    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int concatLen = queue1.length + queue2.length;
            int[] concatArr = new int[concatLen];
            System.arraycopy(queue1, 0, concatArr, 0, queue1.length);
            System.arraycopy(queue2, 0, concatArr, queue1.length, queue2.length);

            //절반값 구하기
            long half = 0L;
            for (int i=0;i<concatArr.length;i++){
                half += concatArr[i];
            }
            if (half%2!=0){return -1;}
            half /= 2;

            int min = Integer.MAX_VALUE;
            //모든 경우의 수 돌기
            for (int q1=0; q1<concatLen; q1++){
                long sum = 0L;
                for (int q2=q1; q2<concatLen; q2++){
                    sum += concatArr[q2];
                    if (sum==half){
                        int cnt = 0;
                        if (q2>=queue1.length-1){
                            cnt = q1+(q2-queue1.length+1);
                        }else{
                            cnt = q1+(concatLen- queue1.length+1+q2);
                        }
                        if (cnt<min){min = cnt;}
                    }
                    else if(sum>half){break;}
                }
            }
            return min==Integer.MAX_VALUE?-1:min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1});
        System.out.println(ans);
    }
}
