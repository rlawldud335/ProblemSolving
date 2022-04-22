package 카카오인턴코테;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class 수식최대화 {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        InputReader in = new InputReader(new FileInputStream("input.txt"));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        //전역변수
        int[][] priority = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
        private int changeIndex(char a){
            if (a=='*') {return 0;}
            else if (a=='+'){return 1;}
            else {return 2;}
        }

        public void solve(InputReader in, PrintWriter out) {
            String expression = "100-200*300-500+20";
            long answer = 0L;

            for (int i=0;i<6;i++){
                ArrayList<String> postfix = new ArrayList<>();
                changePostfix(expression,postfix,priority[i]);
                long temp = Math.abs(calculate(postfix));
                if (temp>answer){answer = temp;}
            }

            out.println(answer);
        }

        private long calculate(ArrayList<String> postfix){
            Stack<Long> cal = new Stack<>();
            for (int i =0;i<postfix.size();i++){
                String cur = postfix.get(i);
                System.out.print(cur+" ");
                if (cur.equals("*")){
                    cal.push((cal.pop()*cal.pop()));
                }else if (cur.equals("+")){
                    cal.push((cal.pop()+cal.pop()));
                }else if(cur.equals("-")){
                    long a = cal.pop();
                    long b = cal.pop();
                    cal.push(b-a);
                }else{
                    cal.push(Long.parseLong(cur));
                }
            }
            return cal.pop();
        }

        private void changePostfix(String expression, ArrayList<String> postfix, int[] priority){
            Stack<Character> stk = new Stack<>();
            String temp = "";

            for (int i=0;i<expression.length();i++){
                char t =expression.charAt(i);
                if (t=='-'||t=='+'||t=='*'){
                    postfix.add(temp);
                    temp = "";
                    while(!stk.isEmpty()&&priority[changeIndex(stk.peek())]<=priority[changeIndex(t)]){
                        postfix.add(stk.pop()+"");
                    }
                    stk.push(t);
                }else{
                    temp += t;
                }
            }
            postfix.add(temp);
            while(!stk.isEmpty()){
                postfix.add(stk.pop()+"");
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}