package lib;
import java.io.*;

public class OutputWriter {
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
