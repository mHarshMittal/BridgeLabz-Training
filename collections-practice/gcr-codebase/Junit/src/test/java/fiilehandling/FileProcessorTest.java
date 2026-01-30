package filehandling;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private final FileProcessor processor = new FileProcessor();
    private final String testFile = "testfile.txt";
    private final String content = "Hello, File Handling!";

    @Test
    void testWriteAndReadFile() throws IOException {
        // Write content to file
        processor.writeToFile(testFile, content);

        // Verify file exists
        assertTrue(Files.exists(Path.of(testFile)), "File should exist after writing");

        // Verify content is correct
        String readContent = processor.readFromFile(testFile);
        assertEquals(content, readContent, "Content read should match content written");

        // Clean up
        Files.deleteIfExists(Path.of(testFile));
    }

    @Test
    void testReadNonExistentFile() {
        String nonExistentFile = "nofile.txt";

        // Expect IOException when reading a non-existent file
        assertThrows(IOException.class, () -> processor.readFromFile(nonExistentFile),
                "Reading a non-existent file should throw IOException");
    }
}
