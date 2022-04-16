package Template.최소비용탐색;

import Template.InputReader;

import java.util.PriorityQueue;

public class Kruskal {

    static int V, E;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] uf;

    public static void initData(InputReader ir) {
        V = ir.nextInt();
        E = ir.nextInt();
        for(int i=0; i<E; i++){
            int node1 = ir.nextInt();
            int node2 = ir.nextInt();
            int cost = ir.nextInt();
            pq.add(new Edge(node1, node2, cost));
        }
    }

    public static void kruskal(){
        makeSet();
        int cnt = 0;
        int sum =0;
        while(cnt!=V-1){
            Edge curr = pq.poll();
            if(union(curr.node1,curr.node2)){
                sum += curr.cost;
                cnt++;
            }
        }
        System.out.println(sum);
    }

    private static void makeSet() {
        uf = new int[V+1];
        for(int i=0; i<=V; i++){
            uf[i]=i;
        }
    }

    private static int find(int x){
        if(uf[x]==x){
            return x;
        }else{
            //중간에 거쳐간 노드의 부모를 모두 대표값으로 바꾸기.
            return uf[x] = find(uf[x]);
        }
    }
    private static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y){
            return false;
        }else{
            uf[y]=x;
            return true;
        }
    }

    static class Edge implements Comparable<Edge>{
        int node1, node2, cost;
        Edge(int node1, int node2, int cost){
            this.node1= node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(cost > o.cost){
                return 1;
            }else{
                return -1;
            }
        }
    }
}