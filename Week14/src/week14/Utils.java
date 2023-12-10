package week14;

import java.io.*;

public class Utils {

    public static String readContentFromFile(String path) {
        StringBuilder content = new StringBuilder();
        String a = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
                a += line + "\n";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    public static void writeContentToFile(String content, String path) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(content);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void appendContentToFile(String content, String path) {
        try {
            String s = readContentFromFile(path);
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(s + "\n" + content);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null)
            for (File file : files)
                if (file.getName().equals(fileName)) return file;
        return null;
    }


    public static void main(String[] args) {
        File file = findFileByName("C:\\Users\\84976\\Desktop\\LTHDT\\Week14\\src\\week14","oop.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(readContentFromFile("C:\\Users\\84976\\Desktop\\LTHDT\\Week14\\src\\week14\\oop.txt"));
        writeContentToFile("abc\n","C:\\Users\\84976\\Desktop\\LTHDT\\Week14\\src\\week14\\oop.txt");
        appendContentToFile("abc d\n","C:\\Users\\84976\\Desktop\\LTHDT\\Week14\\src\\week14\\oop.txt");

    }
}