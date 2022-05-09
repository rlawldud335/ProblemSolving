package 썸머코딩;

import java.util.*;

public class _2번 {
    static class Solution {
        public String[] solution(String[] rooms, int target) {
            HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
            HashSet<String> targetPeople = new HashSet<>();

            for (String r : rooms){
                String[] temp = r.substring(1).split("]");
                int roomNumber = Integer.parseInt(temp[0]);
                String[] names = temp[1].split(",");
                //hm
                for (String name:names){
                    if (!hm.containsKey(name)){
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(roomNumber);
                        hm.put(name,al);
                    }else{
                        ArrayList<Integer> al = hm.get(name);
                        al.add(roomNumber);
                    }
                }
                //room
                if (target==roomNumber){
                    targetPeople = new HashSet<String>(Arrays.asList(names));
                }
            }

            //우선순위 정하기
            //hm에서 room에 포함되지 않는 사람만 answer에 추가하기.o
            //answer를 ArrayList.size 기준으로 정렬하기.
            //size가 같다면 거리가 가까운사람이 앞, 거리가 같다면 사전순으로 이름이 앞인사람이 앞으로 정렬
            ArrayList<Person> answer = new ArrayList<>();
            for (String key : hm.keySet()) {
                if (targetPeople.contains(key)){continue;}
                ArrayList<Integer> al =hm.get(key);
                int seatCnt = al.size();
                int minDistance = Integer.MAX_VALUE;
                for (int rm : al){
                    int t = Math.abs(target-rm);
                    if (minDistance>t){minDistance=t;}
                }
                answer.add(new Person(key,seatCnt,minDistance));
            }
            Collections.sort(answer);
            String[] ans = new String[answer.size()];
            for (int i=0;i<answer.size();i++){
                ans[i] = answer.get(i).name;
            }
            return ans;
        }

        static class Person implements Comparable<Person>{
            String name;
            int SeatCnt;
            int targetDistance;

            public Person(String name, int seatCnt, int targetDistance) {
                this.name = name;
                SeatCnt = seatCnt;
                this.targetDistance = targetDistance;
            }

            @Override
            public int compareTo(Person o) {
                if (SeatCnt==o.SeatCnt){
                    if (targetDistance==o.targetDistance){
                        return name.compareTo(o.name);
                    }
                    return targetDistance-o.targetDistance;
                }
                return SeatCnt-o.SeatCnt;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] ans = s.solution(new String[]{"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"},403);
        System.out.println(Arrays.toString(ans));
    }
}
