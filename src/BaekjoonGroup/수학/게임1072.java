package BaekjoonGroup.수학;

import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1072

public class 게임1072 {

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
            //지역변수
            long X = in.nextLong(); //게임횟수
            long Y = in.nextLong(); //이긴게임

            double Z = Math.floor((double) (Y * 100) / X); //승률

            if (Z >= 99) {
                out.println(-1);
            } else {
                long ans = (long) Math.ceil(((100 * Y) - X - (X * Z)) / (Z - 99));
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
