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
    //change [] to {}
    static void changeBracket(){
        String a = "[[1,0,0,1],[1,1,1,1],[2,1,0,1],[2,2,1,1],[5,0,0,1],[5,1,0,1],[4,2,1,1],[3,2,1,1]]";
        a = a.replaceAll("[\\[]","{");
        a = a.replaceAll("[\\]]","}");
        System.out.println(a);
    }
}
