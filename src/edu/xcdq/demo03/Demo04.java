package edu.xcdq.demo03;

import java.io.*;

/**
 * @author wangwenbo
 * @data 2021/5/20 8:09
 */
public class Demo04 {
    // 输出流装换器
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(""));
        OutputStreamWriter osw  = new OutputStreamWriter(System.out); // 装换器 stream ->writer
        String line = null;
        while ((line = (br.readLine())) !=null);{
            osw.write(line+"\n");
        }

        osw.flush();

        br.close();
        osw.close();

    }

}
