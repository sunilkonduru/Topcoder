package lib;

/**
 * Created by sunil.kksubramanyam on 6/18/15.
 */
class IOUtils {

    public static char[] readCharArray(InputReader in, int size) {
        char[] array = new char[size];
        array = in.nextChar();
        return array;
    }

    public static char[][] readTable(InputReader in, int rowCount, int columnCount) {
        char[][] table = new char[rowCount][];
        for (int i = 0; i < rowCount; i++)
            table[i] = readCharArray(in, columnCount);
        return table;
    }

}
