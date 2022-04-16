package BaekjoonGroup.재귀;

import java.io.*;
import java.util.StringTokenizer;

public class 접두사1992 {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        //전역변수
        int N;
        int[][] map;
        public void solve(InputReader in, PrintWriter out) {
            //지역변수
            N = in.nextInt();
            map = new int[N][N];

            for (int i=0;i<N;i++){
                String t = in.next();
                for (int j=0;j<N;j++){
                    map[i][j] = t.charAt(j)-'0';
                }
            }

            out.println(compression(0,0,N));
        }

        private String compression(int r, int c, int n){
            int sum=0;
            for (int i=r; i<r+n; i++){
                for (int j=c; j<c+n; j++){
                    sum += map[i][j];
                }
            }
            if (sum==0){return "0";}
            if (sum==n*n){return "1";}

            String res ="(";
            res += compression(r,c,n/2);
            res += compression(r,c+n/2, n/2);
            res += compression(r+n/2, c, n/2);
            res += compression(r+n/2, c+n/2,n/2);
            res += ")";
            return res;
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