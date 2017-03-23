//SRM 391 - good(made few mistakes, corrected before submitting)
//Missed a case when mapping two charaacter aaa aba for the first a put in hashmap a,a and when I see  3rd a I am verifying if word2 also has a.
//but missed a case if ab aa for a,a I will put next b,a also I am putting inside I am not verifying the reverse hash. did it with boolean and iteration.
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class IsomorphicWords
{
	public int countPairs(String[] words)
	{
	   Map<Character,Character> m;
	   boolean[] b = new boolean[256];
	   int count = 0;
	   for(int i=0;i<words.length;i++){
	     String word1 =words[i];
	     String word2 ="";
	     for(int j=i+1;j<words.length;j++){
	       m = new HashMap<Character,Character>();
	       word2=words[j];
	       int k = 0;
	       for(k=0;k<word1.length();k++){
	         if(m.containsKey(word1.charAt(k))){
	            if(m.get(word1.charAt(k))==word2.charAt(k))
	             continue;
	            else break;
	         }
	         else{
	         	m.put(word1.charAt(k),word2.charAt(k));
	      	   continue;
	         }  
	       }
	       boolean ok = true;
	       if(k==word1.length()) {
	      		 System.out.println(word1+","+word2);
	       
	       for(Map.Entry<Character,Character> entry: m.entrySet()){
	         if(b[entry.getValue()])
	           ok=false;
	         b[entry.getValue()]=true;
	       }
	       if(ok)
	         count++;
	       }
	       Arrays.fill(b,false);
	     }
	   }
		return count;
	}
	<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!

//better solution - more concise and using loop: for first time//break and dont execute statemnts below and run.

public int countWords(String[] words){
	int count = 0;
	for(int i=0;i<words.length;i++){
       loop: for(int j=i+1;j<words.length;j++){
         if(words[i].length()!=words[j].length()) continue;
         int[] a = new int[26];
         int[] b = new int[26];
         Arrays.fill(a,-1);
         Arrays.fill(b,-1);
         for(int k=0;k<words[i].length();k++){
         	int u = words[i].charAt(k)-'a';
         	int v = words[i].charAt(k)-'a';
            if(a[u]==-1){
              a[u]=u;
            }
            if(a[v]==-1){
              b[v]=u;
            }
            if(a[u]!=v && b[v]!=u)
            	continue loop;
		}
       }
       count++;
	}
	return count;
}