/*
SRM 571 Div2 Mid
http://community.topcoder.com/stat?c=problem_statement&pm=12437
*/

import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class FoxAndMp3Easy
{
	public String[] playList(int n)
	{
	   String[] str = new String[n];
	   for(int i=0;i<n;i++){
	    str[i]=new String((i+1)+".mp3");
	   }
	   Arrays.sort(str);	
	   if(str.length>50){
	    String[] str1 = new String[50];
	    for(int i=0;i<50;i++)
	      str1[i] = str[i];
	      return str1;
	   }
	   
	   return str;
	}
	
	
}