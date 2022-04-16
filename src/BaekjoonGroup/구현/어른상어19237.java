package BaekjoonGroup.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 어른상어19237 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {

        int N,M,K;
        Smell[][] smells;
        Shark[] sharks;
        int[][] sharkLocation;
        int[] moveRow = {-1,1,0,0}; // 위 아래 왼쪽 오른쪽
        int[] moveCol = {0,0,-1,1};
        int time =0;

        public void solve(InputReader in, PrintWriter out) {
            N = in.nextInt();
            M = in.nextInt();
            K = in.nextInt();
            smells = new Smell[N][N];
            sharks = new Shark[M+1];
            sharkLocation = new int[N][N];

            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    int num = in.nextInt();
                    smells[i][j] = new Smell(0,0);
                    sharks[num] = new Shark(i,j);
                    sharkLocation[i][j] = num;
                }
            }
            for (int i=1;i<=M;i++){
                sharks[i].direction = in.nextInt()-1;
            }
            for (int i=1;i<=M;i++){
                int[][] prio = new int[4][4];
                for (int n=0;n<4;n++){
                    for (int m=0;m<4;m++){
                        prio[n][m] = in.nextInt()-1;
                    }
                }
                sharks[i].priority = prio;
            }


            while(time<=1000&&!isOneShark()){
                makeSmell();
                moveShark();
                minusSmellLife();
                time++;
            }

            System.out.println(time==1000?-1:time);
        }

        private void minusSmellLife(){
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (smells[i][j].sharkNumber!=0){
                        smells[i][j].minusLife();
                    }
                }
            }
        }

        private boolean isOneShark(){
            for (int i=2;i<=M;i++){
                if (!sharks[i].death){return false;}
            }
            return true;
        }

        private void makeSmell(){
            for (int i=1;i<=M;i++){
                if (!sharks[i].death){
                    int r = sharks[i].row;
                    int c = sharks[i].col;
                    smells[r][c].sharkNumber= i;
                    smells[r][c].life=K;
                }
            }
        }

        private void moveShark(){
            for (int i=1;i<=M;i++){
                if (!sharks[i].death){
                    int curRow = sharks[i].row;
                    int curCol = sharks[i].col;
                    int curDir = sharks[i].direction;
                    int[] curPrio = sharks[i].priority[curDir];
                    int newRow=-1;
                    int newCol=-1;
                    int newDir=-1;
                    //빈칸찾기
                    for (int j=0;j<4;j++){
                        int d = curPrio[j];
                        int r = curRow + moveRow[d];
                        int c = curCol + moveCol[d];
                        if (0<=r&&r<N&&0<=c&&c<N&&smells[r][c].sharkNumber==0){
                            newRow = r;
                            newCol = c;
                            newDir = d;
                            break;
                        }
                    }
                    //빈칸없으면 자기냄새칸 찾기
                    if (newRow==-1){
                        for (int j=0;j<4;j++){
                            int d = curPrio[j];
                            int r = curRow + moveRow[d];
                            int c = curCol + moveCol[d];
                            if (0<=r&&r<N&&0<=c&&c<N&&smells[r][c].sharkNumber==i){
                                newRow = r;
                                newCol = c;
                                newDir = d;
                                break;
                            }
                        }
                    }
                    //칸을 찾았으면 이동하기
                    if (newRow!=-1){
                        //sharks의 위치와 방 갱신하기.
                        sharks[i].row = newRow;
                        sharks[i].col = newCol;
                        sharks[i].direction = newDir;
                        //sharkLocation 갱신하기.
                        int newShark = sharkLocation[newRow][newCol];
                        if (newShark==0){
                            sharkLocation[newRow][newCol] = i;
                            sharkLocation[curRow][curCol] = 0;
                        }else if(newShark>i){
                            sharks[newShark].death = true;
                            sharkLocation[newRow][newCol] = i;
                            sharkLocation[curRow][curCol] = 0;
                        }else{
                            sharks[i].death = true;
                            sharkLocation[curRow][curCol] = 0;
                        }
                    }
                }
            }
        }
    }

    static class Shark{
        int direction;
        int[][] priority;
        boolean death = false;
        int row,col;
        public Shark(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Smell{
        int sharkNumber;
        int life;
        public Smell(int sharkNumber, int life) {
            this.sharkNumber = sharkNumber;
            this.life = life;
        }
        public void minusLife(){
            if (--life==0){sharkNumber=0;}
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