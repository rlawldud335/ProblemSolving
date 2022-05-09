package 썸머코딩;

public class _1번 {
    static class Solution {
        public int solution(int[][] atmos) {
            int answer = 0;
            int life = 0;
            for (int[] atm : atmos){
                if (atm[0]>=81||atm[1]>=36){
                    //마스크가 없다면 마스크 추가
                    if(life<0){
                        life = 2;
                        answer++;
                    }
                    //초미세날이면 마스크 수명을 1로 바꾸기
                    if (atm[0]>=151&&atm[1]>=76){
                        life = 0;
                    }
                }
                life--;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int ans = s.solution(new int[][]{{80, 35}, {70, 38}, {100, 41}, {75,30}, {160,80}, {77, 29}, {181, 68}, {151, 76}});
        System.out.println(ans);

//        String a = "[[80, 35], [70, 38], [100, 41], [75,30], [160,80], [77, 29], [181, 68], [151, 76]]";
//        a = a.replaceAll("[\\[]","{");
//        a = a.replaceAll("[\\]]","}");
//        System.out.println(a);
    }
}
