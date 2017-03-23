/**
 *  http://community.topcoder.com/stat?c=problem_statement&pm=12613&rd=15696
 *
 */

import java.util.*;

//using floyd warshall algorithm.
class Egalitariansm1{
    public int maxDifference(String[] isFriend, int d){
        int m = isFriend.length;
        int n = isFriend[0].length();
        int[][] w = new int[m][n];
        final int INF=10000000;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isFriend[i].charAt(j)!='Y'){
                    w[i][j]=INF;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isFriend[i].charAt(j)=='Y'){
                    w[i][j]=1;
                }
            }
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    w[i][j]=Math.min(w[i][j],(w[i][k]+w[k][j]));
                }
            }
        }

        for(int i=0;i<n;i++){
            if(w[0][i]==INF)
                return -1;
        }

        int depth = -1;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                depth = Math.max(depth,w[i][j]);

        return depth*d;


    }

    public static void main(String[] args){
        Egalitariansm1 e = new Egalitariansm1();
        e.test();
    }

    public void test(){
        String[] s ={"NYYNNNNYYYYNNNN",
                "YNNNYNNNNNNYYNN",
                "YNNYNYNNNNYNNNN",
                "NNYNNYNNNNNNNNN",
                "NYNNNNYNNYNNNNN",
                "NNYYNNYNNYNNNYN",
                "NNNNYYNNYNNNNNN",
                "YNNNNNNNNNYNNNN",
                "YNNNNNYNNNNNYNN",
                "YNNNYYNNNNNNNNY",
                "YNYNNNNYNNNNNNN",
                "NYNNNNNNNNNNNNY",
                "NYNNNNNNYNNNNYN",
                "NNNNNYNNNNNNYNN",
                "NNNNNNNNNYNYNNN"};
        int d = 747;

        int res = maxDifference(s,d);
        System.out.println(res);

    }
}




//Using bfs, depth and connected components
 class Egalitarianism {

    String [] friend;
    int maxDepth = 0;
    boolean[] visited;


    public int maxDifference(String[] isFriend, int d){
        friend=isFriend;
        visited = new boolean[friend.length];
        int m = isFriend.length;
        int count = 0;
        int n = isFriend[0].length();
        for(int i=0;i<m;i++){
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }

        for(int i=0;i<m;i++){
            Arrays.fill(visited, false);
            int depth = bfs(i);
            maxDepth = Math.max(depth,maxDepth);
        }


        return (maxDepth==0||count>1)? -1: (maxDepth-1)*d;
    }

    public int bfs(int v){
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(v);
        q.add(-1);
        visited[v]=true;
        while(!q.isEmpty()){
            int top = q.remove();
            if(top==-1){
                count++;
                if(!q.isEmpty())
                    q.add(-1);
                continue;

            }
            //if(visited[top]) continue;

            for(int i=0;i<friend[0].length();i++){
                if(friend[top].charAt(i)=='Y'){
                    if(!visited[i]) {
                        visited[i]=true;
                        q.add(i);
                    }
                }
            }

        }
        return count;
    }



    public static void main(String[] args){
        Egalitarianism e = new Egalitarianism();
        e.test();
    }

    public void test(){
        String[] s ={"NYYNNNNYYYYNNNN",
                "YNNNYNNNNNNYYNN",
                "YNNYNYNNNNYNNNN",
                "NNYNNYNNNNNNNNN",
                "NYNNNNYNNYNNNNN",
                "NNYYNNYNNYNNNYN",
                "NNNNYYNNYNNNNNN",
                "YNNNNNNNNNYNNNN",
                "YNNNNNYNNNNNYNN",
                "YNNNYYNNNNNNNNY",
                "YNYNNNNYNNNNNNN",
                "NYNNNNNNNNNNNNY",
                "NYNNNNNNYNNNNYN",
                "NNNNNYNNNNNNYNN",
                "NNNNNNNNNYNYNNN"};
        int d = 747;

        int res = maxDifference(s,d);
        System.out.println(res);

    }


}

