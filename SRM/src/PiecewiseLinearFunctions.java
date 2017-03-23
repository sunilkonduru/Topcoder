import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;


// SRM 586 ~ 280 points
// I made a mistake (i<Y.length-1) && ((Y[i]<q&&Y[i+1]>q)||(Y[i]>q&&Y[i+1]<q)), I removed the outer brackets of the 2nd expresion~ Index out of bounds exception
public class PiecewiseLinearFunctionDiv2
{
	public int[] countSolutions(int[] Y, int[] query)
	{   
	    int[] res = new int[query.length];
	    int count;
		int i;
		int k=0;
		for(int q: query){
		 count = 0;
		 i=0;
		 boolean val1 = false;
		 boolean val2 = false;
		 int prevX=Integer.MIN_VALUE;
		 while(i<Y.length){
		    if((i<Y.length-1) && ((Y[i]<q&&Y[i+1]>q)||(Y[i]>q&&Y[i+1]<q))){
		      count++;
		      
		    }
		    else if(Y[i]==q){
		      if(val1){
		        if(prevX-i==-1)
		             val2=true;
		      }
		      val1=true;
		      prevX=i;
		      count++;
		    }
		    i++;
		 }
		 if(val2){
		   res[k++]=-1;
		 }
		 else{
		 	res[k++]=count;
		 	count = 0; 
		 }
		}
		return res;
	}
	
	<%:testing-code%>
}
//Powered by [KawigiEdit] 2.0!