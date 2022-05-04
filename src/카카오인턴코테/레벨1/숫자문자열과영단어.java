package 카카오인턴코테.레벨1;

public class 숫자문자열과영단어 {
    static class Solution {
        public int solution(String s) {
            s = s.replaceAll("(one)","1");
            s = s.replaceAll("(two)","2");
            s = s.replaceAll("(three)","3");
            s = s.replaceAll("(four)","4");
            s = s.replaceAll("(five)","5");
            s = s.replaceAll("(six)","6");
            s = s.replaceAll("(seven)","7");
            s = s.replaceAll("(eight)","8");
            s = s.replaceAll("(nine)","9");
            s = s.replaceAll("(zero)","0");
            int answer = Integer.parseInt(s);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.solution("one4seveneight");
        System.out.println(ans);
    }
}
