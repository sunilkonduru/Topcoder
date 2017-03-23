/*
  SRM 306 Div2 500
  http://community.topcoder.com/stat?c=problem_statement&pm=6415
*/

import java.util.Arrays;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Sunil
 */
public class BifidSortMachine {
    public int countMoves(int[] a) {

       int n = a.length;
       int[] b = new int[n];
       System.arraycopy(a,0,b,0,n);
        Arrays.sort(b);
       int max = Integer.MIN_VALUE;
       for(int i=0;i<n;i++){
        int count = i;
        int sameOrder = 0;
        for(int j=0;j<n;j++){
            if(b[count]==a[j]){
                sameOrder++;
                count++;
            }
           if(count >=n)
               break;
        }
        max = Math.max(max,sameOrder);
       }
     return n - max;
    }

}