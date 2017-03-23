import java.util.*;
//time limit exceeded exception.
public class TheLuckyString
{
    public int count(String s)
    {
        int count = 0;

        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        String s2 = new String(cs);
        if(isLucky(s2))
            count++;

        System.out.println("1"+count);

        Character[] c1 = new Character[cs.length];
        int k=0;
        for(char c: cs){
            c1[k++]=c;
        }
        ArrayList<String> res =printPermutations(c1);
        for(String s1: res){
            s1 = s1.replace("[","");
            s1 = s1.replace("]","");
            s1 = s1.replace(",","");
            s1 = s1.replace(" ","");
            if(isLucky(s1))
                count++;



        }
        return count;

    }

    public boolean isLucky(String s){
        char prev='1';
        char[] cs = s.toCharArray();

        int i = 0;
        for(char c: cs){
            if(i==0){
                prev = c;
            }
            else{
                if(prev==c)
                    return false;
                prev = c;
            }
            i++;
        }
        return true;
    }


    // simply prints all permutation - to see how it works
    public  ArrayList<String> printPermutations( Comparable[] c ) {
        // System.out.println( Arrays.toString( c ) );
        ArrayList<String>  a = new ArrayList<String>();
        while ( ( c = nextPermutation( c ) ) != null ) {
            a.add(Arrays.toString(c));
        }
        return a;
    }

    // modifies c to next permutation or returns null if such permutation does not exist
    public  Comparable[] nextPermutation( final Comparable[] c ) {
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
    public  int getFirst( final Comparable[] c ) {
        for ( int i = c.length - 2; i >= 0; --i )
            if ( c[ i ].compareTo( c[ i + 1 ] ) < 0 )
                return i;
        return -1;
    }

    // swaps two elements (with indexes i and j) in array
    private  void swap( final Comparable[] c, final int i, final int j ) {
        final Comparable tmp = c[ i ];
        c[ i ] = c[ j ];
        c[ j ] = tmp;
    }

}
//Powered by [KawigiEdit] 2.0!


//bit more optimal  solution workede for all the cases
class TheLuckyString1
{

    int[] have = new int[26];
    int count = 0;
    int L = 0;
    public int count(String s)
    {
        L = s.length();
        for(int i=0;i<s.length();i++){
            have[s.charAt(i)-'a']++;
        }

        solve(0,' ');
        return count;
    }

    public void solve(int pos, char prev){

        if(pos==L){
            count++;
            return;
        }

        for(char c='a';c<='z';c++){
            if(c!=prev && have[c-'a']>0){
                have[c-'a']--;
                solve(pos+1,c);
                have[c-'a']++;
            }

        }

    }



  //  <%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!