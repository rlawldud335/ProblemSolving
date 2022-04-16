package BaekjoonGroup.DP;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/2579

public class 계단오르기2579 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        int N;
        int[] stair = new int[300];
        int[] dp = new int[300];

        public void solve(InputReader in, PrintWriter out) {
            N = in.nextInt();
            for (int i=0;i<N;i++){
                stair[i] = in.nextInt();
            }
            dp[0] = stair[0];
            dp[1] = Math.max(stair[0]+stair[1],stair[1]);
            dp[2] = Math.max(stair[0]+stair[2],stair[1]+stair[2]);

            for (int i = 3; i < N; i++) {
                dp[i] = Math.max(dp[i-2]+stair[i], stair[i-1]+stair[i]+dp[i-3]);
            }

            out.println(dp[N-1]);
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