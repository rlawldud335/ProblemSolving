package BaekjoonGroup.투포인터;

import java.io.*;
import java.util.StringTokenizer;

public class 회문17609 {

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
            int N = in.nextInt();
            while(N-->0){
                String input = in.next();
                int len = input.length();
                int ans = 0;
                for (int i=0,j=len-1;i<=j;i++,j--){
                    if (input.charAt(i)!=input.charAt(j)){
                        //왼쪽을 삭제 했을 때
                        int leftans = 1;
                        for (int l=0; i+1+l<=j-l; l++){
                            if (input.charAt(i+1+l)!=input.charAt(j-l)){
                                leftans = 2;
                            }
                        }
                        //오른쪽 삭제 했을 때
                        int rightans = 1;
                        for (int l=0; i+l<=j-l-1; l++){
                            if (input.charAt(i+l)!=input.charAt(j-l-1)){
                                rightans = 2;
                            }
                        }
                        if (leftans==1||rightans==1){ ans = 1; }
                        else { ans =2; }
                        break;
                    }
                }
                out.println(ans);
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