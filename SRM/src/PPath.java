/*
   SPOJ - PPATH
   Sieve of erastothenes
   substring
 */

import java.util.Scanner;
import java.util.*;

public class PPath {

    Set<Integer> prime = new HashSet<Integer>();
    public int returnInt(String a){
        return Integer.parseInt(a);
    }
    public int pPath(String a, String b){
        Queue<String> q = new LinkedList<String>();
        q.add(a);
        if(a.equals(b))
            return 0;
        int count = 0;
        Set<String> visited = new HashSet<String>();
        visited.add(a);
        q.add(null);
        while(!q.isEmpty()) {
            String top = q.remove();
            if(top==null){
                count++;
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if(i==0&&j==0) continue;
                    String s1 = top.substring(0,i)+j+top.substring(i+1); //biggest mistake is using a.substring instead of top.substring.
                    if(visited.contains(s1)) continue;
                    int v =returnInt(s1);
                    if(s1.equals(b))
                        return count+1;
                    if (prime.contains(v)){
                        q.add(s1);
                        visited.add(s1);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws java.lang.Exception{
        PPath m2 = new PPath();
        //Sieve of eratosthenes - Learnt about this method for computing primes.
        boolean[] isComposite = new boolean[10000];
        int upperBound = (int)Math.sqrt(10000);
        for(int i=2;i<=upperBound;i++){ //first looop for marking primes
            if(!isComposite[i]){
                if(i>1000)
                    m2.prime.add(i);
            }
            for(int j=i*i;j<=9999;j+=i){ //second loop for all eliminated values. j+=i could overflow be careful.
                isComposite[j]=true;
            }
        }
        for(int i=1000;i<=9999;i++) if(!isComposite[i]) m2.prime.add(i);

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        for(int i=0;i<m;i++){
            String a= scan.next(); // didnt know how scan works. Had to spend some time figuring this out.
            String b = scan.next();
            System.out.println(m2.pPath( a, b));
        }

    }
}
