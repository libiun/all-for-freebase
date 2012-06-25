package basic.javaio;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class GetName implements FilenameFilter {

    private Pattern pattern;

    public GetName(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        // Strip path information, search for regex: 
        String nameString = new File(name).getName();
        String postfix = nameString.substring(nameString.lastIndexOf(".") + 1);
        return pattern.matcher(postfix).matches();
    }

    public static void main(String[] args) {

        File file = new File("X:/papers/论文：语义数据库Freebase研究");
        String test[];
        test = file.list(new GetName("docx"));
        for (int i = 0; i < test.length; i++) {
            List list = Arrays.asList(test);
            System.out.println(file.getPath() + "\\" + list.get(i));
        }
    }
}