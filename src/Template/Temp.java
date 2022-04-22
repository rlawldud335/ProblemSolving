package Template;

public class Temp {
    //위부터 시계방향
    int[] moveRow = {-1,0,1,0};
    int[] moveCol = {0,1,0,-1};

    //행,열 클래스
    static class Node{
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
