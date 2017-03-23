import java.io.*;
import java.util.StringTokenizer;

public class SubsetsCodeForces {
    public static void main(String[] args){
        InputStream inputStream = System.in;
        OutputStream outStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outStream);
        TaskB solver = new TaskB();
        solver.solve(in,out);
        out.close();
    }
}

class TaskB{
    public void solve(InputReader in, OutputWriter out){
        int noOfProblems = in.nextInt();
        int minDiff = in.nextInt();
        int maxDiff = in.nextInt();
        int diff = in.nextInt();
        int[] difficulty = new int[noOfProblems];
        for(int i=0;i<noOfProblems;i++){
            difficulty[i]= in.nextInt();
        }
        //Arrays.sort(difficulty);
        int count = 0;
        for(int i=0;i<(1<<noOfProblems);i++){
            int min = Integer.MAX_VALUE, max =Integer.MIN_VALUE;
            int sum = 0;
            for(int j=0;j<noOfProblems;j++){
                if((i&(1<<j))!=0){
                    min = Math.min(min,difficulty[j]);
                    max = Math.max(max,difficulty[j]);
                    sum += difficulty[j];
                }
            }
            int diffMaxMin = max - min;
            if((diffMaxMin>=diff)&& sum>=minDiff && sum<=maxDiff){
                count++;
            }
        }
        out.printLine(count);
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public InputReader(File f) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(f));
        tokenizer = null;
    }
    public String next(){
        String str = null;
        while ((tokenizer == null || !tokenizer.hasMoreTokens())) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }


    public char[] nextChar() {
        try {
            return reader.readLine().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: optimise return value for error case
            return null;
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public OutputWriter(File f) throws IOException{
        writer = new PrintWriter(new FileWriter(f));
    }

    public void close() {
        writer.close();
    }

    public void printLine(long i) {
        writer.println(i);
    }

    public void printLine(String str){
        writer.println(str);
    }

}








