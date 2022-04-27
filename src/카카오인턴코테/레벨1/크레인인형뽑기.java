package 카카오인턴코테.레벨1;

import java.io.*;
import java.util.*;

public class 크레인인형뽑기 {

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
        static int answer = 0;
        public void solve(InputReader in, PrintWriter out) {
            int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
            int[] moves = {1,5,3,5,1,2,1,4};

            Bucket bucket = new Bucket();

            for (int i=0;i<moves.length;i++){
                int c = moves[i]-1;
                int r = 0;
                while(0<=r&&r<board.length&&board[r][c]==0){r++;}
                if (0<=r&&r<board.length&&board[r][c]!=0){
                    bucket.push(board[r][c]);
                    board[r][c]=0;
                }
            }
            out.println(answer);
        }

        static class Bucket{
            Stack<Integer> stk = new Stack<>();
            public void push(Integer temp){
                if (stk.isEmpty()){stk.push(temp);}
                else if (stk.peek().equals(temp)) { stk.pop(); answer+=2; }
                else{ stk.push(temp); }
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