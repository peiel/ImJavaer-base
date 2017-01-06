package com.elong.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class TextFile extends ArrayList<String> {

    /**
     * 读取文件内容
     *
     * @param fileName 文件名称
     * @return 文件内容
     */
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        String s;
        try {
            in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            for (; (s = in.readLine()) != null; ) {
                sb.append(s);
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * @param fileName 文件名称
     * @param text     写入内容
     */
    public static void write(String fileName, String text) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
            out.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) out.close();
        }
    }

    public TextFile(String fileName, String spliter) {
        super(Arrays.asList(read(fileName).split(spliter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        PrintWriter out = null;
        try {
            out = new PrintWriter(fileName);
            for (String item : this)
                out.write(item);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();

        }
    }

}
