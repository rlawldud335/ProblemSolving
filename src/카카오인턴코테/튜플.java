package 카카오인턴코테;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 튜플 {

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
        public void solve(InputReader in, PrintWriter out) {
            String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"	;
            int[] ans = solution(s);
            out.println(Arrays.toString(ans));
        }

        public int[] solution(String s) {
            ArrayList<Integer>[] arr = new ArrayList[500];
            int cnt = 0;
            for (int i=1;i<s.length()-1;i++){
                if (s.charAt(i)=='{'){
                    ArrayList<Integer> t = new ArrayList<>();
                    int temp = 0;
                    while(s.charAt(++i)!='}'){
                        if (s.charAt(i)==','){
                            t.add(temp);
                            temp = 0;
                        }else{
                            temp = temp * 10+ s.charAt(i)-'0';
                        }
                    }
                    if (temp!=0){t.add(temp);}
                    arr[cnt++] = t;
                }
            }

            // length 기준으로 정렬
            for (int i=0;i<cnt;i++){
                for (int j=i;j<cnt;j++){
                    if (arr[i].size()>arr[j].size()){
                        ArrayList<Integer> temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] =temp;
                    }
                }
            }

            boolean[] chk = new boolean[100001];
            int[] answer = new int[cnt];
            int ai = 0;

            for (int i=0;i<cnt;i++){
                for (int j=0;j<arr[i].size();j++){
                    int c = arr[i].get(j);
                    if (!chk[c]){
                        answer[ai++]=c;
                        chk[c]=true;
                    }
                }
            }

            return answer;
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