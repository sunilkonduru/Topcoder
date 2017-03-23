package Practice;
import java.util.*;

public class LIS {
    public int longestIncreasingSubsequence(int[] arr){
        int[] count = new int[arr.length];
        int[] parent = new int[arr.length];
        Arrays.fill(count,-1);
        Arrays.fill(parent,-1);
        for(int i=0;i<arr.length;i++){
        for(int j=0;j<i;j++){
            if(arr[j]<arr[i]&&count[i]<=(count[j]+1)){
                count[i]=count[j]+1;
                if(parent[i]==-1||arr[parent[i]]<arr[j])
                    parent[i]=j;
            }
        }
        if(count[i]==-1)
            count[i]=1;
    }
    int maxCountIndex = -1;
    int maxValue = -1;

    for(int j=0;j<count.length;j++) if(count[j]>maxValue){maxValue=count[j]; maxCountIndex = j;}
    for(int p=maxCountIndex;p!=-1;p=parent[p]){
        System.out.println(arr[p]);
    }
    return maxValue;
}

    public void test(){
        int[] arr = {5,4,6,2,7,10,8,9,11,12};
        int[] testArray1 = { 100,10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("result:"+longestIncreasingSubsequence(testArray1));
    }

    public static void main(String[] args){
        LIS l = new LIS();
        l.test();
    }

}
