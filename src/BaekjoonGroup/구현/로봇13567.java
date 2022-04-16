package BaekjoonGroup.구현;

import java.io.*;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13567

public class 로봇13567 {

    public static void main(String[] args) throws Exception {
//        InputReader in = new InputReader(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        InputReader in = new InputReader(new FileInputStream("input.txt"));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        //전역변수
        int M,n;
        // direction : 동-0 남-1 서-2 북-3 ( 동쪽부터 시계방향 )
        int x=0, y=0, direction=0;

        public void solve(InputReader in, PrintWriter out) {
            //풀이
            M = in.nextInt();
            n = in.nextInt();

            for (int i=0;i<n;i++){
                String operator = in.next();
                int operand = in.nextInt();

                if (operator.equals("TURN")){
                    turn(operand);
                }else{
                    move(operand);
                    if(!boundaryCheck()){
                        out.println(-1);
                        return;
                    }
                }
            }
            out.println(x+" "+y);
        }

        private boolean boundaryCheck(){
            return (0<=x&&x<=M)&&(0<=y&&y<=M);
        }

        private void turn(int dir){
            // 0 - 왼쪽으로 90도 (반시계)
            // 1 - 오른쪽으로 90도 (시계)
            if (dir == 0){
                direction = (direction+3)%4;
            }else{
                direction = (direction+1)%4;
            }
        }

        private void move(int d){
            // 0-동 - x증가
            // 1-남 - y감소
            // 2-서 - x감소
            // 3-북 = y증가
            switch (direction){
                case 0:
                    x += d; break;
                case 1:
                    y -= d; break;
                case 2:
                    x -= d; break;
                case 3:
                    y += d; break;
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