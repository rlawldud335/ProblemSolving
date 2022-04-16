package Template.완전탐색;

public class DFS {
    static int[] moveX = {0,0,1,-1};
    static int[] moveY = {1,-1,0,0};

    static boolean check(int[][] arr, int x, int y){
        if(-1 < x && x < arr.length){
            if(-1 < y && y < arr[0].length){
                return true;
            }
        }
        return false;
    }

    static void dfs(int[][] arr, boolean[][] visit, int x, int y){
        visit[x][y] = true;
        for(int i=0; i<4; i++){
            int tx = x+moveX[i];
            int ty = y+moveY[i];
            if(check(arr,tx,ty) && !visit[tx][ty]){
                visit[tx][ty]=true;
                dfs(arr,visit,tx,ty);
            }
        }
    }

    static void dfs(int[][] arr, int depth, int N, int x, int y){
        if (depth==N){
            return;
        }
        for(int i=0; i<4; i++){
            int tx = x+moveX[i];
            int ty = y+moveY[i];
            if(check(arr,tx,ty)){
                dfs(arr,depth+1, N,tx,ty);
            }
        }
    }
}
