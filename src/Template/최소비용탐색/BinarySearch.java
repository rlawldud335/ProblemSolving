package Template.최소비용탐색;

import Template.InputReader;
import java.util.Arrays;

public class BinarySearch {

    static int[] data;

    public static void initData(InputReader ir){
        int N = ir.nextInt();
        data = new int[N];
        for(int i=0;i<N; i++){
            data[i] = ir.nextInt();
        }
        Arrays.sort(data);
    }

    public static int findData(int target){
        int l = 0;
        int r = data.length-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(target==data[mid]){ return mid;}
            else if(target>data[mid]){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}
