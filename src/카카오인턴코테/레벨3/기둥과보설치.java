package 카카오인턴코테.레벨3;

import java.util.ArrayList;
import java.util.Arrays;

public class 기둥과보설치 {

    static class Solution {
        public int[][] solution(int n, int[][] build_frame) {
            boolean[][][] wall = new boolean[n+1][n+1][2];
            for (int[] bf :build_frame){
                int x = bf[0];
                int y = bf[1];
                int a = bf[2];
                int b = bf[3];
                if (b==0){//삭제
                    wall[x][y][a] = false;
                    if(!isAllSafe(wall,n)){wall[x][y][a] = true;}
                }else{//설치
                    if (a==0&&isPillarSafe(wall,x,y,n)){wall[x][y][0]=true;}
                    else if(a==1&&isBeamSafe(wall,x,y,n)){wall[x][y][1]=true;}
                }
            }

            ArrayList<int[]> temp = new ArrayList<>();
            for (int i=0;i<n+1;i++){
                for (int j=0;j<n+1;j++){
                    if (wall[i][j][0]){temp.add(new int[]{i,j,0});}
                    if (wall[i][j][1]){temp.add(new int[]{i,j,1});}
                }
            }
            int[][] answer = new int[temp.size()][];
            int i=0;
            for (int[] t : temp){
                answer[i++] = t;
            }

            return answer;
        }

        private boolean isAllSafe(boolean[][][] wall, int n){
            for (int i=0;i<n+1;i++){
                for (int j=0;j<n+1;j++){
                    if (wall[i][j][0]&&!isPillarSafe(wall, i,j,n)){return false;}
                    if (wall[i][j][1]&&!isBeamSafe(wall,i,j,n)){return false;}
                }
            }
            return true;
        }

        private boolean isPillarSafe(boolean[][][] wall, int x, int y, int n){
            if (y == 0 || 0 <= x - 1 && wall[x - 1][y][1] || wall[x][y][1] || 0 <= y - 1 && wall[x][y - 1][0]){return true;}
            return false;
        }

        private boolean isBeamSafe(boolean[][][] wall, int x, int y, int n){
            if (0 <= y - 1 && wall[x][y-1][0]||
                    x + 1 <= n && 0 <= y - 1 && wall[x+1][y-1][0]||
                    0 <= x - 1 && x + 1 <= n && wall[x-1][y][1]&&
                            wall[x+1][y][1]){return true;}
            return false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[][] build_frame={{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] ans = s.solution(n,build_frame);
        for (int i=0;i<ans.length;i++){
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
