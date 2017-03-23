/*
http://community.topcoder.com/stat?c=problem_statement&pm=13648
*/
import java.util.*;

public class Fragile2
{
    boolean[][] connected;
    boolean[] reached;
    public int countPairs(String[] graph)
    {

        connected = new boolean[graph.length][graph[0].length()];
        reached = new boolean[graph.length];
        int i = 0;
        for(String g: graph){
            char[] vs = g.toCharArray();
            int j=0;
            for(char c: vs){
                if(c=='Y')
                    connected[i][j]=true;
                else
                    connected[i][j]=false;
                j++;
            }
            i++;
        }

        int actualCC = getCC(connected);
        int result = 0;
        for(int p1=0;p1<graph.length;p1++){
            for(int p2=p1+1;p2<graph.length;p2++){//if you want to get permutation without repeating use this, I was like solving the problem and dividing the solution by 2 (1,2) (2,1) wont repeat with this.
                 /*  if(p1==p2)
                       continue;
                    boolean[] temp1 = new boolean[graph.length];
                    boolean[] temp2 = new boolean[graph.length];
                    for(int k=0;k<graph.length;k++){
                        temp1[k]=connected[p2][k];
                        temp2[k]=connected[p1][k];
                    }
                    Arrays.fill(connected[p2],false);
                    Arrays.fill(connected[p1],false);
                    for(int l=0;l<connected[p2].length;l++){
                        if(connected[l][p2])
                            connected[l][p2]=false;
                        if(connected[l][p1])
                            connected[l][p1]=false;

                    }
                    */
                    Arrays.fill(reached,false);
                    reached[p1]=true;//these two lines are such a nice optimization.
                    reached[p2]=true;
                    int nowCC = getCC(connected);


                   // nowCC = nowCC -2;
                    if(nowCC>actualCC)
                        result++;
                    /*
                    for(int k=0;k<graph.length;k++){
                        connected[p2][k]=temp1[k];
                        connected[p1][k]=temp2[k];
                    }

                     for(int l=0;l<connected[p2].length;l++){
                        if(connected[p2][l])
                            connected[l][p2]=true;
                        if(connected[p1][l])
                            connected[l][p1]=true;

                    }

                    */


                }

            }

        return result;
    }

    public int getCC(boolean[][] connected){

        int count = 0;
        for(int i=0;i<connected[0].length;i++){

            if(!reached[i])
                dfs(i);
            else
              continue;
            count++;
        }
        return count;
    }

    public void dfs(int src){
        reached[src]=true;
        for(int i=0;i<connected[0].length;i++){
            if(src==i)
                continue;
            if(connected[src][i]&&!reached[i])
                dfs(i);
        }
    }

    public void test(){

        String[] graph ={"NYNN", "YNYN", "NYNY", "NNYN"};
        int res = countPairs(graph);
        System.out.println(res);
    }

    public static void main(String[] args){
        Fragile2 f = new Fragile2();
        f.test();

    }


}