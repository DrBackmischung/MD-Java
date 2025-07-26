package de.mathisneunzig.md;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class MarkdownIO {

    public static MDFile readFrom(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String content = reader.lines().collect(Collectors.joining("\n"));
            return MarkdownParser.parse(content);
        }
    }

    /**
     * Writes a .md file to the given path.
     *
     * @param file MDFile
     * @param path Path to be written to
     * @throws IOException Exception during write operation
     */
    public static void writeTo(MDFile file, Path path) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(MarkdownRenderer.render(file));
            writer.flush();
        }
    }
}
