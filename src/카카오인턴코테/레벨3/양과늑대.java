package 카카오인턴코테.레벨3;

import java.util.ArrayList;

class 양과늑대 {

    static class Solution {

        boolean[][] adm;
        int[] info;
        int max=0;

        public int solution(int[] info, int[][] edges) {
            adm = new boolean[17][17];
            this.info = info;
            for(int[] e: edges){
                adm[e[0]][e[1]]=true;
                adm[e[1]][e[0]]=true;
            }
            ArrayList<Integer> select = new ArrayList<>();
            select.add(0);
            backTracking(select, 1,0);
            return max;
        }

        private void backTracking(ArrayList<Integer> select, int sheep, int wolf){
            if (sheep>max){max = sheep;}
            if (sheep<=wolf){return;}
            //select와 인접해있는 모든 노드 순회
            for (int s : select){
                for (int i=0;i<17;i++){
                    if (adm[s][i]&&!select.contains(i)){
                        ArrayList<Integer> copySelect = new ArrayList<>(select);
                        copySelect.add(i);
                        if (info[i]==0){
                            backTracking(copySelect, sheep+1, wolf);
                        }
                        else {
                            backTracking(copySelect, sheep, wolf+1);
                        }
                        copySelect.remove((Integer)i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] info = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        int cnt = s.solution(info,edges);
        System.out.println(cnt);
    }
}
