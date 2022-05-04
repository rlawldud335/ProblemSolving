package 카카오인턴코테.레벨3;


public class K진수에서소수개수구하기 {

    static class Solution {
        public int solution(int n, int k) {
            StringBuilder sb = new StringBuilder();
            int temp = n;
            while(temp>=k){
                sb.insert(0,temp%k);
                temp = temp/k;
            }
            sb.insert(0,temp);
            int answer=0;
            //앞에서 0을 포함하지 않는 수로 묶어서 소수인지 확인하기
            long sum =0;
            for (int i=0;i<sb.length();i++){
                if (sb.charAt(i)!='0'){
                    sum = sum *10 + sb.charAt(i)-'0';
                }else{
                    //sum이 소수인지 확인 후 cnt에 추
                    if (isPrimeNumber(sum)){answer++;}
                    sum = 0;
                }
            }
            if (isPrimeNumber(sum)){answer++;}
            return answer;
        }

        private boolean isPrimeNumber(long num){
            if (num<=1){return false;}
            for(int i=2; i<=Math.sqrt(num); i++){
                if(i%2==0){continue;}
                if(num % i == 0) {return false;}
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int cnt = s.solution(3,3);
        System.out.println(cnt);
    }
}
