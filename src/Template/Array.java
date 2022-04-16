package Template;

public class Array {

    InputReader ir;

    public Array(InputReader ir) {
        this.ir = ir;
    }

    public void inputArray(int N, int M, int[][] matrix){
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                matrix[i][j] = ir.nextInt();
            }
        }
    }

    public void inputArray(int N, int M, long[][] matrix){
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                matrix[i][j] = ir.nextLong();
            }
        }
    }

    void printArray(int[] array){
        int L = array.length;
        System.out.print("[ ");
        for (int i=0; i<L; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }

    void printArray(long[] array){
        int L = array.length;
        System.out.print("[ ");
        for (int i=0; i<L; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println("]");
    }

    public static void printArray(int[][] matrix){
        int L = matrix.length;
        for (int i=0;i<L;i++){
            int LL = matrix[i].length;
            System.out.print("[ ");
            for (int j=0;j<LL;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("]");
        }
        System.out.println();
    }

    void printArray(long[][] matrix){
        int L = matrix.length;
        for (int i=0;i<L;i++){
            int LL = matrix[i].length;
            System.out.print("[ ");
            for (int j=0;j<LL;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
