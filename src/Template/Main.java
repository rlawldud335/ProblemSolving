package Template;

import Template.탐색.Combination;
import Template.탐색.Permutation;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,7,8,9};
        LinkedList<Integer> select = new LinkedList<>();
        boolean[] visit = new boolean[arr.length];
        Permutation.permutation(arr,2,select, visit);
//        Permutation.multiPermutation(arr,3,select);
//        Combination.combination(arr,3,0,select);
//        Combination.multiCombination(arr, 5, 0,select);

    }
}
