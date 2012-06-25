package basic.javaio;

import java.io.File;
import java.util.ArrayList;

public class ListAllTest {

    private static int time;

    public static void deepList(File file) {
        if (file.isFile() || 0 == file.listFiles().length) {
            return;
        } else {
            File[] files = file.listFiles();

            files = sort(files);

            for (File f : files) {
                StringBuffer output = new StringBuffer();

                if (f.isFile()) {
                    output.append(getTabs(time));
                    output.append(f.getName());
                } else {
                    output.append(getTabs(time));
                    output.append(f.getName());
                    output.append("\\");
                }

                System.out.println(output);

                if (f.isDirectory()) {
                    time++;

                    deepList(f);

                    time--;
                }
            }
        }
    }

    private static File[] sort(File[] files) {
        ArrayList<File> sorted = new ArrayList<File>();

        for (File f : files) {
            if (f.isDirectory()) {
                sorted.add(f);
            }
        }
        for (File f : files) {
            if (f.isFile()) {
                sorted.add(f);
            }
        }

        return sorted.toArray(new File[files.length]);
        //集合转数组。
    }

    private static String getTabs(int time) {
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < time; i++) {
            buffer.append("\t");
        }

        return buffer.toString();
    }

    public static void main(String[] args) {
        File file = new File("d:/write");
        deepList(file);
    }
}
