package icu.zheteng;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yangpeng
 * @date 2023年04月18日
 */

public class FilesTest {

    /**
     * 新增redaString和writeString两个API，更方便操作文件
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/Users/temp/slan/shell/20.txt");
        String s = Files.readString(path);
        System.out.println(s);
    }

}
