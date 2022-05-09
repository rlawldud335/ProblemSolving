package _2022카카오인턴코테;

public class _1번 {

    static class Solution {
        public String solution(String[] survey, int[] choices) {
            int N = survey.length;
            int[] point = new int[30];
            for (int i=0;i<N;i++){
                if (choices[i]<4){
                    int temp =choices[i];
                    if (choices[i]==1){temp = 3;}
                    else if (choices[i]==3){temp = 1;}
                    point[survey[i].charAt(0)-'A'] += temp;
                }else{
                    point[survey[i].charAt(1)-'A'] += choices[i]-4;
                }
            }
            String answer = "";
            answer += point['R'-'A'] >= point['T'-'A']?'R':'T';
            answer += point['C'-'A'] >= point['F'-'A']?'C':'F';
            answer += point['J'-'A'] >= point['M'-'A']?'J':'M';
            answer += point['A'-'A'] >= point['N'-'A']?'A':'N';
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5});
        System.out.println(ans);
    }
}
