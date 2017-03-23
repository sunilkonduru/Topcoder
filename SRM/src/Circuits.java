public class Circuits {
    int[][] cost;
    boolean[] visited;
    int maxCost = Integer.MIN_VALUE;
    public int readInt(String a){
        return Integer.parseInt(a);
    }
    public int howLong(String[] connects, String[] costs) {
        cost = new int[connects.length][connects.length];
        visited = new boolean[connects.length];
        for(int i =0;i<connects.length;i++){
            if(connects[i].length()==0)
                continue;
            String[] cn = connects[i].split(" ");
            String[] csts = costs[i].split(" ");
            if(cn.length>0) {
                for (int j=0;j<cn.length;j++) {
                    cost[i][readInt(cn[j])]=readInt(csts[j]);
                }
            }
        }
        //run dfs and return the maximum path.
        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost[i].length;j++){
                if(cost[i][j]!=0){
                    visited[i]=true;
                    dfs(i,j,0);

                }
            }
        }

        return maxCost;
    }
    public void dfs(int u, int v, int cst){
        visited[v]=true;
        cst += cost[u][v];
        maxCost = Math.max(cst,maxCost);
        for(int w=0;w<cost.length;w++){
            if(cost[v][w]!=0){
                //if(!visited[w]){
                dfs(v,w,cst);
                //}
            }
        }
    }
}