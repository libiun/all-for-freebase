package basic.javaio;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileDemo {

    public void testFileMethod(String filename) {
        /* 本方法的层次
        if(file.exists()){
        if(file.isFile()){}else{}
        }else{System.out.println("参数错误。");}
         */
        File file = new File(filename);
        if (file.exists()) {
            if (file.isFile()) {
                System.out.println("返回由此抽象路径名表示的文件或目录的名称：" + file.getName());
                System.out.println("测试应用程序是否可以执行此抽象路径名表示的文件：" + file.canExecute());
                System.out.println("测试应用程序是否可以读取此抽象路径名表示的文件:" + file.canRead());
                System.out.println("返回此抽象路径名的绝对路径名形式:" + file.getAbsoluteFile());
                System.out.println("返回此抽象路径名表示的文件最后一次被修改的时间：" + new Date(file.lastModified()));
                System.out.println("文件的父路径：" + file.getParent());
                //列出可用的文件系统根
                File filelist[] = File.listRoots();
                System.out.print("本机的所有磁盘分区：");
                for (File f : filelist) {
                    System.out.print(f.toString() + " ");
                }
            } else {
                //传递的filename是目录
                System.out.println("传递目录");
                System.out.println("返回由此抽象路径名表示的文件或目录的名称：" + file.getName());
                System.out.println("返回此抽象路径名的绝对路径名字符串:" + file.getAbsolutePath());
                System.out.println("返回此抽象路径名指定的分区中未分配的字节数:" + file.getFreeSpace());
                System.out.println("返回此抽象路径名父目录的路径名字符串,如果此路径名没有指定父目录则返回null:" + file.getParent());
                System.out.println("测试此抽象路径名表示的文件是否是一个目录:" + file.isDirectory());

                String[] filelist = file.list();
                for (String str : filelist) {
                    System.out.println(str);
                }

                File[] includeFiles = file.listFiles();
                for (File f : includeFiles) {
                    System.out.println(f.getAbsoluteFile());
                }
            }
        } else {
            System.out.println("文件不存在！");
        }
    }

    public void createDirectory(String name) {
        File f = new File(name);
        if (f.delete()) {
            System.out.println("创建前删除目录。");
        }
        if (f.mkdirs()) {
            System.out.println("创建目录成功。");
        }
    }

    public static void createNewFile(String name) {
        File f = new File(name);
        if (f.exists()) {
            System.out.println("文件已存在。");
        } else {
            try {
                f.createNewFile();
                System.out.println("创建文件成功。");
            } catch (IOException ex) {
                Logger.getLogger(FileDemo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String args[]) {
        FileDemo fd = new FileDemo();
        fd.testFileMethod("resource/first/second");
        fd.createDirectory("resource/first/second");
        FileDemo.createNewFile("resource/hello.txt");
    }
}
