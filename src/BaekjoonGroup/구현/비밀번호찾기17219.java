package BaekjoonGroup.구현;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 비밀번호찾기17219 {

    public static void main(String[] args) throws Exception {
        InputReader in = new InputReader(System.in);
        BufferedWriter out = new BufferedWriter(new PrintWriter(System.out));
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }

    static class Task {
        int N,M;
        public void solve(InputReader in, BufferedWriter out) throws IOException {
            N = in.nextInt();
            M = in.nextInt();
            HashMap<String,String> hm = new HashMap<>();
            for (int i=0;i<N;i++){
                hm.put(in.next(),in.next());
            }
            for (int i=0;i<M;i++){
                out.write(hm.get(in.next())+"\n");
            }
            out.flush();
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