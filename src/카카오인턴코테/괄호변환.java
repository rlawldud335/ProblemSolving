package 카카오인턴코테;

import java.util.Stack;
class 괄호변환{

    static class Solution {

        public String solution(String p) {
            String answer = changeScope(p);;
            return answer;
        }

        private String changeScope(String p){
            if (p.equals("")){return "";}

            StringBuilder u = new StringBuilder();
            Stack<Character> stk = new Stack<>();
            int left=0, right=0, idx=0;
            for (;idx<p.length();idx++){
                char cur = p.charAt(idx);
                u.append(cur);

                if (stk.isEmpty()){stk.push(cur);}
                else if (cur==')'&&stk.peek()=='('){
                    stk.pop();
                }else{
                    stk.push(cur);
                }

                if (cur=='('){left++;}
                else {right++;}
                if (left==right){
                    break;
                }
            }
            String v = p.substring(idx+1);
            if (!stk.isEmpty()){
                StringBuilder temp = new StringBuilder();
                temp.append('(');
                temp.append(changeScope(v));
                temp.append(')');
                u.deleteCharAt(0); u.deleteCharAt(u.length()-1);
                for (int i=0;i<u.length();i++){
                    char t = u.charAt(i);
                    if (t=='('){temp.append(')');}
                    else {temp.append('(');}
                }
                return temp.toString();
            }else{
                u.append(changeScope(v));
                return u.toString();
            }
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "()))((()";
        String ret = s.solution(input);
        System.out.println(ret);
    }
}