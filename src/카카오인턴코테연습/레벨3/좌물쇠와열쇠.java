package 카카오인턴코테연습.레벨3;

public class 좌물쇠와열쇠 {

    static class Solution {

        public boolean solution(int[][] key, int[][] lock) {
            int N = lock.length;
            int minRow=N,maxRow=0,minCol=N,maxCol=0;
            boolean flag = false;
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (lock[i][j]==0){
                        if (minRow>i){minRow = i;}
                        if (maxRow<i){maxRow = i;}
                        if (minCol>j){minCol = j;}
                        if (maxCol<j){maxCol = j;}
                        flag = true;
                    }
                }
            }
            if (!flag){
                return true;
            }
            int patternRowSize = maxRow-minRow+1;
            int patternColSize = maxCol-minCol+1;
            int [][] pattern = new int[patternRowSize][patternColSize];
            for (int pi=0,i=minRow; i<=maxRow; i++,pi++){
                for (int pj=0,j=minCol;j<=maxCol;j++,pj++){
                    if (lock[i][j]==0){ pattern[pi][pj] = 1;}
                    else{ pattern[pi][pj] = 0; }
                }
            }

            int M = key.length;
            for (int r=0;r<4;r++){
                for (int i=0;i<=M-patternRowSize;i++){
                    for (int j=0;j<=M-patternColSize;j++){
                        //패턴이 같으면 열쇠를 좌물쇠 위치로 이동시키기
                        if(isSamePattern(i,j,pattern,key)){
                            //moveRow moveCol 만큼 key를 쉬프트 시키기
                            int moveRow = minRow-i;
                            int moveCol = minCol-j;
                            int[][] newKey = shiftKey(moveRow, moveCol,key,N);
                            if (isSolve(lock, newKey)){return true;}
                        }
                    }
                }
                key = rotateKey(key);
            }

            return false;
        }

        private int[][] rotateKey(int[][] key){
            int M = key.length;
            int[][] rotate = new int[M][M];
            for (int i=0;i<M;i++){
                for (int j=0;j<M;j++){
                    rotate[j][M-1-i] = key[i][j];
                }
            }
            return rotate;
        }

        private boolean isSolve(int[][] lock, int[][] newKey){
            int N = lock.length;
            for (int i=0;i<N;i++){
                for (int j=0;j<N;j++){
                    if (lock[i][j]==newKey[i][j]){return false;}
                }
            }
            return true;
        }

        private int[][] shiftKey(int moveRow, int moveCol, int[][] key, int N){
            int M = key.length;
            int[][] shiftKey = new int[N][N];
            for (int i=0;i<M;i++){
                for (int j=0;j<M;j++){
                    if (0<=i+moveRow&&i+moveRow<N&&0<=j+moveCol&&j+moveCol<N){
                        shiftKey[i+moveRow][j+moveCol] = key[i][j];
                    }
                }
            }
            return shiftKey;
        }

        private boolean isSamePattern(int keyi, int keyj, int[][] pattern, int[][] key){
            for (int i=0;i<pattern.length;i++){
                for (int j=0;j<pattern[i].length;j++){
                    if (pattern[i][j]!=key[keyi+i][keyj+j]){return false;}
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] key ={{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] lock = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        boolean b = s.solution(key, lock);
        System.out.println(b);
    }
}
