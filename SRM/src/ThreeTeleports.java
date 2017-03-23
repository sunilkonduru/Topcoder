/**
 * SRM 519: Frog Jumping with bi-directional teleport. Amazing Problem.
 * Implemented Three algorithms to solve this problem:
 *   1) Dijkstra with many state - Failed. Time Limit Exceeded.
 *   2) Floyd Warshall Algorithm, First time implementation as input would be a reduced state graph. You can reduce the large space of the graph
 *      into a smaller space, if they every mention about infinite lattice. O(n3) time complexity for Floyd Warshall Algorithm. n - no of vertices.
 *      This is an all pair shortest path algorithm. With enough practise you can code this very quickly with matrices.
 *   3) Dijkstra - revisited. Reduced the state space of the graph and re-ran the tests, finally it worked. Nice problem to practise and reduce state
 *      space to run in time. I understood I am still skeptical about set.contains(node) - uses hashCode() method and set.add(node) - uses hashCode()
 *      and equals methods. Still need to be careful about this.
 *
 *   URL: http://community.topcoder.com/stat?c=problem_statement&pm=11554&rd=14544
 */

import java.util.StringTokenizer;
import java.util.*;

//Dijkstra brute Force algorithm.
public class ThreeTeleports {
    int[] x1 = new int[3];
    int[] y1 = new int[3];
    int[] x2 = new int[3];
    int[] y2 = new int[4];
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public class Node implements Comparable<Node> {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int hashCode() {
            int res = 1;
            int prime = 31;
            res = res * prime + x;
            res = res * prime + y;
            res = res * prime + time;
            return res;
        }

        @Override
        public boolean equals(Object o) {
            Node n = (Node) o;
            if (this.x != n.x)
                return false;
            if (this.y != n.y)
                return false;
            if (this.time > n.time)
                return false;
            return true;
        }

        @Override
        public int compareTo(Node n) {
            return time - n.time;
        }

    }
    public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
        int p1 = 0, p2 = 0;
        int maxQueueSize = -1;
        long startTime = System.currentTimeMillis();
        for (String t : teleports) {
            String[] t1 = t.split(" ");
            x1[p1] = Integer.parseInt(t1[p2++]);
            y1[p1] = Integer.parseInt(t1[p2++]);
            x2[p1] = Integer.parseInt(t1[p2++]);
            y2[p1] = Integer.parseInt(t1[p2++]);
            p1 += 1;
            p2 = 0;
        }

        Queue<Node> q = new PriorityQueue<Node>();
        Map<Node,Boolean> visited = new HashMap<Node,Boolean>();
        Node start = new Node(xMe, yMe, 0);
        q.add(start);
        visited.put(start, false);
        while (!q.isEmpty()) {
            Node top = q.remove();
            maxQueueSize = Math.max(q.size(),maxQueueSize);
            if (top.x == xHome && top.y == yHome) {
                long endTime = System.currentTimeMillis();
                long totalTime = endTime - startTime;
                System.out.println(totalTime);
                System.out.println(maxQueueSize);
                return top.time;
            }

            for (int k = 0; k < 3; k++) {
                if (x1[k] == top.x && y1[k] == top.y) {
                    Node n = new Node(x2[k], y2[k], top.time + 10);
                    if (!visited.containsKey(n)) {
                        visited.put(n,false);
                        q.add(n);
                    }
                } else if (x2[k] == top.x && y2[k] == top.y) {
                    Node n = new Node(x1[k], y1[k], top.time + 10);
                    if (!visited.containsKey(n)) {
                        visited.put(n,false);
                        q.add(n);
                    }
                }
            }
            int p = dx.length;
            for (int i = 0; i < p; i++) {
                int x = top.x + dx[i];
                int y = top.y + dy[i];
                if (!ok(x, y)) continue;
                //for teleports, if you are already on a teleport
                Node temp = new Node(x, y, top.time + 1);
                if (!visited.containsKey(temp)) {
                    visited.put(temp,false);
                    q.add(temp);
                }
            }
        }

        return -1;
    }

    public void test() {
        int x1 = 3, y1 = 7, x2 = 10000, y2 = 30000;
        String[] i1 = {"3 10 5200 4900", "12212 8699 9999 30011", "12200 8701 5203 4845"};
        System.out.println(shortestDistance(x1, y1, x2, y2, i1));

    }

    public boolean ok(int x, int y) {
        return (x >= 0 && y >= 0);
    }

    public static void main(String[] args){
        ThreeTeleports t = new ThreeTeleports();
        t.test();
    }

}
//Floyd Warshall Algorithm
class ThreeTeleports1{
    public class Point{
        int x=0; int y=0;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public long distance(Point a, Point b){
        return Math.abs((a.x-b.x))+Math.abs((a.y-b.y));
    }
    public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports){
        Point[] P = new Point[8];
        for(int i=0;i<8;i++){
            P[i]= new Point(0,0);
        }

        P[0].x=xMe;
        P[0].y=yMe;
        P[7].x=xHome;
        P[7].y=yHome;

        int p = 1;



        for(String t: teleports){
            StringTokenizer in = new StringTokenizer(t);
            P[p].x= Integer.parseInt(in.nextToken());
            P[p].y=Integer.parseInt(in.nextToken());
            p++;
            P[p].x=Integer.parseInt(in.nextToken());
            P[p].y=Integer.parseInt(in.nextToken());
            p++;
        }

        long[][] G = new long[8][8];
        for(int i=0;i<8;i++)
            for(int j=0;j<8;j++)
                G[i][j]=distance(P[i],P[j]);
        for(int i=0;i<3;i++){
            G[2*i+2][2*i+3]=G[2*i+3][2*i+2]=Math.min(10,G[2*i+2][2*i+3]);
        }

        for(int k=0;k<8;k++)
            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++)
                    G[i][j]=Math.min(G[i][j],G[i][k]+G[k][j]) ;


        return (int)G[0][1];


    }

    public void test() {
        int x1 = 3, y1 = 7, x2 = 10000, y2 = 30000;
        String[] i1 = {"3 10 5200 4900", "12212 8699 9999 30011", "12200 8701 5203 4845"};
        System.out.println(shortestDistance(x1, y1, x2, y2, i1));

    }

    public boolean ok(int x, int y) {
        return (x >= 0 && y >= 0);
    }

    public static void main(String[] args){
        ThreeTeleports1 t = new ThreeTeleports1();
        t.test();
    }

}

//Dijkstra updated states.
class ThreeTeleports2 {
    public class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class State implements Comparable<State> {
        public int node;
        public int cost;

        public State(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int compareTo(State x) {
            return this.cost - x.cost;
        }
    }

    public long distance(Point a, Point b) {
        return Math.abs((a.x - b.x)) + Math.abs((a.y - b.y));
    }

    public int shortestDistance(int xMe, int yMe, int xHome, int yHome, String[] teleports) {
        Point[] P = new Point[8];
        for (int i = 0; i < 8; i++) {
            P[i] = new Point(0, 0);
        }

        P[0].x = xMe;
        P[0].y = yMe;
        P[1].x = xHome;
        P[1].y = yHome;

        int p = 2;
        for (String t : teleports) {
            StringTokenizer in = new StringTokenizer(t);
            P[p].x = Integer.parseInt(in.nextToken());
            P[p].y = Integer.parseInt(in.nextToken());
            p++;
            P[p].x = Integer.parseInt(in.nextToken());
            P[p].y = Integer.parseInt(in.nextToken());
            p++;
        }

        long[][] G = new long[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                G[i][j] = distance(P[i], P[j]);
        for (int i = 0; i < 3; i++) {
            G[2 * i + 2][2 * i + 3] = G[2 * i + 3][2 * i + 2] = Math.min(10, G[2 * i + 2][2 * i + 3]);
        }

        //Dijkstra on the graph.
        State s = new State(0, 0);
        Queue<State> pq = new PriorityQueue<State>();
        pq.add(s);
        Set<Integer> vis = new HashSet<Integer>();
        while (!pq.isEmpty()) {
            State s1 = pq.remove();
            if (vis.contains(s1.node))
                continue;
            vis.add(s1.node);
            int node = s1.node;
            if (node == 1)
                return s1.cost;
            for (int i = 0; i < 8; i++) {
                pq.add(new State(i, s1.cost + (int) G[s1.node][i]));
            }
        }
        return -1;

    }

    public void test() {
        int x1 = 10, y1 = 10, x2 = 10000, y2 = 20000;
        String[] i1 =  {"1000 1003 1000 1004", "3 3 10004 20002", "1000 1005 1000 1006"};
        System.out.println(shortestDistance(x1, y1, x2, y2, i1));
    }

    public boolean ok(int x, int y) {
        return (x >= 0 && y >= 0);
    }

    public static void main(String[] args){
        ThreeTeleports2 t = new ThreeTeleports2();
        t.test();
    }

}
