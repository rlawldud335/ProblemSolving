package 카카오인턴코테.레벨2;

import java.util.Arrays;

public class 거리두기확인하기 {

    static class Solution {
        //위부터 시계방향
        int[] moveRow = {-1,0,1,0};
        int[] moveCol = {0,1,0,-1};

        public int[] solution(String[][] places) {
            int[] answer = new int[5];
            for (int i=0;i<5;i++){
                answer[i] = isFollowed(places[i]);
            }
            return answer;
        }

        private int isFollowed(String[] map){
            for (int i=0;i<5;i++){
                for (int j=0;j<5;j++){
                    if (map[i].charAt(j)=='P'){
                        boolean[][] chk = new boolean[5][5];
                        chk[i][j]=true;
                        if(!DFS(0,i,j,map,chk)){
                            return 0;
                        }
                    }
                }
            }
            return 1;
        }

        private boolean DFS(int dep,int i,int j, String[] map,boolean[][] chk){
            if (dep==1&&map[i].charAt(j)=='P'||dep==2&&map[i].charAt(j)=='P'){return false;}
            if (dep==3||map[i].charAt(j)=='X'){ return true;}

            boolean flag = true;
            for (int m=0;m<4;m++){
                int newRow = i+moveRow[m];
                int newCol = j+moveCol[m];
                if (0<=newRow&&newRow<5&&0<=newCol&&newCol<5&&!chk[newRow][newCol]){
                    chk[newRow][newCol] = true;
                    flag=DFS(dep+1, newRow, newCol, map, chk);
                    chk[newRow][newCol] = false;
                    if (!flag){ break;}
                }
            }
            return flag;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] places ={{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] ans = s.solution(places);
        System.out.println(Arrays.toString(ans));

    }
}
