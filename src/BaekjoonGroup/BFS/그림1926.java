package BaekjoonGroup.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림1926 {

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
        int N,M;
        int[][] map ;
        int[] moveRow = {-1,0,1,0};
        int[] moveCol = {0,1,0,-1};
        int cnt = 0;
        int max = 0;
        public void solve(InputReader in, PrintWriter out) {
            N = in.nextInt();
            M = in.nextInt();
            map = new int[N][M];
            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    map[i][j] = in.nextInt();
                }
            }

            for (int i=0;i<N;i++){
                for (int j=0;j<M;j++){
                    if (map[i][j]==1){
                        cnt++;
                        int sum = BFS(i,j);
                        if (max<sum){max = sum;}
                    }
                }
            }
            out.print(cnt+"\n"+max);
        }

        private int BFS(int r, int c){
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(r,c));
            int sum = 0;
            while(!q.isEmpty()){
                Node cur = q.poll();
                //방문을 안했으면?
                if (map[cur.row][cur.col]==1){
                    sum++;
                    map[cur.row][cur.col] =0;
                    for (int i=0;i<4; i++){
                        int nr = cur.row + moveRow[i];
                        int nc = cur.col + moveCol[i];
                        if (0<=nr&&nr<N&&0<=nc&&nc<M&&map[nr][nc]==1){
                            q.add(new Node(nr,nc));
                        }
                    }
                }
            }
            return sum;
        }
    }

    static class Node{
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
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