package com.elong.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 创建人 : peierlong
 * 描述 :
 */
public final class Directory {

    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }

    public static File[] local(String dir, final String regex) {
        return local(new File(dir), regex);
    }

    static TreeInfo recurseDirs(File starDir, String regex){
        TreeInfo result = new TreeInfo();
        for (File file : starDir.listFiles()) {
            if (file.isDirectory()){
                result.dirs.add(file);
                result.addAll(recurseDirs(file, regex));
            }else if(file.getName().matches(regex)){
                result.files.add(file);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(new File("C://123.txt").getName());
    }


    static class TreeInfo implements Iterable<File> {
        private List<File> files = new ArrayList<File>();
        private List<File> dirs = new ArrayList<File>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo treeInfo) {
            files.addAll(treeInfo.files);
            dirs.addAll(treeInfo.dirs);
        }

        @Override
        public String toString() {
            return "files : " + files + "\n" + "dirs : " + dirs;
        }
    }
}
