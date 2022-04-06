package Template.탐색;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int[] moveX = {0,0,1,-1};
    static int[] moveY = {1,-1,0,0};

    static class Tuple{
        int x, y;
        public Tuple(int x, int y){this.x=x; this.y=y;}
    }

    static boolean check(int[][] arr, int x, int y){
        if(-1 < x && x < arr.length){
            if(-1 < y && y < arr[0].length){
                return true;
            }
        }
        return false;
    }

    static void bfs(int[][] arr,boolean[][] visit, int x, int y){
        Queue<Tuple> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new Tuple(x,y));
        while(!q.isEmpty()){
            Tuple t = q.poll();
            for(int i=0; i<4; i++){
                int tx = t.x+moveX[i];
                int ty = t.y+moveY[i];
                if(check(arr,tx,ty) && !visit[tx][ty]){
                    visit[tx][ty]=true;
                    q.add(new Tuple(tx,ty));
                }
            }
        }
    }
}
