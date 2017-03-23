/*
  srm 415 div2: https://community.topcoder.com/stat?c=problem_statement&pm=9954&rd=13506
*/
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;

public class ThreePhotos
{
    public int removeCubes(String[] A, String[] B, String[] C)
    {
        int N = A.length;
        int total = N*N*N;
        //Set<String> set = new HashSet<String>();
        int count = 0;

		/*
		//use count approach or
		int countA = 0 ,  countB=0, countC=0;
		for(int i=0;i<N;i++){
		  for(int j=0;j<N;j++){
		     if(A[i].charAt(j)=='N'){
		       countA++;
		     }
		     if(B[i].charAt(j)=='N'){
		       countB++;
		      }
		     if(C[i].charAt(j)=='N'){
		       countC++;
		      }
		  }
		}
		if countA!=countB || countC!=countB return -1;
		*/

        boolean[][] a = new boolean[N][N];
        boolean[][] b = new boolean[N][N];
        boolean[][] c = new boolean[N][N];



        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    if(A[i].charAt(j)=='Y'&&B[i].charAt(k)=='Y'&&C[j].charAt(k)=='Y'){
                        count++;
                        a[i][j]=true;
                        b[i][k]=true;
                        c[j][k]=true;
                    }
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(A[i].charAt(j)=='Y')if(!a[i][j]) return -1;
                if(B[i].charAt(j)=='Y')if(!b[i][j]) return -1;
                if(C[i].charAt(j)=='Y')if(!c[i][j]) return -1;
            }
        }

        return total-count;

    }


}
//Powered by [KawigiEdit] 2.0!