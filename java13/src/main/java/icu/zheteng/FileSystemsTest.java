package icu.zheteng;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * @author yancy
 */

public class FileSystemsTest {

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        System.out.println(fileSystem.isReadOnly());
        fileSystem.getRootDirectories().forEach(System.out::println);
    }
}
