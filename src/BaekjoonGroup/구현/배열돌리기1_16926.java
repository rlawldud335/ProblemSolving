package BaekjoonGroup.구현;

import Template.Array;

import java.io.*;
import java.util.StringTokenizer;

public class 배열돌리기1_16926 {

    public static void main(String[] args) throws Exception {
//        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(new FileInputStream("input.txt"));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        //전역변수
        int N,M,R;
        int dep;
        int[][] map;
        public void solve(InputReader in, PrintWriter out) {
            N = in.nextInt();
            M = in.nextInt();
            R = in.nextInt();
            dep = Math.min(N,M)/2;
            map = new int[N][M];
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    map[i][j] = in.nextInt();
                }
            }


            for (int i=0;i<R;i++){
                spin();
            }
            printMap();

        }

        private void spin(){
            for (int i=0;i<dep;i++){
                int i00 = map[i][i];
                for (int a=i;a<M-1-i;a++){
                    map[i][a] = map[i][a+1];
                }
                for (int b=i;b<N-1-i;b++){
                    map[b][M-1-i] = map[b+1][M-1-i];
                }
                for (int c=M-1-i;c>i;c--){
                    map[N-1-i][c] = map[N-1-i][c-1];
                }
                for (int d=N-1-i;d>i;d--){
                    map[d][i] = map[d-1][i];
                }
                map[i+1][i] = i00;
            }
        }

        private void printMap(){
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
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