package BaekjoonGroup.정렬;

import java.io.*;
import java.util.StringTokenizer;

public class 접두사1141 {

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
            int N = in.nextInt();
            String[] input = new String[N];
            int ans = N;

            for (int i=0;i<N;i++){
                input[i] = in.next();
            }

            for (int i=0;i<N;i++){
                for (int j=0; j<N; j++){
                    if (StringCompare(input[i],input[j])>0){
                        String tmp= input[j];
                        input[j]=input[i];
                        input[i]=tmp;
                    }
                }
            }

            for (int i=0;i<N; i++){
                for (int j=i+1;j<N;j++){
                    if (prefix(input[i],input[j])){
                        ans--;
                        break;
                    }
                }
            }
            out.println(ans);
        }


        private boolean prefix(String a, String b){
            for (int i=0;i<a.length();i++){
                if (a.charAt(i)!=b.charAt(i)){
                    return false;
                }
            }
            return true;
        }

        private int StringCompare(String a, String b){
            if (a.length()!=b.length()){
                return b.length()-a.length();
            } else{
                int l = Math.min(a.length(),b.length());
                for (int i=0;i<l;i++){
                    if (a.charAt(i)!=b.charAt(i)){
                        return b.charAt(i)-a.charAt(i);
                    }
                }
                return 0;
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