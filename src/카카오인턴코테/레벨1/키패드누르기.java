package 카카오인턴코테.레벨1;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 키패드누르기 {

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
        //전역변수
        public void solve(InputReader in, PrintWriter out) {
            int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
            String hands = "left";

            String[][] priority = new String[10][];
            priority[2] = new String[]{"135","486","709","*#"};
            priority[5] = new String[]{"2468","13790","*#"};
            priority[8] = new String[]{"5790","46*#2","13"};
            priority[0] = new String[]{"8*#","579","246","13"};

            String ans = "";
            char leftHand = '*';
            char rightHand = '#';
            for (int i=0; i<numbers.length;i++){
                int curNum = numbers[i];
                if (curNum == 1 || curNum == 4 ||curNum ==7){
                    ans += "L";
                    leftHand = (char)('0'+curNum);
                }else if (curNum==3||curNum==6||curNum==9){
                    ans += "R";
                    rightHand = (char)('0'+curNum);
                }else {
                    int leftHandPrio = -1;
                    int rightHandPrio = -1;
                    for (int j=0;j<priority[curNum].length; j++){
                        if (contain(priority[curNum][j],leftHand)){leftHandPrio=j;}
                        if (contain(priority[curNum][j],rightHand)){rightHandPrio=j;}
                    }
                    if (leftHandPrio==rightHandPrio){
                        if (hands.equals("right")){
                            ans += "R";
                            rightHand = (char)('0'+curNum);
                        }
                        else {
                            ans += "L";
                            leftHand = (char)('0'+curNum);
                        }
                    }else if (leftHandPrio<rightHandPrio){
                        ans += "L";
                        leftHand = (char)('0'+curNum);
                    }else{
                        ans += "R";
                        rightHand = (char)('0'+curNum);
                    }
                }
            }
            out.println(ans);
        }

        private boolean contain(String str, char c){
            for (int i=0;i<str.length();i++){
                if (str.charAt(i)==c){return true;}
            }
            return false;
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