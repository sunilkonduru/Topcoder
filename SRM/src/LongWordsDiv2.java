//could have solved the next element same as current part more elegantly had too many mistakes in there arr[i]==arr[i-1]?
//problem: http://community.topcoder.com/stat?c=problem_statement&pm=13147&rd=15851
//Editorial: http://apps.topcoder.com/wiki/display/tc/SRM+618

public class LongWordsDiv2
{
    public String find(String word)
    {
        for(char i='A';i<='Z';i++){
            for(char j='A';j<='Z';j++){
                StringBuffer sb = new StringBuffer();
                sb.append(i);
                sb.append(j);
                sb.append(i);
                sb.append(j);
                String sub = new String(sb);
                boolean res1 = hasSameAdjCharacters(word);
                boolean res2 = isSubsequence(sub,word);
                if(res1||res2)
                    return "Dislikes";
            }

        }
        return "Likes";
    }

    public boolean hasSameAdjCharacters(String word1){

        if(word1.length()==1)
            return false;

        //what if the word is only one character?
        char prev=word1.charAt(0), curr=word1.charAt(1);
        for(int i=2;i<word1.length();i++){
            if(prev==curr)
                return true;
            prev=curr;
            curr = word1.charAt(i);
        }

        //missed corner case. What happens when the last two characters are the same
        if(prev==curr)
            return true;


        return false;
    }


    public boolean isSubsequence(String word1, String word2){
        int j=0;
        for(int i=0;i<word2.length();i++){
            if(j<word1.length()&&word1.charAt(j)==word2.charAt(i))
                j++;
        }
        if(j==word1.length())
            return true;

        return false;
    }


}
//Powered by [KawigiEdit] 2.0!