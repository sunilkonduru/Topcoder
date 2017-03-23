/**
 * You could have done some more better with variable naming and stuff.
 * a*b%mod = a%mod*b%mod;
 * (a+b)%mod = (a%mod+b%mod)%mod;
 * (a/b)% mod something complex.
 * http://community.topcoder.com/stat?c=problem_statement&pm=11022
 */

import java.math.BigInteger;
import java.util.*;

public class CarrotJumping {

    public int theJump(int init){
        int count = 0;
        Queue<BigInteger> q = new LinkedList<BigInteger>();
        q.add(BigInteger.valueOf(init));
        q.add(null);
        Set<BigInteger> vis = new HashSet<BigInteger>();
        while(!q.isEmpty()){
            BigInteger top = q.remove();
            if(count==100000)
                return -1;
            if(top==null){
                count++;
                if(!q.isEmpty())
                    q.add(null);
                if(count>100000)
                    return -1;
                continue;
            }

            BigInteger one = top.multiply(BigInteger.valueOf(4));
            BigInteger two = top.multiply(BigInteger.valueOf(8));
            one = one.add(BigInteger.valueOf(3));
            two = two.add(BigInteger.valueOf(7));
            one = one.mod(BigInteger.valueOf(1000000007));//key to this problem's solution.
            two = two.mod(BigInteger.valueOf(1000000007));//important thing to this problems solution.

            if(!vis.contains(one)){
                vis.add(one);
                q.add(one);
            }

            if(!vis.contains(two)){
                vis.add(two);
                q.add(two);
            }

            if(one.equals(BigInteger.ZERO))
                return count+1;

            if(two.equals(BigInteger.ZERO))
                return count+1;

        }


        return -1;
    }

    public void test(){
        int i = 852808441;
        System.out.println(theJump(i));
    }

    public static void main(String[] args){
        CarrotJumping c = new CarrotJumping();
        c.test();
    }

}
