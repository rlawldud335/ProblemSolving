package BaekjoonGroup.우선순위큐;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절대값힙11286 {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
//        InputReader in = new InputReader(new FileInputStream("input.txt"));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream("output.txt")));
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            //min힙(양수만)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            //max힙(음수만)
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

            int N = in.nextInt();
            while(N-->0){
                int t = in.nextInt();
                if (t!=0){
                    if (t>0){
                        minHeap.add(t);
                    }else{
                        maxHeap.add(t);
                    }
                }
                else {
                    if (minHeap.isEmpty()&&maxHeap.isEmpty()){
                        out.println("0");
                    }else if (minHeap.isEmpty()&&!maxHeap.isEmpty()){
                        out.println(maxHeap.poll());
                    }else if (!minHeap.isEmpty()&&maxHeap.isEmpty()){
                        out.println(minHeap.poll());
                    }else{
                        int min = Math.abs(minHeap.peek());
                        int max = Math.abs(maxHeap.peek());
                        if (min>=max){
                            out.println(maxHeap.poll());
                        }else{
                            out.println(minHeap.poll());
                        }
                    }

                }
            }
        }
    }


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}