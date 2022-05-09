package 카카오인턴코테연습.레벨2;

public class _124나라의숫자 {
    static class Solution {
        public String solution(int n) {
            StringBuilder answer = new StringBuilder();
            while (n >= 3){
                int remainder = n%3;
                if (remainder==0){answer.insert(0,'4');}
                else if (remainder==1){answer.insert(0,'1');}
                else{answer.insert(0,'2');}
                n /=3;
            }
            if (n==1){answer.insert(0,'1');}
            else if (n==2){answer.insert(0,'2');}
            else{answer.insert(0,'4');}
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ans = s.solution(10);
        System.out.println(ans);
    }
}
