import java.util.*;
import java.math.*;
import static java.lang.Math.*;

//http://community.topcoder.com/tc?module=ProblemDetail&rd=5069&pm=2437

public class IslandFerries {

    int I;
    int S;
    final int INF = 4000000;
    int[][] costs;
    int[][] price;
    boolean[][][] paths;
    PriorityQueue<State> pq;

    public class State{
        int island;
        int ticket;
        int cost;
        public State(int island, int ticket, int cost){
            this.island = island;
            this.ticket = ticket;
            this.cost = cost;
        }
    }
    public int[] costs(String[] legs, String[] prices) {
        S = legs.length;
        I = prices.length;
        costs = new int[I][1<<S];
        paths = new boolean[S][I][I];
        price = new int[I][S];
        for(int i=0;i<S;i++){
            StringTokenizer st = new StringTokenizer(legs[i],"- ");
            while(st.hasMoreTokens()){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                paths[i][from][to]= true;
            }
        }

        for(int i=0;i<costs.length;i++){
            for(int j=0;j<costs[i].length;j++){
                costs[i][j]=INF;
            }
        }

        for(int i=0;i<I;i++){
            String[] p1 = prices[i].split(" ");
            for(int j=0;j<S;j++){
                price[i][j]=Integer.parseInt(p1[j]);
            }
        }

        pq = new PriorityQueue<State>(new Comparator<State>(){
            public int compare(State a, State b){
                return a.cost - b.cost;
            }
        });

        pq.add(new State(0,0,0));

        while(!pq.isEmpty()){
            State s = pq.remove();
            buyTicket(s.island,s.ticket,s.cost);
            sellTicket(s.island,s.ticket,s.cost);
        }

        int[] res = new int[I-1];
        for(int i=0;i<I-1;i++) res[i]= (costs[i+1][0]==INF)?-1:costs[i+1][0];



        return res;
    }

    public void buyTicket(int island, int ticket, int cost){

        if(count(ticket)>=3) return;
        for(int service=0;service<S;service++){
            if((ticket & (1<<service)) > 0) continue;
            int newTicket = ticket | (1<<service);
            int newCost = cost + price[island][service];
            if(costs[island][newTicket]>newCost){
                pq.add(new State(island,newTicket,newCost));
                costs[island][newTicket] = newCost;
            }

        }
    }

    public void sellTicket(int island, int ticket, int cost){
        int from = island;
        for(int service=0;service<S;service++){
            if((ticket & (1<<service))==0) continue;
            int newTicket = ticket & ~(1<<service);
            for(int to = 0;to<I;to++){
                if(paths[service][from][to] && (costs[to][newTicket]>cost)){
                    costs[to][newTicket] = cost;
                    pq.add(new State(to,newTicket,cost));
                }
            }
        }
    }

    public int count(int ticket){
        int count = 0;
        while(ticket!=0){
            ticket = ticket & (ticket - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        String[] legs = { "0-1 1-2 2-3", "0-1 2-3" };
        String[] prices = { "1 10", "20 25", "50 50", "1000 1000", "1000 1000" };
        IslandFerries i = new IslandFerries();
        int[] res = i.costs(legs,prices);
        for(int i1=0;i1<res.length;i1++){
            System.out.println(res[i1]);
        }
    }


}
