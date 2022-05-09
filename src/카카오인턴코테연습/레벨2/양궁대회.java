package 카카오인턴코테연습.레벨2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    int n, max=-1;
    int[] info, answer;
    ArrayList<A> s = new ArrayList<>();
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        permutation(n,0,new int[11]);
        Collections.sort(s);
        if(max<=0){answer= new int[]{-1};}
        else{answer = s.get(0).a;}
        return answer;
    }

    private void permutation(int arrow, int dep, int[] select){
        if (arrow==0){
            int c = compare(select);
            if (max<c){
                max = c;
                s.clear();
                s.add(new A(select.clone()));
            }else if (max==c){
                s.add(new A(select.clone()));
            }
            return;
        }
        if (dep>10){return;}

        for (int i=arrow;i>=0;i--){
            select[dep] = i;
            permutation(arrow-i, dep+1, select);
            select[dep] = 0;
        }
    }

    private int compare(int[] select){
        int apeach = 0;
        int ryan = 0;
        for (int i=10;i>=0;i--){
            if (info[10-i]==0&&select[10-i]==0){continue;}
            if(info[10-i]<select[10-i]){ryan+=i;}
            else{ apeach +=i; }
        }
        return ryan-apeach;
    }

    static class A implements Comparable<A>{
        int[] a;

        public A(int[] a) {
            this.a = a;
        }

        @Override
        public int compareTo(A o) {
            for (int i=10;i>=0;i--){
                if (o.a[i]!=a[i]){return o.a[i]-a[i];}
            }
            return 0;
        }
    }
}

public class 양궁대회 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] ans =s.solution(10,new int[]{0,0,0,0,0,0,0,0,3,4,3});
        System.out.println(Arrays.toString(ans));
    }
}
