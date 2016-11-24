package com.elong.thinking.io;

import java.io.*;

/**
 * 创建人 : peierlong
 * 描述 : 标准IO的重定向
 */
public class Redirecting {

    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("E:\\BeAJavaer\\src\\main\\java\\com\\elong\\io\\Redirecting.java"));
        System.setIn(in); //标准输入重定向给 BufferedInputStream/

        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
        PrintStream out1 = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out1")));
        System.setOut(out); //输出重定向给 PrintStream
        System.setErr(out1); //错误输出重定向给 PrintStream

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            System.err.println(s);
            System.out.println(s);
        }
        out1.close();
        out.close();
        System.setOut(console);  //重定向到控制台
    }




}
