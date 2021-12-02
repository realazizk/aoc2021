package util;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Files {
    public static String getFileContent(String filename) {
        InputStream is = Files.class.getClassLoader().getResourceAsStream(filename);
        if (is == null) {
            throw new IllegalArgumentException("File not found!");
        } else {
            try {
                return IOUtils.toString(is, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }
}
