package Template.탐색;

import java.util.LinkedList;

public class Combination {

    //arr에서 cnt개를 선택하는 경우의 수
    public static void combination(int[] arr, int cnt, int idx, LinkedList<Integer> select){
        if (select.size()==cnt){
            System.out.println(select.toString());
            return;
        }

        for (int i=idx; i<arr.length; i++){
            select.addLast(arr[i]);
            combination(arr, cnt,i+1, select);
            select.pollLast();
        }
    }

    //중복선택 가능 조합
    public static void multiCombination(int[] arr, int cnt, int idx, LinkedList<Integer> select){
        if (select.size()==cnt){
            System.out.println(select.toString());
            return;
        }

        for (int i=idx; i<arr.length; i++){
            select.addLast(arr[i]);
            multiCombination(arr, cnt,i, select);
            select.pollLast();
        }
    }
}
