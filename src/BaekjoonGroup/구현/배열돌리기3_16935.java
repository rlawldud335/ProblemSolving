package BaekjoonGroup.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 배열돌리기3_16935 {

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
        int[][] map;
        public void solve(InputReader in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();
            int R = in.nextInt();
            map = new int[N][M];

            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    map[i][j] = in.nextInt();
                }
            }

            while(R-->0){
                int command = in.nextInt();
                switch (command) {
                    case 1 : Command1();break;
                    case 2 : Command2();break;
                    case 3 : Command3();break;
                    case 4 : Command4();break;
                    case 5 : Command5();break;
                    case 6 : Command6();break;
                }
            }

            for (int i=0;i<map.length;i++){
                for (int j=0;j<map[i].length;j++){
                    out.print(map[i][j]+" ");
                }
                out.println();
            }
        }

        private void Command1(){
            int N = map.length;
            int M = map[0].length;
            int[][] temp = new int[N][M];
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    temp[i][j] = map[N-1-i][j];
                }
            }
            map = temp;
        }

        private void Command2(){
            int N = map.length;
            int M = map[0].length;
            int[][] temp = new int[N][M];
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    temp[i][j] = map[i][M-1-j];
                }
            }
            map = temp;
        }

        private void Command3(){
            int N = map.length;
            int M = map[0].length;
            int[][] temp = new int[M][N];
            for (int i=0;i<M;i++){
                for (int j=0;j<N;j++){
                    temp[i][j] = map[N-1-j][i];
                }
            }
            map = temp;
        }

        private void Command4(){
            int N = map.length;
            int M = map[0].length;
            int[][] temp = new int[M][N];
            for (int i=0;i<M;i++){
                for (int j=0;j<N;j++){
                    temp[i][j] = map[j][M-1-i];
                }
            }
            map = temp;
        }

        private void Command5(){
            int N = map.length;
            int M = map[0].length;
            int[][] temp = new int[N][M];
            for (int i=0;i<N/2;i++){
                for (int j=0;j<M/2;j++){
                    temp[i][j] = map[i+N/2][j];
                    temp[i][j+M/2] = map[i][j];
                    temp[i+N/2][j] = map[i+N/2][j+M/2];
                    temp[i+N/2][j+M/2] = map[i][j+M/2];
                }
            }
            map = temp;
        }
        private void Command6(){
            int N = map.length;
            int M = map[0].length;
            int[][] temp = new int[N][M];
            for (int i=0;i<N/2;i++){
                for (int j=0;j<M/2;j++){
                    temp[i][j] = map[i][j+M/2];
                    temp[i][j+M/2] = map[i+N/2][j+M/2];
                    temp[i+N/2][j] = map[i][j];
                    temp[i+N/2][j+M/2] = map[i+N/2][j];
                }
            }
            map = temp;
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