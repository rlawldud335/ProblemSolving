package BaekjoonGroup.구현;

import java.io.*;
import java.util.StringTokenizer;

public class 청소년상어19236 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        //전역변수
        int ans =0;
        //방향 = 위부터 반시계(0~7)
        int[] moveRow = {-1,-1,0,1, 1,1,0,-1};
        int[] moveCol = {0,-1,-1,-1, 0,1,1,1};

        public void solve(InputReader in, PrintWriter out) {
            Fish[][] fish = new Fish[4][4];
            Location[] fishLocation = new Location[17];
            int sharkDirection;
            int sharkRow, sharkCol;

            for (int i=0;i<4;i++){
                for (int j=0;j<4;j++){
                    int num = in.nextInt();
                    int dir = in.nextInt()-1;
                    fish[i][j] = new Fish(num,dir,false);
                    fishLocation[num] = new Location(i,j);
                }
            }

            //shark 0,0 입장
            fish[0][0].death=true;
            sharkDirection=fish[0][0].direction;
            sharkRow = sharkCol= 0;

            //물고기 <-> 상어 이동
            DFS(fish, fishLocation, sharkDirection, sharkRow, sharkCol, fish[0][0].number, 0);

            out.println(ans);
        }

        private void DFS(Fish[][] fish, Location[] fishLocation, int sharkDirection, int sharkRow, int sharkCol, int sum, int dep){
            if (ans<sum){
                ans = sum;
            }

            moveFish(fish, fishLocation, sharkRow, sharkCol);

            for (int i=1;i<4; i++){
                int nr = sharkRow+(moveRow[sharkDirection]*i);
                int nc = sharkCol+(moveCol[sharkDirection]*i);
                // nr nc가 범위 안이고 살아있는지 확인
                if (0<=nr&&nr<4&&0<=nc&&nc<4&&!fish[nr][nc].death){
                    Fish[][] newFish = new Fish[4][4];
                    Location[] newFishLocation = new Location[17];
                    copyArray(fish, newFish,fishLocation, newFishLocation);

                    //물고기 먹고 방향,번호 얻기
                    newFish[nr][nc].death = true;
                    DFS(newFish, newFishLocation, newFish[nr][nc].direction, nr, nc, sum+newFish[nr][nc].number, dep+1);
                }
            }
        }

        private void copyArray(Fish[][] fish, Fish[][] newFish, Location[] fishLocation, Location[] newFishLocation){
            for (int n=0;n<4;n++){
                for (int m=0;m<4;m++){
                    newFish[n][m] = new Fish(fish[n][m].number, fish[n][m].direction, fish[n][m].death);
                }
            }
            for (int l=1;l<17; l++){
                newFishLocation[l] = new Location(fishLocation[l].row, fishLocation[l].col);
            }
        }

        private void moveFish(Fish[][] fish, Location[] fishLocation, int sharkRow, int sharkCol){
            //1번부터 16번까지 순서대로 이동
            for (int i=1; i<=16; i++){
                Location curLo = fishLocation[i];
                int curDirection = fish[curLo.row][curLo.col].direction;
                if (!fish[curLo.row][curLo.col].death){
                    for (int j=0;j<8;j++){
                        int nr = curLo.row + moveRow[(curDirection+j)%8];
                        int nc = curLo.col + moveCol[(curDirection+j)%8];
                        if ((0<=nr&&nr<4&&0<=nc&&nc<4)&&!(sharkRow==nr&&sharkCol==nc)){
                            fish[curLo.row][curLo.col].direction = (curDirection+j)%8;
                            fishSwap(curLo, new Location(nr,nc), fish, fishLocation);
                            break;
                        }
                    }

                }
            }
        }

        private void fishSwap(Location f1l, Location f2l, Fish[][] fish, Location[] fishLocation){
            Fish fish1 = fish[f1l.row][f1l.col];
            Fish fish2 = fish[f2l.row][f2l.col];

            fishLocation[fish1.number] = f2l;
            fishLocation[fish2.number] = f1l;

            fish[f1l.row][f1l.col] = fish2;
            fish[f2l.row][f2l.col] = fish1;
        }

    }

    static class Fish{
        int number;
        int direction;
        boolean death;

        public Fish(int number, int direction, boolean death) {
            this.number = number;
            this.direction = direction;
            this.death = death;
        }
    }

    static class Location{
        int row;
        int col;
        public Location(int row, int col) {
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