package 카카오인턴코테연습.레벨3;

public class 합승택시요금 {
    static class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int[][] distance = new int[n+1][n+1];
            int INF = 200000000;
            for (int i=1;i<=n;i++){
                for (int j=1;j<=n;j++){
                    if (i==j){continue;}
                    distance[i][j] = INF;
                }
            }
            for (int[] f: fares){
                distance[f[0]][f[1]] =f[2];
                distance[f[1]][f[0]] =f[2];
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        distance[i][j] = Math.min(distance[i][j], (distance[i][k] + distance[k][j]));
                    }
                }
            }

            int min = distance[s][a]+distance[s][b];
            for (int i=1;i<=n;i++){
                int sum = distance[s][i];
                sum += distance[i][a];
                sum += distance[i][b];
                if (sum<min){min = sum;}
            }

            return min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int ans = s.solution(6,4,6,2,fares);
        System.out.println(ans);
//        String a = "[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]";
//        a = a.replaceAll("[\\[]","{");
//        a = a.replaceAll("[\\]]","}");
//        System.out.println(a);
    }
}
