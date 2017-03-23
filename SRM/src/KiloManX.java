import java.util.*;
import java.math.*;
import static java.lang.Math.*;

/*
    Dijkstra solution. Can solve it with dynamic programming as well.
    http://community.topcoder.com/stat?c=problem_statement&pm=2288&rd=4725
    Can find the solution in tutorials of graph section 3.

 */


public class KiloManX {

    class Node implements Comparable<Node>{
        int weapons;
        int shots;
        public Node(int weapons, int shots){
            this.weapons = weapons;
            this.shots = shots;
        }
        @Override
        public int compareTo(Node n){
            return ((shots == n.shots)?0:(shots>n.shots)?1:-1);
        }
    }

    public int leastShots(String[] damageChart, int[] bossHealth) {

        final int N = damageChart.length;
        assert damageChart.length == bossHealth.length;
        assert 1<=N && N<=15;


        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        pq.add(new Node(0,0));
        BitSet visited = new BitSet(1<<N);

        while(!pq.isEmpty()){
            Node top = pq.remove();
            //check for visited stuff
            if(visited.get(top.weapons)) continue;
            visited.set(top.weapons);

            //check if we reached solution state
            if(top.weapons == (1<<N) - 1) return top.shots;

            //traverse
            for(int i=0;i<N;i++){
                int best = bossHealth[i];

                //if we already killed someone dont bother
                if((top.weapons>>i & 1) != 0) continue;

                for(int j=0;j<N;j++){

                    if(i==j) continue; //cannot kill the same person with same weapon
                    int power = damageChart[j].charAt(i) - '0';

                    //most important step, especially the second expression.
                    if(power==0|| (top.weapons & (1<<j)) == 0) continue; // first step 0000 & 100 returns 0. when you have a 1 already and going to next step see how this behaves: 001 & 101 -- ok.

                    int shots = bossHealth[i]/power;
                    if(bossHealth[i]%power!=0) shots++;
                    best = Math.min(shots, best);
                }
                pq.add(new Node(top.weapons | (1 << i),top.shots+best));
            }
        }
        return 0;
    }


    public void test(){
        String[] damage = {"070","500","140"};
        int[] bosshealth = {150,150,150};
        System.out.println(leastShots(damage,bosshealth));
    }

    public static void main(String[] args){
        KiloManX k = new KiloManX();
        k.test();
    }


}

//Explanation:
/*

damage: {"070","500","140"}
bosshealth: {150,150,150}

       start with 001, 150
                  010, 150
                  100, 150

                  top 010, 150
                  011, 172
                  101,300

                  top 010,150
                  011,180
                  110 300

                  top 100,150
                  110,188
                  101, 300

                  top 011 172
                  111 322

                  top 011 180
                  111 330

                  top 110 182
                      111 212

                  top 111 212



 */
