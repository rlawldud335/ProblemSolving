package BaekjoonGroup.구현;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 마법사상어와파이어볼20056 {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        //전역변수
        int N,M,K;
        LinkedList<FireBall>[][] map;
        int[] moveRow = {-1,-1,0,1,1,1,0,-1};
        int[] moveCol = {0,1,1,1,0,-1,-1,-1};

        public void solve(InputReader in, PrintWriter out) {
            N = in.nextInt();
            M = in.nextInt();
            K = in.nextInt();
            map = new LinkedList[N][N];
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    map[i][j]=new LinkedList<>();
                }
            }

            for (int i=0;i<M;i++){
                //mass speed direction
                map[in.nextInt()-1][in.nextInt()-1].add(new FireBall(in.nextInt(),in.nextInt(),in.nextInt()));
            }

            for (int i=0;i<K;i++){
                moveFireBall();
                sumDivideFireBall();
            }

            out.println(sumMass());
        }

        private int sumMass(){
            int sum =0;
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    for (FireBall fb : map[i][j]){
                        sum += fb.m;
                    }
                }
            }
            return sum;
        }

        private void sumDivideFireBall(){
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    //파볼합치기
                    int sumCnt = map[i][j].size();
                    if (sumCnt<=1){continue;}

                    int sumMass =0;
                    int sumSpeed =0;
                    int sumDirEven = 0;
                    while(!map[i][j].isEmpty()){
                        FireBall fb = map[i][j].poll();
                        sumMass += fb.m;
                        sumSpeed += fb.s;
                        if (fb.d%2==0){sumDirEven++;}
                    }
                    //파볼나누기
                    if (sumMass/5<=0){continue;}
                    if (sumDirEven==sumCnt||sumDirEven==0){ //0246 방향으로 나누기
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 0));
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 2));
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 4));
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 6));
                    }
                    else{ //1357 방향으로 나누기
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 1));
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 3));
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 5));
                        map[i][j].add(new FireBall(sumMass/5,sumSpeed/sumCnt, 7));
                    }
                }
            }
        }

        public void moveFireBall(){
            LinkedList<FireBall>[][] temp = new LinkedList[N][N];
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    temp[i][j]=new LinkedList<>();
                }
            }

            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    for (FireBall fb : map[i][j]){
                        int newRow = (i + moveRow[fb.d]*fb.s +N*fb.s)%N;
                        int newCol = (j + moveCol[fb.d]*fb.s +N*fb.s)%N;
                        temp[newRow][newCol].add(fb);
                    }
                }
            }

            map = temp;
        }
    }


    static class FireBall{
        int m,s,d;

        public FireBall(int m, int s, int d) {
            this.m = m;
            this.s = s;
            this.d = d;
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