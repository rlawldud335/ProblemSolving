package BaekjoonGroup.수학;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1057

public class 토너먼트1057 {

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
        int N, K, I;

        public void solve(InputReader in, PrintWriter out) {
            //풀이
            N = in.nextInt();
            K = in.nextInt();
            I = in.nextInt();

            //최대 라운드 수 구하기
            int MAX = (int) Math.ceil(Math.log(N) / Math.log(2)) +1;

            for (int round=1; round<=MAX ; round++){
                int term = 1<<round;
                for (int i=1;i<=N;i+=term){
                    if ((i<=K&&K<i+term)&&(i<=I&&I<i+term)){
                        System.out.println(round);
                        return;
                    }
                }
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