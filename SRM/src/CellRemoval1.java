import java.util.*;

public class CellRemoval
{
    boolean[][] isConnected;
    boolean[] marked;
    boolean[] isLeaf;
    int deleted;
    int count = 0;
    public int cellsLeft(int[] parent, int deletedCell)
    {
        isConnected = new boolean[parent.length][parent.length];
        marked= new boolean[parent.length];
        isLeaf = new boolean[parent.length];
        deleted = deletedCell;
        Arrays.fill(isLeaf,true);
        int src=-1;
        for(int i=0;i<parent.length;i++){
            if(parent[i]==-1){
                src = i;
                continue;
            }

            isLeaf[parent[i]]=false;
            isConnected[parent[i]][i]=true;
            //isConnected[i][parent[i]]=true;

        }
        marked[deletedCell]=true;
        dfs(src);
        return count;
    }

    public void dfs(int src){
        if(isLeaf[src]){
            count++;
        }
        for(int i=0;i<isConnected[0].length;i++){
            if(i==src)
                continue;
            if(!marked[i]&&isConnected[src][i]) { //made a mistake here marked[i]
                marked[src] = true;
                dfs(i);
            }
        }
    }
    public void test(){
        int[] arr = {-1,0,0,1,1};
        int count=cellsLeft(arr,1);
        System.out.println(count);

    }

    public static void main(String[] args){
        CellRemoval c = new CellRemoval();
        c.test();
    }

   // <%:testing-code%>

}