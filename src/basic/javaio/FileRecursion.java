package basic.javaio;

import java.io.File;

public class FileRecursion {

    //递归删除一个目录和里面的东西
    public static void deleteAll(File file) {
        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteAll(f);
                f.delete();
            }
        }
    }
}
