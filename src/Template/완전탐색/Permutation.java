package Template.완전탐색;

import java.util.LinkedList;

public class Permutation {

    //arr중에 cnt개를 선택해 순서있게 나열하는 경우의 수
    public static void permutation(int[] arr, int cnt, LinkedList<Integer> select, boolean[] visit){
        if (select.size()==cnt){
            System.out.println(select.toString());
            return;
        }
        for (int i=0;i<arr.length;i++){
            if (visit[i]) continue;
            visit[i]= true;
            select.addLast(arr[i]);
            permutation(arr, cnt, select, visit);
            select.pollLast();
            visit[i]=false;
        }
    }

    //중복선택 가능한 순열
    public static void multiPermutation(int[] arr, int cnt, LinkedList<Integer> select){
        if (select.size()==cnt){
            System.out.println(select.toString());
            return;
        }
        for (int j : arr) {
            select.addLast(j);
            multiPermutation(arr, cnt, select);
            select.pollLast();
        }
    }

}
