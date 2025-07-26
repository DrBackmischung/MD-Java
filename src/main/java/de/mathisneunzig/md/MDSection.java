package de.mathisneunzig.md;

import java.util.ArrayList;
import java.util.List;

public class MDSection implements MarkdownElement {
    private String title;
    private List<MarkdownElement> content = new ArrayList<>();

    public MDSection(String title) {
        this.title = title;
    }

    public String getTitle() { return title; }

    public MDSection addText(String text) {
        content.add(new MDText(text));
        return this;
    }

    public MDSection addSubsection(MDSubsection subsection) {
        content.add(subsection);
        return this;
    }

    public MDSection addElement(MarkdownElement e) {
        content.add(e);
        return this;
    }

    public List<MarkdownElement> getContent() { return content; }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder("## ").append(title).append("\n\n");
        for (MarkdownElement e : content) {
            sb.append(e.render()).append("\n\n");
        }
        return sb.toString().trim();
    }
}
