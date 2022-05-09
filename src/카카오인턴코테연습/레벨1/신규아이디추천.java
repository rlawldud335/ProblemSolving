package 카카오인턴코테연습.레벨1;

public class 신규아이디추천 {
    static class Solution {
        public String solution(String new_id) {
            String answer = new_id;
            //step1
            answer = answer.toLowerCase();
            //step2
            answer = answer.replaceAll("[~!@#$%^&*()=+{}:?,<>/\\[\\]]","");
            //step3 - 연속2번 이상 .을 하나로 치환
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<answer.length();){
                sb.append(answer.charAt(i));
                if (answer.charAt(i)=='.'){
                    while(i<answer.length()&&answer.charAt(i)=='.'){i++;};
                }else{
                    i++;
                }
            }
            //step4
            if(sb.length()!=0&&sb.charAt(0)=='.'){sb.deleteCharAt(0);}
            if(sb.length()!=0&&sb.charAt(sb.length()-1)=='.'){sb.deleteCharAt(sb.length()-1);}
            //step5
            if (sb.length()==0){sb.append('a');}
            //step6
            while(sb.length()>=16){
                sb.deleteCharAt(sb.length()-1);
            }
            if(sb.charAt(0)=='.'){sb.deleteCharAt(0);}
            if(sb.charAt(sb.length()-1)=='.'){sb.deleteCharAt(sb.length()-1);}
            //step7
            while(sb.length()<=2){
                sb.append(sb.charAt(sb.length()-1));
            }

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String ans = s.solution(new_id);
        System.out.println(ans);
    }
}
