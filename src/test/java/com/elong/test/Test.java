package com.elong.test;

import java.io.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public class Test {

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("c://123.txt"));
            String s;
            StringBuilder sb = new StringBuilder();
            while((s = bufferedReader.readLine()) !=null){
                sb.append(s + " ");
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
