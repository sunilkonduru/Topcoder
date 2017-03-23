//http://community.topcoder.com/stat?c=problem_statement&pm=2997&rd=5857
import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class grafixCorrupt
{
	public int selectWord(String[] dictionary, String candidate)
	{
		int maxCount = -1;
		int index = -1;
		String maxString = null;
		int j=0;
		for(String word: dictionary){
		  int count = 0;
		  for(int i=0;i<candidate.length();i++){
		    if(candidate.charAt(i)==word.charAt(i)){
		      count++;
		    }
		  }
		  if(count>maxCount&&count!=0){ maxCount=count; index=j; maxString=word;}
		  j++;
		}
		return index;
	}	
}