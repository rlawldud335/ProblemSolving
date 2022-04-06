package Template.집합;

// 상호배타적인 두 집합을 저장하는 자료구조 (Disjoint Set)
public class UnionFind {

    static int[] data;

    //초기화, 자기 자신만을 원소로하는 새로운 집합을 만든다.
    static void makeSet(int N) {
        data = new int[N+1];
        for(int i=0; i<=N; i++){
            data[i]=i;
        }
    }

    //두 집합 합치기. ( 두 집합의 대표중 하나를 새로운 대표로 만들기 )
    static boolean unionSet(int a, int b){
        if(findSet(a)==findSet(b)) return false;
        else data[findSet(a)] = findSet(b);
        return true;
    }

    //a가 속해있는 집합의 대표값 찾기.
    static int findSet(int a){
        if(a == data[a]) return a;
        return data[a] = findSet(data[a]);
    }
}