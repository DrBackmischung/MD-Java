package de.mathisneunzig.md;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        MDFile file = new MDFile()
            .addElement(new MDChapter("Einleitung")
                .addText("Dieses Markdown-Dokument wurde in Java erzeugt.")
                .addSection(new MDSection("Ziele")
                    .addText("Wir möchten Markdown schreiben und lesen.")
                    .addElement(new MDList(false)
                        .addItem("Kapitel & Abschnitte")
                        .addItem("Listen & Tabellen")
                        .addItem("Codeblöcke")
                    )
                    .addSubsection(new MDSubsection("Erweiterungen")
                        .addText("Tabellen und Links folgen später.")
                    )
                )
            )
            .addElement(new MDCodeBlock("java", "System.out.println(\"Hallo Welt\");"))
            .addElement(new MDHorizontalRule());

        Path output = Path.of("output.md");
        MarkdownIO.writeTo(file, output);

        MDFile parsed = MarkdownIO.readFrom(output);
        System.out.println("\n Parsed Content:\n" + parsed.render());
    }
}
