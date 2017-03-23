// http://community.topcoder.com/stat?c=problem_statement&pm=1524&rd=4472


public class Marketing {

    boolean[][] edge = new boolean[64][64];
    int[] color = new int[64];
    boolean oddCycle = false;
    public int returnInt(String x){
        return Integer.parseInt(x);
    }


    public boolean isValid(int x, int y){
        return (x>=0&&x<30&&y>=0&&y<30);
    }
    public long howMany(String[] compete) {
        int n1 = 0;
        for(String c: compete) {
            String[] nums = c.split(" ");
            for(int i=0;i<nums.length;i++){
                if(nums[i]=="")
                    continue;
                int n2 = returnInt(nums[i]);
                edge[n1][n2]=edge[n2][n1]=true;
            }
            n1++;
        }
        for(int i=0;i<64;i++){
            color[i]=0;
        }
        long count = 1;
        for(int i=0;i<compete.length;i++){
            if(color[i]==0) {
                dfs(i, 1);
                count *= 2;
            }
        }
        if(oddCycle)
            return -1;

        return count;

    }

   //detect odd cycle and all possibilites are the number of connected components. If you have odd cycle it cannot be bipartite.
    public void dfs(int u, int c){
        if(color[u]==0){
            color[u]=c;
            for(int v=0;v<64;v++){
                if(edge[u][v])
                    dfs(v,3-c);
            }
        }

        if(color[u]!=0) {
            if (color[u] != c) {
                oddCycle=true;
            }
            return;
        }
    }

    public void test(){
        String[] edge = {"1 4","2","3","0",""};
        long res = howMany(edge);
        System.out.println(res);
    }

    public static void main(String[] args){
        Marketing m = new Marketing();
        m.test();
    }


}

