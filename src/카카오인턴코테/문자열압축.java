package 카카오인턴코테;

class 문자열압축 {

    static class Solution {
        public int solution(String s) {
            int answer = s.length();
            for (int term=1;term<s.length();term++){
                int t = compression(s, term);
                if (answer>t){answer = t;}
            }
            return answer;
        }

        private int compression(String s, int term){
            int ans = 0;
            int cnt =1;
            int i=0;
            for (; i+term*2-1<s.length();i+=term){
                if(compare(s,i, i+term, term)){
                    cnt++;
                }else if (cnt!=1){
                    ans += Integer.toString(cnt).length() + term;
                    cnt = 1;
                }else{
                    ans += term;
                }
            }
            if (cnt!=1){
                ans += Integer.toString(cnt).length() + term;
            }else{
                ans += term;
            }
            i+=term;
            if (i<s.length()){ans += s.length()-i;}
            return ans;
        }

        private boolean compare(String s, int start1, int start2, int term){
            for (int i=0;i<term;i++){
                if(s.charAt(start1+i)!=s.charAt(start2+i)){return false;}
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "xababcdcdababcdcd";
        int ret = s.solution(input);
        System.out.println(ret);
    }
}
