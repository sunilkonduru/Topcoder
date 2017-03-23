import java.util.*;
public class FilipTheFrog {
    public int countReachableIslands(int[] positions, int L) {
        int count = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(positions[0]);
        Set<Integer> set = new HashSet<Integer>();
        for(int i=1;i<positions.length;i++){
            set.add(positions[i]);
        }
        while(!q.isEmpty()) {
            int v = q.remove();
            count++;
            for (int i = -L; i <= L ; i++){
                if(i==0) continue;
                int v1 = v - i;
                if (set.contains(v1)) {
                    //count++;
                    q.add(v1);
                    set.remove(v1);
                }
            }
        }
        return count;
    }
}