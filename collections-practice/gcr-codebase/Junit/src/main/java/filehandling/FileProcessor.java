package filehandling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    // Writes content to a file
    public void writeToFile(String filename, String content) throws IOException {
        Files.writeString(Path.of(filename), content);
    }

    // Reads content from a file
    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
