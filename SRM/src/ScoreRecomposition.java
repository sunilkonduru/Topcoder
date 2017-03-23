import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class ScoreRecomposition
{
    public int minError(String questions, int score)
    {
        int minError=-1;
        boolean pa = false;
        char[] qs = questions.toCharArray();
        int  s = 0;
        int index = 1;
        for(char q: qs){
            if(q=='C')
                s+=index;
            index++;
        }
        if(s==score)
            return 0;
        //otherwise try all the combinations and find the best solution
        Integer[] a = new Integer[questions.length()];
        for(int i=0;i<questions.length();i++){
            a[i] = i+1;
        }


        ArrayList<String> p;
        p=printPermutations(a);
        for(String p1: p){
            s=0;
            p1=p1.replace("[","");
            p1=p1.replace("]","");
            p1=p1.replace(" ","");
            p1=p1.replace(",","");
            char[] cs= p1.toCharArray();


            int i = 0;
            for(char c: cs){
                int v = Character.getNumericValue(c);
                if(questions.charAt(i)=='C')
                    s+=v;
                i++;
             }
            if(score!=s)
                continue;
            else{
                i=1;
                int res = 0;
                int e = -1;
                for(char c: cs){
                    int v = Character.getNumericValue(c);
                    res = Math.abs(i-v);
                    i++;
                    e = Math.max(res,e);
                }
                if(minError<0||e<minError)
                    minError=e;

            }


        }

            return minError;

    }


    // simply prints all permutation - to see how it works
    public static ArrayList<String> printPermutations( Comparable[] c ) {
       // System.out.println( Arrays.toString( c ) );
        ArrayList<String>  a = new ArrayList<String>();
        while ( ( c = nextPermutation( c ) ) != null ) {
            a.add(Arrays.toString(c));
        }
        return a;
    }

    // modifies c to next permutation or returns null if such permutation does not exist
    public static Comparable[] nextPermutation( final Comparable[] c ) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst( c );
        if ( first == -1 ) return null; // no greater permutation
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = c.length - 1;
        while ( c[ first ].compareTo( c[ toSwap ] ) >= 0 )
            --toSwap;
        // 3. swap elements with indexes first and last
        swap( c, first++, toSwap );
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.length - 1;
        while ( first < toSwap )
            swap( c, first++, toSwap-- );
        return c;
    }

    // finds the largest k, that c[k] < c[k+1]
    // if no such k exists (there is not greater permutation), return -1
    public static int getFirst( final Comparable[] c ) {
        for ( int i = c.length - 2; i >= 0; --i )
            if ( c[ i ].compareTo( c[ i + 1 ] ) < 0 )
                return i;
        return -1;
    }

    // swaps two elements (with indexes i and j) in array
    private static void swap( final Comparable[] c, final int i, final int j ) {
        final Comparable tmp = c[ i ];
        c[ i ] = c[ j ];
        c[ j ] = tmp;
    }

    public void test(){
         int v = minError("WWCC",3);
         System.out.println(v);

    }

    public static void main(String[] args){
        ScoreRecomposition s = new ScoreRecomposition();
        s.test();
    }


}