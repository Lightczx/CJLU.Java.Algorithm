package DGP.CJLU.Experiment4.Lab3;

import DGP.CJLU.Utils.File.FileHelper;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Count each word in a English file.
 * a)	Create a file and copy an English article to the file.
 * b)	Write a program to count each word in the file
 * c)	TreeMap must be used.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("D:\\test.txt");
        if (!file.exists()) {
            System.out.println("找不到文件");
            return;
        }
        StringBuilder sb = FileHelper.readFileToStringBuilder(file);
        Analyse(sb.toString());
    }

    public static void Analyse(String text) {
        TreeMap<String, Integer> treemap = new TreeMap<>();
        //split text into array
        String[] str = text.split("[,.!\": ]");
        for (String s : str) {
            String key = s.toLowerCase();
            if (key.length() > 0) {
                if (!treemap.containsKey(key)) {
                    treemap.put(key, 1);
                } else {
                    int value = treemap.get(key);
                    value++;
                    treemap.put(key, value);
                }
            }
        }

        System.out.println("Word\tCount");
        for (Map.Entry<String, Integer> e : treemap.entrySet())
            System.out.println(e.getKey() + "\t" + e.getValue());
    }
}
