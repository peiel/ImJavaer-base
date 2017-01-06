package com.elong.io;

import java.io.*;

/**
 * 创建人 : peierlong
 * 描述 : 读取字符串 使用FileWriter输出到文件中 打印文件中的内容
 */
public class BasicFileOutput {

    static String file = "BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader("I am a Javaer"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null){
            out.write(lineCount++ + ": " + s);
        }
        out.close();

        System.out.println(BufferedInputFIle.read(file));
    }

}
