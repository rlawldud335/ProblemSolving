package Template.최소비용탐색;

import Template.InputReader;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra {

    static int V,E,START;
    static ArrayList<Edge>[] edges;
    static int[] minimun;

    public static void initData(InputReader ir) {
        V = ir.nextInt();
        E  = ir.nextInt();
        START = ir.nextInt();
        edges = new ArrayList[V+1];
        for(int i=0;i<V+1;i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=0;i<E;i++){
            int start = ir.nextInt();
            int end = ir.nextInt();
            int w = ir.nextInt();
            edges[start].add(new Edge(end, w));
        }
        minimun = new int[V+1];
    }

    public static void dijkstra(){
        //모든 노드까지 비용을 무한대로 초기화
        for(int i=1; i<V+1;i++){
            minimun[i] = Integer.MAX_VALUE;
        }
        //자기자신 노드까지 비용은 없으므로 0
        minimun[START] = 0;
        //가까운 순서대로 처리하므로 pq를 사용한다.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(START,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            // cur.num 까지 가는데 드는 비용이 현재 구한 min보다 크면 패스.
            if(minimun[cur.num]<cur.cost) continue;

            //인접한 노드까지 가는 비용 구하기.
            for (int i = 0; i< edges[cur.num].size(); i++){
                Edge iz = edges[cur.num].get(i);
                //지금까지 구한 start에서 iz.end까지 가는 비용의 최소값 > 현재노드를 거쳐서 iz.end까지 가는 비용 (새로운경로)
                if(minimun[iz.end] > cur.cost+iz.w){
                    minimun[iz.end] = cur.cost+iz.w;
                    pq.add(new Node(iz.end, cur.cost+iz.w));
                }
            }
        }

        for(int i=1;i<=V;i++){
            System.out.println(minimun[i]==Integer.MAX_VALUE?"INF": minimun[i]);
        }
    }

    static class Edge {
        int end;
        int w;
        public Edge(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }

    static class Node implements Comparable<Node>{
        int num,cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

}
