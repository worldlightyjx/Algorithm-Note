package com.yang.acmio;

import java.io.*;
import java.math.BigInteger;
import java.text.Format;
import java.util.StringTokenizer;

public class ACMIOTest {

    public static void main(String[] args) throws IOException {
        AReader reader = new AReader(System.in);
        AWriter writer = new AWriter(System.out);
        // Do something
        reader.close();
        writer.close();

    }


}
class AReader implements Closeable {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    public AReader(InputStream inputStream) {
        reader = new BufferedReader(new InputStreamReader(inputStream));
        tokenizer = new StringTokenizer("");
    }
    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException ex) {
            return null;
        }
    }
    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }
    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }
    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }
    public int nextInt() {
        return Integer.valueOf(next());
    }
    public double nextDouble() {
        return Double.valueOf(next());
    }
    public BigInteger nextBigInteger() {
        return new BigInteger(next());
    }
    @Override
    public void close() throws IOException {
        reader.close();
    }
}


class AWriter implements Closeable {
    private BufferedWriter writer;
    public AWriter(OutputStream outputStream) {
        writer = new BufferedWriter(new OutputStreamWriter(outputStream));
    }
    public void print(Object object) throws IOException {
        writer.write(object.toString());
    }
    public void println(Object object) throws IOException {
        writer.write(object.toString());
        writer.write("\n");
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}

