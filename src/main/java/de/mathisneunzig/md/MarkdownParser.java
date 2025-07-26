package de.mathisneunzig.md;

/**
 * Nicht fertig
 */
public class MarkdownParser {

    public static MDFile parse(String markdown) {
        MDFile file = new MDFile();

        MDChapter currentChapter = null;
        MDSection currentSection = null;
        MDSubsection currentSubsection = null;

        for (String line : markdown.split("\n")) {
            line = line.strip();

            if (line.isBlank()) continue;

            if (line.startsWith("# ")) {
                currentChapter = new MDChapter(line.substring(2).trim());
                file.addElement(currentChapter);
                currentSection = null;
                currentSubsection = null;
            } else if (line.startsWith("## ")) {
                if (currentChapter == null) {
                    currentChapter = new MDChapter("Kapitel ohne Titel");
                    file.addElement(currentChapter);
                }
                currentSection = new MDSection(line.substring(3).trim());
                currentChapter.addSection(currentSection);
                currentSubsection = null;
            } else if (line.startsWith("### ")) {
                if (currentSection == null) {
                    if (currentChapter == null) {
                        currentChapter = new MDChapter("Kapitel ohne Titel");
                        file.addElement(currentChapter);
                    }
                    currentSection = new MDSection("Abschnitt ohne Titel");
                    currentChapter.addSection(currentSection);
                }
                currentSubsection = new MDSubsection(line.substring(4).trim());
                currentSection.addSubsection(currentSubsection);
            } else {
                if (currentSubsection != null) {
                    currentSubsection.addText(line);
                } else if (currentSection != null) {
                    currentSection.addText(line);
                } else if (currentChapter != null) {
                    currentChapter.addText(line);
                } else {
                    currentChapter = new MDChapter("Kapitel ohne Titel");
                    file.addElement(currentChapter);
                    currentChapter.addText(line);
                }
            }
        }

        return file;
    }
}
