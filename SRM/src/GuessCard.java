import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

/*
  code is not complete there are few more optimizations, I dont understand them though.
  editorial: http://community.topcoder.com/tc?module=Static&d1=match_editorials&d2=srm242
  Tomek's c++ solution: http://community.topcoder.com/stat?c=problem_solution&rm=202733&rd=7217&pm=4490&cr=14886245
  Idea: eliminate all the wrong answers and solve the problem
  this code works on all basic test cases given, but it fails too for some cases like the one in the test() method..:(
 */


public class GuessCard
{
    public int whichRow(int width, int height, int[] columns)
    {
        boolean[] solution = new boolean[width*height];
        Arrays.fill(solution,true);
        int[][] config = new int[height][width];
        int v = 0;
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                config[i][j] = v++;
            }
        }

        int k ;

        for(int c: columns){
            k = 0;
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    if(c!=j){
                        solution[config[i][j]] = false;
                    }
                }
            }

            int count = 0 ;
            int index = 0;
            for(int i=0;i<solution.length;i++){
                if(solution[i]==true){
                    index = i;
                    count++;
                }
            }
            //found the solution
            if(count==1){
                for(int i=0;i<height;i++){
                    for(int j=0;j<width;j++){
                        if(index==config[i][j])
                            return i;
                    }
                }
            }

            //Otherwise rearrange
            k = 0;
            int[] temp = new int[width*height];
            for(int i=0;i<width;i++){
                for(int j=0;j<height;j++){
                    temp[k] = config[j][i];
                    k++;
                }

            }

            k=0;
            for(int i=0;i<height;i++){
                for(int j=0;j<width;j++){
                    config[i][j] = temp[k++];
                }
            }

        }
        return -1;
    }

    public void test(){
        int[] columns=  {32, 23, 8, 15, 27, 21, 5, 16, 23, 26, 30, 29, 0, 29, 5, 23, 16, 6, 10, 30};
        int res = whichRow(34,33,columns);
        System.out.println(res);
       // {34, 33,         {32, 23, 8, 15, 27, 21, 5, 16, 23, 26, 30, 29, 0, 29, 5, 23, 16, 6, 10, 30}}

    }

    public static void main(String[] args){


        GuessCard g = new GuessCard();
        g.test();
    }

}