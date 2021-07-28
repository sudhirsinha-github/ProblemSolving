package fileops;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttributeView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileReadAndFetchProperties {

    public static void main(String[] args) throws IOException {
        Path file = Paths.get("/Users/sudhirkumar/Documents/RabbitMQ.docx");
        String pathname = "/Users/sudhirkumar/Documents";
        File folder = new File(pathname);

        List<File> paths = Arrays.stream(folder.listFiles())
                .filter(r -> ! r.isHidden())
//                .filter(r -> Files.getAttribute(r.toPath(), "description:tags"))
                .sorted((File a, File b) -> a.length() < b.length() ? 1 : -1)
                .collect(Collectors.toList());

        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());

    }
}
