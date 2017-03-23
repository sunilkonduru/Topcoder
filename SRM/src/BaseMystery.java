import java.util.*;
import java.math.*;

public class BaseMystery
{
    public int[] getBase(String equation)
    {
        StringTokenizer st = new StringTokenizer(equation,"+=");
        String n1 = st.nextToken();
        String n2 = st.nextToken();
        String n3 = st.nextToken();
        BigInteger b1,b2,b3;
        Set<Integer> set = new TreeSet<Integer>();
        for(int i=2;i<=20;i++){
            BigInteger b4=null;
            try{
                b1 = new BigInteger(n1,i);
                b2 = new BigInteger(n2,i);
                b3 = new BigInteger(n3,i);
                b4 = b1.add(b2);
            }
            catch(NumberFormatException n){
                continue;
            }
            if(b4.equals(b3))
                set.add(new Integer(i));//cannot directly add int be careful about that.

        }
        int[] res = new int[set.size()];
        int j=0;
        for(int i:set){
            res[j++]=i;

        }
        return res;

    }


}
//Powered by [KawigiEdit] 2.0!
